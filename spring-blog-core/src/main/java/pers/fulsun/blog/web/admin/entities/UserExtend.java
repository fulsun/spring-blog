package pers.fulsun.blog.web.admin.entities;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * 表名：t_user_extend
 * 表注释：用户信息扩展表
*/
@Data
@Table(name = "`t_user_extend`")
@Accessors(chain = true)
public class UserExtend {
    /**
     * 主键
     */
    @Id
    @Column(name = "`id`")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 用户 id
     */
    @Column(name = "`uid`")
    private Long uid;

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
     * 自我介绍
     */
    @Column(name = "`descr`")
    private String descr;
}