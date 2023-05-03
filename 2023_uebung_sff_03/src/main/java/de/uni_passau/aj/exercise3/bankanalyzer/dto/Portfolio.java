package de.uni_passau.aj.exercise3.bankanalyzer.dto;

import de.uni_passau.aj.exercise3.bankanalyzer.enums.PortfolioType;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.List;

/**
 * A portfolio
 */
@Value
@AllArgsConstructor
public class Portfolio {
    /**
     * The identifier for a specific portfolio.
     */
    String id;
    /**
     * The portfolio's type.
     */
    PortfolioType type;
    /**
     * The accounts grouped by this portfolio.
     */
    List<Account> accounts;
}
