package org.kcdm;

import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

public abstract class ModelDaoSuport extends JdbcDaoSupport{
    @Inject
    @Named("jdbcTemplate")
    protected JdbcTemplate jdbcTemplate;

    public static final int JDBC_BATCH_SIZE_SUGGESTION = 20;

    protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @PostConstruct
    private void initialize() {
        this.setJdbcTemplate(jdbcTemplate);
        this.afterPropertiesSet();
    }

    @Override
    protected void initTemplateConfig() {

        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
    }

    @Override
    protected void initDao() throws Exception {
        throw new BeanInitializationException("Override this method to initialize components based on DataSource and JdbcTemplate.");
    }

    protected <M > void doBatchUpdate(final String query, final List<M> models, final ParametersBuilder<M> builder) {

        if(CollectionUtils.isEmpty(models)) {
            return;
        }

        int batchIndex = 0;

        while(batchIndex < models.size()) {

            int lastIndex = batchIndex + JDBC_BATCH_SIZE_SUGGESTION;

            if(lastIndex > models.size()) {
                lastIndex = models.size();
            }

            final List<M> currentBatch = models.subList(batchIndex, lastIndex);

            final ArrayList<SqlParameterSource> sqlParameterSources = new ArrayList<>();

            for(M model: currentBatch) {
                sqlParameterSources.add(builder.build(model));
            }

            final SqlParameterSource[] array = new SqlParameterSource[sqlParameterSources.size()];

            this.namedParameterJdbcTemplate.batchUpdate(query, sqlParameterSources.toArray(array));

            batchIndex = lastIndex;
        }
    }

    protected interface ParametersBuilder<M> {
        SqlParameterSource build(final M model);
    }

    protected static class SqlParameterSourceBuilder {

        private MapSqlParameterSource parameterSource = new MapSqlParameterSource();

        private SqlParameterSourceBuilder() {
        }

        public static SqlParameterSourceBuilder builder() {
            return new SqlParameterSourceBuilder();
        }

        public SqlParameterSourceBuilder addValue(String paramName, Object value) {
            parameterSource.addValue(paramName, value);
            return this;
        }

        public MapSqlParameterSource build() {
            return new MapSqlParameterSource(parameterSource.getValues());
        }
    }




}
