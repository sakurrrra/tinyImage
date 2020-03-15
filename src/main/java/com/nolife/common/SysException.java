package com.nolife.common;

/**
 *description 自定义异常
 *@author xierl
 *date 2020/3/15
 */
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
