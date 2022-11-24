import java.util.ArrayList;

public class Garcom {
    private Integer idGarcom;
    private String nome;
    private String cpf;
    private String dataNascimento;
    private String email;
    private Integer telefone;
    private String sexo;
    private Double salarioFixo;



    public Garcom() {}

    public Garcom(Integer idGarcom, String nome, String cpf, String dataNascimento, String email, Integer telefone, String sexo, Double salarioFixo) {
        this.idGarcom = idGarcom;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
        this.sexo = sexo;
        this.salarioFixo = salarioFixo;

    }

    public Integer getIdGarcom() {
        return idGarcom;
    }

    public void setIdGarcom(Integer idGarcom) {
        this.idGarcom = idGarcom;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Double getSalarioFixo() {
        return salarioFixo;
    }

    public void setSalarioFixo(Double salarioFixo) {
        this.salarioFixo = salarioFixo;
    }

}
