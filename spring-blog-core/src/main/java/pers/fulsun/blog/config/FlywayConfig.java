package pers.fulsun.blog.config;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.FlywayException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.sql.DataSource;

/**
 * Flyway配置类
 *
 * @author fulsun
 */
@Configuration
@Slf4j
@DependsOn("dataSourceConfig")
public class FlywayConfig {
    @Autowired
    private DataSource dataSource;

    /**
     * 保证Flyway在DataSource初始化之后执行
     *
     * @return Flyway对象
     */

    @PostConstruct
    public Flyway flyway() {
        try {
            Flyway flyway = Flyway.configure().dataSource(dataSource).cleanDisabled(true).baselineOnMigrate(true).baselineVersion("0").locations("db/migration").load();
            flyway.migrate();
            log.info("flyway migrated successfully");
            return flyway;
        } catch (FlywayException e) {
            log.error("Flyway 配置加载出错", e);
            throw new RuntimeException(e);
        }
    }
}
