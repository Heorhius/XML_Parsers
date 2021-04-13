package com.kaptsiug.project.controller;

import com.kaptsiug.project.model.Customer;
import com.kaptsiug.project.parser.DomParser;
import com.kaptsiug.project.parser.sax.SaxParser;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // SAX
        SaxParser saxParser = new SaxParser();

        // DOM
        DomParser parser = new DomParser();

        List<Customer> customers = parser.parse("src/Input_file.xml");
        customers.forEach((customer -> System.out.println(customer.getName() + " " + customer.getDepartment() + " " + customer.getAge())));
    }
}
