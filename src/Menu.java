import java.util.*;

public class Menu {
    public static void main(String[] args) {
        boolean ficarPrograma = true;
        do {
            Scanner read = new Scanner(System.in);
            System.out.println("Escolha uma ação:");
            System.out.println("1 - Logar");
            System.out.println("2 - Sair");
            int escolha = read.nextInt();
            switch (escolha) {
                case 1:
                    System.out.print("Digite nome de usuário: ");
                    read = new Scanner(System.in);
                    String nome = read.nextLine();
                    System.out.print("Digite a senha: ");
                    read = new Scanner(System.in);
                    String senha = read.nextLine();
                    System.out.println(nome + " - " + senha);
                    if (nome.equals("guilherme") && senha.equals("123")) {
                        boolean ficar = true;
                        do {
                            System.out.println("Escolha o que quer fazer:");
                            System.out.println("1 - Inserir produto");
                            System.out.println("2 - Exibir produtos");
                            System.out.println("3 - Editar dados de um produto");
                            System.out.println("4 - Excluir produto");
                            System.out.println("5 - Sair"); //e assim por diante
                            read = new Scanner(System.in);
                            int opcao = read.nextInt();
                            switch (opcao)
                            {
                                case 1: //criação de produto
                                    break;
                                case 2: //consulta de produtos
                                    break;
                                case 3: //edição
                                    break;
                                case 4: //exclusão
                                    break;
                                case 5: //sair do programa
                                    ficar = false;
                                    break;
                                default:
                                    System.out.println("Opção invalida, tente denovo");
                                    break;
                            }
                        }
                        while (ficar);
                    }
                    break;
                case 2:
                    ficarPrograma = false;
                    break;
                default:
                    System.out.println("Opção invalida, tente denovo");
                    break;
            }
        }
        while(ficarPrograma);
    }
}
