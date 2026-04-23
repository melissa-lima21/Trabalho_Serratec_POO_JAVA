package app;

import entidades.FolhaPagamento;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

public class EscritorCSV {

    public void escrever(String nomeArquivoSaida, List<FolhaPagamento> folhas) {

        try (PrintWriter escritor = new PrintWriter(new File(nomeArquivoSaida))) {

            for (FolhaPagamento f : folhas) {
                String linhaFormatada = FolhaPagamento.formatarSaida(f);
                escritor.println(linhaFormatada);
            }

            System.out.println("Arquivo gerado com sucesso em: " + nomeArquivoSaida);

        } catch (Exception e) {
            System.err.println("Erro ao criar o arquivo: " + e.getMessage());
        }
    }
}