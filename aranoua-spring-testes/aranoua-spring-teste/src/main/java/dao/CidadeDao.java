package dao;

import model.Cidade;
import model.Estado;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CidadeDao {

    private EntityManager em;

    public CidadeDao(EntityManager em){
        this.em = em;
    }

    public void inserir(Cidade cidade){
        em.persist(cidade);

    }
    public List<Cidade> listar(){
        Query consulta = em.createQuery("select cidade from Cidade cidade");

        return consulta.getResultList();
    }

    public Cidade consultar(Long id){
        return em.find(Cidade.class,id);
    }

    public void remover(Long id){

        em.remove(em.find(Cidade.class,id));
    }


}
