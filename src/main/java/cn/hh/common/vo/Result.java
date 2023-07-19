package cn.hh.common.vo;

import lombok.Data;

@Data
public class Result<T> {
    private Result() {

    }

    private Result(Integer code, String message, T data, Long count) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.count = count;
    }

    private Integer code;           // 返回码，0表示成功，否则失败
    private String message;     // 返回描述信息
    private T data;                 // 返回数据,返回类型由泛型类决定
    private Long count;         // 分页查询的总记录数

    public static<T> Result success() {
        return new Result<T>(0, "success", null, null);
    }

    public static<T> Result success(T data, Long count) {
        return new Result<T>(0, "success", data, count);
    }

    public static <T> Result success(String message) {
        return new Result<T>(0, message, null, null);
    }
    public static <T> Result fail() {
        return new Result(-1, "fail", null, null);
    }

    public static <T> Result fail(String message) {
        return new Result(-1, message, null, null);
    }


}
