import java.util.Scanner;

public class SistemaFilmes {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {

            System.out.println("=== CADASTRO DE FILME ===");

            System.out.print("Informe o título: ");
            String titulo = scanner.nextLine();

            System.out.print("Informe a duração em minutos: ");
            int duracao = scanner.nextInt();

            scanner.nextLine();

            System.out.print("Informe o gênero: ");
            String genero = scanner.nextLine();

            Filme filme = new Filme(titulo, duracao, genero);

            filme.setTitulo(titulo);
            filme.setDuracaoMinutos(duracao);
            filme.setGenero(genero);

            filme.exibirDados();

        } catch (Exception e) {

            System.out.println("Não foi possível cadastrar o filme.");
            System.out.println("Motivo: " + e.getMessage());

        }

        scanner.close();
    }
}
