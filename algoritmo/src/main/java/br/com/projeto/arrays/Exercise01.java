package br.com.projeto.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 Given a  2D Array
 1 1 1 0 0 0
 0 1 0 0 0 0
 1 1 1 0 0 0
 0 0 0 0 0 0
 0 0 0 0 0 0
 0 0 0 0 0 0

 An hourglass in  is a subset of values with indices falling in this pattern in 's graphical representation:
 a b c
 d
 e f g

 There are  hourglasses in . An hourglass sum is the sum of an hourglass' values. Calculate the hourglass sum for every hourglass in ,
 then print the maximum hourglass sum. The array will always be .

 Example
 -9 -9 -9  1 1 1
 0 -9  0  4 3 2
 -9 -9 -9  1 2 3
 0  0  8  6 6 0
 0  0  0 -2 0 0
 0  0  1  2 4 0

 The  hourglass sums are:

 -63, -34, -9, 12,
 -10,   0, 28, 23,
 -27, -11, -2, 10,
 9,  17, 25, 18

 The highest hourglass sum is 28 from the hourglass beginning at row , column :
 0 4 3
 1
 8 6 6

 **/

public class Exercise01 {
    public static int hourglassSum(List<List<Integer>> arr) {
        int topo = 0;
        int meio = 0;
        int base = 0;
        int soma = 0;
        int resposta = 0;
        for (int i=0; i < 4; i++){
            for(int j=0; j < 4; j++){
                topo = arr.get(i).get(j) + arr.get(i).get(j + 1) + arr.get(i).get(j+2);
                meio = arr.get(i+1).get(j+1);
                base = arr.get(i+2).get(j) + arr.get(i+2).get(j + 1) + arr.get(i+2).get(j+2);
                soma = topo + meio + base;
                if (soma > resposta){
                    resposta = soma;
                }
            }
        }
        System.out.println("A maior some é: " + resposta);
        return resposta;
    }


    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<>();

        // Adicionando as linhas à matriz
        matrix.add(List.of(-9, -9, -9, 1, 1, 1));
        matrix.add(List.of(0, -9, 0, 4, 3, 2));
        matrix.add(List.of(-9, -9, -9, 1, 2, 3));
        matrix.add(List.of(0, 0, 8, 6, 6, 0));
        matrix.add(List.of(0, 0, 0, -2, 0, 0));
        matrix.add(List.of(0, 0, 1, 2, 4, 0));

        // Exibindo a matriz
        for (List<Integer> row : matrix) {
            System.out.println(row);
        }

        hourglassSum(matrix);
    }
}
