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
        List<CakeList> cList = em.createQuery("select name from com.BakeryPackage.CakeList").getResultList();
        CakeList c = cList.get(0);
        System.out.println("**************************************");
        System.out.println("class is loaded : " + unitUtil.isLoaded(c));
//        System.out.println("collection is loaded : " + unitUtil.isLoaded(t, "teacher_students"));
//        List<Teacher_Student> teacher_students = t.getTeacher_students();
//        System.out.println("collection is loaded : " + unitUtil.isLoaded(teacher_students, "teacher_students"));
//        System.out.println(teacher_students);
//        System.out.println("collection is loaded : " + unitUtil.isLoaded(teacher_students, "teacher_students"));
//        System.out.println("**************************************");


        //Query
        Query query = em.createQuery("select * from com.BakeryPackage.CakeList");
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

    private static void insertToCakeList(EntityManager em) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        CakeList ck = new CakeList();
        ck.setID("CID-00004");
        ck.setName("Burnt Almond Cake");
        ck.setDescription("White cake coated with toasted Almonds");
        em.merge(ck);
        tx.commit();
    }

    private static void insertToPieList(EntityManager em) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        PieList pie = new PieList();
        pie.setID("PID-00005");
        pie.setName("Coconut Cream Pie");
        pie.setPrimaryIngredient("Coconuts");
        em.merge(pie);
        tx.commit();
    }

    private static void getCakeByName(EntityManager em) {
        Query query = em.createQuery("select s from Student s left join fetch s.teacher_students ts where s.id = ?1");
        query.setParameter(1, "17");
        CakeList ck = (CakeList)query.getSingleResult();
        System.out.println(ck);
    }



}

