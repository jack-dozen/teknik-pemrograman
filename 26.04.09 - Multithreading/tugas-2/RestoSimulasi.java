import java.util.Date;

class Resto {
    private int chickenStock = 100;

    public void serveCustomer(String cashierName) {
        try { Thread.sleep(1); } catch (InterruptedException e) {}

        synchronized (this) {
            Date now = new Date();
            if (chickenStock > 0) {
                chickenStock--;
                System.out.println(now + " " + cashierName + " berhasil menjual 1 ayam. Sisa stok: " + chickenStock);
            } else {
                System.out.println(now + " " + cashierName + " tidak jadi menjual karena stok habis.");
            }
        }
    }

    public int getRemainingStock() {
        return chickenStock;
    }
}

public class RestoSimulasi {
    public static void main(String[] args) throws InterruptedException {
        Resto ayamJuicyLuicyGallagher = new Resto();

        Runnable task = () -> {
            for (int i = 0; i < 40; i++) {
                ayamJuicyLuicyGallagher.serveCustomer(Thread.currentThread().getName());
            }
        };

        Thread kasir1 = new Thread(task, "Kasir-A");
        Thread kasir2 = new Thread(task, "Kasir-B");
        Thread kasir3 = new Thread(task, "Kasir-C");

        kasir1.start();
        kasir2.start();
        kasir3.start();

        kasir1.join();
        kasir2.join();
        kasir3.join();

        System.out.println("--- HASIL AKHIR STOK: " + ayamJuicyLuicyGallagher.getRemainingStock() + " ---");
    }
}
