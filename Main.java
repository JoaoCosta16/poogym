/**
 * Classe main
 * @author Gustavo e João
 * @version 1.0
 */

public class Main {

    /**
     * Construtor privado da classe Main
     */
    private Main() {
    }

    /**
     * arranca a aplicacao e apresenta o menu
     * @param args argumentos da linha de comandos (nao utilizados)
     */
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.iniciarMenu();
    }
}
