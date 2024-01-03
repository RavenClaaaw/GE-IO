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

    public void readPayroll() throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader("employee_payroll.txt"));
        System.out.println("\nFile Contents:- ");
        String line;
        while((line = reader.readLine()) != null){
            System.out.println(line);
        }

        reader.close();
    }

    public void readCount() throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader("employee_payroll.txt"));
        String line;
        int counter = 0;
        while((line = reader.readLine()) != null){
            counter += 1;
        }
        
        System.out.println("\nTotal Entries:- " + (counter));
        reader.close();
    }

    public static void main(String[] args) {
        PayrollService payrollService = new PayrollService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Employee \n2. Display Employee \n3. Write To File \n4. Read From File \n5. Total Entries");
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

                case 4:
                    try {
                        payrollService.readPayroll();
                    } catch (IOException e) {
                        System.out.println("ERROR GENERATED:- ");
                        e.printStackTrace();
                    }
                    break;

                case 5:
                    try {
                        payrollService.readCount();
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
