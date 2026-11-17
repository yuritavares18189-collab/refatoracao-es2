package br.ufpa.refactoring.q9;

// Q9 - Move Method
// a conta do desconto foi para o Customer. o pedido so usa o resultado
public class Order {

    private final Customer customer;
    private final double total;
    private final double discountRate;

    public Order(Customer customer, double total, double discountRate) {
        this.customer = customer;
        this.total = total;
        this.discountRate = discountRate;
    }

    public double finalTotal() {
        return Math.max(0.0, total - customer.discount(total, discountRate));
    }

    public record Customer(boolean vip, int yearsAsCustomer) {
        public boolean isVip() { return vip; }

        public double discount(double total, double discountRate) {
            double discount = total * discountRate;
            if (isVip()) discount += 25.0;
            if (yearsAsCustomer() >= 5) discount += 15.0;
            return discount;
        }
    }
}
