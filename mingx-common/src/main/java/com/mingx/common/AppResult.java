package com.mingx.common;

/**
 * @author fuqiangxin
 * @Classname: AppResult
 * @Description: 规范返回结果的格式的类
 * @date 2020/5/15 18:28
 */
public class AppResult<T> {
    private int code;
    private String msg;
    private T data;// 数据

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
