package com.tiagoramirez_portfolio.portfolio.dto;

public class ResponseMessage {
    private String message;
    private Integer id;

    public ResponseMessage(String message) {
        this.message = message;
    }

    public ResponseMessage(String message, Integer id) {
        this.message = message;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
