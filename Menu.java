import java.util.Scanner;
    public class Menu {
    private Gestor gestor;
    Scanner sc = new Scanner(System.in);
    
    public Menu() {
        this.gestor = new Gestor();
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
