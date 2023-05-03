package de.uni_passau.aj.exercise3.bankanalyzer.dto;

import lombok.Value;

import java.util.ArrayList;
import java.util.List;

/**
 * An advisor manages a set of assigned portfolios.
 */
@Value
public class Advisor {
    /**
     * The advisors name.
     */
     String name;

    /**
     * The advisor's email address.
     */
     String email;

    /**
     * The portfolios to manage.
     */
     List<Portfolio> portfolios= new ArrayList<>();

    /**
     * Constructor.
     *
     * @param name The advisor's name
     */
    public Advisor(String name) {
        this.name = name;
        this.email = name.replace(" ", ".") + "@software-engineering.advanced";
    }

    /**
     * Lazy init always good?
     * Adds a portfolio to the list of managed portfolios.
     *
     * @param portfolio The portfolio to add
     */
    public void addPortfolio(Portfolio portfolio) {
        portfolios.add(portfolio);
    }

}
