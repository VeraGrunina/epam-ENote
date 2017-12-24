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

public class config {
    @Configuration
    @PropertySource("database.properties")
    @EnableJpaRepositories("data")
    @ComponentScan(basePackages = "generalPackage")
    public static class TestConfig {

        @Bean
        public DataSource h2dataSource() throws SQLException {
            return new EmbeddedDatabaseBuilder()
                    .setName("testDatabase")
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
            try {
                em.setDataSource(h2dataSource());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            em.setPackagesToScan("generalPackage.data.entity");
            em.setJpaVendorAdapter(jpaVendorAdapter());
            return em;
        }

        @Bean
        public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
            return new JpaTransactionManager(emf);
        }
    }
}
