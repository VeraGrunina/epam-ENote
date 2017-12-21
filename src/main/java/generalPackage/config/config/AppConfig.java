package generalPackage.config.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.sql.SQLException;
import generalPackage.config.repositories.HashRepository;
import generalPackage.config.services.impl.HashServiceImpl;
import generalPackage.config.web.utils.AuthService;

@Configuration
@PropertySource("database.properties")
@EnableJpaRepositories(basePackageClasses = HashRepository.class)
@ComponentScan(basePackageClasses = {
    HashRepository.class,
    HashServiceImpl.class,
    AuthService.class
})
public class AppConfig {

    @Bean
    public DataSource h2dataSource() throws SQLException {
        return new EmbeddedDatabaseBuilder()
                .setName("realDatabase")
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:src/java/resources/init.sql")
                .addScript("insertInDataBase.sql")
                .build();
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter bean = new HibernateJpaVendorAdapter();
        bean.setDatabase(Database.H2);
        return bean;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        try {
            em.setDataSource(h2dataSource());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        em.setPackagesToScan("generalPackage/config/model");
        em.setJpaVendorAdapter(jpaVendorAdapter());
        return em;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }

//    @Bean(name = "sessionFactory")
//    public SessionFactory sessionFactory() throws IOException, SQLException {
//        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
//        sessionFactoryBean.setDataSource(h2dataSource());
//        sessionFactoryBean.setPackagesToScan("generalPackage.config.model");
//        sessionFactoryBean.setAnnotatedPackages("generalPackage.config.model");
//        sessionFactoryBean.afterPropertiesSet();
//        return sessionFactoryBean.getObject();
//    }

}
