import org.hibernate.jpa.HibernatePersistenceProvider;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.*;
import javax.sql.DataSource;
import java.util.Properties;

public class HibernateDemo1 {

    private DataSource getDataSource() {
        final PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setDatabaseName("CakeList");
        dataSource.setUser("root");
        dataSource.setPassword("66hizzy8989!#");
        dataSource.setUrl("jdbc:mysql://localhost:3306/?user=root");
        return dataSource;
    }

    private Properties getProperties() {
        final Properties properties = new Properties();
        properties.put( "hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect" );
        properties.put( "hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver" );
//        properties.put("hibernate.show_sql", "true");
        return properties;
    }

    private EntityManagerFactory entityManagerFactory(DataSource dataSource, Properties hibernateProperties ){
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan( "demo2" );
        em.setJpaVendorAdapter( new HibernateJpaVendorAdapter() );
        em.setJpaProperties( hibernateProperties );
        em.setPersistenceUnitName( "demo-unit" );
        em.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        em.afterPropertiesSet();
        return em.getObject();
    }

    public static void main(String[] args) {
        HibernateDemo1 hbDemo = new HibernateDemo1();
        DataSource dataSource = hbDemo.getDataSource();
        Properties properties = hbDemo.getProperties();
        EntityManagerFactory entityManagerFactory = hbDemo.entityManagerFactory(dataSource, properties);
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Cake ck = new Cake();
        ck.setID("ID-00039");
        ck.setName("Burnt Almond Cake");
        ck.setDescription("White cake coated with toasted Almonds");
        ck.setPrice(50);
        ck.setStock(8);
        em.merge(ck);
        tx.commit();

        //Query
        Query query = em.createQuery("select * from CakeList");
        List<CakeList> ckList = (CakeList)query.getResultList();
        System.out.println(ckList);

/*
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<CakeList> query = builder.createQuery(CakeList.class);
        Root<CakeList> from = query.from(CakeList.class);
        Predicate exp1 = builder.equal(from.get("name"), "German Chocolate Cake");
        Predicate exp2 = null;
        if(!"xx".equals(null)) {
            exp2 = builder.equal(from.get("last_name"), "xx");
        }
        Predicate exp3 = builder.or(exp1, exp2);
        query.where(exp1);
        Query q = em.createQuery(query);


 */
    }



}

test {
    System.out.println(ckList);
}