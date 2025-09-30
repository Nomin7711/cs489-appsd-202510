package edu.miu.nomin.jpa;


import com.fasterxml.jackson.databind.SerializationFeature;
import edu.miu.nomin.jpa.model.Employee;
import edu.miu.nomin.jpa.model.PensionPlan;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.miu.nomin.jpa.util.QuarterUtil;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static boolean isEligibleForPensionPlan(Employee employee){
        LocalDate hireDate = LocalDate.parse(employee.getEmployeementDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return hireDate.plusYears(3).isBefore(LocalDate.now());
    }

    public static void printInJson(List<Employee> employees){
        employees = employees.stream().sorted(Comparator.comparing(Employee::getYearlySalary).reversed().thenComparing(Employee::getLastName)).toList();
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            // Convert to JSON string
            String json = mapper.writeValueAsString(employees);
            System.out.println(json);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static List<Employee> upcomingReport(List<Employee> employees){
        LocalDate quarterStart = QuarterUtil.getNextQuarterStart();
        LocalDate quarterEnd = QuarterUtil.getNextQuarterEnd();

        return employees.stream()
                .filter(emp -> emp.getPensionPlan() == null) // not yet enrolled
                .filter(emp -> {
                    LocalDate hireDate = LocalDate.parse(emp.getEmployeementDate(), fmt);
                    LocalDate qualificationDate = hireDate.plusYears(3); // qualifies after 3 years
                    return !qualificationDate.isBefore(quarterStart) && !qualificationDate.isAfter(quarterEnd);
                })
                .sorted((e1, e2) -> LocalDate.parse(e2.getEmployeementDate(), fmt)
                        .compareTo(LocalDate.parse(e1.getEmployeementDate(), fmt))) // descending
                .collect(Collectors.toList());
    }
    public static void printQuarterlyReport(List<Employee> employees){
        System.out.println("Upcoming Pension Plan Enrollment Report:");
        if (employees.isEmpty()) {
            System.out.println("No employees are eligible for pension plan enrollment in the upcoming quarter.");
        } else {
            employees.forEach(emp -> System.out.println("Employee ID: " + emp.getEmployeeId() +
                    ", Name: " + emp.getFirstName() + " " + emp.getLastName() +
                    ", Employment Date: " + emp.getEmployeementDate()));
        }

    }
    public static void main(String[] args) {
        Employee emp1 = new Employee(1, "Daniel", "Agar", "2023-01-17", 105945.50);
        Employee emp2 = new Employee(2, "Benard", "Shaw", "2022-09-03", 197750.00);
        Employee emp3 = new Employee(3, "Carly", "Agar", "2014-05-16", 842000.75);
        Employee emp4 = new Employee(4, "Wesley", "Schneider", "2023-07-21", 74500.00);
        Employee emp5 = new Employee(5, "Anna", "Wiltord", "2022-11-15", 85750.00);
        Employee emp6 = new Employee(6, "Yosef", "Tesfalem", "2022-10-30", 100000.00);

        if (isEligibleForPensionPlan(emp1)) {
            emp1.setPensionPlan(new PensionPlan(emp1, "EX1089", "2026-01-17", 100.00));
        }
        if (isEligibleForPensionPlan(emp2)) {
            emp2.setPensionPlan(new PensionPlan(emp2, "SH4455", "2025-09-03", 200.00));
        }
        if (isEligibleForPensionPlan(emp3)) {
            emp3.setPensionPlan(new PensionPlan(emp3, "SM2307", "2017-05-17", 1555.50));
        }
        List<Employee> employees = List.of(emp1, emp2, emp3, emp4, emp5, emp6);
        printInJson(employees);

        //Upcoming report
        List<Employee> upcoming = upcomingReport(employees);
        printQuarterlyReport(upcoming);

    }
}