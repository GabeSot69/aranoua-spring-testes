package testeManual;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Cidade;
import model.Estado;
import util.JPAUtil;

public class TesteCidade {

    private static void inserirNoBancoDeDadosEstado() {

//        Obtenho a EntityManager
        EntityManager em = JPAUtil.getEntityManager();

        Estado estado = new Estado();
        estado.setNome("Sao Paulo");
        estado.setSigla("SP");

        em.getTransaction().begin();

        em.persist(estado);

        em.getTransaction().commit();

        em.close();

    }


    private static void inserirNoBancoDeDadosCidade() {

//        Obtenho a EntityManager
        EntityManager em = JPAUtil.getEntityManager();

        Estado estado = em.find(Estado.class,1L);

        Cidade cidade = new Cidade();
        cidade.setNome("Sao Paulo");
        cidade.setEstado(estado);

        em.getTransaction().begin();

        em.persist(cidade);

        em.getTransaction().commit();

        em.close();

    }


    private static void listarDoBancoDeDados() {

        //      SQL (Structured Query Language): select id,nome,estado from cidade;
//      JPQL (Java Persistence Query Language): select cidade from Cidade cidade

        EntityManager em = JPAUtil.getEntityManager();

        Query consulta = em.createQuery("select cidade from Cidade cidade");

        List<Cidade> cidades = consulta.getResultList();

        for(Cidade c:cidades){
            System.out.println("Id:"+c.getId()+" Nome:"+c.getNome()+" Estado:"+c.getEstado());
        }

        em.close();

    }

    private static void consultarEspecificoDoBancoDeDados() {

        EntityManager em = JPAUtil.getEntityManager();

        Cidade cidadeEncontrada = em.find(Cidade.class,5L);

        System.out.println("Cidade encontrada:"+cidadeEncontrada.getNome());

        em.close();

    }


    private static void removerDoBancoDeDados() {

        EntityManager em = JPAUtil.getEntityManager();

        em.getTransaction().begin();

        Cidade cidadeEncontrada=em.find(Cidade.class,5L);

        em.remove(cidadeEncontrada);

        em.getTransaction().commit();

        em.close();

    }

    public static void main(String[] args) {


        // Insere um registro no banco de dados Estado.

//        inserirNoBancoDeDadosEstado();

        // Insere um registro no banco de dados Cidade.

        inserirNoBancoDeDadosCidade();

        // Listar os registros no banco de dados

//        listarDoBancoDeDados();

        // Consultar um registro específico no banco de dados

//        consultarEspecificoDoBancoDeDados();

        // Remover registros do banco de dados

//        removerDoBancoDeDados();

    }


}
