import java.util.Scanner;

public class RestaurantMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Restaurant menu = new Restaurant();

        menu.tambahMenuMakanan("Pizza", 250000, 20);
        menu.nextId();

        menu.tambahMenuMakanan("Spaghetti", 80000, 20);
        menu.nextId();

        menu.tambahMenuMakanan("Tenderloin Steak", 60000, 30);
        menu.nextId();

        menu.tambahMenuMakanan("Chicken Steak", 45000, 30);

        menu.tampilMenuMakanan();

        for (;;) {
            menu.tampilMenuMakanan();

            System.out.println("Pesan Makanan:");

            System.out.print("Id Makanan (0-10): ");
            int idMenu = scanner.nextInt();

            System.out.print("Jumlah: ");
            int jumlahMakanan = scanner.nextInt();

            menu.pesanMakanan(idMenu, jumlahMakanan);

            System.out.print("Pesan Lagi? (1/0): ");
            int lagi = scanner.nextInt();

            if (lagi == 0)
                break;
        }

        scanner.close();
    }
}
