class LibraryManual {

    public BookManual[] books = new BookManual[100];
    int Bookcount = 0;

    public MemberManual[] members = new MemberManual[250];
    int Membercount = 0;


    public void addBook(BookManual book) {
        books[Bookcount] = book;
        Bookcount++;
    }


    public void addMember(MemberManual member) {
        members[Membercount] = member;
        Membercount++;
    }

    public void DisplayAllBooks(){
        System.out.println("--- Available Books in Library ---");
        for(int i = 0; i < Bookcount; i++){
            if(books[i].getAvailability().equalsIgnoreCase("Available")){
                books[i].DisplayBookDetails();
            }
        }
    }
    public void DisplayAllMembers(){
        for(int i=0;i<Membercount;i++){
            members[i].DisplayMemberDetails();
        }
    }

}
