import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BankAccount {
    private static final Logger logger = LogManager.getLogger(BankAccount.class);
    private double balance;

    public void deposit(double amount) {
        logger.trace("Entering deposit() with amount={}", amount); [cite: 82]
        if (amount < 0) {
            logger.warn("Invalid input: amount {} is negative", amount); [cite: 84]
            return;
        }
        logger.debug("Balance before deposit: {}", balance); [cite: 87]
        balance += amount;
        logger.info("Deposited {}. New balance={}", amount, balance); [cite: 89]
        logger.trace("Exiting deposit()"); [cite: 90]
    }

    public void withdraw(double amount) {
        logger.trace("Entering withdraw() with amount={}", amount); [cite: 71]
        if (amount < 0) {
            logger.warn("Invalid input: negative withdrawal amount={}", amount); [cite: 74]
            return;
        }
        if (amount > balance) {
            logger.error("Insufficient funds! Balance: {}, Requested: {}", balance, amount); [cite: 75]
            return;
        }
        logger.debug("Balance before withdrawal: {}", balance); [cite: 72]
        balance -= amount;
        logger.info("Successfully withdrew {}. Remaining balance: {}", amount, balance); [cite: 73]
        logger.trace("Exiting withdraw()"); [cite: 71]
    }

    public double getBalance() {
        logger.trace("Entering getBalance()"); [cite: 71]
        logger.debug("Current balance requested: {}", balance); [cite: 72]
        return balance;
    }
    
    public static void triggerFatal() {
        // Example of a critical system condition [cite: 76]
        logger.fatal("CRITICAL: Application configuration file missing or corrupted!"); [cite: 157]
    }
}
