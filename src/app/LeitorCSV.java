package app;

import entidades.Dependente;
import entidades.Funcionario;
import enums.Parentesco;
import sql.FuncionaioDAO;
import sql.DependenteDAO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LeitorCSV {   
    public static void main(String[] args) {
        String caminho = "C:\\Users\\Matheus\\Serratec\\POOJava\\TrabalhoGrupo\\Trabalho_Serratec_POO_JAVA\\src\\app\\Entrada.csv";
        
        try{
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyyMMdd");
            BufferedReader br = new BufferedReader(new FileReader(caminho));
            List<Funcionario> funcionarios = new ArrayList<>();
            Funcionario funcionarioAtual = null;
            FuncionaioDAO fdao = new FuncionaioDAO();
            DependenteDAO ddao =new DependenteDAO();
            String linha;

                while ((linha = br.readLine()) != null) {
                    linha = linha.trim();

                    if (linha.isEmpty()) {
                        continue; 
    }
                    linha = linha.replaceAll(";$", "");
                    String[] campos = linha.split(";");

                    boolean isFuncionario;

                    try {
                        Double.parseDouble(campos[3]);
                        isFuncionario = true;
                    } catch (Exception e) {
                        isFuncionario = false;
                    }

                    if (isFuncionario == true) {

                        funcionarioAtual = new Funcionario(
                            campos[0],
                            campos[1],
                            LocalDate.parse(campos[2], formato),
                            Double.parseDouble(campos[3])
                        );

                        funcionarios.add(funcionarioAtual);
                        fdao.salvar(funcionarioAtual);

                    } else {
    
                        Dependente dep = new Dependente(
                            campos[0],
                            campos[1],
                            LocalDate.parse(campos[2], formato),
                            Parentesco.valueOf(campos[3])
                        );

                        if (funcionarioAtual != null) {
                            funcionarioAtual.adicionarDependente(dep);
                            int idAtual = fdao.salvar(funcionarioAtual);
                            ddao.salvar(dep, idAtual);
                        }
                    }
}
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
