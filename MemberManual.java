class MemberManual{
    private String MembershipID;
    private String Name;
    private String email;
    private String Tel;
    private String MembershipType;

    public MemberManual(String MembershipID,String Name,String email,String Tel,String MembershipType){
        this.MembershipID = MembershipID;
        this.Name = Name;
        this.email = email;
        this.Tel = Tel;
        this.MembershipType = MembershipType;
    }

    public String getMembershipID() {
        return MembershipID;
    }
    public String getName(){
        return Name;
    }

    public String getEmail() {
        return email;
    }

    public String getTel() {
        return Tel;
    }

    public String getMembershipType() {
        return MembershipType;
    }

    public void DisplayMemberDetails(){
        System.out.println("MemberID"+MembershipID);
        System.out.println("Name"+Name);
        System.out.println("email"+email);
        System.out.println("Tel"+Tel);
        System.out.println("Member Type"+MembershipType);
    }



    
}
