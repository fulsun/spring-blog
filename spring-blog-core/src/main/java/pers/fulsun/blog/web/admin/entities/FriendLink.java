package pers.fulsun.blog.web.admin.entities;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * 表名：t_friend_link
 * 表注释：友链表
*/
@Data
@Table(name = "`t_friend_link`")
public class FriendLink {
    /**
     * 主键
     */
    @Id
    @Column(name = "`id`")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 标题
     */
    @Column(name = "`title`")
    private String title;

    /**
     * 作者
     */
    @Column(name = "`author`")
    private String author;

    /**
     * 主页地址
     */
    @Column(name = "`home_url`")
    private String homeUrl;

    /**
     * 邮箱地址
     */
    @Column(name = "`email`")
    private String email;

    /**
     * 排序
     */
    @Column(name = "`sort`")
    private Integer sort;

    /**
     * 类型 1：博主主页 2：常用网址
     */
    @Column(name = "`link_type`")
    private Integer linkType;

    /**
     * 背景颜色
     */
    @Column(name = "`background_color`")
    private String backgroundColor;

    /**
     * 备注
     */
    @Column(name = "`remark`")
    private String remark;

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