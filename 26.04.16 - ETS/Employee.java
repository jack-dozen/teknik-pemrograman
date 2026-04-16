public class Employee{
    private double gajiPokok, tunjanganLembur;
    protected String nama, jabatan;
    protected int tahunMulaiKerja, jumlahAnak, bulanSekarang, tahunSekarang, jumlahHariKerja, jamLembur;
    protected boolean isWeekend;

    public Employee(String nama, String jabatan, int tahunMulaiKerja, int jumlahAnak, int bulanSekarang, int tahunSekarang, int jumlahHariKerja, boolean isWeekend, int jamLembur){
        this.nama = nama;
        this.jabatan = jabatan;
        this.tahunMulaiKerja = tahunMulaiKerja;
        this.jumlahAnak = jumlahAnak;
        this.bulanSekarang = bulanSekarang;
        this.tahunSekarang = tahunSekarang;
        this.jumlahHariKerja = jumlahHariKerja;
        this.isWeekend = isWeekend;
        this.jamLembur = jamLembur;
    }

    public double getSalary(){
        return gajiPokok + tunjanganLembur;
    }
}
