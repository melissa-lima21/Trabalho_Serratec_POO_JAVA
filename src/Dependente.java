import java.time.LocalDate;

public class Dependente extends Pessoa {
    private Parentesco parentesco;

    public Dependente(
            String nome,
            String cpf,
            LocalDate dataNasc,
            Parentesco parentesco){

        super(nome,cpf,dataNasc);
        this.parentesco = parentesco;

    }


}
