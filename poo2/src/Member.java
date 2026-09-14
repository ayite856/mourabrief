public class Member {
    private int memberId;
    private String lastName;
    private String firstName;
    private String fullAdresse;
    private String gender;
    private String phoneNumber;


    public Member(int memberId, String lastName, String firstName, String fullAdresse, String gender, String phoneNumber) {
        this.memberId = memberId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.fullAdresse = fullAdresse;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFullAdresse() {
        return fullAdresse;
    }

    public void setFullAdresse(String fullAdresse) {
        this.fullAdresse = fullAdresse;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
