package br.ufpa.refactoring.q2;

public class PasswordPolicy {

    public boolean isValid(String password) {
        return password != null
                && password.length() >= 10
                && password.chars().anyMatch(Character::isUpperCase)
                && password.chars().anyMatch(Character::isDigit)
                && !password.contains(" ");
    }
}
