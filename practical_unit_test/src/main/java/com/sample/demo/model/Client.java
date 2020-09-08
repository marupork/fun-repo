package com.sample.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Client {

    private List<Address> addressList;

    void addAddress(Address address) {
        if(addressList == null) {
            addressList = new ArrayList<>();
        }

        addressList.add(address);
    }

    public List<Address> getAddressList() {
        return addressList;
    }
}

class Address {
    private String location;

    public Address(String location) {
        this.location = location;
    }
}