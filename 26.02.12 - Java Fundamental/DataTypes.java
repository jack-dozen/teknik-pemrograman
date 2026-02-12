import java.util.Scanner;

public class DataTypes{
    public static void main(String[] args){
        Scanner scanf = new Scanner(System.in);

        byte jumlah_uji = scanf.nextByte();
        String n[] = new String[jumlah_uji];

        scanf.nextLine();

        for (byte i = 0; i < jumlah_uji; i++)
            n[i] = scanf.nextLine();

        for (byte i = 0; i < jumlah_uji; i++){
            try{
                long str_to_long = Long.parseLong(n[i]);
                System.out.println(n[i] + " can be fitted in:");

                if (str_to_long <= Byte.MAX_VALUE && str_to_long >= Byte.MIN_VALUE){
                    System.out.println("* byte");
                    System.out.println("* short");
                    System.out.println("* int");
                    System.out.println("* long");
                } else if (str_to_long <= Short.MAX_VALUE && str_to_long >= Short.MIN_VALUE){
                    System.out.println("* short");
                    System.out.println("* int");
                    System.out.println("* long");
                } else if (str_to_long <= Integer.MAX_VALUE && str_to_long >= Integer.MIN_VALUE){
                    System.out.println("* int");
                    System.out.println("* long");
                } else if (str_to_long <= Long.MAX_VALUE && str_to_long >= Long.MIN_VALUE){
                    System.out.println("* long");
                }
            }catch (NumberFormatException e){
                System.out.println(n[i] + " can't be fitted anywhere");
            }
        }
        scanf.close();
    }
}
