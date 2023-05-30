import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Arquivo
{
    public static void escrever(Livro livro) {
        try
        {
            FileWriter escritor = new FileWriter("arquivo.txt", true);
            escritor.write(livro.getNome() + "," + livro.getAutor() + "," + livro.getEditora() + "," + livro.getQtdPaginas() + "\n");
            escritor.close();
        }
        catch (IOException e)
        {
            System.out.println("Ocorreu um erro ao salvar o livro no arquivo: " + e.getMessage());
        }
    }

    public static ArrayList<Livro> ler()
    {
        ArrayList<Livro> toReturn = new ArrayList<Livro>();
        try
        {
            BufferedReader leitor = new BufferedReader(new FileReader("arquivo.txt"));
            String linha;
            while ((linha = leitor.readLine()) != null)
            {
                String[] split = linha.split(",");
                toReturn.add(new Livro(split[0], split[1], split[2], Integer.parseInt(split[3])));
            }
            leitor.close();
        }
        catch (IOException e)
        {
            System.out.println("Ocorreu um erro ao ler o arquivo: " + e.getMessage());
        }
        catch (InfoInvalidaException e)
        {
            System.out.println(e);
        }

        return toReturn;
    }
}
