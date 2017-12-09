package main;

import model.User;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hibernate tutorial");

        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();

        User user = new User();

        user.setName("Arthur");
        user.setEmail("email1");
        user.setPassword("password1");

        session.save(user);
        session.getTransaction().commit();
        System.out.println("Got user id: " + user.getId());
        session.close();

//        try (InputStreamReader input = new InputStreamReader(
//                ConnectionPool.class.getClassLoader().getResourceAsStream(
//                        "init.sql"))) {
//
//            params = new DBParamsFromArgs("org.hsqldb.jdbcDriver",
//                    "jdbc:hsqldb:mem:shop", "sa", "", "5");
//
//            Class.forName(params.getDriver());
//
//            SqlFile sqlFile = new SqlFile(input, "init", System.out,
//                    "UTF-8", false, new File("."));
//
//            sqlFile.setConnection(DriverManager.getConnection(
//                    params.getUrl(),
//                    params.getUser(),
//                    params.getPassword()));
//
//            sqlFile.execute();
//        } catch (ClassNotFoundException | SQLException | IOException | SqlToolError e) {
//            throw new RuntimeException(e);
//        }
    }
}
