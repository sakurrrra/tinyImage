package com.nolife.common;

import java.io.Serializable;

/**
 *description 返回结果类
 *@author xierl
 *date 2020/3/15
 */
public class Result implements Serializable {

    private Integer code;
    private String message;
    private Object data;

    /**
     * 成功，默认消息
     *
     * @return Result
     */
    public static Result success() {
        Result result = new Result();
        result.setCode(200);
        result.setMessage("成功");
        return result;
    }

    /**
     * 成功+默认消息+数据
     *
     * @param data 数据
     * @return Result
     */
    public static Result success(Object data) {
        Result result = success();
        result.setData(data);
        return result;
    }

    /**
     * 失败
     *
     * @return Result
     */
    public static Result failure() {
        Result result = new Result();
        result.setCode(500);
        result.setMessage("失败");
        return result;
    }

    /**
     * 失败
     * @param message 错误信息
     * @return Result
     */
    public static Result failure(String message) {
        Result result = new Result();
        result.setCode(500);
        result.setMessage(message);
        return result;
    }

    /**
     * 失败
     * @param message 错误信息
     * @param data 数据
     * @return Result
     */
    public static Result failure(String message, Object data) {
        Result result = new Result();
        result.setCode(500);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
