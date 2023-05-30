public class GooglePlus extends RedeSocial implements VideoConferencia, Compartilhamento {

    @Override
    public void postarFoto() {
        System.out.println("Postou uma foto no Google Plus!");
    }

    @Override
    public void postarVideo() {
        System.out.println("Postou um video no Google Plus!");
    }

    @Override
    public void postarComentario() {
        System.out.println("Postou um comentario no Google Plus!");
    }

    @Override
    public void curtirPublicacao() {
        System.out.println("Curtiu uma publicacao no Google Plus!");
    }


    @Override
    public void compartilhar() {
        System.out.println("Compartilhou um post no Google Plus!");
    }

    @Override
    public void fazStreaming() {
        System.out.println("Realizou uma Video Conferencia no Google Plus!");
    }
}
