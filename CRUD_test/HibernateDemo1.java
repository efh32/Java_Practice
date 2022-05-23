package com.BakeryPackage;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;


import javax.persistence.*;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class HibernateDemo1 {

    private DataSource getDataSource() throws SQLException {
        final PGSimpleDataSource dataSource = new PGSimpleDataSource();
        //dataSource.setDatabaseName("com.BakeryPackage.CakeList");
        dataSource.setUser("postgres");
        dataSource.setPassword("66hizzy8989!#");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/bakery");
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

    public static void main(String[] args) throws SQLException {
        HibernateDemo1 hbDemo = new HibernateDemo1();
        DataSource dataSource = hbDemo.getDataSource();
        Properties properties = hbDemo.getProperties();
        EntityManagerFactory entityManagerFactory = hbDemo.entityManagerFactory(dataSource, properties);
        EntityManager em = entityManagerFactory.createEntityManager();




        PersistenceUnitUtil unitUtil = entityManagerFactory.getPersistenceUnitUtil();
//        insertToStudent(em);
        //getStudentById(em);
        List<Cakes> cList = em.createQuery("select name from CakeList").getResultList();
        Cakes c = cList.get(0);
        System.out.println("**************************************");
        System.out.println("class is loaded : " + unitUtil.isLoaded(c));



        //Query
        Query query = em.createQuery("select * from Cakes");
        //List<CakeList> ckList = (CakeList)query.getResultList();
        //System.out.println(ckList);

/*
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<com.BakeryPackage.CakeList> query = builder.createQuery(com.BakeryPackage.CakeList.class);
        Root<com.BakeryPackage.CakeList> from = query.from(com.BakeryPackage.CakeList.class);
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

    private static void insertToCakes(EntityManager em) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Cakes ck = new Cakes();
        ck.setID("CID-00004");
        ck.setName("Burnt Almond Cake");
        ck.setDescription("White cake coated with toasted Almonds");
        em.merge(ck);
        tx.commit();
    }

    private static void insertToBakeries(EntityManager em) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Bakeries bk = new Bakeries();
        bk.setId("BID-00005");
        bk.setName("Coconut Cafe");
        bk.setCity("Plano");
        bk.setState("Texas");
        em.merge(bk);
        tx.commit();
    }


    private static void getCakeByName(EntityManager em) {
        Query query = em.createQuery("select c from Cake c left join fetch c.cakeInventoryList ts where c.id = ?1");
        query.setParameter(1, "17");
        CakeList ck = (CakeList)query.getSingleResult();
        System.out.println(ck);
    }

    private static void getBakeryByName(EntityManager em) {
        Query query = em.createQuery("select b from Bakery b left join fetch b.bakeryInventoryList ts where b.id = ?1");
        query.setParameter(1, "bid-00077");
        Bakeries bk = (Bakeries) query.getSingleResult();
        System.out.println(bk);
    }



}

