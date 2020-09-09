import Enums.CoresRoupa;
import Enums.TamanhoRoupa;
import VO.RoupaVO;

import Business.Data;
import com.sun.deploy.util.StringUtils;

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
                    //System.out.println(nome + " - " + senha); //linha de debug
                    if (nome.equals("guilherme") && senha.equals("123")) {
                        boolean ficar = true;
                        do {
                            try {
                                System.out.println("Escolha o que quer fazer:");
                                System.out.println("1 - Inserir produto");
                                System.out.println("2 - Exibir produtos");
                                System.out.println("3 - Editar dados de um produto");
                                System.out.println("4 - Excluir produto");
                                System.out.println("5 - Sair");
                                read = new Scanner(System.in);
                                int opcao = read.nextInt();
                                switch (opcao) {
                                    case 1: //Inserir roupa
                                        InserirRoupa();
                                        break;
                                    case 2: //consulta de produtos
                                        listarRoupas();
                                        break;
                                    case 3: //edição
                                        System.out.print("Digite o id da roupa para ser editada (0 para cancelar): ");
                                        read = new Scanner(System.in);
                                        int cod = read.nextInt();
                                        if (cod != 0)
                                            editarRoupa(cod);
                                        break;
                                    case 4: //exclusão
                                        System.out.println("Digite o id da roupa para ser EXCLUÍDA (0 para cancelar): ");
                                        read = new Scanner(System.in);
                                        int id = read.nextInt();
                                        Data info = new Data();
                                        if (id != 0)
                                            info.DeleteLine(id);
                                        break;
                                    case 5: //sair do programa
                                        ficar = false;
                                        break;
                                    default:
                                        System.out.println("Opção invalida, tente de novo");
                                        break;
                                }

                            }
                            catch (Exception e)
                            {
                                System.out.println(e);
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
        while (ficarPrograma);
    }

    public static void InserirRoupa() {
        RoupaVO roupa = new RoupaVO();
        Data data = new Data();
        String escrito; //variável usada pra validações de string
        double valorDigitado; //variável usada pra validações de double
        boolean valido = false;
        try {
            roupa.setId(data.nextID());
            Scanner read;
            do {
                System.out.println("Insira a Data de entrada: (DD/MM/AAAA)");
                read = new Scanner(System.in);
                String dataDMY = read.nextLine();
                if (validarData(dataDMY)) {
                    roupa.setDataEntrada(dataDMY);
                    valido = true;
                } else {
                    System.out.println("Data Inválida!");
                }
            }
            while (!valido);
            do {
                System.out.println("Digite o Local de compra: ");
                read = new Scanner(System.in);
                escrito = read.nextLine().trim();
                if(escrito.isEmpty()) {
                    System.out.println("Esse campo não pode estar vazio! ");
                    valido = false;
                }
                else {
                    roupa.setLocalCompra(escrito);
                    valido= true;
                }
            }while (!valido);
            do {
                System.out.println("Digite o tipo de roupa: ");
                read = new Scanner(System.in);
                escrito = read.nextLine().trim();
                if(escrito.isEmpty()) {
                    System.out.println("Esse campo não pode estar vazio! ");
                    valido = false;
                }
                else {
                    roupa.setTipo(escrito);
                    valido = true;
                }
            } while(!valido);
            do {
                System.out.println("Digite a marca da roupa: ");
                read = new Scanner(System.in);
                escrito = read.nextLine().trim();
                if (escrito.isEmpty()) {
                    System.out.println("Esse campo não pode estar vazio! ");
                    valido = false;
                } else {
                    roupa.setMarca(escrito);
                    valido = true;
                }
            }while (!valido);
            do {
                System.out.println("Faça a descrição da peça: ");
                read = new Scanner(System.in);
                escrito = read.nextLine().trim();
                if (escrito.isEmpty()) {
                    System.out.println("Esse campo não pode estar vazio! ");
                    valido = false;
                } else {
                    roupa.setDescricaoPeca(escrito);
                    valido = true;
                }
            } while (!valido);
            TamanhoRoupa[] tamanhos = TamanhoRoupa.values();
            do {
                System.out.println("Escolha o tamanho da peça: \n P \n M \n G \n GG");
                read = new Scanner(System.in);
                escrito = read.nextLine().toUpperCase();
                for (TamanhoRoupa tamanho : tamanhos) {
                    if (escrito.equals(tamanho.toString())) {
                        roupa.setTamanho(tamanho);
                        valido = true;
                        break;
                    }
                    valido = false;
                }
            }while (!valido);

            CoresRoupa[] cores = CoresRoupa.values();
            do{
                System.out.println("Escolha a cor da peça: \n Azul \n Vermelho " +
                                   "\n Amarelo \n Verde \n Roxo \n Preto \n Branco");
                read = new Scanner(System.in);
                escrito = read.nextLine().toUpperCase();
                for (CoresRoupa cor : cores) {
                    if (escrito.equals(cor.toString())) {
                        roupa.setCor(cor);
                        valido = true;
                        break;
                    }
                    valido = false;
                }
            }while (!valido);
            do {
                System.out.println("Digite o valor de etiqueta: ");
                read = new Scanner(System.in);
                valorDigitado = Double.parseDouble(read.nextLine());
                if (valorDigitado <= 0) {
                    System.out.println("Esse valor não pode ser Zero/Negativo! ");
                    valido = false;
                }
                else {
                    roupa.setValorEtiqueta(valorDigitado);
                    valido = true;
                }
            }while(!valido);
            do {
                System.out.println("Digite o valor pago: ");
                read = new Scanner(System.in);
                valorDigitado = Double.parseDouble(read.nextLine());
                if (valorDigitado <= 0) {
                    System.out.println("Esse valor não pode ser Zero/Negativo! ");
                    valido = false;
                }
                else {
                    roupa.setValorPago(valorDigitado);
                    valido = true;
                }
            }while(!valido);
            do{
                System.out.println("Qual o preço sugerido?");
                read = new Scanner(System.in);
                valorDigitado = Double.parseDouble(read.nextLine());
                if (valorDigitado <= 0) {
                    System.out.println("Esse valor não pode ser Zero/Negativo! ");
                    valido = false;
                }
                else {
                    roupa.setPrecoSugerido(valorDigitado);
                    valido = true;
                }
            }while(!valido);

            exibirDadosRoupa(roupa);
            System.out.println("Confirmar os campos acima?");
            System.out.println("1 - Confirmar");
            System.out.println("2 - Corrigir");
            System.out.println("3 - Cancelar");
            read = new Scanner(System.in);
            int opcao = read.nextInt();
            switch (opcao) {
                case 1:
                    data.NewLine(roupa);
                    break;
                case 2:
                    editarRoupa(roupa, true);
                    break;
                case 3:
                    //voltar para o menu
                    break;
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static boolean validarData(String dataDigitada) {
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date data = formato.parse(dataDigitada);
            return true;
        } catch (ParseException erro) {
            return false;
        }
    }

    public static void editarRoupa(RoupaVO roupa, boolean inserido) {
        Data info = new Data();
        boolean ficar = true;
        String escrito;
        do {
            try {
                System.out.println("Selecione a linha que deseja alterar:");
                System.out.println("1 (Data de entrega) - " + roupa.getDataEntrada());
                System.out.println("2 (Local da compra) - " + roupa.getLocalCompra());
                System.out.println("3 (Tipo) - " + roupa.getTipo());
                System.out.println("4 (Marca) - " + roupa.getMarca());
                System.out.println("5 (Características) - " + roupa.getDescricaoPeca());
                System.out.println("6 (Tamanho) - " + roupa.getTamanho());
                System.out.println("7 (Cor) - " + roupa.getCor());
                System.out.println("8 (Valor de etiqueta) - " + roupa.getValorEtiqueta());
                System.out.println("9 (Valor pago) - " + roupa.getValorPago());
                System.out.println("10 (Preço sugerido) - " + roupa.getPrecoSugerido());
                if (inserido) {
                    System.out.println("11 Inserir roupa");
                } else System.out.println("11 Confirmar edição");
                System.out.println("12 Cancelar");
                Scanner read = new Scanner(System.in);
                int opcao = read.nextInt();
                switch (opcao) {
                    case 1://data de entrega
                        System.out.println("Insira a Data de entrada: (DD/MM/AAAA)");
                        read = new Scanner(System.in);
                        String dataDMY = read.nextLine();
                        if (validarData(dataDMY)) {
                            roupa.setDataEntrada(read.nextLine());
                            System.out.println("Data alterada para " + roupa.getDataEntrada());
                        }
                        else {
                            System.out.println("Data Inválida!");
                        }
                        break;
                    case 2: //local da compra
                        System.out.println("Digite o Local de compra: ");
                        read = new Scanner(System.in);
                        roupa.setLocalCompra(read.nextLine());
                        System.out.println("Local de compra alterado para " + roupa.getLocalCompra());
                        break;
                    case 3: //Tipo
                        System.out.println("Digite o tipo de roupa: ");
                        read = new Scanner(System.in);
                        roupa.setTipo(read.nextLine());
                        System.out.println("Tipo alterado para " + roupa.getTipo());
                        break;
                    case 4: //Marca
                        System.out.println("Digite a marca de roupa: ");
                        read = new Scanner(System.in);
                        roupa.setMarca(read.nextLine());
                        System.out.println("Marca alterada para " + roupa.getMarca());
                        break;
                    case 5: //Característica
                        System.out.println("Faça a descrição da peça: ");
                        read = new Scanner(System.in);
                        roupa.setDescricaoPeca(read.nextLine());
                        System.out.println("Descrição alterada para " + roupa.getDescricaoPeca());
                        break;
                    case 6: //Tamanho
                        TamanhoRoupa[] tamanhos = TamanhoRoupa.values();
                        System.out.println("Escolha o tamanho da peça: \n P \n M \n G \n GG");
                        read = new Scanner(System.in);
                        escrito = read.nextLine().toUpperCase();
                        for (TamanhoRoupa tamanho : tamanhos) {
                            if (escrito.equals(tamanho.toString())) {
                                roupa.setTamanho(tamanho);
                            }
                        }
                        break;
                    case 7: //Cor
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
                        break;
                    case 8: //Valor da etiqueta
                        System.out.println("Digite o valor de etiqueta: ");
                        read = new Scanner(System.in);
                        roupa.setValorEtiqueta(Double.parseDouble(read.nextLine()));
                        System.out.println("Valor de etiqueta alterado para: R$" + roupa.getValorEtiqueta());
                        break;
                    case 9: //Valor pago
                        System.out.println("Digite o valor pago: ");
                        read = new Scanner(System.in);
                        roupa.setValorPago(Double.parseDouble(read.nextLine()));
                        System.out.println("Valor pago alterado para: R$" + roupa.getValorPago());
                        break;
                    case 10: //Preço sugerido
                        System.out.println("Qual o preço sugerido?");
                        read = new Scanner(System.in);
                        roupa.setPrecoSugerido(Double.parseDouble(read.nextLine()));
                        System.out.println("Preço sugerido alterado para: R$" + roupa.getPrecoSugerido());
                        break;
                    case 11: //Confirmar
                        if (inserido) {
                            info.NewLine(roupa);
                        } else {
                            info.EditLine(roupa);
                        }
                        ficar = false;
                        break;
                    case 12: //Cancelar
                        ficar = false;
                        break;
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        } while (ficar);
    }

    public static void editarRoupa(int id) {
        Data info = new Data();
        try {
            editarRoupa(info.MontaRoupa(id), false);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void listarRoupas() {

        Data info = new Data();
        try {
            String[] linhas = info.GetAll();
            if (linhas.length-1 <= 0)
            {
                System.out.println("********** Database vazia, adiciona elementos antes! **********");
                return;
            }
            System.out.println("Código - Data de entrada - Local da compra - Tipo - Marca - Características - idTamanho - idCor - Valor da etiqueta - Valor pago - Valor margem de 100% - Preço sugerido");
            for (String linha : linhas) {
                String[] aux = linha.split(";");
                if (aux[0].equals("."))
                {
                    break;
                }
                System.out.println(aux[0] + " - " +
                        aux[1] + " - " +
                        aux[2] + " - " +
                        aux[3] + " - " +
                        aux[4] + " - " +
                        aux[5] + " - " +
                        aux[6] + " - " +
                        aux[7] + " - " +
                        aux[8] + " - " +
                        aux[9] + " - " +
                        aux[10] + " - " +
                        aux[11]);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void exibirDadosRoupa(RoupaVO roupa) {
        System.out.println("Data de entrega: " + roupa.getDataEntrada());
        System.out.println("Local de compra: " + roupa.getLocalCompra());
        System.out.println("Tipo: " + roupa.getTipo());
        System.out.println("Marca: " + roupa.getMarca());
        System.out.println("Descrição da peça: " + roupa.getDescricaoPeca());
        System.out.println("Tamanho: " + roupa.getTamanho());
        System.out.println("Cor da peça: " + roupa.getCor());
        System.out.println("Valor de etiqueta: R$" + roupa.getValorEtiqueta());
        System.out.println("Valor pago: R$" + roupa.getValorPago());
        System.out.println("Valor margem 100%: R$" + roupa.getValorMargem100porcento());
        System.out.println("Preço sugerido: R$" + roupa.getPrecoSugerido());
    }

    public static void exibirDadosRoupa(int id) throws Exception{
        Data info = new Data();
        RoupaVO roupa = info.MontaRoupa(id);
        exibirDadosRoupa(roupa);
    }
}
