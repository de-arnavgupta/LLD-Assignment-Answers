import java.util.*;

public class CafeteriaSystem {
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private int invoiceSeq = 1000;

    public void addToMenu(MenuItem i) { menu.put(i.id, i); }

    public void checkout(TaxCalculator taxCalc, DiscountCalculator discountCalc,
                         InvoiceStore store, List<OrderLine> lines) {

        String invId = "INV-" + (++invoiceSeq);

        PriceCalculator pricer = new PriceCalculator(menu);
        double subtotal = pricer.subtotal(lines);

        double taxPct = taxCalc.taxPercent();
        double tax = subtotal * (taxPct / 100.0);

        double discount = discountCalc.discountAmount(subtotal, lines.size());

        double total = subtotal + tax - discount;

        InvoiceFormatter formatter = new InvoiceFormatter();
        String printable = formatter.format(invId, lines, pricer, subtotal, taxPct, tax, discount, total);

        System.out.print(printable);

        store.save(invId, printable);
        System.out.println("Saved invoice: " + invId + " (lines=" + store.countLines(invId) + ")");
    }
}
