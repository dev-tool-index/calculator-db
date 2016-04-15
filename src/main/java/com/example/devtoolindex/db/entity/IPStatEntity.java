package com.example.devtoolindex.db.entity;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by hongkailiu on 2016-04-11.
 */
@Document(collection = "ipstat")
@Data public class IPStatEntity extends BaseEntity {

    public static final String VISIT_DATE_NAME ="visit_date";
    public static final long TTL = TimeUnit.DAYS.toSeconds(30);

    private String ip;
    @Field(VISIT_DATE_NAME)
    private Date visitDate;
    private String path;

    public IPStatEntity(String ip, Date visitDate,  String path){
        this.ip = ip;
        this.visitDate = visitDate;
        this.path = path;
    }

    public IPStatEntity(){
    }
}
