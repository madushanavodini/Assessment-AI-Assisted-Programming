/**
 * Represents an advanced Book model in the Library Management System.
 * Refactored and optimized for production environments.
 * Generated/Assisted by AI Assistant.
 */
public class BookAI {
    private final String isbn;
    private final String title;
    private final String author;
    private final String genre;
    private boolean isAvailable;

    /**
     * Constructs a new Book instance with strict edge-case validation.
     *
     * @param isbn        Unique book identification key
     * @param title       Title of the publication
     * @param author      Author name strings
     * @param genre       Category/Genre of fiction/non-fiction
     * @param isAvailable Initial availability flag state
     */
    public BookAI(String isbn, String title, String author, String genre, boolean isAvailable) {
        if (isbn == null || isbn.trim().isEmpty()) throw new IllegalArgumentException("ISBN cannot be null or empty.");
        if (title == null || title.trim().isEmpty()) throw new IllegalArgumentException("Title cannot be null or empty.");
        if (author == null || author.trim().isEmpty()) throw new IllegalArgumentException("Author cannot be null or empty.");
        if (genre == null || genre.trim().isEmpty()) throw new IllegalArgumentException("Genre cannot be null or empty.");

        this.isbn = isbn.trim();
        this.title = title.trim();
        this.author = author.trim();
        this.genre = genre.trim();
        this.isAvailable = isAvailable;
    }

    // Thread-safe transaction logic
    public synchronized boolean borrowBook() {
        if (this.isAvailable) {
            this.isAvailable = false;
            return true;
        }
        return false;
    }

    // Clean operational state display method
    public void displayBookDetails() {
        System.out.println("----------------------------------------");
        System.out.println("           BOOK SYSTEM METRICS          ");
        System.out.println("----------------------------------------");
        System.out.println("ISBN        : " + this.isbn);
        System.out.println("Title       : " + this.title);
        System.out.println("Author      : " + this.author);
        System.out.println("Genre       : " + this.genre);
        System.out.println("Available   : " + (this.isAvailable ? "Yes" : "No"));
        System.out.println("----------------------------------------");
    }

    // Getters
    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
    public synchronized boolean isAvailable() { return isAvailable; }
}
