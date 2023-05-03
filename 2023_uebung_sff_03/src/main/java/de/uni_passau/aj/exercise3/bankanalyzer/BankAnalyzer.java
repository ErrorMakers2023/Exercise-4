package de.uni_passau.aj.exercise3.bankanalyzer;

import de.uni_passau.aj.exercise3.bankanalyzer.dto.Account;
import de.uni_passau.aj.exercise3.bankanalyzer.dto.Advisor;
import de.uni_passau.aj.exercise3.bankanalyzer.dto.Portfolio;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface BankAnalyzer {
    /**
     * Returns the email addresses for all advisors in lower case,
     * sorted alphabetically in ascending order
     *
     * @return A list of email addresses
     */
    List<String> getEmailAddresses();

    /**
     * Returns a list of all available portfolios,
     * sorted by id in ascending order.
     *
     * @return A list of {@link Portfolio}s
     */
    List<Portfolio> getAllPortfolios();

    /**
     * Returns a list of all available accounts.
     *
     * @return A list of {@link Account}s
     */
    List<Account> getAllAccounts();

    /**
     * Returns a list of all available portfolios.
     *
     * @return A map of {@link Portfolio}s (id only) to and their total managed volume
     */
    Map<String, BigDecimal> getVolumeGroupedByPortfolioId();

    /**
     * Returns the bank's total volume.
     *
     * @return The bank's total volume
     */
    BigDecimal getTotalVolume();
}
