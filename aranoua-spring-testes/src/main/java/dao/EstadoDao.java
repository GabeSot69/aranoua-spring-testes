package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Estado;

public class EstadoDao {
    private EntityManager em;

    public EstadoDao(EntityManager em) {
        this.em = em;
    }

    public void inserir(Estado estado) {
        em.persist(estado);
    }

    public List<Estado> listar() {
        Query consulta = em.createQuery("select estado from Estado estado");
        return consulta.getResultList();
    }

    public Estado consultar(Long id) {
        return em.find(Estado.class, id);
    }

    public void remover(Long id) {
        em.remove(em.find(Estado.class, id));
    }
}
