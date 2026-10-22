/**
 * Classe Gestor
 * @author Gustavo e João
 * @version 2.0
 */

import java.util.ArrayList;
public class Gestor {

    /**
     * Listas dinamica que contem todos os socios e instrutores registados no ginasio
     */
    private ArrayList<Socio> socios;
    private ArrayList<Instrutor> instrutores;

    /**
     * Construtor da classe Gestor
     * Inicia a lista dos socios e instrutores vazia
     */
    public Gestor(){
        socios = new ArrayList<>();
        instrutores = new ArrayList<>();
    }

    /**
     * Verifica se ja existe um socio registado com o numero indicado 
     * @param numeroSocio o valor a verificar se ja existe
     * @return true se o socio ja exister e false caso contrario
     */

    public boolean existeSocio(int numeroSocio) {
        for (Socio s : socios) {
            if (s.getNumeroSocio() == numeroSocio) {
                return true;
            }   
        }
        return false;
    }

    /**
     * Adiciona um novo socio a lista caso este seja valido
     * @param novoSocio o objeto da Classe Socio a adicionar
     * @return true se a insercao tiver sucesso e false caso contrario
     */

    public boolean adicionarSocio(Socio novoSocio) {
        if (novoSocio == null || existeSocio(novoSocio.getNumeroSocio())) {
            return false;
        }
        socios.add(novoSocio);
        return true;
    }

    /**
     * Obtem a lista com todos os socios registados no ginasio
     * @return
     */
    public ArrayList<Socio> getSocios() {
        return socios;
    }

    /**
     * Verifica se ja existe um instrutor registado com o nome indicado 
     * @param nomeInstrutor o nome a verificar se ja existe
     * @return true se o instrutor ja exister e false caso contrario
     */

    public boolean existeInstrutor(String nomeInstrutor) {
        for (Instrutor i : instrutores) {
            if (i.getNomeInstrutor().equals(nomeInstrutor)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Adiciona um novo intrutor a lista caso este seja valido
     * @param instrutor o objeto da Classe instrutor a adicionar
     * @returninstrutor true se a insercao tiver sucesso e false caso contrario
     */

    public boolean adicionarInstrutor(Instrutor novoInstrutor) {
        if (novoInstrutor == null || existeInstrutor(novoInstrutor.getNomeInstrutor())) {
            return false;
        }
        instrutores.add(novoInstrutor);
        return true;
    }

    /**
     * Obtem a lista com todos os instrutores registados no ginasio
     * @return
     */
    public ArrayList<Instrutor> getInstrutores() {
        return instrutores;
    }



}
