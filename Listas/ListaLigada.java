package Listas;

import java.util.Scanner;

public class ListaLigada extends No {

    private No primeiroNo;
    private No ultimoNo;
    private int quantidadesNos;

    public ListaLigada(Object elementoInicial) {

        No novoNo = new No(elementoInicial, null);

        this.primeiroNo = novoNo;
        this.ultimoNo = novoNo;
        this.quantidadesNos = 1;
    }

    // PERCORRE A LISTA

    private No percorrerLista(int posicao) {

        No atual = primeiroNo;

        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximoNo();
        }

        return atual;
    }

    // ADICIONA NO FINAL

    public void adicionar(Object elemento) {

        No novoNo = new No(elemento, null);

        if (this.quantidadesNos == 0) {

            this.primeiroNo = novoNo;
            this.ultimoNo = novoNo;
            this.quantidadesNos = 1;

            return;
        }

        this.ultimoNo.setProximoNo(novoNo);
        this.ultimoNo = novoNo;
        this.quantidadesNos++;
    }

    // ADICIONA NO INICIO

    public void adicionarNoInicio(Object elemento) {

        No novoNo = new No(elemento, this.primeiroNo);

        if (this.quantidadesNos == 0) {

            this.primeiroNo = novoNo;
            this.ultimoNo = novoNo;
            this.quantidadesNos = 1;

            return;
        }

        this.primeiroNo = novoNo;
        this.quantidadesNos++;
    }

    // ADICIONA EM UMA POSICAO

    public boolean adicionarNaPosicao(Object elemento, int posicao) {

        if (posicao < 0 || posicao > this.quantidadesNos) {
            return false;
        }

        if (posicao == 0) {
            adicionarNoInicio(elemento);
            return true;
        }

        if (posicao == this.quantidadesNos) {
            adicionar(elemento);
            return true;
        }

        No anterior = percorrerLista(posicao - 1);

        No novoNo = new No(elemento, anterior.getProximoNo());

        anterior.setProximoNo(novoNo);

        this.quantidadesNos++;

        return true;
    }

    // REMOVE DO INICIO

    public boolean removerDoInicio() {

        if (this.quantidadesNos == 0) {
            return false;
        }

        this.primeiroNo = this.primeiroNo.getProximoNo();

        this.quantidadesNos--;

        if (this.quantidadesNos == 0) {
            this.ultimoNo = null;
        }

        return true;
    }

    // REMOVE DO FINAL

    public boolean removerDoFinal() {

        if (this.quantidadesNos == 0) {
            return false;
        }

        if (this.quantidadesNos == 1) {

            this.primeiroNo = null;
            this.ultimoNo = null;
            this.quantidadesNos = 0;

            return true;
        }

        No penultimo = percorrerLista(this.quantidadesNos - 2);

        penultimo.setProximoNo(null);

        this.ultimoNo = penultimo;

        this.quantidadesNos--;

        return true;
    }

    // REMOVE DE UMA POSICAO

    public boolean removerDaPosicao(Object elemento, int posicao) {

        if (posicao < 0 || posicao >= this.quantidadesNos) {
            return false;
        }

        if (posicao == 0) {
            return removerDoInicio();
        }

        if (posicao == this.quantidadesNos - 1) {
            return removerDoFinal();
        }

        No anterior = percorrerLista(posicao - 1);

        anterior.setProximoNo(
            anterior.getProximoNo().getProximoNo()
        );

        this.quantidadesNos--;

        return true;
    }

    // RETORNA A QUANTIDADE DE ELEMENTOS

    public int tamanhoDaLista() {
        return quantidadesNos;
    }

    // IMPRIME A LISTA

    public String imprimirLista() {

        if (this.primeiroNo == null) {
            return "NULL";
        }

        StringBuilder sb = new StringBuilder();

        No atual = primeiroNo;

        while (atual != null) {

            sb.append(atual.getInfo());
            sb.append(" -> ");

            atual = atual.getProximoNo();
        }

        sb.append("NULL");

        return sb.toString();
    }

    // EXIBE A LISTA NO CONSOLE

    public void exibirListaNoConsole() {

        System.out.println();
        System.out.println("Lista Atual:");
        System.out.println(imprimirLista());
        System.out.println(
            "Tamanho: " + quantidadesNos + " elemento(s)"
        );
    }

    // MAIN

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("        LISTA LIGADA INTERATIVA");
        System.out.println("========================================");

        System.out.print("Digite o primeiro valor da lista: ");
        String primeiro = scanner.nextLine();

        ListaLigada lista = new ListaLigada(primeiro);

        lista.exibirListaNoConsole();

        boolean continuar = true;

        while (continuar) {

            System.out.println();
            System.out.println("========================================");
            System.out.println("                  MENU");
            System.out.println("========================================");
            System.out.println("1 - Adicionar ao final");
            System.out.println("2 - Adicionar ao inicio");
            System.out.println("3 - Adicionar em posicao especifica");
            System.out.println("4 - Remover do inicio");
            System.out.println("5 - Remover do final");
            System.out.println("6 - Remover de posicao especifica");
            System.out.println("7 - Exibir lista");
            System.out.println("0 - Sair");
            System.out.println("========================================");

            System.out.print("Escolha uma opcao: ");
            String opcao = scanner.nextLine();

            switch (opcao) {

                // 1 - ADICIONAR NO FINAL

                case "1":

                    System.out.print("Digite o valor: ");
                    String valorFinal = scanner.nextLine();

                    lista.adicionar(valorFinal);

                    System.out.println(
                        "Elemento adicionado ao final."
                    );

                    lista.exibirListaNoConsole();

                    break;

                // 2 - ADICIONAR NO INICIO

                case "2":

                    System.out.print("Digite o valor: ");
                    String valorInicio = scanner.nextLine();

                    lista.adicionarNoInicio(valorInicio);

                    System.out.println(
                        "Elemento adicionado ao inicio."
                    );

                    lista.exibirListaNoConsole();

                    break;

                // 3 - ADICIONAR EM POSICAO

                case "3":

                    System.out.print("Digite o valor: ");
                    String valorPosicao = scanner.nextLine();

                    System.out.println(
                        "Posicao valida: 0 ate "
                        + lista.tamanhoDaLista()
                    );

                    System.out.print("Digite a posicao: ");
                    String entradaPosicao = scanner.nextLine();

                    try {

                        int posicao =
                            Integer.parseInt(entradaPosicao);

                        boolean adicionou =
                            lista.adicionarNaPosicao(
                                valorPosicao,
                                posicao
                            );

                        if (adicionou) {

                            System.out.println(
                                "Elemento adicionado com sucesso."
                            );

                            lista.exibirListaNoConsole();

                        } else {

                            System.out.println(
                                "Posicao invalida."
                            );
                        }

                    } catch (NumberFormatException e) {

                        System.out.println(
                            "Entrada invalida. Digite um numero inteiro."
                        );
                    }

                    break;

                // 4 - REMOVER DO INICIO

                case "4":

                    if (lista.removerDoInicio()) {

                        System.out.println(
                            "Primeiro elemento removido."
                        );

                        lista.exibirListaNoConsole();

                    } else {

                        System.out.println(
                            "Lista vazia."
                        );
                    }

                    break;

                // 5 - REMOVER DO FINAL

                case "5":

                    if (lista.removerDoFinal()) {

                        System.out.println(
                            "Ultimo elemento removido."
                        );

                        lista.exibirListaNoConsole();

                    } else {

                        System.out.println(
                            "Lista vazia."
                        );
                    }

                    break;

                // 6 - REMOVER DE UMA POSICAO

                case "6":

                    if (lista.tamanhoDaLista() == 0) {

                        System.out.println(
                            "Lista vazia."
                        );

                        break;
                    }

                    System.out.println(
                        "Posicao valida: 0 ate "
                        + (lista.tamanhoDaLista() - 1)
                    );

                    System.out.print("Digite a posicao: ");
                    String entradaRemocao = scanner.nextLine();

                    try {

                        int posicao =
                            Integer.parseInt(entradaRemocao);

                        boolean removeu =
                            lista.removerDaPosicao(
                                null,
                                posicao
                            );

                        if (removeu) {

                            System.out.println(
                                "Elemento removido com sucesso."
                            );

                            lista.exibirListaNoConsole();

                        } else {

                            System.out.println(
                                "Posicao invalida."
                            );
                        }

                    } catch (NumberFormatException e) {

                        System.out.println(
                            "Entrada invalida. Digite um numero inteiro."
                        );
                    }

                    break;

                // 7 - EXIBIR LISTA

                case "7":

                    System.out.println();
                    System.out.println("******** LISTA ********");

                    lista.exibirListaNoConsole();

                    System.out.println("************************");

                    break;

                // 0 - SAIR

                case "0":

                    continuar = false;

                    break;

                // OPCAO INVALIDA

                default:

                    System.out.println(
                        "Opcao invalida. Escolha uma opcao entre 0 e 7."
                    );

                    break;
            }
        }

        scanner.close();

        System.out.println();
        System.out.println("Programa encerrado.");
    }
}