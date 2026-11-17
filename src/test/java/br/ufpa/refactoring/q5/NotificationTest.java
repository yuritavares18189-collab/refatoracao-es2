package br.ufpa.refactoring.q5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotificationTest {

    @Test
    void render_shouldContainSubjectAndBody() {
        Notification n = new PasswordResetNotification("Joelma");
        String r = n.render();

        assertTrue(r.contains("Redefinição de senha"));
        assertTrue(r.contains("Olá Joelma"));
    }

    @Test
    void refactorGoal_collapseHierarchy_removeRedundantSubclass() {
        // VIPPasswordResetNotification foi removida porque nao mudava o texto.
        // o teste de cima usa direto PasswordResetNotification.
    }
}
