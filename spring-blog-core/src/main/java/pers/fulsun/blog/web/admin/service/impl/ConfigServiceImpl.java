package pers.fulsun.blog.web.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.fulsun.blog.web.admin.entities.Config;
import pers.fulsun.blog.web.admin.mapper.ConfigMapper;
import pers.fulsun.blog.web.admin.service.ConfigService;

import java.util.List;

@Service
public class ConfigServiceImpl implements ConfigService {
    @Autowired
    private ConfigMapper configMapper;

    @Override
    public void saveConfigBatch(List<Config> configList) {
        this.configMapper.updateByConfigKey(configList);
    }
}
