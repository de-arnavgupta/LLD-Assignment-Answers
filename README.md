# LLD Assignment — SOLID Refactoring Solutions

Solutions for the first 6 SOLID refactoring exercises from SST28-LLD101.

## Exercises Solved

| Exercise | Principle | Topic |
|----------|-----------|-------|
| Ex1 | SRP | Student Onboarding — split parsing, validation, printing, storage into separate classes |
| Ex2 | SRP | Cafeteria Billing — extracted tax, discount, pricing, formatting behind interfaces |
| Ex3 | OCP | Placement Eligibility — replaced if-else chain with a list of rule objects |
| Ex4 | OCP | Hostel Fee Calculator — replaced switch-case with a pricing registry |
| Ex5 | LSP | File Exporter — made all exporters return error results instead of throwing |
| Ex6 | LSP | Notification Sender — made all senders return SendResult instead of throwing |

## How to Run

Each exercise is in `SOLID/ExN/src/`. To compile and run:

```bash
cd SOLID/Ex1/src
javac *.java
java Main
```

Requires Java 17+. No build tools needed.

## Author

Arnav Gupta

