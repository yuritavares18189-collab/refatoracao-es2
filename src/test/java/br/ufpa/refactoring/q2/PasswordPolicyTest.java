package br.ufpa.refactoring.q2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordPolicyTest {

    @Test
    void validPassword_examples() {
        PasswordPolicy policy = new PasswordPolicy();
        assertTrue(policy.isValid("SenhaForte1"));
    }

    @Test
    void invalidPassword_examples() {
        PasswordPolicy policy = new PasswordPolicy();
        assertFalse(policy.isValid("curta1A"));       // < 10
        assertFalse(policy.isValid("senhaforte1"));   // sem maiúscula
        assertFalse(policy.isValid("SenhaForteX"));   // sem dígito
        assertFalse(policy.isValid("Senha Forte1"));  // espaço
    }

    @Test
    void refactorGoal_inlineSomeHelpers() {
        // TODO: após refatorar, alguns helpers devem sumir (inline)
        // Este teste não verifica estrutura, só comportamento.
    }
}
