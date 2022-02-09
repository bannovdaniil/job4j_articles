package ru.job4j.design.srp;

import com.google.gson.GsonBuilder;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Calendar;
import java.util.List;

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
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 10);
        Employee worker2 = new Employee("Fedr", now, now, 500);
        store.add(worker1);
        store.add(worker2);
        Report engine = new ReportJson(store);
        StringBuilder expect = new StringBuilder();
        expect.append("[")
                .append(new GsonBuilder().create().toJson(worker1))
                .append(",")
                .append(new GsonBuilder().create().toJson(worker2))
                .append("]");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenXML() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 10);
        Employee worker2 = new Employee("Fedr", now, now, 500);
        store.add(worker1);
        store.add(worker2);
        Report engine = new ReportXml(store);
        String expect = "";
        try (StringWriter writer = new StringWriter()) {
            JAXBContext context = JAXBContext.newInstance(ReportXml.Employees.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(new ReportXml.Employees(List.of(worker1, worker2)), writer);
            expect = writer.getBuffer().toString();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (PropertyException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        assertThat(engine.generate(em -> true), is(expect));
    }

}