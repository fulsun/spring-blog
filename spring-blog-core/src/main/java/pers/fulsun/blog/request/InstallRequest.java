package pers.fulsun.blog.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class InstallRequest extends BaseRequest<InstallRequest> {
    /**
     * 用户名：保存时不能为空
     */
    @NotEmpty(message = "用户名不能为空", groups = {BaseRequest.Save.class})
    private String username;

    /**
     * 密码：保存时不能为空
     */
    @NotEmpty(message = "密码不能为空", groups = {BaseRequest.Save.class})
    private String password;

    /**
     * 博客名称：保存时不能为空
     */
    @NotEmpty(message = "博客名称不能为空", groups = {BaseRequest.Save.class})
    private String blogName;

    /**
     * 博客首页
     */
    private String homePage;

    /**
     * 博客描述
     */
    private String description;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 邮箱地址
     */
    private String email;
}
