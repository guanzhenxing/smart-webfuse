package cn.webfuse.cloud.uaa.provider;

import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

import javax.sql.DataSource;

public class CustomUserDetailsService extends JdbcDaoImpl {


    public CustomUserDetailsService(DataSource dataSource) {
        setEnableGroups(true);
        setDataSource(dataSource);
    }
}
