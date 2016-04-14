package com.example.devtoolindex.db.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Created by hongkailiu on 2016-04-11.
 */
@Document(collection = "ipstat")
@Data public class IPStatEntity extends BaseEntity {
    @Id
    private String ip;
    private Date lastVisitDate;
    private String path;

    public IPStatEntity(String ip, Date lastVisitDate,  String path){
        this.ip = ip;
        this.lastVisitDate = lastVisitDate;
        this.path = path;
    }

    public IPStatEntity(){
    }
}
