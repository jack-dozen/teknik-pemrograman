
public class Restaurant {
    private final String[] nama_makanan;
    private final double[] harga_makanan;
    private final int[] stok;
    private byte id = 0;

    public String getNamaMakanan(int index) {
        return nama_makanan[index];
    }

    public void setNamaMakanan(int index, String nama) {
        nama_makanan[index] = nama;
    }

    public double getHargaMakanan(int index) {
        return harga_makanan[index];
    }

    public void setHargaMakanan(int index, double harga) {
        if (harga < 0) {
            System.out.println("Harga tidak boleh negatif!");
            return;
        }
        harga_makanan[index] = harga;
    }

    public int getStok(int index) {
        return stok[index];
    }

    public void setStok(int index, int nilai) {
        if (nilai < 0) {
            System.out.println("Stok tidak boleh negatif!");
            return;
        }
        stok[index] = nilai;
    }

    public byte getId() {
        return id;
    }

    public Restaurant() {
        nama_makanan = new String[10];
        harga_makanan = new double[10];
        stok = new int[10];
    }

    public void tambahMenuMakanan(String nama, double harga, int stok) {
        setNamaMakanan(id, nama);
        setHargaMakanan(id, harga);
        setStok(id, stok);
    }

    public void tampilMenuMakanan() {
        for (int i = 0; i <= id; i++) {
            if (!isOutOfStock(i)) {
                System.out.println("(" + i + ") " + getNamaMakanan(i) + "[" + getStok(i) + "]" + "\tRp. " + getHargaMakanan(i));
            }
        }
    }

    public void pesanMakanan(int idMenu, int jumlah) {
        if (isOutOfStock(idMenu)) {
            System.out.println("Stok Habis!");
            return;
        }

        if (getStok(idMenu) < jumlah) {
            System.out.println("Stok Tidak Cukup! Stok Tersisa: " + getStok(idMenu));
            return;
        }

        setStok(idMenu, getStok(idMenu) - jumlah);
        System.out.println("Pesanan " + getNamaMakanan(idMenu) + " x" + jumlah + " Berhasil!");
    }

    public boolean isOutOfStock(int id) {
        return (getStok(id) == 0);
    }

    public void nextId() {
        id++;
    }
}
