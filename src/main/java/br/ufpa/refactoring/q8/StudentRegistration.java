package br.ufpa.refactoring.q8;

public class StudentRegistration {

    private final ContactInfo contact;
    private final Address address;

    public StudentRegistration(String name, String email, String phone, String city, String zip) {
        this.contact = new ContactInfo(name, email, phone);
        this.address = new Address(city, zip);
    }

    public boolean isValid() {
        return contact.isValid() && address.isValid();
    }

    public String formattedContact() {
        return contact.formatted() + " | " + address.formatted();
    }
}
