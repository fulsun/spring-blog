package pers.fulsun.blog.web.admin.entities;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * 表名：t_user
 * 表注释：用户表
*/
@Data
@Table(name = "`t_user`")
@Accessors(chain = true)
public class User {
    /**
     * 主键
     */
    @Id
    @Column(name = "`id`")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 用户名
     */
    @Column(name = "`username`")
    private String username;

    /**
     * 密码
     */
    @Column(name = "`password`")
    private String password;

    /**
     * 昵称
     */
    @Column(name = "`nickname`")
    private String nickname;

    /**
     * 邮箱地址
     */
    @Column(name = "`email`")
    private String email;

    /**
     * 头像
     */
    @Column(name = "`avatar`")
    private String avatar;

    /**
     * 主页地址
     */
    @Column(name = "`home_url`")
    private String homeUrl;

    /**
     * 状态 1：可用 0：禁用
     */
    @Column(name = "`state`")
    private Integer state;

    /**
     * 角色 1：博主 2：用户
     */
    @Column(name = "`role`")
    private Integer role;

    /**
     * 创建时间
     */
    @Column(name = "`create_time`")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @Column(name = "`update_time`")
    private LocalDateTime updateTime;
}