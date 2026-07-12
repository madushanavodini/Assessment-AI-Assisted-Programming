import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

class Library {

    private final List<Book> books = new ArrayList<>();
    private final List<Member> members = new ArrayList<>();

    /** @throws IllegalArgumentException if a book with the same ID already exists. */
    public void addBook(Book book) {
        for (Book existing : books) {
            if (existing.getBookId().equalsIgnoreCase(book.getBookId())) {
                throw new IllegalArgumentException("A book with ID " + book.getBookId() + " already exists.");
            }
        }
        books.add(book);
    }

    /** @throws IllegalArgumentException if a member with the same membership ID already exists. */
    public void addMember(Member member) {
        for (Member existing : members) {
            if (existing.getMembershipId().equalsIgnoreCase(member.getMembershipId())) {
                throw new IllegalArgumentException("A member with ID " + member.getMembershipId() + " already exists.");
            }
        }
        members.add(member);
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void displayAllBooks() {
        System.out.println("--- Available Books in Library ---");
        boolean any = false;
        for (Book book : books) {
            if (book.isAvailable()) {
                book.displayDetails();
                System.out.println("-----------------------------------");
                any = true;
            }
        }
        if (!any) {
            System.out.println("No available books at the moment.");
        }
    }

    public void displayAllMembers() {
        System.out.println("--- Registered Members ---");
        if (members.isEmpty()) {
            System.out.println("No members registered yet.");
            return;
        }
        for (Member member : members) {
            member.displayDetails();
            System.out.println("-----------------------------------");
        }
    }

    /**
     * @throws NoSuchElementException if no book with that title exists.
     * @throws IllegalStateException  if the book is already borrowed.
     */
    public void borrowBook(String title) {
        Book book = findByTitle(title);
        book.markAsBorrowed();
    }

    /**
     * @throws NoSuchElementException if no book with that title exists.
     * @throws IllegalStateException  if the book was never borrowed.
     */
    public void returnBook(String title) {
        Book book = findByTitle(title);
        book.markAsReturned();
    }

    private Book findByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        throw new NoSuchElementException("No book found with title \"" + title + "\".");
    }

    /** @throws IllegalArgumentException if the category is blank. */
    public List<Book> searchByCategory(String category) {
        if (category == null || category.trim().isEmpty()) {
            throw new IllegalArgumentException("Category cannot be empty.");
        }
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getCategory().equalsIgnoreCase(category)) {
                results.add(book);
            }
        }
        return results;
    }

    /** @throws IllegalArgumentException if the author name is blank. */
    public List<Book> searchByAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Author cannot be empty.");
        }
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                results.add(book);
            }
        }
        return results;
    }
}
