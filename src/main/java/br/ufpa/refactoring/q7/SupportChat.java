package br.ufpa.refactoring.q7;

// Q7 - Introduce Null Object
// quando o usuario vem null, uso um visitante em vez de espalhar if (user == null)
public class SupportChat {

    public String greeting(User user) {
        if (user == null) {
            return new Visitante().saudacao();
        }
        if (user.isBanned()) return "Conta bloqueada. Contate o suporte.";
        if (user.name() == null || user.name().isBlank()) return "Olá! Como posso ajudar?";
        return "Olá, " + user.name() + "! Como posso ajudar?";
    }

    // objeto que representa a ausencia de usuario
    static class Visitante {
        String saudacao() {
            return "Olá! Quer continuar como visitante?";
        }
    }

    public record User(String name, boolean banned) {
        public boolean isBanned() { return banned; }
    }
}
