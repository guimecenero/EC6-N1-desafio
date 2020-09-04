import java.io.*;
import java.util.*;

public class Data {

    File arquivo = new File("/Tabela.txt");

    public boolean CheckFile() throws IOException {

        return  arquivo.createNewFile();
    }

    public String[] GetLine(int id) throws Exception {
        FileReader fr = new FileReader(arquivo);
        BufferedReader br = new BufferedReader(fr);
        while (br.ready())
        {
            String linha = br.readLine();
            String[] retorno = linha.split(";");
            int codigo = Integer.parseInt(retorno[0]);
            if (codigo == id) return retorno;
        }
        throw new Exception("Id não encontrado");
    }

    public String[] GetAll() throws IOException {
        FileReader fr = new FileReader(arquivo);
        BufferedReader br = new BufferedReader(fr);
        String aux = "";
        while (br.ready())
        {
            String linha = br.readLine();
            linha = linha + "|";
            aux = aux + linha;
        }
        return aux.split("|");
    }
}
