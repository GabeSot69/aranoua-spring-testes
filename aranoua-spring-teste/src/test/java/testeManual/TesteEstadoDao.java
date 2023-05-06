package testeManual;

import dao.CidadeDao;
import dao.EstadoDao;
import model.Cidade;
import model.Estado;

import java.util.List;

public class TesteEstadoDao {
    private static void inserirDao(){
        EstadoDao estadoDao = new EstadoDao();
        Estado estado = new Estado();

        estado.setNome("Sao Paulo");

        estadoDao.inserir(estado);
    }

    private static void listarDao(){
        EstadoDao estadoDao = new EstadoDao();
        List<Estado> estados = estadoDao.listar();

        for (Estado e: estados) {
            System.out.println("Cidade " + e.getId() + ": " + e.getNome() + " Sigla: " + e.getSigla());
        }
    }

    private static void consultarDao(){
        EstadoDao estadoDao = new EstadoDao();

        Estado estadoEncontrado = estadoDao.consultar(1L);
        System.out.println("Estado encontrado: " + estadoEncontrado.getNome());

    }

    private static void removerDao(){
        EstadoDao estadoDao = new EstadoDao();

        estadoDao.remover(1L);
        System.out.println("Cidade com id: 1 "  + " removida");

    }

    public static void main(String[] args) {
        //inserirDao();
        //listarDao();
        removerDao();
        //removerDao();

    }
}
