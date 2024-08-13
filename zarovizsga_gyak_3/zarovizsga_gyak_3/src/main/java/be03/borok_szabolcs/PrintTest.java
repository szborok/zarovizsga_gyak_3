package be03.borok_szabolcs;

import java.util.List;

public class PrintTest {

    public static void jegyek(Integer[] eselyArray) {
        int cntOne = 0;
        int cntTwo = 0;
        int cntThree = 0;
        int cntFour = 0;
        int cntFive = 0;
        for (int i = 0; i < eselyArray.length; i++) {
            if (eselyArray[i].equals(1)) {
                cntOne++;
            }
            else if (eselyArray[i].equals(2)) {
                cntTwo++;
            }
            else if (eselyArray[i].equals(3)) {
                cntThree++;
            }
            else if (eselyArray[i].equals(4)) {
                cntFour++;
            }
            else if (eselyArray[i].equals(5)) {
                cntFive++;
            }
        }
        System.out.println("1 - " + cntOne + "%");
        System.out.println("2 - " + cntTwo + "%");
        System.out.println("3 - " + cntThree + "%");
        System.out.println("4 - " + cntFour + "%");
        System.out.println("5 - " + cntFive + "%");
    }

    public static void diakEvVegiErtekelese(List<Integer[]> naplo) {
        for (int i = 1; i < 7; i++) {

            Double evVegiJegy = App.diakEvVegiErtekelese(i, naplo);
            System.out.println("\nA(z) " + i + " kódú diák év végi értékelése ");
            System.out.printf("%.2f", evVegiJegy);
        }
    }

}
