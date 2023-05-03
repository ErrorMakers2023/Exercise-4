package de.uni_passau.aj.exercise3.bankanalyzer;

import de.uni_passau.aj.exercise3.bankanalyzer.dto.Account;
import de.uni_passau.aj.exercise3.bankanalyzer.dto.Advisor;
import de.uni_passau.aj.exercise3.bankanalyzer.dto.Portfolio;
import de.uni_passau.aj.exercise3.bankanalyzer.enums.AccountType;
import de.uni_passau.aj.exercise3.bankanalyzer.enums.Currency;
import de.uni_passau.aj.exercise3.bankanalyzer.enums.PortfolioType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Slf4j
public class MyBankAnalyzerTest {
    private List<Advisor> createTestAdvisors() {
        // The bank has three advisors
        Advisor johnnyCash = new Advisor("Johnny Cash");
        Advisor bobDylan = new Advisor("Bob Dylan");
        Advisor neilYoung = new Advisor("Neil Young");

        List<Account> accountsOne =
            Stream.of(new Account(AccountType.SALARY, new BigDecimal("21434.66"), Currency.EUR), new Account(AccountType.FOREIGN_CURRENCIES, new BigDecimal("155026.18"), Currency.USD))
                .collect(Collectors.toList());

        List<Account> accountsTwo =
            Stream.of(new Account(AccountType.PRIVATE_SAVINGS, new BigDecimal("14574.56"), Currency.EUR), new Account(AccountType.GIFT, new BigDecimal("1524.00"), Currency.EUR)).
                collect(Collectors.toList());

        // Johnny Cash is now responsible for two portfolios with two accounts each
        johnnyCash.addPortfolio(new Portfolio("2", PortfolioType.STANDARD, accountsOne));
        johnnyCash.addPortfolio(new Portfolio("4", PortfolioType.RETIREMENT_PROVISION, accountsTwo));

        accountsOne = Stream.of(new Account(AccountType.SALARY, new BigDecimal("10054.74"), Currency.EUR)).collect(Collectors.toList());
        accountsTwo = Stream.of(new Account(AccountType.PRIVATE_SAVINGS, new BigDecimal("14574.56"), Currency.EUR)).collect(Collectors.toList());

        // Bob Dylan is now responsible for two portfolios with one account each
        bobDylan.addPortfolio(new Portfolio("3", PortfolioType.STANDARD, accountsOne));
        bobDylan.addPortfolio(new Portfolio("1", PortfolioType.RETIREMENT_PROVISION, accountsTwo));

        // Neil Young just has a portfolio without accounts:
        neilYoung.addPortfolio(new Portfolio("5", PortfolioType.STANDARD, null));
        return Stream.of(johnnyCash, bobDylan, neilYoung).collect(Collectors.toList());
    }

    @Test
    public void testGetEmailAddresses() {
        List<Advisor> advisors = createTestAdvisors();
        final BankAnalyzer bankAnalyzerStreamStyle = new BankAnalyzerStreamStyle(advisors);
        final BankAnalyzer bankAnalyzerOldStyle = new BankAnalyzerOldStyle(advisors);
        List<String> expected = Stream.of(
            "bob.dylan@software-engineering.advanced",
            "johnny.cash@software-engineering.advanced",
            "neil.young@software-engineering.advanced"
        ).collect(Collectors.toList());

        log.info("Result: {}", expected);
        Assertions.assertEquals(expected, bankAnalyzerStreamStyle.getEmailAddresses());
        Assertions.assertEquals(expected, bankAnalyzerOldStyle.getEmailAddresses());
    }


    @Test
    public void testGetAllPortfolios() {
        List<Advisor> advisors = createTestAdvisors();
        final BankAnalyzer bankAnalyzerStreamStyle = new BankAnalyzerStreamStyle(advisors);
        final BankAnalyzer bankAnalyzerOldStyle = new BankAnalyzerOldStyle(advisors);
        List<Portfolio> portfolios = bankAnalyzerStreamStyle.getAllPortfolios();
        log.info("Result: {}", portfolios);
        Assertions.assertEquals(5, portfolios.size());
        Assertions.assertEquals("1", portfolios.get(0).getId());
        Assertions.assertEquals("2", portfolios.get(1).getId());
        Assertions.assertEquals("3", portfolios.get(2).getId());
        Assertions.assertEquals("4", portfolios.get(3).getId());
        Assertions.assertEquals("5", portfolios.get(4).getId());

        List<Portfolio> portfoliosOldStyle = bankAnalyzerOldStyle.getAllPortfolios();
        Assertions.assertEquals(portfolios, portfoliosOldStyle);
    }

    @Test
    public void testGetAllAccounts() {
        List<Advisor> advisors = createTestAdvisors();
        final BankAnalyzer bankAnalyzerStreamStyle = new BankAnalyzerStreamStyle(advisors);
        final BankAnalyzer bankAnalyzerOldStyle = new BankAnalyzerOldStyle(advisors);
        List<Account> accounts = bankAnalyzerStreamStyle.getAllAccounts();
        List<Account> accountsOldStype = bankAnalyzerOldStyle.getAllAccounts();
        log.info("Result: {}", accounts);
        Assertions.assertEquals(6, accounts.size());
        Assertions.assertEquals(6, accountsOldStype.size());
        Assertions.assertEquals(accounts, accountsOldStype);
    }

    @Test
    public void testGetTotalVolume() {
        List<Advisor> advisors = createTestAdvisors();
        final BankAnalyzer bankAnalyzerStreamStyle = new BankAnalyzerStreamStyle(advisors);
        final BankAnalyzer bankAnalyzerOldStyle = new BankAnalyzerOldStyle(advisors);
        BigDecimal result = bankAnalyzerStreamStyle.getTotalVolume();
        BigDecimal resultOldStyle = bankAnalyzerOldStyle.getTotalVolume();
        Assertions.assertEquals(new BigDecimal("217188.70"), result);
        Assertions.assertEquals(new BigDecimal("217188.70"), resultOldStyle);
    }

    @Test
    public void testGetVolumeGroupedByPortfolioId() {
        List<Advisor> advisors = createTestAdvisors();
        final BankAnalyzer bankAnalyzerStreamStyle = new BankAnalyzerStreamStyle(advisors);
        final BankAnalyzer bankAnalyzerOldStyle = new BankAnalyzerOldStyle(advisors);
        Map<String, BigDecimal> expected = new HashMap<>();
        expected.put("1", new BigDecimal("14574.56"));
        expected.put("2", new BigDecimal("176460.84"));
        expected.put("3", new BigDecimal("10054.74"));
        expected.put("4", new BigDecimal("16098.56"));
        expected.put("5", BigDecimal.ZERO);
        log.info("Result: {}", expected);

        Assertions.assertEquals(expected, bankAnalyzerStreamStyle.getVolumeGroupedByPortfolioId());
        Assertions.assertEquals(expected, bankAnalyzerOldStyle.getVolumeGroupedByPortfolioId());
    }
}
