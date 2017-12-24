package generalPackage.config;

import generalPackage.data.dao.HashDAO;
import generalPackage.service.impl.HashServiceImpl;
import generalPackage.service.interfaces.AuthService;
import generalPackage.service.interfaces.HashService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
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
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("database.properties")
@EnableJpaRepositories(basePackageClasses = HashDAO.class)
@ComponentScan(basePackageClasses = {
        HashService.class,
})

//@Configuration
//@PropertySource("database.properties")
//@EnableJpaRepositories(basePackageClasses = HashDAO.class)
//@ComponentScan(basePackageClasses = {
//    HashDAO.class,
//    HashServiceImpl.class,
//    AuthService.class
//})
//@EnableTransactionManagement
//@EnableAspectJAutoProxy
public class AppConfig {

    @Bean
    public DataSource h2dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setName("realDatabase")
                .setType(EmbeddedDatabaseType.H2)
                .addScript("init.sql")
                .addScript("insert.sql")
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
        em.setDataSource(h2dataSource());
        em.setPackagesToScan("generalPackage.data.entity");
        em.setJpaVendorAdapter(jpaVendorAdapter());
        return em;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
}
