package com.zoha.batch.entity.pstn;

import java.io.Serializable;

/**
 * Created by velorin on 5/13/16.
 */
public class DevicePstnEntity implements Serializable {

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
}
