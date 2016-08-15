package com.library;

import com.library.user.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;

@Configuration
public class JDBCTemplate {

    dbConfiguration dbConfig = new dbConfiguration();
    public DataSource dataSource = dbConfig.dataSource();
    public JdbcTemplate templateObject = new JdbcTemplate(dataSource);

}
