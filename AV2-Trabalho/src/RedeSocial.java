public abstract class RedeSocial {
    protected String senha;
    protected int numAmigos;

    public void postarFoto() {
        System.out.println("Postou uma foto!");
    }

    public void postarVideo() {
        System.out.println("Postou um video!");
    }

    public void postarComentario() {
        System.out.println("Postou um comentario!");
    }

    public void curtirPublicacao() {
        System.out.println("Curtiu uma publicacao!");
    }
}
