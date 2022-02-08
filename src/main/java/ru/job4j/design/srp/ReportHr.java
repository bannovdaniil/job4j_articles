package ru.job4j.design.srp;

import java.util.Collections;
import java.util.Comparator;
import java.util.function.Predicate;

public class ReportHr implements Report {
    private Store store;

    public ReportHr(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        var sortList = store.findBy(filter);
        sortList.sort((o1, o2) -> Double.compare(o2.getSalary(), o1.getSalary()));
        text.append("Name; Salary;").append(System.lineSeparator());
        for (Employee employee : sortList) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
