import id.ac.polban.employee.model.*;
import id.ac.polban.employee.service.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("JAR berhasil digunakan!");
        System.out.println("Total karyawan: " + Employee.getTotalEmployee());
    }
}
