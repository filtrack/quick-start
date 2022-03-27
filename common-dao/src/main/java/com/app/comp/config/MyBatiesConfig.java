package com.app.comp.config;

import com.app.comp.interceptor.SqlCostInterceptor;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.MybatisXMLLanguageDriver;
import com.github.pagehelper.PageInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @Title
 * @Auther hjw
 * @Date 2022/3/23 23:07
 * @Version 1.0
 */
@Configuration
@RefreshScope
@Slf4j
public class MyBatiesConfig {

    @Value("${mybatis.mapperLocations}")
    private String mapperLocations;
    @Value("${mybatis.entityPackage}")
    private String entityPackage;


    @Bean
    @RefreshScope
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        //设置数据源
        sqlSessionFactoryBean.setDataSource(dataSource);

        //mapper.xml entity路径设置
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(mapperLocations));//加载配置文件的地址;
        sqlSessionFactoryBean.setTypeAliasesPackage(entityPackage);


        // 配置mybatis-config
        MybatisConfiguration configuration = new MybatisConfiguration();
        configuration.setDefaultScriptingLanguage(MybatisXMLLanguageDriver.class);
        configuration.setCacheEnabled(true);
        configuration.setUseGeneratedKeys(true);
        configuration.setDefaultExecutorType(ExecutorType.REUSE);
//        configuration.setLogImpl(StdOutImpl.class);
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setJdbcTypeForNull(JdbcType.NULL);
        sqlSessionFactoryBean.setConfiguration(configuration);

        log.debug("wawawawawawa *******************************************************");

        // sql 美化
        sqlSessionFactoryBean.setPlugins(new Interceptor[] {new SqlCostInterceptor()});
//        sqlSessionFactoryBean.setTransactionFactory(new SpringManagedTransactionFactory());
        return sqlSessionFactoryBean.getObject();
    }


    @Bean
    @RefreshScope
    public PageInterceptor pageInterceptor() {
        PageInterceptor interceptor = new PageInterceptor();
        Properties props = new Properties();
        props.setProperty("helperDialect", "mysql");
        props.setProperty("reasonable", "true");
        props.setProperty("params","count=countSql");
        props.setProperty("supportMethodsArguments", "mysql");
        props.setProperty("autoRuntimeDialect", "true");
        interceptor.setProperties(props);
        return interceptor;
    }

}
