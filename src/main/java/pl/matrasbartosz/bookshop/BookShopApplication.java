package pl.matrasbartosz.bookshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class BookShopApplication{
    public static void main(String[] args) {
        SpringApplication.run(BookShopApplication.class, args);
    }
}
