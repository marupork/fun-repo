package com.sample.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Phone {

    private final boolean mobile;
    private final String number;

    public Phone(String number, boolean mobile) {
        this.number = number;
        this.mobile = mobile;
    }

    /*public Phone(String number) {
        this.number = number;
        this.mobile = number.startsWith("+") && number.endsWith("9");
    }*/

    public boolean isMobile() {
        return mobile;
    }
}

class PhoneClient {

    private final List<Phone> phones = new ArrayList<Phone>();

    public void addPhone(Phone phone) {
        phones.add(phone);
    }

    public boolean hasMobile() {
        for (Phone phone : phones) {
            if (phone.isMobile()) {
                return true;
            }
        }

        return false;
    }
}
