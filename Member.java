public class Member {
    private final String membershipId;
    private final String name;
    private final String email;
    private final String tel;
    private final String membershipType;

    public Member(String membershipId, String name, String email, String tel, String membershipType) {
        if (isBlank(membershipId)) {
            throw new IllegalArgumentException("Membership ID cannot be empty.");
        }
        if (isBlank(name)) {
            throw new IllegalArgumentException("Member name cannot be empty.");
        }
        if (isBlank(email) || !email.contains("@")) {
            throw new IllegalArgumentException("Email must be a valid, non-empty address.");
        }
        if (isBlank(tel)) {
            throw new IllegalArgumentException("Telephone number cannot be empty.");
        }
        if (isBlank(membershipType)) {
            throw new IllegalArgumentException("Membership type cannot be empty.");
        }

        this.membershipId = membershipId;
        this.name = name;
        this.email = email;
        this.tel = tel;
        this.membershipType = membershipType;
    }

    private static boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }

    public String getMembershipId() {
        return membershipId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getTel() {
        return tel;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void displayDetails() {
        System.out.println("Member ID  : " + membershipId);
        System.out.println("Name       : " + name);
        System.out.println("Email      : " + email);
        System.out.println("Tel        : " + tel);
        System.out.println("Member Type: " + membershipType);
    }

    @Override
    public String toString() {
        return String.format("[%s] %s (%s) - %s", membershipId, name, membershipType, email);
    }
}
