import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Livro> livros = new ArrayList<>();

        int opcao;
        do
        {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer de entrada

            switch (opcao)
            {
                case 1:
                    System.out.println("Digite o nome do livro:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o autor do livro:");
                    String autor = scanner.nextLine();
                    System.out.println("Digite a editora do livro:");
                    String editora = scanner.nextLine();
                    System.out.println("Digite o número de páginas do livro:");
                    int qtdPaginas = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer de entrada
                    Livro livro = null;

                    try
                    {
                        livro = new Livro(nome, autor, editora, qtdPaginas);
                    }
                    catch (InfoInvalidaException e)
                    {
                        System.out.println(e);
                    }
                    livros.add(livro);
                    Arquivo.escrever(livro);
                    System.out.println("Livro salvo no arquivo.txt");
                    break;

                case 2:

                    System.out.println("Informações dos livros salvos:");
                    try
                    {
                        ArrayList<Livro> livrosArquivo = Arquivo.ler();
                        for (Livro l: livrosArquivo)
                        {
                            l.mostraInfos();
                        }
                    }
                    catch (NullPointerException e)
                    {
                        throw new RuntimeException(e);
                    }

                    break;

                case 3:
                    System.out.println("Livros em ordem crescente de páginas:");
                    ordenarLivrosPorPaginasCrescente(livros);
                    mostrarLivros(livros);
                    break;

                case 4:
                    System.out.println("Livros em ordem decrescente de páginas:");
                    ordenarLivrosPorPaginasDecrescente(livros);
                    mostrarLivros(livros);
                    break;

                case 0:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }

    public static void exibirMenu() {
        System.out.println("\n==== Menu ====");
        System.out.println("1) Salvar as informações do livro no arquivo.txt");
        System.out.println("2) Mostrar as informações dos livros salvos no arquivo");
        System.out.println("3) Ordenar os livros em ordem crescente de páginas");
        System.out.println("4) Ordenar os livros em ordem decrescente de páginas");
        System.out.println("0) Sair");
        System.out.print("Escolha uma opção: ");
    }

    public static void ordenarLivrosPorPaginasCrescente(List<Livro> livros) {
        Collections.sort(livros, new Comparator<Livro>() {
            @Override
            public int compare(Livro livro1, Livro livro2) {
                return livro1.getQtdPaginas() - livro2.getQtdPaginas();
            }
        });
    }

    public static void ordenarLivrosPorPaginasDecrescente(List<Livro> livros) {
        Collections.sort(livros, new Comparator<Livro>() {
            @Override
            public int compare(Livro livro1, Livro livro2) {
                return livro2.getQtdPaginas() - livro1.getQtdPaginas();
            }
        });
    }

    public static void mostrarLivros(List<Livro> livros) {
        for (Livro livro : livros) {
            System.out.println(livro);
        }
    }
}
