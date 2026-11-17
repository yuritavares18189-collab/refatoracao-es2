package br.ufpa.refactoring.q5;

public class PasswordResetNotification extends Notification {
    private final String customerName;
    public PasswordResetNotification(String customerName) { this.customerName = customerName; }

    @Override public String subject() { return "Redefinição de senha"; }
    @Override public String body() { return "Olá " + customerName + ", clique no link para redefinir."; }
}
