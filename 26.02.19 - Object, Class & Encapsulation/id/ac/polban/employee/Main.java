package id.ac.polban.employee;

import id.ac.polban.employee.model.*;
import id.ac.polban.employee.service.EmployeeService;

public class Main {
    public static void main(String[] args) {

        Department engineering = new Department("Engineering");
        Department hr = new Department("Human Resources");

        EmploymentType fullTime = new EmploymentType("Full-Time");
        EmploymentType partTime = new EmploymentType("Part-Time");

        Employee emp1 = new Employee(1, "Andi", engineering, fullTime, 8000000);
        Employee emp2 = new Employee(2, "Budi", hr, partTime, 4000000);
        Employee emp3 = new Employee(3, "Citra", engineering, fullTime, 9500000);

        System.out.println("Total karyawan dibuat: " + Employee.getTotalEmployees());
        System.out.println("Minimal kenaikan gaji: " + EmployeeService.getMinRaisePercent() + "%");

        EmployeeService service = new EmployeeService();
        service.addEmployee(emp1);
        service.addEmployee(emp2);
        service.addEmployee(emp3);

        System.out.println("\n=== Data Karyawan ===");
        service.printAllEmployees();

        service.raiseSalary(1, 10);
        System.out.println("\n=== Setelah Kenaikan Gaji Andi 10% ===");
        service.printAllEmployees();
    }
}
