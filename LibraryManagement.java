import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LibraryManagement {
    public static void main(String[] args) {
        Library cityLibrary = new Library();
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("\n1. Add Member");
            System.out.println("2. Add Book");
            System.out.println("3. Display all Books");
            System.out.println("4. Display all Members");
            System.out.println("5. Borrow Book");
            System.out.println("6. Return Book");
            System.out.println("7. Search by Category");
            System.out.println("8. Search by Author");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            // Guard against non-numeric menu input so the program doesn't crash.
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input: please enter a number from 1-9.");
                sc.nextLine(); // discard the bad token
                continue;
            }
            sc.nextLine(); // clear leftover newline

            try {
                switch (choice) {
                    case 1 -> {
                        System.out.println("Membership ID:");
                        String membershipId = sc.nextLine();
                        System.out.println("Member Name:");
                        String name = sc.nextLine();
                        System.out.println("Email:");
                        String email = sc.nextLine();
                        System.out.println("Tel:");
                        String tel = sc.nextLine();
                        System.out.println("Membership Type:");
                        String membershipType = sc.nextLine();

                        cityLibrary.addMember(new Member(membershipId, name, email, tel, membershipType));
                        System.out.println("Member added successfully.");
                    }
                    case 2 -> {
                        System.out.println("Book ID:");
                        String bookId = sc.nextLine();
                        System.out.println("Title:");
                        String title = sc.nextLine();
                        System.out.println("Author:");
                        String author = sc.nextLine();
                        System.out.println("Category:");
                        String category = sc.nextLine();
                        System.out.println("Enter availability (Available/Not Available):");
                        String availability = sc.nextLine();

                        cityLibrary.addBook(new Book(bookId, title, author, category, availability));
                        System.out.println("Book added successfully.");
                    }
                    case 3 -> cityLibrary.displayAllBooks();
                    case 4 -> cityLibrary.displayAllMembers();
                    case 5 -> {
                        System.out.println("Enter the book title to borrow:");
                        String searchBook = sc.nextLine();
                        cityLibrary.borrowBook(searchBook);
                        System.out.println(searchBook + " has been successfully borrowed.");
                    }
                    case 6 -> {
                        System.out.println("Enter the book title to return:");
                        String returnBook = sc.nextLine();
                        cityLibrary.returnBook(returnBook);
                        System.out.println(returnBook + " has been successfully returned.");
                    }
                    case 7 -> {
                        System.out.println("What category are you searching for?");
                        System.out.println("1.Fiction 2.Science 3.Novels 4.History 5.Biography");
                        System.out.println("6.Education 7.Literature 8.Law 9.Psychology 10.Business");
                        String searchCategory = sc.nextLine();

                        List<Book> results = cityLibrary.searchByCategory(searchCategory);
                        if (results.isEmpty()) {
                            System.out.println("No books found in category: " + searchCategory);
                        } else {
                            for (Book book : results) {
                                System.out.println(book.getTitle());
                            }
                        }
                    }
                    case 8 -> {
                        System.out.println("Which author are you searching for?");
                        String searchAuthor = sc.nextLine();

                        List<Book> results = cityLibrary.searchByAuthor(searchAuthor);
                        if (results.isEmpty()) {
                            System.out.println("No books found for author: " + searchAuthor);
                        } else {
                            for (Book book : results) {
                                System.out.println(book.getTitle());
                            }
                        }
                    }
                    case 9 -> System.out.println("Exiting... Goodbye!");
                    default -> System.out.println("Invalid choice, please try again.");
                }
            } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException e) {
                // Covers blank/invalid fields, duplicate IDs, book not found, and
                // borrow/return on a book in the wrong state.
                System.out.println("Error: " + e.getMessage());
            } catch (RuntimeException e) {
                // Safety net for anything unexpected, so one bad action never kills the whole program.
                System.out.println("Unexpected error: " + e.getMessage());
            }

        } while (choice != 9);

        sc.close();
    }
}
