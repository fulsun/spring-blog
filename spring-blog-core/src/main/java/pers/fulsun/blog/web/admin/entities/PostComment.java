package pers.fulsun.blog.web.admin.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 表名：t_post_comment
 * 表注释：评论表
*/
@Data
@Table(name = "`t_post_comment`")
public class PostComment {
    /**
     * 主键
     */
    @Id
    @Column(name = "`id`")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 文章 id
     */
    @Column(name = "`post_id`")
    private Long postId;

    /**
     * 文章标题
     */
    @Column(name = "`title`")
    private String title;

    /**
     * 评论用户 id
     */
    @Column(name = "`user_id`")
    private Long userId;

    /**
     * 评论用户昵称
     */
    @Column(name = "`nickname`")
    private String nickname;

    /**
     * 评论头像
     */
    @Column(name = "`avatar`")
    private String avatar;

    /**
     * 是否为博主
     */
    @Column(name = "`is_blogger`")
    private Integer isBlogger;

    /**
     * 评论内容
     */
    @Column(name = "`content`")
    private String content;

    /**
     * 父级评论 id
     */
    @Column(name = "`p_id`")
    private Long pId;

    /**
     * 面板 id
     */
    @Column(name = "`banner_id`")
    private Long bannerId;

    /**
     * 被回复者昵称
     */
    @Column(name = "`source_nickname`")
    private String sourceNickname;

    /**
     * 是否删除
     */
    @Column(name = "`is_delete`")
    private Integer isDelete;

    /**
     * ip 地址
     */
    @Column(name = "`ip_address`")
    private String ipAddress;

    /**
     * 浏览器
     */
    @Column(name = "`browser`")
    private String browser;

    /**
     * 点赞数
     */
    @Column(name = "`praise_num`")
    private Long praiseNum;

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