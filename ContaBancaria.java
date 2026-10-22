public class ContaBancaria {

    private double saldo;
    private int quantidadeConsultas;

    public ContaBancaria(double saldo) {
    this.saldo = saldo;
    this.quantidadeConsultas = 0;
}

    public void depositar(double valor) {

        if (valor > 0) {

            double taxa = valor * 0.01;
            double valorCreditado = valor - taxa;

            this.saldo = this.saldo + valorCreditado;

            System.out.println("Depósito realizado!");
            System.out.println("Valor informado: R$ " + valor);
            System.out.println("Taxa: R$ " + taxa);
            System.out.println("Valor creditado: R$ " + valorCreditado);

        } else {

            System.out.println("O valor do depósito deve ser maior que zero.");
        }
    }

    public void sacar(double valor) {

        if (valor > 0) {

            double taxa = valor * 0.005;
            double valorTotal = valor + taxa;

            if (valorTotal <= this.saldo) {

                this.saldo = this.saldo - valorTotal;

                System.out.println("Saque realizado!");
                System.out.println("Valor solicitado: R$ " + valor);
                System.out.println("Taxa: R$ " + taxa);
                System.out.println("Total debitado: R$ " + valorTotal);

            } else {

                System.out.println("Saldo insuficiente.");
            }

        } else {

            System.out.println("O valor do saque deve ser maior que zero.");
        }
    }

    public double consultarSaldo() {

        this.quantidadeConsultas++;

        if (this.quantidadeConsultas % 5 == 0) {

            this.saldo = this.saldo - 0.10;

            System.out.println("Tarifa da quinta consulta: R$ 0,10");
        }

        System.out.println("Saldo disponível: R$ " + this.saldo);

        return this.saldo;
    }

    public void exibirResumo() {

        System.out.println("\n=== RESUMO DA CONTA ===");
        System.out.println("Saldo: R$ " + this.saldo);
        System.out.println("Quantidade de consultas: " + this.quantidadeConsultas);
    }
}