package br.ufpa.refactoring.q7;

public class SupportChat {

    public String greeting(User user) {
        if (user == null) {
            return new Visitante().saudacao();
        }
        if (user.isBanned()) return "Conta bloqueada. Contate o suporte.";
        if (user.name() == null || user.name().isBlank()) return "Olá! Como posso ajudar?";
        return "Olá, " + user.name() + "! Como posso ajudar?";
    }

    static class Visitante {
        String saudacao() {
            return "Olá! Quer continuar como visitante?";
        }
    }

    public record User(String name, boolean banned) {
        public boolean isBanned() { return banned; }
    }
}
