
/// шифр Виженера
/// предложение mama gde ruka
/// ключ   love
/// зашифровка xoherrzvfyv
/// расшифровка  bmrwvpjnjwf


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) throws FileNotFoundException {

        Scanner a = new Scanner(System.in);
        System.out.print(" Нажмите ");
        System.out.print(" (1) чтобы зашифровать сообщение или (2) чтобы расшифровать сообщение ");
        int input = a.nextInt();

        Scanner b = new Scanner(new File("C:\\Users\\gainu\\Desktop\\трусов\\les2\\src\\myTest.txt"));

        if (input == 1) {
            System.out.print("Введите ключ в верхнем регистре: ");
            String key = a.next();
            System.out.print("Введите сообщение, которое хотите зашифровать в файле myTest.txt: ");
            String Message = b.nextLine();
            String answer = encrypt(Message, key);
            System.out.println("ответ : " + answer);
        }

        else if (input == 2) {
            System.out.print("Введите ключ в верхнем регистре:");
            String key = a.next();
            System.out.print("Введите сообщение, которое хотите зашифровать в файле myTest.txt : ");
            String Message = b.nextLine();
            String answer = decrypt(Message, key);
            System.out.println("ответ : " + answer);
        }else{
            System.out.println("чтото пошло не так ");
        }

    }
    public static String encrypt(String Message, String Key) {
        System.out.println(Message.replaceAll("\\s+",""));
        String Message2 = "";
        Message = Message.toUpperCase().replaceAll("\\s+","");
        for (int i = 0, j = 0; i < Message.length(); i++) {
            char a = Message.charAt(i);
            Message2 += (char)(((a - 65) + (Key.charAt(j)-65)) % 26 + 65);
            j = ++j % Key.length();
        }

        return Message2;
    }
    public static String decrypt(String Message, String Key) {
        System.out.println(Message.replaceAll("\\s+",""));
        String Message2 = "";
        Message = Message.toUpperCase().replaceAll("\\s+","");
        for (int i = 0, j = 0; i < Message.length(); i++) {
            char a = Message.charAt(i);
            Message2 += (char)((a - Key.charAt(j) + 26) % 26 + 65);
            j = ++j % Key.length();
        }
        return Message2;
    }
}