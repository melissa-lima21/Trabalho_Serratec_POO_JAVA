package app;

import entidades.Dependente;
import entidades.Funcionario;
import enums.Parentesco;
import exceptions.DependenteException;
import sql.FuncionarioDAO;
import sql.DependenteDAO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LeitorCSV {

    public List<Funcionario> ler(String caminho) {
        List<Funcionario> funcionarios = new ArrayList<>();

        try {
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyyMMdd");
            BufferedReader br = new BufferedReader(new FileReader(caminho));

            Funcionario funcionarioAtual = null;

            FuncionarioDAO fdao = new FuncionarioDAO();
            DependenteDAO ddao = new DependenteDAO();

            String linha;

            while ((linha = br.readLine()) != null) {
                linha = linha.trim();

                if (linha.isEmpty()) {
                    funcionarioAtual = null;
                    continue;
                }

                linha = linha.replaceAll(";$", "");
                String[] campos = linha.split(";", -1);

                boolean isFuncionario;

                try {
                    Double.parseDouble(campos[3]);
                    isFuncionario = true;
                } catch (Exception e) {
                    isFuncionario = false;
                }

                if (isFuncionario) {

                    try {
                        funcionarioAtual = new Funcionario(
                                campos[0],
                                campos[1],
                                LocalDate.parse(campos[2], formato),
                                Double.parseDouble(campos[3])
                        );

                        funcionarios.add(funcionarioAtual);
                        fdao.salvar(funcionarioAtual);

                    } catch (IllegalArgumentException e) {
                        System.out.println("Funcionario inválido ignorado: "
                                + campos[0] + " (" + e.getMessage() + ")");
                        funcionarioAtual = null;
                    }

                } else {

                    try {
                        Dependente dep = new Dependente(
                                campos[0],
                                campos[1],
                                LocalDate.parse(campos[2], formato),
                                Parentesco.valueOf(campos[3].toUpperCase())
                        );
                        if (funcionarioAtual != null) {
                            funcionarioAtual.adicionarDependente(dep);

                            ddao.salvar(dep, funcionarioAtual.getCpf());
                        }

                    } catch (DependenteException e) {
                        System.out.println("Dependente inválido ignorado: "
                                + campos[0] + " (" + e.getMessage() + ")");
                    } catch (Exception e) {
                        System.out.println("Erro inesperado na linha: " + linha);
                    }
                }
            }

            br.close();

        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }

        return funcionarios;
    }
}