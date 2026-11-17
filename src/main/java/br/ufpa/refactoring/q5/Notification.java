package br.ufpa.refactoring.q5;

import java.time.LocalDate;

public abstract class Notification {
    public abstract String subject();
    public abstract String body();
    public String render() {
        return "[" + LocalDate.now() + "] " + subject() + "\n" + body();
    }
}
