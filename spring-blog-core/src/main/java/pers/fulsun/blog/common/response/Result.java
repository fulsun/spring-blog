package pers.fulsun.blog.common.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import pers.fulsun.blog.common.exception.GlobalExceptionMap;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * 返回结果，默认 code 200：成功  500：失败
 *
 * @author fulsun
 */
@Getter
public class Result {
    /**
     * 状态码
     */
    private Integer code;

    /**
     * 返回内容
     */
    private String message;

    /**
     * 返回数据
     */
    private Object data;

    /**
     * 响应时间戳
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateTime;
    /**
     * 操作是否成功
     */
    private Boolean success;


    private Result(Integer code, String message) {
        this.code = code;
        this.message = message;
        this.dateTime = LocalDateTime.now();
        this.success = this.code.equals(200);
    }


    private Result(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.dateTime = LocalDateTime.now();
        this.success = this.code.equals(200);
    }

    private Result(GlobalExceptionMap exceptionMap) {
        this.code = exceptionMap.getCode();
        this.message = exceptionMap.getMessage();
        this.success = this.code.equals(200);
        this.dateTime = LocalDateTime.now();
    }

    public static Result success() {
        return new Result(200, "success");
    }

    public static <T> Result success(T data) {
        return new Result(200, "success", data);
    }

    public static Result fail() {
        return new Result(500, "error");
    }

    public static Result fail(int code, String message) {
        return new Result(code, message);
    }

    public static Result fail(GlobalExceptionMap exceptionMap) {
        return new Result(exceptionMap);
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>(4);
        map.put("code", code);
        map.put("success", success);
        map.put("message", message);
        map.put("data", data);
        map.put("dateTime", dateTime);
        return map;
    }

}
