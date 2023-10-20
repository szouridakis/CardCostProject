package com.project.api.bin.data;

public class Card {
    private String scheme;

    private String type;

    private String category;
    private Integer length;
    private Integer checkluhn;
    private Integer cvvlen;

    public Card(){};
    public Card(String scheme, String type, String category, Integer length, Integer checkluhn, Integer cvvlen) {
        super();
        this.scheme = scheme;
        this.type = type;
        this.category = category;
        this.length = length;
        this.checkluhn = checkluhn;
        this.cvvlen = cvvlen;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getCheckluhn() {
        return checkluhn;
    }

    public void setCheckluhn(Integer checkluhn) {
        this.checkluhn = checkluhn;
    }

    public Integer getCvvlen() {
        return cvvlen;
    }

    public void setCvvlen(Integer cvvlen) {
        this.cvvlen = cvvlen;
    }
}
