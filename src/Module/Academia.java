package Module;

public class Academia {

    private Aluno[] matriculados;
    private int quantidade;
    private final int LIMITE = 3;

    private FilaEspera filaEspera;

    public Academia() {
        matriculados = new Aluno[LIMITE];
        quantidade = 0;
        filaEspera = new FilaEspera();
    }

    // 1. Matricular aluno
    public void matricularAluno(Aluno aluno) {

        if (quantidade < LIMITE) {

            matriculados[quantidade] = aluno;
            quantidade++;

            System.out.println("Aluno matriculado com sucesso!");

        } else {

            System.out.println("Academia lotada!");
            System.out.println("Aluno enviado para fila de espera.");

            filaEspera.adicionar(aluno);
        }
    }

    // 2. Cancelar matrícula
    public void cancelarMatricula(int id) {

        int posicao = -1;

        for (int i = 0; i < quantidade; i++) {

            if (matriculados[i].getId() == id) {
                posicao = i;
                break;
            }
        }

        if (posicao == -1) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        System.out.println("Aluno removido: " + matriculados[posicao].getNome());

        for (int i = posicao; i < quantidade - 1; i++) {
            matriculados[i] = matriculados[i + 1];
        }

        quantidade--;

        // chama próximo da fila
        if (!filaEspera.vazia()) {

            Aluno novoAluno = filaEspera.remover();

            matriculados[quantidade] = novoAluno;
            quantidade++;

            System.out.println("Novo aluno matriculado da fila:");
            System.out.println(novoAluno);
        }
    }

    // 3. Pesquisar aluno
    public Aluno pesquisarAluno(int id) {

        for (int i = 0; i < quantidade; i++) {

            if (matriculados[i].getId() == id) {
                return matriculados[i];
            }
        }

        return null;
    }

    // 4. Listar alunos
    public void listarMatriculados() {

        if (quantidade == 0) {
            System.out.println("Nenhum aluno matriculado.");
            return;
        }

        for (int i = 0; i < quantidade; i++) {
            System.out.println(matriculados[i]);
        }
    }

    // 5. Listar fila
    public void listarFilaEspera() {
        filaEspera.listarFila();
    }

    // 6. Escolher treino
    public void escolherTreino(int id, String treinoNome) {

        Aluno aluno = pesquisarAluno(id);

        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        aluno.getPilhaTreinos().push(new Treino(treinoNome));

        System.out.println("Treino adicionado.");
    }

    // 7. Executar treinos
    public void executarTreinos(int id) {

        Aluno aluno = pesquisarAluno(id);

        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        System.out.println("Executando treinos de " + aluno.getNome());

        while (!aluno.getPilhaTreinos().vazia()) {

            Treino treino = aluno.getPilhaTreinos().pop();

            System.out.println("Executando: " + treino.getNome());
        }
    }
}