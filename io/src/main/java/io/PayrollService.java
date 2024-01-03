package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PayrollService {
    private ArrayList<EmployeePayroll> employeePayrollList;

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

    public void writePayroll() throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter("employee_payroll.txt"));
        for(EmployeePayroll i : employeePayrollList){
            writer.write(i.toString() + "\n");
        }
        writer.close();
    }

    public static void main(String[] args) {
        PayrollService payrollService = new PayrollService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Employee \n2. Display Employee \n3. Write To File");
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
            
                case 2:
                    payrollService.displayAllEmployees();
                    break;

                case 3:
                    try {
                        payrollService.writePayroll();
                    } catch (IOException e) {
                        System.out.println("ERROR GENERATED:- ");
                        e.printStackTrace();
                    }
                    break;

                default:
                    break;
            }
        }

        
    }
}
