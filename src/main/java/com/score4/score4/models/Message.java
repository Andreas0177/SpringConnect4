package com.score4.score4.models;

public class Message {

    boolean successful;
    boolean end;
    String message;

    public Message(boolean successful, String message) {
        this.successful = successful;
        this.message = message;
        this.end=false;
    }

    public Message(boolean successful,boolean end,String message) {
        this.successful = successful;
        this.message = message;
        this.end=end;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }
}
