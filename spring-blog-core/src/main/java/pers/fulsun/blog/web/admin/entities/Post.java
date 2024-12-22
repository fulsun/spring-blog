package pers.fulsun.blog.web.admin.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 表名：t_post
 * 表注释：文章表
*/
@Data
@Table(name = "`t_post`")
public class Post {
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
     * 摘要
     */
    @Column(name = "`summary`")
    private String summary;

    /**
     * 作者
     */
    @Column(name = "`author`")
    private String author;

    /**
     * 发表年份
     */
    @Column(name = "`year`")
    private String year;

    /**
     * 发表月份
     */
    @Column(name = "`month`")
    private String month;

    /**
     * 发表日期
     */
    @Column(name = "`day`")
    private String day;

    /**
     * 封面图片地址
     */
    @Column(name = "`cover_url`")
    private String coverUrl;

    /**
     * 发表时间（yyyy-MM-dd）
     */
    @Column(name = "`publish_date`")
    private String publishDate;

    /**
     * 是否发表
     */
    @Column(name = "`is_publish`")
    private Integer isPublish;

    /**
     * 是否允许评论
     */
    @Column(name = "`is_comment`")
    private Integer isComment;

    /**
     * 是否置顶
     */
    @Column(name = "`is_top`")
    private Integer isTop;

    /**
     * 是否删除
     */
    @Column(name = "`is_delete`")
    private Integer isDelete;

    /**
     * 是否转载
     */
    @Column(name = "`is_reprint`")
    private Integer isReprint;

    /**
     * 转载链接
     */
    @Column(name = "`reprint_link`")
    private String reprintLink;

    /**
     * 分类 id
     */
    @Column(name = "`category_id`")
    private Long categoryId;

    /**
     * 文章链接
     */
    @Column(name = "`link`")
    private String link;

    /**
     * 标签，多个标签使用逗号拼接
     */
    @Column(name = "`tags`")
    private String tags;

    /**
     * 阅读数
     */
    @Column(name = "`read_num`")
    private Long readNum;

    /**
     * 点赞数
     */
    @Column(name = "`praise_num`")
    private Long praiseNum;

    /**
     * 评论数
     */
    @Column(name = "`comment_num`")
    private Long commentNum;

    /**
     * 置顶时间
     */
    @Column(name = "`top_time`")
    private LocalDateTime topTime;

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

    /**
     * 内容（md 格式）
     */
    @Column(name = "`content`")
    private String content;
}