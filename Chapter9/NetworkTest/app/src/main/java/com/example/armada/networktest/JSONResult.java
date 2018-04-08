package com.example.armada.networktest;

public class JSONResult {

    private String date;

    private String message;

    private String city;

    private JSONData data;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public JSONData getData() {
        return data;
    }

    public void setData(JSONData data) {
        this.data = data;
    }
}
