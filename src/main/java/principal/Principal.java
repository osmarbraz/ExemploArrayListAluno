package principal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;
import model.Aluno;

public class Principal {

    public static void main(String[] args) {
        //Declaramos e instanciamos uma ArrayList de Alunos
        ArrayList<Aluno> listasimples = new ArrayList<>();

        int opcao = -1;
        while (opcao != 9) {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("##Menu do Cadastro de Aluno##\n"
                    + "1 - Criar (Create)\n"
                    + "2 - Recuperação (Retrive)\n"
                    + "3 - Atualizar (Update)\n"
                    + "4 - Apagar (Delete)\n"
                    + "5 - Listar Tudo (List All)\n"
                    + "6 - Classificar (Classify)\n"
                    + "9 - Sair"));

            switch (opcao) {
                case 1:
                    //Declarando o aluno e instanciando
                    Aluno alunonovo = new Aluno();
                    //Preenchendo os atributos do aluno
                    alunonovo.setId(Integer.parseInt(JOptionPane.showInputDialog("Digite o id do aluno")));
                    alunonovo.setNome(JOptionPane.showInputDialog("Digite o nome do aluno"));
                    alunonovo.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do aluno")));
                    alunonovo.setCurso(JOptionPane.showInputDialog("Digite o curso do aluno"));
                    alunonovo.setFase(Integer.parseInt(JOptionPane.showInputDialog("Digite a fase do aluno")));
                    //Adicionando o aluno ao ArrayList
                    listasimples.add(alunonovo);
                    System.out.println("Aluno inserido com sucesso!");
                    break;

                case 2:
                    int chaveProcura = Integer.parseInt(JOptionPane.showInputDialog("Digite o id de um aluno a ser consultado:"));
                    //Procura a posição do id do aluno
                    int posicaoProcura = -1;
                    for (int i = 0; i < listasimples.size(); i++) {
                        if (listasimples.get(i).getId() == posicaoProcura) {
                            posicaoProcura = i;
                        }
                    }
                    //Mostra os dados se encontrou o aluno
                    if (posicaoProcura != -1) {
                        System.out.println("Aluno encontrado!");
                        System.out.println("  Id   :" + listasimples.get(posicaoProcura).getId());
                        System.out.println("  Nome :" + listasimples.get(posicaoProcura).getNome());
                        System.out.println("  Idade:" + listasimples.get(posicaoProcura).getIdade());
                        System.out.println("  Curso:" + listasimples.get(posicaoProcura).getCurso());
                        System.out.println("  Fase:" + listasimples.get(posicaoProcura).getFase());

                    } else {
                        System.out.println("Não encontrei o aluno com o id:" + chaveProcura);
                    }
                    break;

                case 3:
                    int chaveAtualizar = Integer.parseInt(JOptionPane.showInputDialog("Digite o id de um aluno a ser atualizado:"));
                    //Procura a posição do id do aluno
                    int posicaoAtualizar = -1;
                    for (int i = 0; i < listasimples.size(); i++) {
                        if (listasimples.get(i).getId() == chaveAtualizar) {
                            posicaoAtualizar = i;
                        }
                    }
                    //Mostra os dados se encontrou o aluno
                    if (posicaoAtualizar != -1) {
                        //Declarando o aluno e instanciando
                        Aluno alunoatualizado = new Aluno();
                        //Preenchendo os atributos do aluno a ser atualizado
                        alunoatualizado.setId(Integer.parseInt(JOptionPane.showInputDialog("Digite o id do aluno")));
                        alunoatualizado.setNome(JOptionPane.showInputDialog("Digite o nome do aluno"));
                        alunoatualizado.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do aluno")));
                        alunoatualizado.setCurso(JOptionPane.showInputDialog("Digite o curso do aluno"));
                        alunoatualizado.setFase(Integer.parseInt(JOptionPane.showInputDialog("Digite a fase do aluno")));
                        //Atualiza o aluno na posição
                        listasimples.set(posicaoAtualizar, alunoatualizado);
                        System.out.println("Aluno atualizado com sucesso!");
                    } else {
                        System.out.println("Não encontrei o aluno com o id:" + chaveAtualizar);
                    }

                    break;

                case 4:
                    int chaveExclusao = Integer.parseInt(JOptionPane.showInputDialog("Digite o id de um aluno a ser excluído:"));
                    int posicaoExclusao = -1;
                    for (int i = 0; i < listasimples.size(); i++) {
                        if (listasimples.get(i).getId() == chaveExclusao) {
                            posicaoExclusao = i;
                        }
                    }
                    if (posicaoExclusao != -1) {
                        listasimples.remove(posicaoExclusao);
                        System.out.println("Aluno de id " + chaveExclusao + " excluído com sucesso!");
                    } else {
                        System.out.println("Não encontrei o aluno para excluir com o id:" + chaveExclusao);
                    }
                    break;

                case 5:
                    System.out.println("Listagem de alunos");
                    for (int i = 0; i < listasimples.size(); i++) {
                        System.out.println("i      :" + i);
                        System.out.println("  Id   :" + listasimples.get(i).getId());
                        System.out.println("  Nome :" + listasimples.get(i).getNome());
                        System.out.println("  Idade:" + listasimples.get(i).getIdade());
                        System.out.println("  Curso:" + listasimples.get(i).getCurso());
                        System.out.println("  Fase :" + listasimples.get(i).getFase());
                    }
                    break;

                case 6:
                    System.out.println("Classificado os alunos pelo nome");
                    Collections.sort(listasimples, new Comparator() {
                        @Override
                        public int compare(Object o1, Object o2) {
                            Aluno a1 = (Aluno) o1;
                            Aluno a2 = (Aluno) o2;
                            return a1.getNome().compareToIgnoreCase(a2.getNome());
                            // retorna -1 se for menor e +1 se for maior.
                        }
                    });
                    break;
                case 9:
                    System.out.println(
                            "Saindo do sistema");
                    break;
                default:
                    System.out.println(
                            "Opção inválida");
                    break;
            }//Fim switch
        }//Fim while
    }//Fim main
}//Fim classe
