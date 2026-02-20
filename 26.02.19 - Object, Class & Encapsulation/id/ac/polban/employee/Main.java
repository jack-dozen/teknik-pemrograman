package id.ac.polban.employee;

import id.ac.polban.employee.model.Department;
import id.ac.polban.employee.model.Employee;
import id.ac.polban.employee.model.EmploymentType;
import id.ac.polban.employee.service.EmployeeService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanf = new Scanner(System.in);
        EmployeeService service = new EmployeeService();

        // Kamus Data Lokal
        int id;
        String nama;
        String dept;
        String et;
        double gaji;
        double percent;

        // Define Department | Employment Type | Deklarasi Employee
        Department en = new Department("Engineer");
        Department hr = new Department("Human Resources");
        Department fi = new Department("Finance");
        Department ad = new Department("Admin");
        Department mk = new Department("Marketing");

        EmploymentType ft = new EmploymentType("Full Time");
        EmploymentType pt = new EmploymentType("Part Time");
        EmploymentType in = new EmploymentType("Internship");

        Employee emp;

        while (true) {
            System.out.println("=== SISTEM DATA KARYAWAN ===");
            System.out.println("1. Tambah Karyawan");
            System.out.println("2. Lihat Karyawan");
            System.out.println("3. Naikan Gaji Karyawan");
            System.out.println("4. Hapus Karyawan");
            System.out.println("5. Kamus");
            System.out.println("0. Keluar");
            System.out.print("Pilih Menu: ");

            int menu = scanf.nextInt();

            switch (menu) {
                case 1 -> {
                    System.out.print("Nama Karyawan: ");
                    scanf.nextLine(); // consume newline
                    nama = scanf.nextLine();
                    System.out.print("Id Karyawan: ");
                    id = scanf.nextInt();
                    System.out.print("Department: ");
                    scanf.nextLine(); // consume newline
                    dept = scanf.nextLine();
                    System.out.print("Employment Type: : ");
                    et = scanf.nextLine();
                    System.out.print("Gaji: ");
                    gaji = scanf.nextDouble();

                    Department department = getDepartment(dept, en, hr, fi, ad, mk);
                    EmploymentType employmentType =  getEmploymentType(et, ft, pt, in);
                    emp = new Employee(id, nama, department, employmentType, gaji);
                    service.addEmployee(emp);

                    System.out.print("\nTekan Enter untuk melanjutkan...");
                    scanf.nextLine();
                    scanf.nextLine();
                }
                case 2 -> {
                    service.printAllEmployees();
                    System.out.println("Total karyawan: " + Employee.getTotalEmployee());

                    System.out.print("\nTekan Enter untuk melanjutkan...");
                    scanf.nextLine();
                    scanf.nextLine();
                }
                case 3 -> {
                    System.out.print("ID Karyawan: ");
                    id = scanf.nextInt();
                    System.out.print("Persentase Kenaikan: ");
                    percent = scanf.nextDouble();

                    service.raiseSalary(id, percent);

                    System.out.print("\nTekan Enter untuk melanjutkan...");
                    scanf.nextLine();
                    scanf.nextLine();
                }
                case 4 -> {
                    System.out.print("ID Karyawan Yang Mau DiHapus: ");
                    id = scanf.nextInt();
                    service.removeEmployee(id);

                    System.out.print("\nTekan Enter untuk melanjutkan...");
                    scanf.nextLine();
                    scanf.nextLine();
                }
                case 5 -> {
                    System.out.println("=== KAMUS ===");
                    System.out.println("- Department");
                    System.out.println("en = Engineer");
                    System.out.println("hr = Human Resources");
                    System.out.println("fi = Finance");
                    System.out.println("ad = Admin");
                    System.out.println("mk = Marketing");
                    System.out.println("");
                    System.out.println("- Employment Type");
                    System.out.println("ft = Full Time");
                    System.out.println("pt = Part Time");
                    System.out.println("in = Internship");

                    System.out.print("\nTekan Enter untuk melanjutkan...");
                    scanf.nextLine();
                    scanf.nextLine();
                }
                case 0 -> {
                    scanf.close();
                    System.out.println("Sayonara!");
                    return;
                }
                default -> throw new AssertionError();
            }
        }
    }

// helper
    private static Department getDepartment(String dept, Department en, Department hr, Department fi, Department ad, Department mk) {
        return switch (dept.toLowerCase()) {
            case "engineer" -> en;
            case "human resources" -> hr;
            case "finance" -> fi;
            case "admin" -> ad;
            case "marketing" -> mk;
            default -> en;
        };
    }

    private static EmploymentType getEmploymentType(String et, EmploymentType ft, EmploymentType pt, EmploymentType in) {
        return switch (et.toLowerCase()) {
            case "full time" -> ft;
            case "part time" -> pt;
            case "internship" -> in;
            default -> ft;
        };
    }
}

