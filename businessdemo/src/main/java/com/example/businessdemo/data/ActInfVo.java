package com.example.businessdemo.data;

import java.io.Serializable;
import lombok.Data;

@Data
public class ActInfVo implements Serializable {

    private String id;

    private String actEname;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getActEname() {
        return actEname;
    }

    public void setActEname(String actEname) {
        this.actEname = actEname;
    }

    public String getActCname() {
        return actCname;
    }

    public void setActCname(String actCname) {
        this.actCname = actCname;
    }

    private String actCname;
}
