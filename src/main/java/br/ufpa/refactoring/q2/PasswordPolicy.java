package br.ufpa.refactoring.q2;

// Q2 - Inline Method
// as checagens pequenas foram para dentro do isValid
public class PasswordPolicy {

    public boolean isValid(String password) {
        return password != null
                && password.length() >= 10
                && password.chars().anyMatch(Character::isUpperCase)
                && password.chars().anyMatch(Character::isDigit)
                && !password.contains(" ");
    }
}
