import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Twitter tw = new Twitter();
        tw.numAmigos = 420;
        tw.senha = "senha";

        GooglePlus gp = new GooglePlus();
        gp.numAmigos = 70;
        gp.senha = "schnoz";


        ArrayList<RedeSocial> rs = new ArrayList<RedeSocial>(10);
        rs.add(tw);
        rs.add(gp);

        Usuario user = new Usuario(rs);
        user.email = "schnozzer@gmail.com";
        user.nome = "Vitor Schnoz Pereira";

        user.RedesSociais.get(1).postarVideo();
        ((GooglePlus) user.RedesSociais.get(1)).compartilhar();
        ((GooglePlus) user.RedesSociais.get(1)).fazStreaming();

        user.RedesSociais.get(0).postarComentario();
        user.RedesSociais.get(0).curtirPublicacao();
        user.RedesSociais.get(0).postarFoto();
    }
}