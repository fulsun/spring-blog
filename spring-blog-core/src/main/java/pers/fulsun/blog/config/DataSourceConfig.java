package pers.fulsun.blog.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@Configuration
@Slf4j
public class DataSourceConfig {

    @Autowired
    private HikariProperties hikariProperties;

    // 手动配置HikariCP数据源
    // 具体配置请参考HikariCP官方文档 https://github.com/brettwooldridge/HikariCP
    @Bean
    public DataSource dataSource() {
        HikariDataSource dataSource = hikariProperties.createDataSource();
        try {
            Class.forName(dataSource.getDriverClassName());
            String datasourceUrl = dataSource.getJdbcUrl();
            int index = datasourceUrl.indexOf("?");
            String url = datasourceUrl.substring(0, index);
            String param = datasourceUrl.substring(index);
            String baseUrl = url.substring(0, url.lastIndexOf("/"));

            Connection connection = DriverManager.getConnection(baseUrl + param, dataSource.getUsername(), dataSource.getPassword());
            Statement statement = connection.createStatement();

            // 创建数据库
            String databaseName = url.substring(url.lastIndexOf("/") + 1);
            statement.executeUpdate("create database if not exists `" + databaseName + "` default character set utf8 COLLATE utf8_general_ci");
            log.info("create database `" + databaseName + "` success");
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }
}
