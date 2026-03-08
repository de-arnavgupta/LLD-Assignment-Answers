package com.example.payments;

import java.util.Objects;

// adapter for SafeCash SDK — it has a weird two-step create+confirm flow
public class SafeCashAdapter implements PaymentGateway {

    private final SafeCashClient client;

    public SafeCashAdapter(SafeCashClient client) {
        this.client = Objects.requireNonNull(client, "SafeCashClient cannot be null");
    }

    @Override
    public String charge(String customerId, int amountCents) {
        // note: SafeCash takes args in (amount, user) order, not (user, amount)
        SafeCashPayment payment = client.createPayment(amountCents, customerId);
        return payment.confirm();
    }
}



