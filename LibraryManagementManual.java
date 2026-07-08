import java.util.Scanner;

public class LibraryManagementManual {
    public static void main(String[] args){
        LibraryManual CityLibrary = new LibraryManual();
        Scanner sc = new Scanner(System.in);
        int choice;
        do{
            System.out.println("\n1.Add Members");
            System.out.println("2.Add Book");
            System.out.println("3.Display all Books");
            System.out.println("4.Display all members");
            System.out.println("5.Borrow Book");
            System.out.println("6.Return Book");
            System.out.println("7.Search by category");
            System.out.println("8.Search by Author");
            System.out.println("9.Exit");

            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Clears the leftover newline character

            if(choice == 1){
                System.out.println("Membership Id:");
                String MembershipID = sc.nextLine();
                System.out.println("Member Name:");
                String Name = sc.nextLine();
                System.out.println("email:");
                String email = sc.nextLine();
                System.out.println("Tel:");
                String Tel = sc.nextLine();
                System.out.println("Membership Type:");
                String MembershipType = sc.nextLine();

                MemberManual member = new MemberManual(MembershipID, Name, email, Tel, MembershipType);
                CityLibrary.addMember(member);

            } else if(choice == 2){
                System.out.println("Book Id:");
                String BookID = sc.nextLine();
                System.out.println("Title:");
                String Title = sc.nextLine();
                System.out.println("Author:");
                String Author = sc.nextLine();
                System.out.println("Category:");
                String Category = sc.nextLine();
                System.out.println("\"Enter availability (Available/Not Available):\"");
                String Availability = sc.nextLine();

                BookManual book = new BookManual(BookID, Title, Author, Category, Availability);
                CityLibrary.addBook(book);

            } else if(choice == 3){
                CityLibrary.DisplayAllBooks();

            } else if(choice == 4){
                CityLibrary.DisplayAllMembers();

            } else if(choice == 5){
                System.out.println("Enter the book name to borrow:");
                String searchBook = sc.nextLine();


                boolean found = false;
                for(int i = 0; i < CityLibrary.Bookcount; i++ ){
                    if(CityLibrary.books[i].getTitle().equalsIgnoreCase(searchBook)){
                        CityLibrary.books[i].markasborrowBook();
                        System.out.println(CityLibrary.books[i].getTitle() + " has been successfully borrowed.");
                        found = true;
                        break;
                    }
                }
                if(!found) {
                    System.out.println("Book not found.");
                }

            } else if(choice == 6){

                System.out.println("Enter the book name to return:");
                String returnBook = sc.nextLine();

                boolean found = false;
                for(int i = 0; i < CityLibrary.Bookcount; i++){
                    if(CityLibrary.books[i].getTitle().equalsIgnoreCase(returnBook)){
                        CityLibrary.books[i].markasreturnBook();
                        System.out.println(CityLibrary.books[i].getTitle() + " has been successfully returned.");
                        found = true;
                        break;
                    }
                }
                if(!found) {
                    System.out.println("Book not found in library records.");
                }
            }else if(choice== 7){
                System.out.println("What Category Are You Searching");
                System.out.println("1.Fiction");
                System.out.println("2.Science");
                System.out.println("3.Novels");
                System.out.println("4.History");
                System.out.println("5.Biography");
                System.out.println("6.Education");
                System.out.println("7.Literature");
                System.out.println("8.Law");
                System.out.println("9.Psychology");
                System.out.println("10.Business");
                String SearchCategory = sc.nextLine();
                for(int j=0; j< CityLibrary.Bookcount; j++){
                    if(CityLibrary.books[j].getCategory().equalsIgnoreCase(SearchCategory));
                    System.out.println(CityLibrary.books[j].getTitle());

                }

            }else if(choice==8){
                System.out.println("Which Author Are You Searching");
                String SearchAuthor = sc.nextLine();
                for(int i=0; i< CityLibrary.Bookcount; i++){
                    if(CityLibrary.books[i].getAuthor().equalsIgnoreCase(SearchAuthor)){
                        System.out.println(CityLibrary.books[i].getTitle());
                    }
                }
            }

        } while(choice != 9);

        sc.close();
    }
}