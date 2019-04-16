package cn.webfuse.cloud.uaa.security.provider;

import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

import javax.sql.DataSource;

/**
 * 这里为了简单，直接继承了JdbcDaoImpl。
 * <p>
 * 可以自己自定义一个，实现UserDetailsService
 */
public class CustomUserDetailsService extends JdbcDaoImpl {


    public CustomUserDetailsService(DataSource dataSource) {
        setEnableGroups(true);
        setDataSource(dataSource);
    }
}
