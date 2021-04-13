package com.kaptsiug.project.parser;

import com.kaptsiug.project.model.Customer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class DomParser implements Parser {
    private static final String MSG_DOM_PARSER_START = "Start parsing with DOMParser";
    private static final String MSG_DOM_PARSER_END = "Finish parsing with DOMParser";
    private static Logger log = Logger.getLogger(DomParser.class.getName());

    @Override
    public List<Customer> parse(String file){
        log.info(MSG_DOM_PARSER_START);
        List<Customer> customers = new ArrayList<>();

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(file));
            document.getDocumentElement().normalize();

            NodeList nList = document.getElementsByTagName("customer");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node node = nList.item(temp);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    String name = eElement.getAttribute("name");
                    int age = Integer.parseInt(eElement.getAttribute("age"));
                    String department = eElement.getAttribute("department");

                    customers.add(new Customer(name, age, department));
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        log.info(MSG_DOM_PARSER_END);
        return customers;
    }

}
