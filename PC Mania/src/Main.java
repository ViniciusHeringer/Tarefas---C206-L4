import java.util.Scanner;

public class Main {
    public static Scanner Input = new Scanner(System.in);

    public static void main(String[] args) {

        Cliente Cliente = new Cliente();
        Computador PC1 = new Computador();
        Computador PC2 = new Computador();
        Computador PC3 = new Computador();
        MemoriaUSB tempUsb;


        Cliente.nome = "Schnoz";
        Cliente.cpf = 215_666_420_69l; //l no final para o long funcionar


        PC1.Marca = new String("Positivo");
        PC1.Preco = 2300;
        PC1.HardB.nome = "Pentium Core i3 (2200 Mhz)";
        PC1.HardB.CapacidadeRam = 8;
        PC1.HardB.CapacidadeHDD = 500;
        PC1.SisOp.nome = "Linux Ubuntu";
        PC1.SisOp.tipo = 32;
        tempUsb = new MemoriaUSB();
        tempUsb.nome = "PenDrive";
        tempUsb.capacidade = 16;
        PC1.addMemoriaUSB(tempUsb);

        PC2 = new Computador();
        PC2.Marca = new String("Acer");
        PC2.Preco = 5800;
        PC2.HardB.nome = "Pentium Core i5 (3370 Mhz)";
        PC2.HardB.CapacidadeRam = 16;
        PC2.HardB.CapacidadeHDD = 1000;
        PC2.SisOp.nome = "Windows 8";
        PC2.SisOp.tipo = 64;
        tempUsb = new MemoriaUSB();
        tempUsb.nome = "PenDrive";
        tempUsb.capacidade = 32;
        PC2.addMemoriaUSB(tempUsb);

        PC3 = new Computador();
        PC3.Marca = new String("Vaio");
        PC3.Preco = 1800;
        PC3.HardB.nome = "Pentium Core i7 (4500 Mhz)";
        PC3.HardB.CapacidadeRam = 32;
        PC3.HardB.CapacidadeHDD = 2000;
        PC3.SisOp.nome = "Windows 10";
        PC3.SisOp.tipo = 64;
        tempUsb = new MemoriaUSB();
        tempUsb.capacidade = 1000;
        tempUsb.nome = "HD Externo";
        PC3.addMemoriaUSB(tempUsb);

        
        System.out.println
                (
                        "Escolha numeros correpondentes as promocoes da loja para compra-las!\n" +
                                "////////////////////////////////////////////////////////\n" +
                                "1- PC Positivo com Pentium i3 (2200Mhz), 8Gb de RAM, 500Gb de HD, SO Linux Ubuntu (32b) acompanhado de um Pen-Drive de 16 GB\n" +
                                "Tudo isso por apenas R$2300.00!\n" +
                                "////////////////////////////////////////////////////////\n" +
                                "2- PC Acer com Pentium i5 (3370Mhz), 16Gb de RAM, 1Tb de HD, SO Windows 8 (64b) acompanhado de um Pen-Drive de 32 GB\n" +
                                "Tudo isso por apenas 5800.00!\n" +
                                "////////////////////////////////////////////////////////\n" +
                                "3- PC Positivo com Pentium i7 (4500Mhz), 32Gb de RAM, 2Tb de HD, SO Windows 10 (64b) acompanhado de um HD Externo de 1Tb\n" +
                                "Tudo isso por apenas R$1800.00!\n" +
                                "////////////////////////////////////////////////////////\n" +
                                "0-Sair\n" +
                                "////////////////////////////////////////////////////////"
                );


        int escolha = 1;
        while (escolha != 0) {
            System.out.print("Opção: ");
            escolha = Input.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("A promoção escolhida foi a número 1!");
                    System.out.println("Produtos correspondentes foram adicionados ao carrinho.");

                    Cliente.PCs.add(PC1);
                    break;
                case 2:
                    System.out.println("A promoção escolhida foi a número 2!");
                    System.out.println("Produtos correspondentes foram adicionados ao carrinho.");

                    Cliente.PCs.add(PC2);
                    break;
                case 3:
                    System.out.println("A promoção escolhida foi a número 3!");
                    System.out.println("Produtos correspondentes foram adicionados ao carrinho.");

                    Cliente.PCs.add(PC3);
                    break;
                case 0:
                    System.out.println("\nSAINDO...");
                    System.out.println("Usuário: " + Cliente.nome);
                    System.out.println("CPF: " + Cliente.cpf);
                    System.out.println();
                    System.out.println(String.format("Valor total: R$%.2f", Cliente.calculaTotalCompra()));
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente!");
                    break;
            }
        }
    }
}