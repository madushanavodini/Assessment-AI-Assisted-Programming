class Book {
    private final String bookId;
    private final String title;
    private final String author;
    private final String category;
    private String availability;

    public Book(String bookId, String title, String author, String category, String availability) {
        if (isBlank(bookId)) {
            throw new IllegalArgumentException("Book ID cannot be empty.");
        }
        if (isBlank(title)) {
            throw new IllegalArgumentException("Book title cannot be empty.");
        }
        if (isBlank(author)) {
            throw new IllegalArgumentException("Book author cannot be empty.");
        }
        if (isBlank(availability)) {
            throw new IllegalArgumentException("Book availability cannot be empty.");
        }

        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.category = category;
        this.availability = availability;
    }

    private static boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public String getAvailability() {
        return availability;
    }

    public boolean isAvailable() {
        return "Available".equalsIgnoreCase(availability);
    }

    /** @throws IllegalStateException if the book is already borrowed. */
    public void markAsBorrowed() {
        if (!isAvailable()) {
            throw new IllegalStateException("\"" + title + "\" is already borrowed.");
        }
        this.availability = "Borrowed";
    }

    /** @throws IllegalStateException if the book was never borrowed in the first place. */
    public void markAsReturned() {
        if (isAvailable()) {
            throw new IllegalStateException("\"" + title + "\" was not marked as borrowed.");
        }
        this.availability = "Available";
    }

    public void displayDetails() {
        System.out.println("Book ID    : " + bookId);
        System.out.println("Title      : " + title);
        System.out.println("Author     : " + author);
        System.out.println("Category   : " + category);
        System.out.println("Availability: " + availability);
    }

    @Override
    public String toString() {
        return String.format("[%s] %s by %s (%s) - %s", bookId, title, author, category, availability);
    }
}
