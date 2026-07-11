class Fine {
    private static final double RATE_PER_DAY = 10.0;

    public static double calculate(TransactionManual t) {
        return t.getDaysOverdue() * RATE_PER_DAY;
    }
}