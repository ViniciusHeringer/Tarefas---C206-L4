public class Livro {
    private String nome;
    private String autor;
    private String editora;
    private int qtdPaginas;

    public Livro(String nome, String autor, String editora, int qtdPaginas) throws InfoInvalidaException
    {
        this.nome = nome;
        this.autor = autor;
        this.qtdPaginas = qtdPaginas;
        this.editora = editora;

        if (!editora.equals("Leya") && !editora.equals("Arqueiro") && !editora.equals("Rocco"))
        {
            throw new InfoInvalidaException("Info Inválida");
        }

        if(qtdPaginas <= 0)
        {
            throw new InfoInvalidaException("Info Inválida");
        }
    }

    public String getNome() {
        return nome;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditora() {
        return editora;
    }

    public int getQtdPaginas() {
        return qtdPaginas;
    }

    public void mostraInfos() {
        System.out.println("Nome do livro: "+this.nome);
        System.out.println("Autor do livro: "+this.autor);
        System.out.println("Editora do livro: "+this.editora);
        System.out.println("Quantidade de paginas do livro: "+this.qtdPaginas);
    }
}