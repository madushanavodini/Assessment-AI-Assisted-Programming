class Fine {
    private static final double RATE_PER_DAY = 10.0;

    public static double calculate(Transaction transaction) {
        if (transaction == null) {
            throw new IllegalArgumentException("Transaction cannot be null.");
        }
        return transaction.getDaysOverdue() * RATE_PER_DAY;
    }
}
