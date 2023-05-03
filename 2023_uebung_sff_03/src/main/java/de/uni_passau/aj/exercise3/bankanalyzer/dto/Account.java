package de.uni_passau.aj.exercise3.bankanalyzer.dto;

import de.uni_passau.aj.exercise3.bankanalyzer.enums.AccountType;
import de.uni_passau.aj.exercise3.bankanalyzer.enums.Currency;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.math.BigDecimal;

/**
 * Represents an account.
 */
@Value
@AllArgsConstructor
public class Account {

    /**
     * Defines the account type.
     */
    AccountType type;

    /**
     * The account's current balance.
     */
    BigDecimal balance;

    /**
     * The account's currency.
     */
    Currency currency;

}
