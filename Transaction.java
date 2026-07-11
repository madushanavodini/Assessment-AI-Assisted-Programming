import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class Transaction {
    private final String bookId;
    private final String membershipId;
    private final LocalDate borrowDate;
    private final LocalDate dueDate;
    private LocalDate returnDate;

    public Transaction(String bookId, String membershipId) {
        if (bookId == null || bookId.trim().isEmpty()) {
            throw new IllegalArgumentException("Book ID cannot be empty.");
        }
        if (membershipId == null || membershipId.trim().isEmpty()) {
            throw new IllegalArgumentException("Membership ID cannot be empty.");
        }

        this.bookId = bookId;
        this.membershipId = membershipId;
        this.borrowDate = LocalDate.now();
        this.dueDate = borrowDate.plusDays(14);
    }

    /** @throws IllegalStateException if the transaction was already closed. */
    public void markReturned() {
        if (returnDate != null) {
            throw new IllegalStateException("Transaction for book " + bookId + " is already closed.");
        }
        this.returnDate = LocalDate.now();
    }

    public String getBookId() {
        return bookId;
    }

    public String getMembershipId() {
        return membershipId;
    }

    public boolean isActive() {
        return returnDate == null;
    }

    public boolean isOverdue() {
        return returnDate == null && LocalDate.now().isAfter(dueDate);
    }

    public long getDaysOverdue() {
        if (!isOverdue()) return 0;
        return ChronoUnit.DAYS.between(dueDate, LocalDate.now());
    }
}
