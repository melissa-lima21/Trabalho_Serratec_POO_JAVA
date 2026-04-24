package app;

<<<<<<< HEAD
import entidades.Funcionario;
import entidades.FolhaPagamento;
import service.CalculadoraFolhaPagamento;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        LeitorCSV leitor = new LeitorCSV();
        EscritorCSV escritor = new EscritorCSV();
        CalculadoraFolhaPagamento calculadora = new CalculadoraFolhaPagamento();
        Scanner sc = new Scanner(System.in);
        String entrada;
        String saida;

        System.out.print("Digite o caminho do arquivo de entrada: ");
        entrada = sc.nextLine();

        System.out.print("Digite o caminho do arquivo de saída: ");
        saida = sc.nextLine();

        entrada = entrada.replace("\"", "");
        saida = saida.replace("\"", "");

        try {
            List<Funcionario> funcionarios = leitor.ler(entrada);
            List<FolhaPagamento> folhas = calculadora.processar(funcionarios);
            escritor.escrever(saida, folhas);

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        sc.close();
=======
import java.io.File;

public class Main {
    public static void main(String[] args) {
        File arquivo = new
        File("Entrada.csv");
>>>>>>> master
    }
}