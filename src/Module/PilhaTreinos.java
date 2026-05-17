package Module;

public class PilhaTreinos {

    private Treino[] pilha;
    private int topo;

    public PilhaTreinos() {
        pilha = new Treino[10];
        topo = -1;
    }

    public void push(Treino treino) {

        if (topo == pilha.length - 1) {
            System.out.println("Pilha cheia!");
            return;
        }

        topo++;
        pilha[topo] = treino;
    }

    public Treino pop() {

        if (topo == -1) {
            return null;
        }

        Treino treino = pilha[topo];
        topo--;

        return treino;
    }

    public boolean vazia() {
        return topo == -1;
    }

    public void listarTreinos() {

        if (vazia()) {
            System.out.println("Nenhum treino escolhido.");
            return;
        }

        for (int i = topo; i >= 0; i--) {
            System.out.println("- " + pilha[i].getNome());
        }
    }
}
