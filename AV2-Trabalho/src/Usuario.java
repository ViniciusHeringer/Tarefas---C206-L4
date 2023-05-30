import java.util.ArrayList;

public class Usuario {
    public String nome;
    public String email;

    public ArrayList<RedeSocial> RedesSociais;

    public Usuario(ArrayList<RedeSocial> rs) {
        RedesSociais = rs;
    }

}
