package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("springtestes-jpa-pu");

    public static EntityManager getEntityManager(){

        return fabrica.createEntityManager();

    }

}
