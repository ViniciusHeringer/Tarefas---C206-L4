import java.util.ArrayList;
import java.util.List;

public class Cliente {
    String nome;
    long cpf;
    List<Computador> PCs = new ArrayList<>();

    float calculaTotalCompra()
    {
        Object[] computadores = PCs.toArray();
        float totalCompra = 0;
        for (int i = 0; i < computadores.length; i++)
        {
            totalCompra += ((Computador)computadores[i]).Preco;
            System.out.println("PC " + (i + 1) + ": ");
            ((Computador)computadores[i]).mostraPCConfigs();
            System.out.println();
        }
        return totalCompra;
    }
}
