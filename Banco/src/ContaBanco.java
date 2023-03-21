public class ContaBanco {
    // Atributos da ContaBanco
    float saldoDaContaBanco; // Saldo da ContaBanco
    String numContaBanco; // Número da ContaBanco

    // Titular agregado a ContaBanco
    TitularBanco[] titular = new TitularBanco[2];

    // Construtor da classe
    public ContaBanco(float saldoDaContaBanco, String numero) {
        System.out.println("++++ ContaBanco CRIADA +++++");
        this.saldoDaContaBanco = saldoDaContaBanco;
        this.numContaBanco = numero;
    }

    // Método para mostrar as informações
    void mostraInfos() {
        System.out.println("Informações da ContaBanco");
        System.out.println("Saldo: " + this.saldoDaContaBanco);
        System.out.println("Número da ContaBanco: " + this.numContaBanco);
    }

    // Adicionando titulares na ContaBanco
    void addTitular(TitularBanco novoTitular) {
        // Percorrendo as posicoes do array
        for (int i = 0; i < titular.length; i++) {
            if (titular[i] == null) {
                titular[i] = novoTitular; // Adicionei um titular a uma posição vazia
                break;
            }

        }
    }
}
