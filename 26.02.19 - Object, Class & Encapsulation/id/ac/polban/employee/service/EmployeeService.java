package id.ac.polban.employee.service;

import id.ac.polban.employee.model.*;
import java.util.HashMap;
import java.util.Map;

public class EmployeeService {
    private static final double MIN_RAISE_PERCENT = 1.0;

    private final Map<Integer, Employee> employees = new HashMap<>();

    public void addEmployee(Employee emp) {
        employees.put(emp.getId(), emp);
    }

    public Employee getEmployee(int id) {
        return employees.get(id);
    }

    public void raiseSalary(int id, double percent) {
        if (percent < MIN_RAISE_PERCENT) {
            System.out.println("Kenaikan gaji minimal " + MIN_RAISE_PERCENT + "%");
            return;
        }
        Employee emp = employees.get(id);
        if (emp != null) {
            emp.setSalary(emp.getSalary() * (1 + percent / 100));
        }
    }

    public static double getMinRaisePercent() {
        return MIN_RAISE_PERCENT;
    }

    public void printAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("Tidak ada karyawan.");
            return;
        }
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
