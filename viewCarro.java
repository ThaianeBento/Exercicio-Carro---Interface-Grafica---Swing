
package View;

import Controller.ListaCarros;
import Model.Carro;
import java.util.Scanner;

public class viewCarro {
    private ListaCarros controller;
    private Scanner scanner;

    public viewCarro(ListaCarros controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        while (true) {
            System.out.println("1. Adicionar Carro");
            System.out.println("2. Alterar Carro");
            System.out.println("3. Consultar Carro");
            System.out.println("4. Excluir Carro");
            System.out.println("5. Listar Carros");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consome a linha

            switch (opcao) {
                case 1:
                    adicionarCarro();
                    break;
                case 2:
                    alterarCarro();
                    break;
                case 3:
                    consultarCarro();
                    break;
                case 4:
                    excluirCarro();
                    break;
                case 5:
                    listarCarros();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void adicionarCarro() {
        System.out.print("Placa: ");
        String placa = scanner.nextLine();
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        
        Carro carro = new Carro(placa, marca, modelo);

        try {
            controller.addCarro(carro);
            System.out.println("Carro adicionado com sucesso.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void alterarCarro() {
        System.out.print("Placa do carro a ser alterado: ");
        String placa = scanner.nextLine();
        System.out.print("Nova Marca: ");
        String novaMarca = scanner.nextLine();
        System.out.print("Novo Modelo: ");
        String novoModelo = scanner.nextLine();

        try {
            controller.alterarCarro(placa, novaMarca, novoModelo);
            System.out.println("Carro alterado com sucesso.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void consultarCarro() {
        System.out.print("Placa do carro: ");
        String placa = scanner.nextLine();

        try {
            Carro carro = controller.consultarCarro(placa);
            System.out.println("Placa: " + carro.getPlaca());
            System.out.println("Marca: " + carro.getMarca());
            System.out.println("Modelo: " + carro.getModelo());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void excluirCarro() {
        System.out.print("Placa do carro a ser excluído: ");
        String placa = scanner.nextLine();

        try {
            controller.excluirCarro(placa);
            System.out.println("Carro excluído com sucesso.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void listarCarros() {
        for (Carro carro : controller.listarCarros()) {
            System.out.println("Placa: " + carro.getPlaca() + ", Marca: " + carro.getMarca() + ", Modelo: " + carro.getModelo());
        }
    }
}
