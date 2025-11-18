public class BankAccountTest {
    public static void main(String[] args) {
        BankAccountTest test = new BankAccountTest();
        test.testDeposit();
        test.testWithdraw();
        test.testWithdrawMoreThanBalance();
        test.testNegativeDeposit();
        test.testInitialBalance();
        test.testAccountNumber();
        System.out.println("All tests completed.");
    }

    void testDeposit() {
        try {
            BankAccount acc = new BankAccount("A101", 1000);
            acc.deposit(500);
            System.out.println(acc.getBalance() == 1500 ? "testDeposit PASSED" : "testDeposit FAILED");
        } catch (Exception e) {
            System.out.println("testDeposit FAILED: " + e.getMessage());
        }
    }

    void testWithdraw() {
        try {
            BankAccount acc = new BankAccount("A102", 1000);
            acc.withdraw(400);
            System.out.println(acc.getBalance() == 600 ? "testWithdraw PASSED" : "testWithdraw FAILED");
        } catch (Exception e) {
            System.out.println("testWithdraw FAILED: " + e.getMessage());
        }
    }

    void testWithdrawMoreThanBalance() {
        try {
            BankAccount acc = new BankAccount("A103", 500);
            acc.withdraw(800);
            System.out.println("testWithdrawMoreThanBalance FAILED");
        } catch (IllegalArgumentException e) {
            System.out.println("Insufficient balance.".equals(e.getMessage()) ? "testWithdrawMoreThanBalance PASSED"
                    : "testWithdrawMoreThanBalance FAILED: " + e.getMessage());
        }
    }

    void testNegativeDeposit() {
        try {
            BankAccount acc = new BankAccount("A104", 200);
            acc.deposit(-100);
            System.out.println("testNegativeDeposit FAILED");
        } catch (IllegalArgumentException e) {
            System.out.println("Deposit amount must be positive.".equals(e.getMessage()) ? "testNegativeDeposit PASSED"
                    : "testNegativeDeposit FAILED: " + e.getMessage());
        }
    }

    void testInitialBalance() {
        try {
            BankAccount acc = new BankAccount("A105", -100);
            System.out.println("testInitialBalance FAILED");
        } catch (IllegalArgumentException e) {
            System.out
                    .println("Initial balance cannot be negative.".equals(e.getMessage()) ? "testInitialBalance PASSED"
                            : "testInitialBalance FAILED: " + e.getMessage());
        }
    }

    void testAccountNumber() {
        BankAccount acc = new BankAccount("A106", 500);
        System.out.println(
                "A106".equals(acc.getAccountNumber()) ? "testAccountNumber PASSED" : "testAccountNumber FAILED");
    }
}
