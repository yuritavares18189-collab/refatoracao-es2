package br.ufpa.refactoring.q3;

import java.util.List;

public class PayrollCalculator {

    public double monthlyNetSalary(Employee employee) {
        double net = gross(employee) - tax(employee) - employee.healthPlanDeduction() + mealVoucher(employee);
        return Math.round(net * 100.0) / 100.0;
    }

    private double overtimePay(Employee employee) {
        double overtime = 0.0;
        for (Overtime ot : employee.overtimes()) overtime += ot.hours() * ot.hourRate();
        return overtime;
    }

    private double gross(Employee employee) {
        return employee.baseSalary() + overtimePay(employee);
    }

    private double tax(Employee employee) {
        double gross = gross(employee);
        if (gross <= 3000) return gross * 0.08;
        if (gross <= 7000) return gross * 0.12;
        return gross * 0.18;
    }

    private double mealVoucher(Employee employee) {
        return employee.hasMealVoucher() ? 450.0 : 0.0;
    }

    public record Employee(double baseSalary, List<Overtime> overtimes,
                           boolean hasMealVoucher, double healthPlanDeduction) {}

    public record Overtime(int hours, double hourRate) {}
}
