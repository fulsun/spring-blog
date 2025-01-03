package pers.fulsun.blog.web.admin.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 表名：t_post_tag
 * 表注释：文章标签关系表
*/
@Data
@Table(name = "`t_post_tag`")
public class PostTag {
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
     * 标签 id
     */
    @Column(name = "`tag_id`")
    private Long tagId;
}