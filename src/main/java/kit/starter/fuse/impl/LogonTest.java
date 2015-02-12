package kit.starter.fuse.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class LogonTest {
    private static final String PERSISTENCE_UNIT_NAME = "User";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        // Read the existing entries and write to console
        Query q = em.createQuery("SELECT u FROM User u");
        
        em.getTransaction().begin();
        User u1 = generateUser();
        em.persist(u1);
        em.getTransaction().commit();
        
        List<User> userList = q.getResultList();
        for (User user : userList) {
            System.out.println(user.getUsername());
        }
        System.out.println("Size: " + userList.size());
        
        em.close();

        // Create new user
//        em.getTransaction().begin();
//        User user = new User();
//        user.setName("Tom Johnson");
//        user.setLogin("tomj");
//        user.setPassword("pass");
//        em.persist(user);
//        em.getTransaction().commit();
//
//        em.close();
    }
    
    public static User generateUser(){
        User user = new User();
        
        user.setUsername("test_username2");
        user.setPassword("password2");
        user.setEmail("testemail2@me.com");
        user.setPhoneNumber("222-222-2222");
        user.setChallengeQ1("challenge question2");
        user.setChallengeAns1("challenge answer 2");
        user.setActive(true);
        user.setVerified(false);
        
        return user;
    }
}