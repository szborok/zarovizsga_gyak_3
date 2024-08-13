package be03.borok_szabolcs;

import java.beans.ExceptionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class App {

    public static Integer[] jegyek = new Integer[101];
    static ArrayList<Integer[]> naplo = new ArrayList<Integer[]>();
    static Map<String, Integer> diakok = new HashMap<String, Integer>();

    public static void main(String[] args) {

        diakok.put("Edina", 1);
        diakok.put("Géza", 2);
        diakok.put("Réka", 3);
        diakok.put("Béla", 4);
        diakok.put("Zita", 5);
        diakok.put("Tamás", 6);

        jegyek[0] = 0;
        for (int i = 1; i <= 10; i++) {
            jegyek[i] = 1;
        }
        for (int i = 11; i <= 25; i++) {
            jegyek[i] = 2;
        }
        for (int i = 26; i <= 45; i++) {
            jegyek[i] = 3;
        }
        for (int i = 46; i <= 70; i++) {
            jegyek[i] = 4;
        }
        for (int i = 71; i <= 100; i++) {
            jegyek[i] = 5;
        }

        // PrintTest.jegyek(jegyek);

        evSzimulalas();

        // PrintTest.diakEvVegiErtekelese(naplo);

        try {
            System.out.println("Add meg egy diák nevét: ");
            Scanner scanner = new Scanner(System.in);
            String inputDiakNeve = scanner.nextLine();
            if (diakok.containsKey(inputDiakNeve)) {

                Integer diakSzama = diakok.get(inputDiakNeve);

                Double atlag = diakEvVegiErtekelese(diakSzama, naplo);
                Integer evVegiJegy = (int) Math.round(atlag);

                String atlagFormatted = String.format("%.2f", atlag);
                System.out.println(inputDiakNeve + " Programozási alapok tantárgy átlaga: " + atlagFormatted + " Év végi jegye: " + evVegiJegy);
            }
            

            else {
                throw new Exception("Iyen nev nincs.");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    // A jegyek generálására hozzon létre egy függvényt „jegyGenerator” névvel,
    // amely [1,100] intervallumba eső
    // (főprogramban generált) egész értéket kap bemenetként. A kapott érték
    // alapján, a bevezetőben megfogalmazottak
    // szerint generálja le az érdemjegyet. (pl.: 10-->1, 11-->2, 26-->3, 46-->4,
    // 71-->5). (Ha ez nem sikerül véletlenszám
    // generátorral adjon vissza értéket [1,5] között, ha ezt választotta akkor a
    // jegygenerátor tesztek hibásan futhat le!)
    public static Integer jegyGenerator(Integer randomNumber) {
        return jegyek[randomNumber];
    }

    // Készítsen egy függvényt „diakEvVegiErtekelese” névvel. A visszatérési értéke
    // valós szám legyen. A függvény
    // bemeneti paramétere pedig egy diák kódja legyen. A függvény a paraméterben
    // kapott diák kódja alapján a „Naplo”
    // adatbázisból adja vissza a diák évvégi átlagát. A diák kódja a listában
    // tárolt tömb első eleme. A hozzá tartozó jegy a tömb harmadik eleme.
    public static Double diakEvVegiErtekelese(Integer diakKodja, List<Integer[]> naplo) {
        double cnt = 0;
        double sum = 0;

        for (int i = 0; i < naplo.size(); i++) {
            Integer[] adottBejegyzes = naplo.get(i);
            if (adottBejegyzes[0].equals(diakKodja)) {
                cnt++;
                sum += adottBejegyzes[2];
            }
        }
        
        

        return sum / cnt;
    }

    // Ciklusok egymásba ágyazásával oldja meg, hogy az összes diák, minden tanítási
    // hónapra, a bevezetőben
    // megfogalmazottak szerinti számú jegyet kapjon. A jegyek generálásához
    // használja a „jegyGenerator” függvényt. Egy
    // diák egy jegyének az eltárolásához hozzon létre egy tömb típusú
    // adatszerkezetet, amely 3 egész szám tárolására szolgál.
    // A tömb első eleme a diák azonosítója, a második elem a hónap, a harmadik elem
    // pedig a generált érdemjegy legyen. A
    // létrehozott tömböt tárolja el a „Naplo”-ban minden egyes iteráció alkalmával.

    public static void evSzimulalas() {
        Random rnd = new Random();

        // szeptember tol
        // januar februar marcius aprilis majus junius julius augusztus szeptember
        // oktober november december januar februar marcius aprilis majus junius
        // 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18
        for (int i = 9; i < 19; i++) {
            System.out.println("\n\n" + i + ". honap");

            // adott honap szimulalasa
            for (int j = 1; j < diakok.size() + 1; j++) {
                Integer diakSzama = j;
                Integer jegyekSzama = rnd.nextInt(1, 6);

                System.out.println(j + ". diak");

                // adott jegy/jegyek hozzaadasa
                for (int k = 1; k < jegyekSzama + 1; k++) {
                    Integer randomSzam = rnd.nextInt(1, 101);
                    Integer adottJegy = (int) Math.round(jegyGenerator(randomSzam));

                    Integer[] adottBejegyzes = new Integer[3];

                    adottBejegyzes[0] = j;

                    if (i > 12) {
                        adottBejegyzes[1] = i - 12;
                    } else {
                        adottBejegyzes[1] = i;
                    }

                    adottBejegyzes[2] = adottJegy;

                    System.out.println("Diak szama: " + adottBejegyzes[0] + " Honap szama: " + adottBejegyzes[1]
                            + " Kiosztott erdemjegy: " + adottBejegyzes[2]);

                    naplo.add(adottBejegyzes);
                }
            }

        }

    }

}
