package com.example.devtoolindex.db.entity;

import lombok.Data;

import java.util.Date;

/**
 * Created by hongkailiu on 2016-04-11.
 */
@Data public class IPStatEntity extends BaseEntity {
    String ip;
    Date lastVisitDate;
    String path;
}
