package pers.fulsun.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@SpringBootTest
class BlogBootApplicationTest {
    @Autowired
    private DataSource dataSource;

    /**
     * 测试数据库连接是否成功
     */
    @Test
    void testDBConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        statement.execute("SELECT 1");
        statement.close();
        connection.close();
        System.out.println("数据库连接成功！");
    }
}