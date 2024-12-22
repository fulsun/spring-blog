package pers.fulsun.blog;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import tk.mybatis.spring.annotation.MapperScan;

@Slf4j
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("pers.fulsun.blog.web.admin.mapper")
public class BlogBootApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BlogBootApplication.class, args);
        log.info("访问地址：http://127.0.0.1:{}/", context.getEnvironment().getProperty("server.port"));
        log.info("安装博客地址：http://127.0.0.1:{}/admin/install.html", context.getEnvironment().getProperty("server.port"));
        log.info("后台登录地址：http://127.0.0.1:{}/admin/login.html", context.getEnvironment().getProperty("server.port"));
    }
}
