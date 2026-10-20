import java.util.ArrayList;

public class Gestor {

    /**
     * Lista dinamica que contem todos os socios registados no ginasio
     */
    private ArrayList<SocioIndividual> sociosIndividuais;
    private ArrayList<SocioEmpresa> sociosEmpresa;

    /**
     * Construtor da classe Gestor
     * Inicia a lista dos socios vazia
     */
    public Gestor(){
        sociosEmpresa = new ArrayList<>();
        sociosIndividuais = new ArrayList<>();

    }

    /**
     * Verifica se ja existe um socio registado com o numero indicado 
     * @param numeroSocio o valor a verificar se ja existe
     * @return true se os socio ja exister e false caso contrario
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
}
