package com.example.devtoolindex.db.service;

import com.example.devtoolindex.db.entity.IPStatEntity;

/**
 * Created by hongkailiu on 2016-04-11.
 */
public interface IPStatService {

    /**
     * save ip stat entity
     * @param ipStatEntity the ip stat entity
     */
    void save(IPStatEntity ipStatEntity);
    /**
     * delete all ip stat documents
     */
    void deleteAll();

    /**
     * count the number of all ip stat documents
     * @return the total number
     */
    int count();

    /**
     * find the latest inserted ip stat document
     * @return the latest inserted ip stat document
     */
    IPStatEntity findLatest();
}
