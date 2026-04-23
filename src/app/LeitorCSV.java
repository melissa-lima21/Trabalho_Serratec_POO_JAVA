package app;

import java.io.BufferedReader;
import java.io.FileReader;
import entidades.Funcionario;
import entidades.Dependente;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import enums.Parentesco;

public class LeitorCSV {   
    public static void main(String[] args) {
        String caminho = "C:\\Users\\Matheus\\Serratec\\POOJava\\TrabalhoGrupo\\Trabalho_Serratec_POO_JAVA\\src\\app\\Entrada.csv";
        
        try{
            BufferedReader br = new BufferedReader(new FileReader(caminho));
            List<Funcionario> funcionarios = new ArrayList<>();
            Funcionario funcionarioAtual;
            String linha;
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyyMMdd");

                while ((linha = br.readLine()) != null) {

                    String[] campos = linha.split(";");

                
                    if (campos[3].matches("\\d+(\\.\\d+)?")) {

                        funcionarioAtual = new Funcionario(
                            campos[0],
                            campos[1],
                            LocalDate.parse(campos[2], formato),
                            Double.parseDouble(campos[3])
                        );

                        funcionarios.add(funcionarioAtual);

                    } else {
    
                        Dependente dep = new Dependente(
                            campos[0],
                            campos[1],
                            LocalDate.parse(campos[2], formato),
                            Parentesco.valueOf(campos[3])
                        );

                        if (funcionarioAtual != null) {
                            funcionarioAtual.adicionarDependente(dep);
                        }
                    }
}
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
