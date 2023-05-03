package de.uni_passau.aj.exercise3.bankanalyzer;

import de.uni_passau.aj.exercise3.bankanalyzer.dto.Account;
import de.uni_passau.aj.exercise3.bankanalyzer.dto.Advisor;
import de.uni_passau.aj.exercise3.bankanalyzer.dto.Portfolio;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Slf4j
public class BankAnalyzerOldStyle implements BankAnalyzer {
    @Getter
    List<Advisor> advisors;

    public BankAnalyzerOldStyle(List<Advisor> bankAdvisors) {
        this.advisors = bankAdvisors;
    }

    @Override
    public List<String> getEmailAddresses() {
        return null;
    }

    @Override
    public List<Portfolio> getAllPortfolios() {
        return null;
    }

    @Override
    public List<Account> getAllAccounts() {
        return null;
    }

    @Override
    public Map<String, BigDecimal> getVolumeGroupedByPortfolioId() {
        return null;
    }

    @Override
    public BigDecimal getTotalVolume() {
        return null;
    }
}
