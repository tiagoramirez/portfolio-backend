package com.tiagoramirez_portfolio.portfolio.dto;

public class ResponseMessage {
    private String message;
    private Integer id;
    private boolean isMessageControlled = true;

    public ResponseMessage(String message) {
        this.message = message;
    }

    public ResponseMessage(String message, Integer id) {
        this.message = message;
        this.id = id;
        isMessageControlled = true;
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

    public boolean isMessageControlled() {
        return isMessageControlled;
    }

    public void setMessageControlled(boolean isMessageControlled) {
        this.isMessageControlled = isMessageControlled;
    }
}
