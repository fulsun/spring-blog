package pers.fulsun.blog.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "blog")
public class BlogConfig {
    /**
     * 附件目录
     */
    private String attachmentDir;
}
