package entidades;
import java.time.LocalDate;
import java.time.Period;

import enums.Parentesco;
import exceptions.DependenteException;

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

    private void validarIdade(LocalDate dataNasc){
        int idade = Period.between(dataNasc, LocalDate.now()).getYears();
        if (idade >= 18){
            throw new DependenteException("Dependente inválido: deve ser menor de 18 anos");
        }
    }
}
