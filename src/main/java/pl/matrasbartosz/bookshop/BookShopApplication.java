package pl.matrasbartosz.bookshop;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.transaction.annotation.Transactional;
import pl.matrasbartosz.bookshop.model.BookType;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class BookShopApplication implements CommandLineRunner {

    @Autowired
    private SessionFactory sessionFactory;

    public static void main(String[] args) {
        SpringApplication.run(BookShopApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
//        System.out.println(BookType.POCKET);

        Session session = sessionFactory.getCurrentSession();

        Object o = session.createSQLQuery("select 1 from dual").uniqueResult();
        System.out.println(o);
    }
}
