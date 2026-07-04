class BookManual {
    private  String BookId;
    private String Title;
    private String Author;
    private String Category;
    private String Availability;

    public BookManual(String BookId,String Title,String Author,String Category,String Availability ){
        this.BookId = BookId;
        this.Title = Title;
        this.Author = Author;
        this.Category = Category;
        this.Availability = Availability;
    }

    public String getBookId(){
        return BookId;
    }

    public String getTitle(){
        return Title;
    }

    public String getAuthor(){
        return Author;
    }

    public String getCategory(){
        return Category;
    }

    public String getAvailability(){
        return Availability;
    }


    public void markasborrowBook(){
        this.Availability = "Borrowed";
    }

    public void markasreturnBook(){
        this.Availability="Available";
    }


    public void DisplayBookDetails(){
        System.out.println("BookId ="+BookId);
        System.out.println("Title ="+Title);
        System.out.println("Authour ="+Author);
        System.out.println("Category ="+Category);
        System.out.println("Availability="+this.Availability);
    }
}
