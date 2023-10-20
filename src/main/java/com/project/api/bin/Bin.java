package com.project.api.bin;
import com.project.api.bin.data.Data;

public class Bin {

    private Integer result;

    private String message;

    private Data data;

    public Bin(){}
    public Bin(Integer result, String message, Data data) {
        super();
        this.result = result;
        this.message = message;
        this.data = data;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
