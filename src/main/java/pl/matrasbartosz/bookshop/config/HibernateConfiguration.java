package pl.matrasbartosz.bookshop.config;


import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:hibernate.properties")
public class HibernateConfiguration {

    @Value("${hibernate.packageToScan}")
    private String packagesToScan;
    @Value("${hibernate.driver}")
    private String driverClassName;
    @Value("${hibernate.url}")
    private String url;
    @Value("${hibernate.password}")
    private String password;
    @Value("${hibernate.username}")
    private String username;
    @Value("${hibernate.showSql}")
    private String showSql;
    @Value("${hibernate.myDialect}")
    private String dialect;
    @Value("${hibernate.poolSize}")
    private String poolSize;
    @Value("${hibernate.currentSessionContextClass}")
    private String currentSessionContextClass;
    @Value("${hibernate.myhbm2ddl.auto}")
    private String hbm2ddlAuto;


    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(packagesToScan);
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean
    public DataSource dataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager hibernateTransactionManager(){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }

    private Properties hibernateProperties(){
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("show_sql", showSql);
        hibernateProperties.setProperty("hibernate.dialect", dialect);
        hibernateProperties.setProperty("connection.pool_size", poolSize);
        hibernateProperties.setProperty("current_session_context_class" , currentSessionContextClass);
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", hbm2ddlAuto);
        return hibernateProperties;
    }

}
