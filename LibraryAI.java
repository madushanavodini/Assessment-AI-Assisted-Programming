/**
 * Main execution driver utilizing the fully integrated AI-optimized Book design.
 * Generated/Assisted by AI Assistant.
 */
public class LibraryAI {

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("  Library Management System   ");
        System.out.println("=================================================\n");

        try {
            System.out.println("[SYSTEM] Initializing object creation pipeline...");

            // Instantiation parameters now match the target constructor signature exactly
            BookAI book1 = new BookAI("S234", "Sherlock Holmes", "Arthur Conan Doyle", "Detective Fiction", true);
            System.out.println("[SUCCESS] Book initialized successfully into memory storage.\n");

            System.out.println("--- Starting Transaction Simulation ---");

            // Executing functional application transactional behavior
            boolean checkoutSuccess = book1.borrowBook();
            if (checkoutSuccess) {
                System.out.println("[TRANSACTION] Book status flipped to borrowed.");
            } else {
                System.out.println("[WARN] Transaction halted: Book is already unavailable.");
            }

            System.out.println("\n--- Presenting Current System State ---");
            book1.displayBookDetails();

        } catch (IllegalArgumentException e) {
            System.err.println("[CRASH PREVENTED] Core system initialization failed: " + e.getMessage());
        }

        System.out.println("\n=================================================");
        System.out.println("       System Simulation Terminated Cleanly      ");
        System.out.println("=================================================");
    }
}
