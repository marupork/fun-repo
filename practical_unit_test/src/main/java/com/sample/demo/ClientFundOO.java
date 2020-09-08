package com.sample.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ClientFundOO {

    private List<IFundOO> funds = new ArrayList<>();

    void addFund(IFundOO fund) {
        funds.add(fund);
    }


    public BigDecimal getValueOfAllFunds() {
        BigDecimal value = BigDecimal.ZERO;
        for (IFundOO f : funds) {
            value = value.add(f.getValue());
        }
        return value;
    }
}

interface IFundOO {
    BigDecimal getValue();
}
