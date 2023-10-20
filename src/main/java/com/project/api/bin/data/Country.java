package com.project.api.bin.data;

public class Country {

    private String name;
    private String code;
    private String flag;
    private String currency;
    private String currency_code;

    public Country (){}
    public Country(String name, String code, String flag, String currency, String currency_code) {
        super();
        this.name = name;
        this.code = code;
        this.flag = flag;
        this.currency = currency;
        this.currency_code = currency_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrency_code() {
        return currency_code;
    }

    public void setCurrency_code(String currency_code) {
        this.currency_code = currency_code;
    }
}
