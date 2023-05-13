package dao;

import model.Cidade;
import model.Estado;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class EstadoDao {
    public void inserir(Estado estado){
        EntityManager em = JPAUtil.getEntityManager();

        em.getTransaction().begin();
        em.persist(estado);
        em.getTransaction().commit();

        em.close();
    }

    public List<Estado> listar(){
        EntityManager em = JPAUtil.getEntityManager();

        Query consulta = em.createQuery("select estado from Estado estado");

        List<Estado> estados = consulta.getResultList();

        em.close();

        return estados;
    }

    public Estado consultar(Long id){
        EntityManager em = JPAUtil.getEntityManager();

        Estado estadoEncontrado = em.find(Estado.class,id);

        em.close();

        return estadoEncontrado;
    }

    public void remover(Long id){
        EntityManager em = JPAUtil.getEntityManager();

        em.getTransaction().begin();

        Estado estadoEncontrado =em.find(Estado.class,id);

        em.remove(estadoEncontrado);

        em.getTransaction().commit();

        em.close();
    }
}
