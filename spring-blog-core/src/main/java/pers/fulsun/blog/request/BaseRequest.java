package pers.fulsun.blog.request;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 请求基类
 *
 * @author fulsun
 */
@Data
@Slf4j
public abstract class BaseRequest<T> {
    /**
     * 当前页
     */
    private Integer pageNum = 1;

    /**
     * 页面大小
     */
    private Integer pageSize = 10;

    private Class<T> doClass;

    public BaseRequest() {
        try {
            Type[] actualTypeArguments = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments();
            if (actualTypeArguments.length > 0) {
                doClass = (Class<T>) actualTypeArguments[0];
            }
        } catch (Exception e) {
            log.warn("==========BaseRequest 获取泛型参数异常：getClass: {}, error: {}==========", getClass(), e.getMessage());
        }
    }

    public interface Save {}

    public interface Remove {}

    public interface Update {}

    public interface Query {}
}
