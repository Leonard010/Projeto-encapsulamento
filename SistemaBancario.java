import java.util.Scanner;

public class SistemaBancario {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ContaBancaria conta = new ContaBancaria(0);

        int opcao = 0;

        while (opcao != 0) {

            System.out.println("\n=== SISTEMA BANCÁRIO ===");
            System.out.println("1 - Realizar depósito");
            System.out.println("2 - Realizar saque");
            System.out.println("3 - Consultar saldo");
            System.out.println("4 - Exibir resumo da conta");
            System.out.println("0 - Encerrar");

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            if (opcao == 1) {

                System.out.print("Informe o valor do depósito: ");
                double valor = scanner.nextDouble();

                conta.depositar(valor);

            } else if (opcao == 2) {

                System.out.print("Informe o valor do saque: ");
                double valor = scanner.nextDouble();

                conta.sacar(valor);

            } else if (opcao == 3) {

                conta.consultarSaldo();

            } else if (opcao == 4) {

                conta.exibirResumo();

            } else if (opcao == 0) {

                System.out.println("Sistema encerrado.");

            } else {

                System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}