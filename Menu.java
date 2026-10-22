import java.util.Scanner;
    public class Menu {
    private Gestor gestor;
    Scanner sc = new Scanner(System.in);
    
    public Menu() {
        this.gestor = new Gestor();
    }

    public void iniciarMenu() {
        int opcao = -1;
        do {
            System.out.println("\n========== POOGYM ==========");
            System.out.println("1 - Registar Socio");
            System.out.println("2 - Registar Instrutor");
            System.out.println("3 - Registar Atividade");
            System.out.println("4 - Listar Socios");
            System.out.println("5 - Listar Atividades");
            System.out.println("6 - Criar Marcação");
            System.out.println("7 - Listar Marcacoes");
            System.out.println("8 - Resumo de Atividades");
            System.out.println("9 - Mais Popular");
            System.out.println("10 - Valores Socio");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao: ");

            opcao = sc.nextInt();
            sc.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    //registarSocio();
                    break;
                case 2:
                    registarInstrutor();
                    break;
                case 3:
                    //registarAtividade();
                    break;
                case 4:
                    //listarSocios();
                    break;
                case 5:
                    //listarAtividades();
                    break;
                case 6:
                    //criarMarcacao();
                    break;
                case 7:
                    //listarMarcacoes();
                    break;
                case 8:
                    //resumoAtividades();
                    break;
                case 9:
                    //maisPopular();
                    break;
                case 10:
                    //valoresSocio();
                    break;
                case 0:
                    System.out.println("A sair...");
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
        } while (opcao != 0);
    }

    public void registarSocio() {
        Socio novoSocio = null;
        System.out.println("---Registar Socio---");
        
        System.out.print("Nome");
        String nomeSocio = sc.nextLine();

        System.out.print("Numero:");
        int numeroSocio = sc.nextInt();

        System.out.print("Email:");
        String email = sc.nextLine();

        System.out.print("Introduza o numero correspondente ao seu tipo de Socio: (0 - Individual | 1 - Empresa)");
        int tipo = sc.nextInt();

        switch (tipo) {
            case 0:
                System.out.println("--Socio Individual Escolhido--");
                System.out.print("Ano de nascimento: ");
                int ano = sc.nextInt();
                novoSocio = new SocioIndividual(nomeSocio, numeroSocio, email, ano);

                if(adicionarSocio(novoSocio)) {
                    System.out.println("Socio Individual adicionado com sucesso")
                } else {
                    System.out.print("Erro a adicionar socio");
                }

                break;
            case 1: 
                System.out.println("--Socio Empresa Escolhido--");

                System.out.print("Nome da empresa: ");
                String nomeEmpresa = sc.nextLine();

                System.out.print("NIF da empresa: ");
                int NIF = sc.nextInt();

                novoSocio = new SocioEmpresa(nomeSocio, numeroSocio, email, NIF ,nomeEmpresa);
                
                if(adicionarSocio(novoSocio)) {
                    System.out.println("Socio Individual adicionado com sucesso")
                } else {
                    System.out.print("Erro a adicionar socio");
                }
                
                break;
            default:
                System.out.println("Opcao invalida!");
        }

    }

    public void registarInstrutor() {
        System.out.println("---Registar Instrutor---");

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Genero: ");
        String genero = sc.nextLine();

        System.out.print("Formacao (Cursos e Formacoes):");
        String formacao = sc.nextLine();

        Instrutor instrutor = new Instrutor(nome, genero, formacao);

        if (gestor.adicionarInstrutor(instrutor)) {
            System.out.println("Instrutor registado com sucesso");
        } else {
            System.out.println("Erro ao registar o instrutor");
        }
    }
}
