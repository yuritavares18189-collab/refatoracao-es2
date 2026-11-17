package br.ufpa.refactoring.q8;

class ContactInfo {

    private final String name;
    private final String email;
    private final String phone;

    ContactInfo(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    boolean isValid() {
        if (name == null || name.isBlank()) return false;
        if (email == null || !email.contains("@")) return false;
        return phone != null && phone.length() >= 10;
    }

    String formatted() {
        return name + " | " + email + " | " + phone;
    }
}
