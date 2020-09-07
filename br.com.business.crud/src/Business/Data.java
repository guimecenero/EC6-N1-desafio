package Business;
import java.io.*;
import VO.RoupaVO;

public class Data {

    File arquivo = new File("/Tabela.txt");

    private boolean CheckFile() throws IOException {
        return  arquivo.createNewFile();
    }

    public String[] GetLine(int id) throws Exception {
        CheckFile();
        FileReader fr = new FileReader(arquivo);
        BufferedReader br = new BufferedReader(fr);
        while (br.ready())
        {
            String linha = br.readLine();
            String[] retorno = linha.split(";");
            int codigo = Integer.parseInt(retorno[0]);
            br.close();
            fr.close();
            if (codigo == id) return retorno;
        }
        throw new Exception("Id não encontrado");
    }

    public String[] GetAll() throws IOException {
        CheckFile();
        FileReader fr = new FileReader(arquivo);
        BufferedReader br = new BufferedReader(fr);
        String aux = "";
        while (br.ready())
        {
            String linha = br.readLine();
            linha = linha + "#";
            aux = aux + linha;
        }
        br.close();
        fr.close();
        return aux.split("#");
    }

    public int nextID() throws IOException {
        String[] linhas = GetAll();
        int lastID = Integer.parseInt(linhas[linhas.length - 1].split(";")[0]);
        return lastID + 1;
    }

    public void NewLine(RoupaVO roupa) throws IOException {
        FileWriter fw = new FileWriter(arquivo,true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(roupa.getId() + ";" +
                roupa.getDataEntrada() + ";" +
                roupa.getLocalCompra() + ";" +
                roupa.getTipo() + ";" +
                roupa.getMarca() + ";" +
                roupa.getDescricaoPeca() + ";" +
                roupa.getTamanho() + ";" +
                roupa.getCor() + ";" +
                roupa.getValorEtiqueta() + ";" +
                roupa.getValorPago() + ";" +
                roupa.getValorMargem100porcento() + ";" +
                roupa.getPrecoSugerido());
        bw.newLine();
        bw.close();
        fw.close();
    }

    public void EditLine(RoupaVO roupa) throws IOException {
        boolean mudou = false;
        String[] linha = GetAll();
        for (int i = 0; i < linha.length; i++)
        {
            String[] aux = linha[i].split(";");
            if (Integer.parseInt(aux[0]) == roupa.getId())
            {
                linha[i] = (roupa.getId() + ";" +
                        roupa.getDataEntrada() + ";" +
                        roupa.getLocalCompra() + ";" +
                        roupa.getTipo() + ";" +
                        roupa.getMarca() + ";" +
                        roupa.getDescricaoPeca() + ";" +
                        roupa.getTamanho() + ";" +
                        roupa.getCor() + ";" +
                        roupa.getValorEtiqueta() + ";" +
                        roupa.getValorPago() + ";" +
                        roupa.getValorMargem100porcento() + ";" +
                        roupa.getPrecoSugerido());
                mudou = true;
                break;
            }
        }
        if (mudou) ReWriteAll(linha);
    }

    public void DeleteLine(int id) throws IOException {
        boolean mudou = false;
        String[] linha = GetAll();
        String[] newLinha = new String[linha.length-1];
        int pos = 0;
        for (int i = 0; i < linha.length; i++)
        {
            String[] aux = linha[i].split(";");
            if (Integer.parseInt(aux[0]) != id)
            {
                newLinha[pos] = linha[i];
                pos++;
            }
            else mudou = true;
        }
        if (mudou) ReWriteAll(newLinha);
    }

    private void ReWriteAll(String[] linhas) throws IOException {
        FileWriter fw = new FileWriter(arquivo,false);
        BufferedWriter bw = new BufferedWriter(fw);
        for (String linha: linhas) {
            bw.write(linha);
            bw.newLine();
        }
        bw.close();
        fw.close();
    }
}
