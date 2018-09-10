package org.kcdm;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.kcdm.utils.JsonUtils;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.inject.Inject;
import javax.inject.Named;


@RunWith(SpringRunner.class)
@ActiveProfiles("spring-api-test")
@AutoConfigureMockMvc
@SpringBootTest(classes = KCDMApplication.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class AbstractSpringMvcTest {
    private static final Logger LOGGER=Logger.getRootLogger();

    @Inject
    protected MockMvc mockMvc;

    @Inject
    @Named("jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Inject
    @Named("masterDataSetupService")
    private MasterDataSetupService masterDataSetupService;

    protected ObjectMapper json = JsonUtils.getJacksonInstance();

    public MasterData masterData;

    @Before
    public void setup()throws Exception{
        this.setup(true);
    }

    private void setup(boolean withMasterData)throws Exception {
        if(withMasterData){
            setupMasterData();
        }
    }

    private void setupMasterData()throws Exception {
        masterDataSetupService.cleanHierarchy(jdbcTemplate);
        masterData=masterDataSetupService.crateHierarchy();
    }

    @After
    public void tearDown()throws Exception{
        tearDownMasterData();
    }

    private void tearDownMasterData()throws Exception {
        if(null != masterData){
            masterDataSetupService.cleanHierarchy(jdbcTemplate);
        }
    }


}
