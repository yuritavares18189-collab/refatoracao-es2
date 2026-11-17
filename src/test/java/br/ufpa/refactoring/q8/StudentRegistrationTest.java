package br.ufpa.refactoring.q8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentRegistrationTest {

    @Test
    void validity_examples() {
        StudentRegistration ok = new StudentRegistration("Juremilda", "n@x.com", "9199999999", "Belém", "66000-000");
        assertTrue(ok.isValid());

        StudentRegistration badZip = new StudentRegistration("Juremilda", "n@x.com", "9199999999", "Belém", "66000000");
        assertFalse(badZip.isValid());
    }

    @Test
    void formattedContact_example() {
        StudentRegistration s = new StudentRegistration("Max", "v@ufpa.br", "91988887777", "Belém", "66000-000");
        assertEquals("Max | v@ufpa.br | 91988887777 | Belém - 66000-000", s.formattedContact());
    }

    @Test
    void refactorGoal_extractClass_contactAndAddress() {
        // TODO: extrair ContactInfo/Address e mover validações/format mantendo testes.
    }
}
