package System;

import java.util.Scanner;
import Module. *;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Academia academia = new Academia();

        int opcao;

        do {

            System.out.println("\n===== ACADEMIA =====");

            System.out.println("1. Matricular aluno");
            System.out.println("2. Cancelar matrícula");
            System.out.println("3. Pesquisar aluno");
            System.out.println("4. Listar matriculados");
            System.out.println("5. Fila de espera");
            System.out.println("6. Escolher treino");
            System.out.println("7. Executar treinos");
            System.out.println("0. Sair");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:

                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    academia.matricularAluno(new Aluno(id, nome));

                    break;

                case 2:

                    System.out.print("ID do aluno: ");
                    int removerId = sc.nextInt();

                    academia.cancelarMatricula(removerId);

                    break;

                case 3:

                    System.out.print("ID do aluno: ");
                    int buscaId = sc.nextInt();

                    Aluno aluno = academia.pesquisarAluno(buscaId);

                    if (aluno != null) {
                        System.out.println(aluno);
                    } else {
                        System.out.println("Aluno não encontrado.");
                    }

                    break;

                case 4:

                    academia.listarMatriculados();

                    break;

                case 5:

                    academia.listarFilaEspera();

                    break;

                case 6:

                    System.out.print("ID do aluno: ");
                    int treinoId = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Treinos disponíveis:");
                    System.out.println("1. Peito");
                    System.out.println("2. Costas");
                    System.out.println("3. Perna");
                    System.out.println("4. Bíceps");
                    System.out.println("5. Cardio");

                    int treinoOpcao = sc.nextInt();
                    sc.nextLine();

                    String treino = "";

                    switch (treinoOpcao) {

                        case 1:
                            treino = "Peito";
                            break;

                        case 2:
                            treino = "Costas";
                            break;

                        case 3:
                            treino = "Perna";
                            break;

                        case 4:
                            treino = "Bíceps";
                            break;

                        case 5:
                            treino = "Cardio";
                            break;

                        default:
                            System.out.println("Treino inválido.");
                    }

                    if (!treino.equals("")) {
                        academia.escolherTreino(treinoId, treino);
                    }

                    break;

                case 7:

                    System.out.print("ID do aluno: ");
                    int executarId = sc.nextInt();

                    academia.executarTreinos(executarId);

                    break;

                case 0:

                    System.out.println("Sistema encerrado.");

                    break;

                default:

                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        sc.close();
    }
}
