package Module;

public class Aluno {

    private int id;
    private String nome;
    private PilhaTreinos pilhaTreinos;

    public Aluno(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.pilhaTreinos = new PilhaTreinos();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public PilhaTreinos getPilhaTreinos() {
        return pilhaTreinos;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Nome: " + nome;
    }
}