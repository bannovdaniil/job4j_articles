package ru.job4j.design.srp;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.function.Predicate;

public class ReportXml implements Report {
    private Store store;

    public ReportXml(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            JAXBContext context = JAXBContext.newInstance(Employees.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(new Employees(store.findBy(filter)), writer);
            xml = writer.getBuffer().toString();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (PropertyException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return xml;
    }

    @XmlRootElement(name = "employees")
    public static class Employees {

        private List<Employee> employee;

        public Employees() {
        }

        public Employees(List<Employee> employee) {
            this.employee = employee;
        }

        public List<Employee> getEmployee() {
            return employee;
        }

        public void setEmployee(List<Employee> employee) {
            this.employee = employee;
        }
    }

}
