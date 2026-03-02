// stuff the treasurer can do
public interface FinanceOps extends ClubAdminTools {
    void addIncome(double amt, String note);
    void addExpense(double amt, String note);
}

