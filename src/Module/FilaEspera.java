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
    //METO RESPONSAVEL POR ADICIONAR O ALUNO A FILA
        if (tamanho == fila.length) {
            System.out.println("Fila cheia!");
            return;
        }
        //SE A FILA ESTIVER COM ESPAÇO, ALUNO E ADICIONADO AO FIM DA FILA
        fila[fim] = aluno;
        fim = (fim + 1) % fila.length;
        tamanho++;
    }

    public Aluno remover() {
        //REMOVE O ALUNO, REMOVE O INICIO DA FILA, PRIMEIRO DA FILA.
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
        //RETORNA O TAMANHO ATUAL DA FILA
    }

    public void listarFila() {
    //LISTA TODOS OS ALUNOS QUE ESTÃO AGUARDANDO NA FILA DE ESPERA
        if (vazia()) {
            System.out.println("Fila vazia.");
            return;
        }

        int i = inicio;
        //USA O FOR PARA PERCORRER A FILA.
        for (int cont = 0; cont < tamanho; cont++) {
            System.out.println(fila[i]);
            i = (i + 1) % fila.length;
        }
    }
}
