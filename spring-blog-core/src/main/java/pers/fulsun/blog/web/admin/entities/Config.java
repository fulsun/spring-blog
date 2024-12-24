package pers.fulsun.blog.web.admin.entities;


import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * 表名：t_config
 * 表注释：全局配置表
*/
@Data
@Table(name = "`t_config`")
@Accessors(chain = true)
public class Config {
    /**
     * 主键
     */
    @Id
    @Column(name = "`id`")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 参数名
     */
    @Column(name = "`config_key`")
    private String configKey;

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

    /**
     * 参数值
     */
    @Column(name = "`config_value`")
    private String configValue;
}