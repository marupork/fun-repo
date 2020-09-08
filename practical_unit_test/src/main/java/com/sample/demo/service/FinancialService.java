package com.sample.demo.service;

import java.math.BigDecimal;

public class FinancialService {

    private ClientDao clientDAO;
    private Calculator calculator;

    public BigDecimal calculateBonus(long clientId, BigDecimal payment) { // direct input
        Short clientType = clientDAO.getClientType(clientId); // indirect inputs and indirect outputs

        BigDecimal bonus = calculator.calculateBonus(clientType, payment); // indirect inputs and indirect outputs

        clientDAO.saveBonusHistory(clientId, bonus);
        return bonus; // direct output
    }
}

interface ClientDao {
    Short getClientType(long clientId);
    void saveBonusHistory(long clientId, BigDecimal bonus);
}

interface Calculator {
    BigDecimal calculateBonus(Short clientType, BigDecimal payment);
}

