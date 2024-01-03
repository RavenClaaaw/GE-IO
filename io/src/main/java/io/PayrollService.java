package io;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PayrollService {
    private List<EmployeePayroll> employeePayrollList;

    public PayrollService() {
        employeePayrollList = new ArrayList<>();
    }

    public void addEmployee(EmployeePayroll employeePayroll) {
        employeePayrollList.add(employeePayroll);
    }

    public void displayAllEmployees() {
        for (EmployeePayroll employeePayroll : employeePayrollList) {
            employeePayroll.display();
        }
    }

    public static void main(String[] args) {
        PayrollService payrollService = new PayrollService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. WRITE \n2. READ");
            System.out.print("ENTER:- ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("\nEnter ID: ");
                    String id = scanner.nextLine();

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Salary: ");
                    double salary = scanner.nextDouble();

                    EmployeePayroll employeePayroll = new EmployeePayroll(id, name, salary);
                    payrollService.addEmployee(employeePayroll);
                    break;
            
                default:
                    payrollService.displayAllEmployees();
                    break;
            }
        }

        
    }
}
