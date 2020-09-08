package com.sample.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ClientFund {
    private List<IFund> funds = new ArrayList<>();

    void addFund(IFund fund) {
        funds.add(fund);
    }

    // "Tell, Don’t Ask!" has been broken, because Client asks for data instead of telling others to give him results
    // "Law of Demeter" has been broken, because Client talks with friends of his friends
    // (i.e. with registers and current value, both of which are accessed as friends of funds).
    public BigDecimal getValueOfAllFunds() {
        BigDecimal value = BigDecimal.ZERO;
        for (IFund f : funds) {
            value = value.add(f.getCurrentValue().getValue().multiply(
                    new BigDecimal(
                            f.getRegisterX().getNbOfUnits()
                                    + f.getRegisterY().getNbOfUnits()
                    )
            ));
        }
        return value;
    }

}

interface IFund {
    ICurrentValue getCurrentValue();
    IRegister getRegisterX();
    IRegister getRegisterY();
}

interface ICurrentValue {
    BigDecimal getValue();
}

interface IRegister {
    Integer getNbOfUnits();
}
