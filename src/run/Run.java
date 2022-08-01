package run;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Hello " + System.getProperty("user.name") + ",\n" + "Cyrilic -> Latin - press 1 to continue" + "\n" + "Latin -> Cyrilic - press 2 to continue" + "\n" + "--------" + "\n" + "Press 0 to exit\n" + "--------");

        switch (sc.nextLine()) {
            case "1" -> {
                System.out.println("Please paste your text: ");
                String text = sc.nextLine();
                System.out.println("------\n" + transliterateC(text));
            }
            case "2" -> {
                System.out.println("Please paste your text: ");
                String text = sc.nextLine();
                System.out.println("------\n" + transliterateL(text));
            }
            case "0" -> {
                System.out.println("System exit confirmed. Goodbye!");
                System.exit(0);
            }
        }

    }

    public static String transliterateC(String text) {


        char[] cyrilic = {'а', 'б', 'в', 'г', 'д', 'ђ', 'е', 'ж', 'з', 'и', 'ј', 'к', 'л', 'љ', 'м', 'н', 'њ', 'о', 'п', 'р', 'с', 'т', 'ћ', 'у', 'ф', 'х', 'ц', 'ч', 'џ', 'ш', 'А', 'Б', 'В', 'Г', 'Д', 'Ђ', 'Е', 'Ж', 'З', 'И', 'Ј', 'К', 'Л', 'Љ', 'М', 'Н', 'Њ', 'О', 'П', 'Р', 'С', 'Т', 'Ћ', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Џ', 'Ш'};
        String[] latin = {"a", "b", "v", "g", "d", "đ", "e", "ž", "z", "i", "j", "k", "l", "lj", "m", "n", "nj", "o", "p", "r", "s", "t", "ć", "u", "f", "h", "c", "č", "dž", "š", "A", "B", "V", "G", "D", "Đ", "E", "Ž", "Z", "I", "J", "K", "L", "Lj", "M", "N", "Nj", "O", "P", "R", "S", "T", "Ć", "U", "F", "H", "C", "Č", "Dž", "Š"};

        Map<Character, String> letterMap = new HashMap<>();

        for (int i = 0; i < cyrilic.length; i++) {
            letterMap.put(cyrilic[i], latin[i]);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            boolean flag = false;
            for (Map.Entry<Character, String> e : letterMap.entrySet()) {
                if (text.charAt(i) == e.getKey()) {
                    sb.append(e.getValue());
                    flag = true;
                }
            }
            if (!flag) {
                sb.append(text.charAt(i));
            }
        }
        return sb.toString();
    }

    public static String transliterateL(String text) {

        char[] cyrilic = {'а', 'б', 'в', 'г', 'д', 'ђ', 'е', 'ж', 'з', 'и', 'ј', 'к', 'л', 'љ', 'м', 'н', 'њ', 'о', 'п', 'р', 'с', 'т', 'ћ', 'у', 'ф', 'х', 'ц', 'ч', 'џ', 'ш', 'А', 'Б', 'В', 'Г', 'Д', 'Ђ', 'Е', 'Ж', 'З', 'И', 'Ј', 'К', 'Л', 'Љ', 'М', 'Н', 'Њ', 'О', 'П', 'Р', 'С', 'Т', 'Ћ', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Џ', 'Ш'};
        String[] latin = {"a", "b", "v", "g", "d", "đ", "e", "ž", "z", "i", "j", "k", "l", "lj", "m", "n", "nj", "o", "p", "r", "s", "t", "ć", "u", "f", "h", "c", "č", "dž", "š", "A", "B", "V", "G", "D", "Đ", "E", "Ž", "Z", "I", "J", "K", "L", "Lj", "M", "N", "Nj", "O", "P", "R", "S", "T", "Ć", "U", "F", "H", "C", "Č", "Dž", "Š"};

        Map<String, Character> letterMap = new HashMap<>();

        for (int i = 0; i < cyrilic.length; i++) {
            letterMap.put(latin[i], cyrilic[i]);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            boolean flag = false;
            for (Map.Entry<String, Character> e : letterMap.entrySet()) {
                if (Character.toString(text.charAt(i)).equals(e.getKey())) {
                    sb.append(e.getValue());
                    flag = true;
                }
            }
            if (!flag) {
                sb.append(text.charAt(i));
            }
        }
        return sb.toString();
    }
}
