package com.example.payments;

import java.util.Objects;

// wraps SafeCashClient behind the common PaymentGateway interface
// SafeCash has a two-step flow (create payment -> confirm) which we hide here
public class SafeCashAdapter implements PaymentGateway {

    private final SafeCashClient client;

    public SafeCashAdapter(SafeCashClient client) {
        this.client = Objects.requireNonNull(client, "SafeCashClient cannot be null");
    }

    @Override
    public String charge(String customerId, int amountCents) {
        // SafeCash takes (amount, user) instead of (user, amount), and needs a confirm step
        SafeCashPayment payment = client.createPayment(amountCents, customerId);
        return payment.confirm();
    }
}

