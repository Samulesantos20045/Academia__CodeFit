package Module;

public class FilaEspera {

    private Aluno[] fila;
    private int inicio;
    private int fim;
    private int tamanho;

    public FilaEspera() {
        fila = new Aluno[20];
        inicio = 0;
        fim = 0;
        tamanho = 0;
    }

    public void adicionar(Aluno aluno) {

        if (tamanho == fila.length) {
            System.out.println("Fila cheia!");
            return;
        }

        fila[fim] = aluno;
        fim = (fim + 1) % fila.length;
        tamanho++;
    }

    public Aluno remover() {

        if (tamanho == 0) {
            return null;
        }

        Aluno aluno = fila[inicio];
        inicio = (inicio + 1) % fila.length;
        tamanho--;

        return aluno;
    }

    public boolean vazia() {
        return tamanho == 0;
    }

    public void listarFila() {

        if (vazia()) {
            System.out.println("Fila vazia.");
            return;
        }

        int i = inicio;

        for (int cont = 0; cont < tamanho; cont++) {
            System.out.println(fila[i]);
            i = (i + 1) % fila.length;
        }
    }
}
