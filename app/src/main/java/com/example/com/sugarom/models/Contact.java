package com.example.com.sugarom.models;

import com.orm.SugarRecord;

/**
 * Created by raul on 28/10/2016.
 */

public class Contact extends SugarRecord {
    private String name;
    private String phone;

    public Contact() {
    }

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "id: " + id + " name: " + name + " phone: " + phone;
    }
}
