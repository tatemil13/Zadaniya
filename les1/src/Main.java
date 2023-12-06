// hello  (зашифровать с шагов 3 ) khoor zruog
// xyz = abc hello ( расшифровать с шагов 3) ebiil tloia

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

    public class Main{

        public static void main(String[] args) throws FileNotFoundException {
            Scanner a = new Scanner(System.in);
            System.out.print(" Нажмите ");
            System.out.print(" (1) чтобы зашифровать сообщение или (2) чтобы расшифровать сообщение ");
            int input = a.nextInt();


            Scanner b = new Scanner(new File("C:\\Users\\gainu\\Desktop\\трусов\\les1\\src\\Text.txt"));



            if (input == 1) {

                System.out.print("Введите шаг : ");
                int key = a.nextInt();
                System.out.print("Введите сообщение, которое хотите зашифровать в файле Text.txt  : ");
                String Message = b.nextLine();
                System.out.println("ответ : " + encrypt(Message, key));

            }else if (input == 2) {

                System.out.print("Введите шаг : ");
                int key = a.nextInt();
                System.out.print("Введите слово, которое хотите расшифровка  в файле Text.txt  : ");
                String Message = b.nextLine();
                System.out.println("ответ : " + decrypt(Message, key));
            }else{
                System.out.println("чтото пошло не так ");
            }
        }





    public static final String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String encrypt (String Message,int Key){
        System.out.println(Message.replaceAll("\\s+",""));
        String Message2 = "";
        Message = Message.toUpperCase().replaceAll("\\s+","");
        for (int i = 0; i < Message.length(); i++) {
            int position = alpha.indexOf(Message.charAt(i));
            int kval = (Key + position) % 26;
            char aval = alpha.charAt(kval);
            Message2 += aval;
        }
        return Message2;
    }

    public static String decrypt (String Message2,int Key){
        System.out.println(Message2.replaceAll("\\s+",""));
        String Message = "";
        Message2 = Message2.toUpperCase().replaceAll("\\s+","");
        for (int i = 0; i < Message2.length(); i++) {
            int position = alpha.indexOf(Message2.charAt(i));
            int kval = (position - Key) % 26;
            if (kval < 0) {
                kval = alpha.length() + kval;
            }
            char aval = alpha.charAt(kval);
            Message += aval;
        }
        return Message;
    }
    }
