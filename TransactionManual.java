import java.time.LocalDate;

class TransactionManual {
    private String bookId;
    private String membershipId;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;

    public TransactionManual(String bookId, String membershipId) {
        this.bookId = bookId;
        this.membershipId = membershipId;
        this.borrowDate = LocalDate.now();
        this.dueDate = borrowDate.plusDays(14);
    }

    public void markReturned() {
        this.returnDate = LocalDate.now();
    }

    public String getBookId() {
        return bookId;
    }

    public boolean isActive() {
        return returnDate == null;
    }

    public boolean isOverdue() {
        return returnDate == null && LocalDate.now().isAfter(dueDate);
    }

    public long getDaysOverdue() {
        if (!isOverdue()) return 0;
        return java.time.temporal.ChronoUnit.DAYS.between(dueDate, LocalDate.now());
    }
}