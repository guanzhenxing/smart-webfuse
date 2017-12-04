package net.webfuse.config;

import net.webfuse.common.db.config.AbstractDBConfig;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * DB相关配置
 * Created by guanzhenxing on 2017/11/12.
 */
@Configuration
public class WafDBConfig extends AbstractDBConfig {

    /**
     * MyBatis相关配置
     *
     * @return
     */
    @Bean
    ConfigurationCustomizer configurationCustomizer() {
        return configuration -> {
            configuration.setMapUnderscoreToCamelCase(true);    //自动将以下划线方式命名的数据库字段映射到Java对象的驼峰式
        };
    }


}
