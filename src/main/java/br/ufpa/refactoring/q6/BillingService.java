package br.ufpa.refactoring.q6;

public class BillingService {

    public enum Plan {
        FREE {
            @Override
            double calcular(int usuarios, boolean suportePrioritario) {
                return 0.0;
            }
        },
        STUDENT {
            @Override
            double calcular(int usuarios, boolean suportePrioritario) {
                double preco = 19.90;
                if (suportePrioritario) preco += 59.90;
                return preco;
            }
        },
        PRO {
            @Override
            double calcular(int usuarios, boolean suportePrioritario) {
                double preco = 49.90 + (usuarios * 1.25);
                if (suportePrioritario) preco += 59.90;
                if (usuarios > 200) preco *= 0.95;
                return preco;
            }
        },
        ENTERPRISE {
            @Override
            double calcular(int usuarios, boolean suportePrioritario) {
                double preco = 199.90 + (usuarios * 0.90);
                if (suportePrioritario) preco += 59.90;
                return preco;
            }
        };

        abstract double calcular(int usuarios, boolean suportePrioritario);
    }

    public double monthlyPrice(Plan plan, int activeUsers, boolean prioritySupport) {
        double price = plan.calcular(activeUsers, prioritySupport);
        return Math.round(price * 100.0) / 100.0;
    }
}
