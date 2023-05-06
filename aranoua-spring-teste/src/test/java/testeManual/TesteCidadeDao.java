package testeManual;

import dao.CidadeDao;
import model.Cidade;

import java.util.List;

public class TesteCidadeDao {

    private static void inserirDao(){
        CidadeDao cidadeDao = new CidadeDao();
        Cidade cidade = new Cidade();

        cidade.setNome("Campinas");

        cidadeDao.inserir(cidade);
    }

    private static void listarDao(){
        CidadeDao cidadeDao = new CidadeDao();
        List<Cidade> cidades = cidadeDao.listar();

        for (Cidade c: cidades) {
            System.out.println("Cidade " + c.getId() + ": " + c.getNome() + " Estado: " + c.getEstado());
        }
    }

    private static void consultarDao(){
        CidadeDao cidadeDao = new CidadeDao();
        Long idCidade = 2L;
        Cidade cidadeEncontrada = cidadeDao.consultar(idCidade);
        System.out.println("Cidade encontrada: " + cidadeEncontrada.getNome());

    }

    private static void removerDao(){
        CidadeDao cidadeDao = new CidadeDao();
        Long idCidade = 2L;
        cidadeDao.remover(idCidade);
        System.out.println("Cidade com id: " + idCidade + " removida");

    }

    public static void main(String[] args) {
        removerDao();

    }
}
