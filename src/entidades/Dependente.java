package entidades;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Set;

import enums.Parentesco;
import exceptions.DependenteException;

public class Dependente extends Pessoa {
    private static final Set<String> CPF_Dependente = new HashSet<>();

    private Parentesco parentesco;

    public Dependente(
            String nome,
            String cpf,
            LocalDate dataNasc,
            Parentesco parentesco){
            
            validarCPF(cpf);
            validarIdade(dataNasc);

            super(nome,cpf,dataNasc);
            this.parentesco = parentesco;
            CPF_Dependente.add(cpf);
    }

    private void validarIdade(LocalDate dataNasc){
        int idade = Period.between(dataNasc, LocalDate.now()).getYears();
        if (idade >= 18){
            throw new DependenteException("Dependente inválido: deve ser menor de 18 anos");
        }
    }

    private void validarCPF (String cpf){
        if (CPF_Dependente.contains(cpf)) {
            throw new IllegalArgumentException("Dependente invalido, CPF ja cadastrado.");
        }
    }

    public Parentesco getParentesco() {
        return parentesco;
    }

    public void setParentesco(Parentesco parentesco) {
        this.parentesco = parentesco;
    }
}
