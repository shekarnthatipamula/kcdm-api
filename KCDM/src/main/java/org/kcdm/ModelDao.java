/*
 * Copyright (c) 2017. Niranta Services and Solutions Pvt. Ltd.
 */

package org.kcdm;

import java.io.Serializable;
import java.util.List;

/**
 * Created by paul on 14/6/16.
 */
public interface ModelDao<T extends Model, ID extends Serializable> {

    List<T> findAll();

    T save(T model);

    T update(T model);

    T findOne(ID id);

}
