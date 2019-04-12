package cn.webfuse.cloud.uaa.authorization.provider;

import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class CustomUserDetailsService extends JdbcDaoImpl {


    public CustomUserDetailsService(DataSource dataSource) {
        setEnableGroups(true);
        setDataSource(dataSource);
    }
}
