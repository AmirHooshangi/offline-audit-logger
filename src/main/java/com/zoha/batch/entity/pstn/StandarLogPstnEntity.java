package com.zoha.batch.entity.pstn;

import com.zoha.batch.entity.standard.StandardBaseLogEntity;

import java.io.Serializable;

/**
 * Created by velorin on 5/13/16.
 */
public class StandarLogPstnEntity extends StandardBaseLogEntity implements Serializable {

    String name;
    String age;
    String location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "StandarLogPstnEntity{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
