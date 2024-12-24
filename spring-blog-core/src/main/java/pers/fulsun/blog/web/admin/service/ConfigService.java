package pers.fulsun.blog.web.admin.service;

import pers.fulsun.blog.web.admin.entities.Config;

import java.util.List;

public interface ConfigService {
    /**
     * 批量保存配置
     * @param configList
     */
    void saveConfigBatch(List<Config> configList);
}
