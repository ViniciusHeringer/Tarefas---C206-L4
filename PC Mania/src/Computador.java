public class Computador {
    String Marca;
    float Preco;

    SistemaOperacional SisOp;
    HardwareBasico HardB;
    MemoriaUSB Musb;

    public Computador() {
        SisOp = new SistemaOperacional();
        HardB = new HardwareBasico();
    }

    void mostraPCConfigs() {
        System.out.println
                (
                        "Marca: " + Marca + '\n' +
                                "Processador: " + HardB.nome + '\n' +
                                "RAM: " + Math.round(HardB.CapacidadeRam) + "Gb\n" +
                                "HDD: " + Math.round(HardB.CapacidadeHDD) + "Gb\n" +
                                "Sistema: " + SisOp.nome + '\n' +
                                "Tipo de Sistema: " + SisOp.tipo + "bits"
                );

        if (Musb != null) {
            System.out.println(Musb.nome + "(Brinde): " + Musb.capacidade + "Gb");
        }
    }

    void addMemoriaUSB(MemoriaUSB musb) {
        Musb = musb;
    }
}
