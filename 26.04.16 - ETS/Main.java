public class Main {
    public static void main(String[] args) {
        Fulltime Asep = new Fulltime("Asep", "Staf Programmer", 2021, 2, 3, 2026, 26, true, 6, 500000);
        Parttime Ujang = new Parttime("Ujang", "Staf Programmer", 2025, 0, 3, 2026, 26, true, 9, 1);

        Asep.printSlipGaji();
        Ujang.printSlipGaji();
    }
}
