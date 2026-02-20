package id.ac.polban.employee.service;

import id.ac.polban.employee.model.*;
import java.util.HashMap;
import java.util.Map;

// mengelola operasi yang berkaitan dengan data dan aturan bisnis
public class EmployeeService {

    private final Map<Integer, Employee> employees = new HashMap<>();

    public void addEmployee(Employee emp) {
        employees.put(emp.getId(), emp);
    }

    public Employee getEmployee(int id) {
        return employees.get(id);
    }

    public void raiseSalary(int id, double percent) {
        Employee emp = employees.get(id);
        if (emp != null) {
            emp.setSalary(emp.getSalary() * (1 + percent/100));
        }
    }

    public void removeEmployee(int id) {
        Employee emp = employees.remove(id);
        if (emp == null) {
            System.out.println("Karyawan dengan id " + id + " Tidak Terdaftar!");
        } else {
            Employee.employeeDecrement(); // hanya kurang kalau beneran dihapus
            System.out.println("Karyawan berhasil dihapus!");
        }
    }

    public void printAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("Tidak ada karyawan.");
            return;
        }

        System.out.println("=== DATA KARYAWAN ===");

        for (Employee emp : employees.values()) {
            System.out.println("---------------------------");
            System.out.println("ID      : " + emp.getId());
            System.out.println("Nama    : " + emp.getName());
            System.out.println("Dept    : " + emp.getDepartment().getName());
            System.out.println("Tipe    : " + emp.getType().getType());
            System.out.printf ("Gaji    : Rp %.2f%n", emp.getSalary());
        }
    }
}
