package io.biblioteca;

import io.biblioteca.db.DBOperacoes;

import java.util.Scanner;

public class BibliotecaApplication {

    public static void main(String[] args) throws InterruptedException {

        // Apenas teste

        DBOperacoes dbOperacoes = new DBOperacoes();

        Livro novoLivro =  new Livro();
        Livro livroSalvo = dbOperacoes.salvar(novoLivro);
        System.out.println(livroSalvo.getNumero());

        System.out.println("Por favor insira um valorzinho: ");
        Scanner scanner = new Scanner(System.in);
        Integer entradaUsuario = 1;

        if (scanner.hasNext()) {
            entradaUsuario = scanner.nextInt();
        }

        int i = 1;
        while(true) {

            Thread.sleep(1000);
            System.out.println(entradaUsuario);
            System.out.println("Legal em" + i);
            i++;
        }

    }
}
