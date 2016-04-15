package com.example.devtoolindex.db.entity;


import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Entity class of ip stat
 */
@Document(collection = "ipstat")
public class IPStatEntity {

    public static final String VISIT_DATE_NAME ="visit_date";
    public static final long TTL = TimeUnit.DAYS.toSeconds(30);

    @Getter private String uuid;
    @Setter @Getter private String ip;
    @Field(VISIT_DATE_NAME)
    @Setter @Getter private Date visitDate;
    @Setter @Getter private String path;

    public IPStatEntity(String ip, Date visitDate,  String path){
        init();
        this.ip = ip;
        this.visitDate = visitDate;
        this.path = path;
    }

    public IPStatEntity(){
        init();
    }

    private void init(){
        this.uuid = UUID.randomUUID().toString();
    }

    @Override public int hashCode() {
        return new HashCodeBuilder().append(uuid).toHashCode();
    }

    @Override public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        IPStatEntity other = (IPStatEntity) obj;
        return new EqualsBuilder().append(uuid, other.uuid).isEquals();
    }
}
