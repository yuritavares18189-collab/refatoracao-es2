package br.ufpa.refactoring.q5;

// Q5 - Collapse Hierarchy
// a subclasse VIP so chamava o super e nao mudava nada, entao ela saiu
public class PasswordResetNotification extends Notification {
    private final String customerName;
    public PasswordResetNotification(String customerName) { this.customerName = customerName; }

    @Override public String subject() { return "Redefinição de senha"; }
    @Override public String body() { return "Olá " + customerName + ", clique no link para redefinir."; }
}
