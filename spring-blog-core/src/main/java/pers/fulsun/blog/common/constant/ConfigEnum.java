package pers.fulsun.blog.common.constant;

import lombok.Getter;

/**
 * 配置枚举类
 * @author fulsun
 */
@Getter
public enum ConfigEnum {
    /* 1:已安装 0：未安装 */
    IS_INSTALLED("is_installed", "", "是否已安装"),
    INSTALL_TIME("install_time", "","安装时间"),
    BLOG_NAME("blog_name", "","博客名称"),
    HOME_PAGE("home_page", "","博客首页"),
    DESCRIPTION("description", "好记性不如烂笔头","博客描述"),
    // ### 以下为自定义配置项 ###
    EMAIL("email", "fl.yi6145@gmail.com","邮箱地址"),
    BLOG_AUTHOR("blog_author", "fulsun","博主名称"),

    BACKUP_DIR("backup_dir", "","备份目录"),
    LOCAL_FILE_PATH("local_file_path", "", "本地文件路径");

    private String name;

    private String value;

    private String remark;

    ConfigEnum(String name, String value, String remark) {
        this.name = name;
        this.value = value;
        this.remark = remark;
    }
}
