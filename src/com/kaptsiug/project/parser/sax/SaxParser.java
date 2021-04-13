package com.kaptsiug.project.parser.sax;

import com.kaptsiug.project.model.Customer;
import com.kaptsiug.project.parser.Parser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class SaxParser implements Parser {
    private static Logger log = Logger.getLogger(SaxParser.class.getName());
    private static final String MSG_SAX_PARSER_START = "Start parsing with SAXParser";
    private static final String MSG_SAX_PARSER_END = "Finish parsing with SAXParser";

    @Override
    public List<Customer> parse(String file) {
        log.info(MSG_SAX_PARSER_START);
        List<Customer> customers = new ArrayList<>();

        try {
            File inputFile = new File(file);
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            CustomerHandler userHandler = new CustomerHandler();
            saxParser.parse(inputFile, userHandler);

            customers = userHandler.getCustomers();
        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }
        log.info(MSG_SAX_PARSER_END);
        return customers;
    }


}