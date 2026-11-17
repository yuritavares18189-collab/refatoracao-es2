package br.ufpa.refactoring.q8;

import java.util.regex.Pattern;

class Address {

    private final String city;
    private final String zip;

    Address(String city, String zip) {
        this.city = city;
        this.zip = zip;
    }

    boolean isValid() {
        return zip != null && Pattern.matches("\\d{5}-\\d{3}", zip);
    }

    String formatted() {
        return city + " - " + zip;
    }
}
