import Enums.CoresRoupa;
import Enums.TamanhoRoupa;
import VO.RoupaVO;

import Business.Data;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
                                case 1: //Inserir roupa
                                    InserirRoupa();
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

    public static void InserirRoupa()
    {
        RoupaVO roupa = new RoupaVO();
        Data data = new Data();
        boolean valido = false;
        try {
            roupa.setId(data.nextID());
            Scanner read;
            do {
                System.out.println("Insira a Data de entrada: (DD/MM/AAAA)");
                read = new Scanner(System.in);
                String dataDMY = read.nextLine();
                if (validarData(dataDMY)) {
                    roupa.setDataEntrada(read.nextLine());
                    valido = true;
                }
                else {
                    System.out.println("Data Inválida!");
                }
            }
            while(!valido);
            System.out.println("Digite o Local de compra: ");
            read = new Scanner(System.in);
            roupa.setLocalCompra(read.nextLine());
            System.out.println("Digite o tipo de roupa: ");
            read = new Scanner(System.in);
            roupa.setTipo(read.nextLine());
            System.out.println("Digite a marca da roupa: ");
            read = new Scanner(System.in);
            roupa.setMarca(read.nextLine());
            System.out.println("Faça a descrição da peça: ");
            read = new Scanner(System.in);
            roupa.setDescricaoPeca(read.nextLine());
            TamanhoRoupa[] tamanhos = TamanhoRoupa.values();
            System.out.println("Escolha o tamanho da peça: \n P \n M \n G \n GG");
            read = new Scanner(System.in);
            String escrito = read.nextLine().toUpperCase();
            for (TamanhoRoupa tamanho : tamanhos) {
                if (escrito.equals(tamanho.toString())) {
                    roupa.setTamanho(tamanho);
                }
            }
            CoresRoupa[] cores = CoresRoupa.values();
            System.out.println("Escolha a cor da peça: \n Azul \n Vermelho " +
                               "\n Amarelo \n Verde \n Roxo \n Preto \n Branco");
            read = new Scanner(System.in);
            escrito = read.nextLine().toUpperCase();
            for (CoresRoupa cor : cores) {
                if (escrito.equals(cor.toString())) {
                    roupa.setCor(cor);
                }
            }
            System.out.println("Digite o valor de etiqueta: ");
            read = new Scanner(System.in);
            roupa.setValorEtiqueta(Double.parseDouble(read.nextLine()));
            System.out.println("Digite o valor pago: ");
            read = new Scanner(System.in);
            roupa.setValorPago(Double.parseDouble(read.nextLine()));
            System.out.println("Qual o preço sugerido?");
            read = new Scanner(System.in);
            roupa.setPrecoSugerido(Double.parseDouble(read.nextLine()));

            listarRoupa(roupa);
            System.out.println("Confirmar os campos acima?");
            System.out.println("1 - Confirmar");
            System.out.println("2 - Corrigir");
            System.out.println("3 - Cancelar");
            read = new Scanner(System.in);
            int opcao = read.nextInt();
            switch (opcao)
            {
                case 1:
                    data.NewLine(roupa);
                    break;
                case 2:
                    //jogar no editar
                    break;
                case 3:
                    //voltar para o menu
                    break;
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }

    public static boolean validarData(String dataDigitada) {
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date data = formato.parse(dataDigitada);
            return true;
        }
        catch (ParseException erro) {
            return false;
        }
    }

    public static void listarRoupa(RoupaVO roupa)
    {
        System.out.print("Data de entrega: " + "variavel");
    }

    public static void listarRoupa(int id) throws Exception {
        Data info = new Data();
        RoupaVO roupa = info.MontaRoupa(id);
        listarRoupa(roupa);
    }
}
