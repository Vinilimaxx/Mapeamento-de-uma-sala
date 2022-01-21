package ProjetoMapeamento;


import java.text.DecimalFormat;
import java.util.Scanner;


public class mapeamento {
    
    
    public static void main(String[] args){
        float matriz[][] = new float[3][3];
        int i, j, k, aluno =0, contR = 0, contT=0, materia;
        float mediaT, soma= 0, nota1, nota2,nota3, porcentR, porcentT;
        Scanner leitor = new Scanner(System.in);
        DecimalFormat deci = new DecimalFormat("0.00");
        
        //entrada
        System.out.println("Informe o numero de materias para serem analisadas");
        materia = leitor.nextInt();
        for (k = 0; k < materia; k++) {
           aluno = 0;
            for (i = 0; i<3; i++){
                for (j = 0; j < 3; j++) {
                    aluno = aluno + 1;
                    System.out.println("Informe as 3 notas do aluno "+  aluno+ ":");
                    nota1= leitor.nextFloat();
                    nota2= leitor.nextFloat();
                    nota3= leitor.nextFloat();
                    matriz[i][j]= (nota1 + nota2 + nota3)/3;
                    if (nota1 < 0 || nota1 > 10  || nota2 < 0 || nota2 > 10 || nota3 < 0 || nota3 > 10 ) {
                        System.out.printf("Ha uma nota incoerente\n");
                        aluno--;
                        j--;
                        continue;
                    }
                    
                    soma = soma + matriz[i][j];
                }
                
    
            }
            
            mediaT = soma/9;
            //saida
            System.out.println("\nDe acordo com os assento de cada aluno, sua respectiva media:");
            for (i = 0; i<3; i++){
               for (j = 0; j < 3; j++) {
                   
                   System.out.printf(deci.format(matriz[i][j]));
                   System.out.printf(" ");
               }
               System.out.println("");
               
               
           }
               
            System.out.print("\nA media para ser aprovado eh: 7.00");
            System.out.print("\nA media da turma foi: ");
            System.out.println(deci.format(mediaT));
            
            
            soma = 0;
            aluno = 0;
           for (i = 0; i<3; i++) {
               for (j = 0; j < 3; j++) {
                aluno = aluno + 1;
                    if (matriz[i][j] < 7.00) {
                        System.out.println("\nO aluno "+ aluno + " foi reprovado");
                        contR++;

                    }
                    if (matriz[i][j] < mediaT) {
                        System.out.println("O aluno "+ aluno + " ficou abaixo da media da turma");
                        contT++;
                  }
               }
           }
        }

        porcentR = (contR * 100)/9;
        porcentT = (contT * 100)/9;
        if (contR > 0) {
            System.out.println("\n"+contR +" Alunos foram reprovados, representando "+ porcentR + "% da turma");
        }
        else{
            System.out.println("Todos os alunos foram aprovados!!!");
        }

        if (contT > 0) {
            System.out.println(contT +" Alunos ficaram abaixo da media da turma, representando "+ porcentT + "% da turma");
        }
        
    }

}
