import java.time.LocalDate;

public abstract class Pessoa {
    private String nome;
    private String cpf;
    private LocalDate dataNasc;

    public Pessoa(String nome, String cpf, LocalDate dataNasc){
        this.nome = nome;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
    }
    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getCpf(){
        return this.cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public LocalDate getDataNasc(){
        return this.dataNasc;
    }
    public void setNome(LocalDate dataNasc){
        this.dataNasc = dataNasc;
    }

}