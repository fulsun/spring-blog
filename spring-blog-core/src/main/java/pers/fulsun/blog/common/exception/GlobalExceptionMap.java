package pers.fulsun.blog.common.exception;

/**
 * 异常枚举接口
 * @author fulsun
 */
public interface GlobalExceptionMap {

    /**
     * 返回 code
     * @return
     */
    int getCode();

    /**
     * 返回消息
     * @return
     */
    String getMessage();
}

