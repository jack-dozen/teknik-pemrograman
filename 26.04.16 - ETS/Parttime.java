public class Parttime extends Employee{
    private final int JumlahProjectSelesai;
    private double gajiPokok, tunjanganLembur;;

    private final String SM = "Staf Manager";
    private final String SP = "Staf Programmer";
    private final String SA = "Staf Analis";

    String[] bulan = {"Januari", "Februari", "Maret",
                    "April", "Mei", "Juni",
                    "Juli", "Agustus", "September",
                    "Oktober", "November", "Desember"};

    public Parttime(String nama, String jabatan, int tahunMulaiKerja, int jumlahAnak, int bulanSekarang, int tahunSekarang, int jumlahHariKerja, boolean isWeekend, int jamLembur, int JumlahProjectSelesai){
        super(nama, jabatan, tahunMulaiKerja, jumlahAnak, bulanSekarang, tahunSekarang, jumlahHariKerja, isWeekend, jamLembur);
        this.JumlahProjectSelesai = JumlahProjectSelesai;
    }

    private double hitungGajiPokok(){
        if(jabatan.compareTo(SM) == 0){
            if(tahunSekarang - tahunMulaiKerja <= 2)
                gajiPokok = 5000000;
            else if(tahunSekarang - tahunMulaiKerja <= 5)
                gajiPokok = 6000000;
            else
                gajiPokok = 7000000;
        } else if (jabatan.compareTo(SP) == 0){
            if(tahunSekarang - tahunMulaiKerja <= 2)
                gajiPokok = 300000;
            else if(tahunSekarang - tahunMulaiKerja <= 5)
                gajiPokok = 4000000;
            else
                gajiPokok = 5000000;
        } else if (jabatan.compareTo(SA) == 0){
            if(tahunSekarang - tahunMulaiKerja <= 2)
                gajiPokok = 300000;
            else if(tahunSekarang - tahunMulaiKerja <= 5)
                gajiPokok = 3500000;
            else
                gajiPokok = 4500000;
        } else {
            System.out.println("Jabatan Tidak Valid!");
            gajiPokok = 0;
        }

        return gajiPokok;
    }

    private double hitTunjanganLembur(){
        if(isWeekend)
            tunjanganLembur = 50000 * jamLembur;
        else
            tunjanganLembur = 30000 * jamLembur;

        return tunjanganLembur;
    }

    @Override
    public double getSalary(){
        return hitungGajiPokok() + hitTunjanganLembur() + (JumlahProjectSelesai * 200000);
    }

    public void printSlipGaji(){
        System.out.println("==== Slip Gaji Bulan " + bulan[bulanSekarang - 1] + " ====");
        System.out.println("Tanggal Terbit: 1 " + bulan[bulanSekarang] + " 2026");
        System.out.println("Tanggal Pembayaran: 1 " + bulan[bulanSekarang] + " 2026");
        System.out.println("");
        System.out.println("Nama: " + nama);
        System.out.println("Jabatan: " + jabatan);
        System.out.println("Total Jam Kerja: " + ((8 * jumlahHariKerja) + jamLembur) + " Jam");
        System.out.println("Total Lembur: " + jamLembur + " Jam");
        System.out.println("Total Tunjangan: Rp" + hitTunjanganLembur());
        System.out.println("Total Gaji: Rp" + getSalary());
    }

}
