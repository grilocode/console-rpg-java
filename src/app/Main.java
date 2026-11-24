package app;

import model.personagens.Cavaleiro;
import model.personagens.Personagem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("========================");
            System.out.println("MENU INICIAL");
            System.out.println("========================");
            System.out.println("1 - Criar um novo personagem");
            System.out.println("0 - Sair");
            System.out.print("Selecione uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1: Personagem guerreiro = new Cavaleiro();
                    System.out.println(guerreiro);
                    break;
            }
        } while (opcao != 0);
    }
}