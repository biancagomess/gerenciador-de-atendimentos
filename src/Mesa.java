import java.util.ArrayList;

public class Mesa {
    private int numeroMesa;
    private String situacao;
    private int capacityMaxClientes;
    private Garcom garcon;
    private String nomeGarcom;

    public Mesa() {
    }

    public Mesa(int numeroMesa, String situacao, int capacityMaxClientes, Garcom garcon, String nomeGarcom) {
        this.numeroMesa = numeroMesa;
        this.situacao = situacao;
        this.capacityMaxClientes = capacityMaxClientes;
        this.garcon = garcon;
        this.nomeGarcom = nomeGarcom;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public int getCapacityMaxClientes() {
        return capacityMaxClientes;
    }

    public void setCapacityMaxClientes(int capacityMaxClientes) {
        this.capacityMaxClientes = capacityMaxClientes;
    }

    public Garcom getGarcon() {
        return garcon;
    }

    public void setGarcon(Garcom garcon) {
        this.garcon = garcon;
    }

    public String getNomeGarcom() {
        return nomeGarcom;
    }

    public void setNomeGarcom(String nomeGarcom) {
        this.nomeGarcom = nomeGarcom;
    }

    @Override
    public String toString() {
        return String.format("\n\tNúmero da mesa: %d \n\t Situcação da mesa: %s\n\t Capacidade Máxima de clientes %d\n", numeroMesa, situacao, capacityMaxClientes);
    }

}
