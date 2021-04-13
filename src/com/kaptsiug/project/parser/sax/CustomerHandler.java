package com.kaptsiug.project.parser.sax;

import com.kaptsiug.project.model.Customer;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class CustomerHandler extends DefaultHandler {

    private List<Customer> customers = new ArrayList<>();

    @Override
    public void startElement(String uri,
                             String localName, String qName, Attributes attributes) {
        if (qName.equals("customer")) {
            String name = attributes.getValue("name");
            int age = Integer.parseInt(attributes.getValue("age"));
            String department = attributes.getValue("department");
            customers.add(new Customer(name, age, department));
        }
    }

    @Override
    public void endDocument() {
    }

    public List<Customer> getCustomers() {
        return customers;
    }

}