package br.ufpa.refactoring.q1;

import java.time.LocalDate;
import java.util.List;

// Q1 - Extract Method
// separei o e-mail em pedacos: saudacao, itens, frete, desconto, totais e endereco
public class PurchaseEmailService {

    public String buildEmail(Purchase purchase) {
        StringBuilder sb = new StringBuilder();
        appendGreeting(sb, purchase);
        double subtotal = appendItems(sb, purchase);
        double shipping = shippingCost(purchase);
        double discount = discount(purchase, subtotal);
        appendTotals(sb, subtotal, shipping, discount);
        appendAddress(sb, purchase.address());
        sb.append("Obrigado por comprar com a gente!\n");
        return sb.toString();
    }

    private void appendGreeting(StringBuilder sb, Purchase purchase) {
        sb.append("Olá, ").append(purchase.customerName()).append("!\n\n");
        sb.append("Seu pedido #").append(purchase.id()).append(" foi confirmado em ")
          .append(LocalDate.now()).append(".\n\n");
    }

    private double appendItems(StringBuilder sb, Purchase purchase) {
        sb.append("Itens:\n");
        double subtotal = 0.0;
        for (PurchaseItem item : purchase.items()) {
            double line = lineTotal(item);
            subtotal += line;
            sb.append("- ").append(item.name())
              .append(" (").append(item.quantity()).append("x) : R$ ")
              .append(money(line)).append("\n");
        }
        return subtotal;
    }

    private double lineTotal(PurchaseItem item) {
        return item.unitPrice() * item.quantity();
    }

    private double shippingCost(Purchase purchase) {
        return purchase.isExpress() ? 29.90 : 14.90;
    }

    private double discount(Purchase purchase, double subtotal) {
        double discount = 0.0;
        if (subtotal >= 300.0) discount = subtotal * 0.10;
        if (purchase.coupon() != null && purchase.coupon().startsWith("VIP"))
            discount += 20.0;
        return discount;
    }

    private void appendTotals(StringBuilder sb, double subtotal, double shipping, double discount) {
        double total = subtotal + shipping - discount;
        sb.append("\nSubtotal: R$ ").append(money(subtotal)).append("\n");
        sb.append("Frete: R$ ").append(money(shipping)).append("\n");
        sb.append("Descontos: R$ ").append(money(discount)).append("\n");
        sb.append("TOTAL: R$ ").append(money(total)).append("\n\n");
    }

    private void appendAddress(StringBuilder sb, Address address) {
        sb.append("Endereço de entrega:\n");
        sb.append(address.street()).append(", ").append(address.number()).append("\n");
        sb.append(address.city()).append(" - ").append(address.zip()).append("\n\n");
    }

    private String money(double value) {
        return String.format("%.2f", value);
    }

    public record Purchase(String id, String customerName, List<PurchaseItem> items,
                           boolean isExpress, String coupon, Address address) {}

    public record PurchaseItem(String name, int quantity, double unitPrice) {}

    public record Address(String street, String number, String city, String zip) {}
}
