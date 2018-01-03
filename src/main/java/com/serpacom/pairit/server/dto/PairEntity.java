package com.serpacom.pairit.server.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "pairEntity")
public class PairEntity {

    private UUID userId;
    @Id
    private UUID pairId;
    private String name;
    private String value;

    public UUID getPairId() {
        return pairId;
    }

    public void setPairId(UUID pairId) {
        this.pairId = pairId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "userid : " + userId +
                "pairId : " + pairId +
                "name : " + name +
                "value : " + value;
    }
}
