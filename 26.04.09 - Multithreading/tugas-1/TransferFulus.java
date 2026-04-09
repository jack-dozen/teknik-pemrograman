import java.util.Date;

class Account {
    int balance = 150;
}

public class TransferFulus {
    public static void main(String[] args) throws InterruptedException {
        Account acc1 = new Account();
        Account acc2 = new Account();

        // Thread 1: Menjumlahkan/ transfer fulus dari acc1 ke acc2
        Thread t1 = new Thread(() -> {
            synchronized (acc1) { // Mengunci acc1 *
                Date now = new Date();
                System.out.println(now + " t1 mengunci acc1..."); // *
                try { Thread.sleep(100); } catch (Exception e) {} // Simulasi dengan memberikan jeda. Execption diperlukan karena bisa saja ada kondisi dimana sebuah thread yang lagi "tidur" dipaksa bangun oleh thread lainnya.

                synchronized (acc2) { // Mengunci acc2 *
                    Date now1 = new Date();
                    System.out.println(now1 + " t1 mengunci acc2 | menjumlahkan saldo acc1 dan acc2 ke acc2..."); // *
                    acc2.balance += acc1.balance; // 150 + 150 = 300
                }
            }
        });

        // Thread 2: Menjumlahkan/ transfer fulus dari acc2 ke acc1
        Thread t2 = new Thread(() -> {
            synchronized (acc1) { // Mengunci acc1 *
                Date now = new Date();
                System.out.println(now + " t2 engunci acc1..."); // *
                try { Thread.sleep(100); } catch (Exception e) {}

                synchronized (acc2) { // Mengunci acc2 *
                    Date now1 = new Date();
                    System.out.println(now1 + " t2 mengunci acc2 | menjumlahkan saldo acc1 dan acc2 ke acc1..."); // *
                    acc1.balance += acc2.balance; // 150 + 300 = 450
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("--- HASIL AKHIR ---");
        System.out.println("Saldo Akhir acc1: " + acc1.balance); // 450
		System.out.println("Saldo Akhir acc2: " + acc2.balance); // 300
    }
}
