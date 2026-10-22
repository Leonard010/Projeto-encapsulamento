public class Filme {

    private String titulo;
    private int duracaoMinutos;
    private String genero;

    // Construtor
    public Filme(String titulo, int duracaoMinutos, String genero) {
        this.titulo = titulo;
        this.duracaoMinutos = duracaoMinutos;
        this.genero = genero;
    }

    // Getter do título
    public String getTitulo() {
        return this.titulo;
    }

    // Setter do título
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    // Getter da duração
    public int getDuracaoMinutos() {
        return this.duracaoMinutos;
    }

    // Setter da duração
    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }

    // Getter do gênero
    public String getGenero() {
        return this.genero;
    }

    // Setter do gênero
    public void setGenero(String genero) {
        this.genero = genero;
    }

    // Exibir dados
    public void exibirDados() {

        System.out.println("\n=== FILME CADASTRADO ===");
        System.out.println("Título: " + this.titulo);
        System.out.println("Duração: " + this.duracaoMinutos + " minutos");
        System.out.println("Gênero: " + this.genero);
    }
}