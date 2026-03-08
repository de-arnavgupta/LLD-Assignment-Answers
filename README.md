# LLD Assignment — Design Pattern & SOLID Solutions

Solutions for the SOLID refactoring exercises and design pattern exercises from SST28-LLD101.

## SOLID Exercises

| Exercise | Principle | Topic |
|----------|-----------|-------|
| Ex1 | SRP | Student Onboarding — split parsing, validation, printing, storage into separate classes |
| Ex2 | SRP | Cafeteria Billing — extracted tax, discount, pricing, formatting behind interfaces |
| Ex3 | OCP | Placement Eligibility — replaced if-else chain with a list of rule objects |
| Ex4 | OCP | Hostel Fee Calculator — replaced switch-case with a pricing registry |
| Ex5 | LSP | File Exporter — made all exporters return error results instead of throwing |
| Ex6 | LSP | Notification Sender — made all senders return SendResult instead of throwing |
| Ex7 | ISP | Smart Classroom — split fat interface into focused ones per device type |
| Ex8 | ISP | Club Console — split monolithic admin tool into role-specific interfaces |
| Ex9 | DIP | Evaluation Pipeline — injected grader, plagiarism checker, report writer via interfaces |
| Ex10 | DIP | Transport Booking — injected distance calc, fare calc, driver alloc, payment via interfaces |

## Design Pattern Exercises

| Exercise | Pattern | Topic |
|----------|---------|-------|
| singleton-metrics | Singleton | Metrics Registry — thread-safe singleton with lazy init |
| immutable-tickets | Immutable | Incident Tickets — made ticket objects fully immutable |
| adapter-payments | Adapter | Payment Gateway — adapters for mismatched payment SDKs |
| flyweight-markers | Flyweight | Map Markers — shared immutable styles via factory cache |
| proxy-reports | Proxy | Campus Reports — access control + lazy loading + caching via proxy |

## How to Run

SOLID exercises are in `SOLID/ExN/src/`. Design pattern exercises are in their own folders.

```bash
# SOLID example
cd SOLID/Ex1/src
javac *.java
java Main

# Design pattern example
cd adapter-payments/src
javac com/example/payments/*.java
java com.example.payments.App
```

Requires Java 17+. No build tools needed.

## Author

Arnav Gupta

