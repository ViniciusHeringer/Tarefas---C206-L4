import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int NP1;
        int NP2;
        int mediaFinal;

        Scanner scan = new Scanner(System.in);

        System.out.println("Insira a nota da primeira prova: ");
        NP1 = scan.nextInt();
        System.out.println("Insira a nota da segunda prova: ");
        NP2 = scan.nextInt();

        System.out.println("/////////////////////////////////");
        mediaFinal = ((NP1+NP2)/2);
        System.out.println("Sua média final é: " + mediaFinal);


    }
}