package testeManual;

import java.util.List;

import javax.persistence.EntityManager;

import dao.EstadoDao;
import model.Estado;
import util.JPAUtil;

public class TesteEstadoDao {


    private static void inserirDao(){

        EntityManager em = JPAUtil.getEntityManager();
        EstadoDao estadoDao = new EstadoDao(em);

        Estado estado = new Estado();
        estado.setNome("Parana");

        em.getTransaction().begin();
        estadoDao.inserir(estado);
        em.getTransaction().commit();

        em.close();


    }

    private static void listarDao() {

        EntityManager em = JPAUtil.getEntityManager();
        EstadoDao estadoDao = new EstadoDao(em);

        List<Estado> estados= estadoDao.listar();

        for(Estado e: estados){
            System.out.println(e.getId()+" - "+e.getNome());
        }

        em.close();

    }


    private static void consultarDao(){

        EntityManager em = JPAUtil.getEntityManager();
        EstadoDao estadoDao = new EstadoDao(em);

        Estado estado = estadoDao.consultar(4L);

        System.out.println(estado.getNome());

        em.close();

    }

    private static void removerDao(){

        EntityManager em = JPAUtil.getEntityManager();
        EstadoDao estadoDao = new EstadoDao(em);

        em.getTransaction().begin();
        estadoDao.remover(4L);
        em.getTransaction().commit();

        em.close();

    }



    public static void main(String[] args) {

//        inserirDao();
//        consultarDao();
//        removerDao();
        listarDao();


    }


}
