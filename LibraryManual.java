class LibraryManual {

    BookManual[] books = new BookManual[100];
    int Bookcount = 0;

    MemberManual[] members = new MemberManual[250];
    int Membercount = 0;


    public void addBook(BookManual book) {
        books[Bookcount] = book;
        Bookcount++;
    }


    public void addMember(MemberManual member) {
        members[Membercount] = member;
        Membercount++;
    }
}