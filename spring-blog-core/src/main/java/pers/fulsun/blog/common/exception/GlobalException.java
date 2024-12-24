package pers.fulsun.blog.common.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class GlobalException extends RuntimeException {

    private int code;

    private String message;
    /**
     * 是否返回json格式的异常信息
     */
    private Boolean json;

    public GlobalException(GlobalExceptionMap exception, Boolean json) {
        super(exception.getMessage());
        this.code = exception.getCode();
        this.message = exception.getMessage();
        this.json = json;
    }

    public GlobalException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
        this.json = true;
    }

    public GlobalException(String message) {
        super(message);
        this.code = 500;
        this.message = message;
        this.json = false;
    }
}
