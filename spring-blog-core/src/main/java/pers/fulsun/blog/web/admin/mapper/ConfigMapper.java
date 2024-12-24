package pers.fulsun.blog.web.admin.mapper;

import org.apache.ibatis.annotations.Param;
import pers.fulsun.blog.web.admin.entities.Config;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ConfigMapper extends Mapper<Config> {
    /**
     * 修改配置
     * @param configList
     */
    void updateByConfigKey(@Param("list") List<Config> configList);
}