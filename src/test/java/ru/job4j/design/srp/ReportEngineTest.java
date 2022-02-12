package ru.job4j.design.srp;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ReportEngineTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenHtmlGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportHtml(store);
        StringBuilder expect = new StringBuilder()
                .append("<html><head></head><body><table border=1><tr>")
                .append("<td>Name</td><td>Hired</td><td>Fired</td><td>Salary</td></tr>")
                .append("<tr><td>")
                .append(worker.getName()).append("</td><td>")
                .append(worker.getHired()).append("</td><td>")
                .append(worker.getFired()).append("</td><td>")
                .append(worker.getSalary()).append("</td></tr>")
                .append(System.lineSeparator())
                .append("</table></body></html>");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenSalaryGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportSalary(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(String.format("%.2f", worker.getSalary())).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenSalaryHr() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 10);
        Employee worker2 = new Employee("Fedr", now, now, 500);
        Employee worker3 = new Employee("Sveta", now, now, 100);
        store.add(worker);
        store.add(worker2);
        store.add(worker3);
        Report engine = new ReportHr(store);
        StringBuilder expect = new StringBuilder();
        expect.append("Name; Salary;").append(System.lineSeparator());
        expect.append(worker2.getName()).append(";");
        expect.append(worker2.getSalary()).append(";").append(System.lineSeparator());
        expect.append(worker3.getName()).append(";");
        expect.append(worker3.getSalary()).append(";").append(System.lineSeparator());
        expect.append(worker.getName()).append(";");
        expect.append(worker.getSalary()).append(";").append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenJson() {
        MemStore store = new MemStore();
        Calendar now = new GregorianCalendar(2022, Calendar.FEBRUARY, 12,
                18, 16, 0);
        Employee worker1 = new Employee("Ivan", now, now, 10);
        store.add(worker1);
        Report engine = new ReportJson(store);
        StringBuilder expect = new StringBuilder();
        expect.append("[{\"name\":\"Ivan\",\"hired\":")
                .append("{\"year\":2022,\"month\":1,\"dayOfMonth\":12,\"hourOfDay\":18,\"minute\":16,\"second\":0},")
                .append("\"fired\":")
                .append("{\"year\":2022,\"month\":1,\"dayOfMonth\":12,\"hourOfDay\":18,\"minute\":16,\"second\":0}")
                .append(",\"salary\":10.0}]");
        assertThat(expect.toString(), is(engine.generate(em -> true)));
    }

    @Test
    public void whenXML() {
        MemStore store = new MemStore();
        Calendar now = new GregorianCalendar(2022, Calendar.FEBRUARY, 12,
                18, 16, 0);
        Employee worker1 = new Employee("Ivan", now, now, 10);
        store.add(worker1);
        Report engine = new ReportXml(store);
        StringBuilder expect = new StringBuilder();
        expect.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<employees>\n    ")
                .append("<employee>\n        <fired>2022-02-12T18:16:00+03:00</fired>\n        ")
                .append("<hired>2022-02-12T18:16:00+03:00</hired>\n        <name>Ivan</name>\n        ")
                .append("<salary>10.0</salary>\n    </employee>\n</employees>\n");
        assertThat(expect.toString(), is(engine.generate(em -> true)));
    }

}