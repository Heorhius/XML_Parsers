package com.kaptsiug.project.parser;

import com.kaptsiug.project.model.Customer;

import java.util.List;

public interface Parser<T> {
    List<Customer> parse(String file);
}
