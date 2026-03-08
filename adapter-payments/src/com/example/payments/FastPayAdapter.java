package com.example.payments;

import java.util.Objects;

// wraps FastPayClient behind the common PaymentGateway interface
// so OrderService doesn't need to know about FastPay's specific API
public class FastPayAdapter implements PaymentGateway {

    private final FastPayClient client;

    public FastPayAdapter(FastPayClient client) {
        this.client = Objects.requireNonNull(client, "FastPayClient cannot be null");
    }

    @Override
    public String charge(String customerId, int amountCents) {
        // delegate to FastPay's own method signature
        return client.payNow(customerId, amountCents);
    }
}

