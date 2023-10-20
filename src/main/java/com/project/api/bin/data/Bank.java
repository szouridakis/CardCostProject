package com.project.api.bin.data;

public class Bank {
    private String name;
    private String website;

    private String phone;

    public Bank(){}

    public Bank(String name, String website, String phone) {
        super();
        this.name = name;
        this.website = website;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}
