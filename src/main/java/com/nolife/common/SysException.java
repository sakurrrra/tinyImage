package com.nolife.common;

public class SysException extends Exception {

    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    SysException(){}
    SysException(String message){
        SysException sysException = new SysException();
        sysException.setMessage(message);
    }
}
