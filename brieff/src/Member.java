public class Member {
    private int memberid;
    private String lastname;
    private String firstname;
    private String fulladress;
    private String gender;
    private String phonenumber;

    public Member() {

    }
    public Member(String firstname,String lastname,String gender) {
       this.firstname=firstname;
       this.lastname=lastname;
       this.gender=gender;
    }
    public Member(int memberid, String lastname, String firstname, String fulladress, String gender, String phonenumber) {
        this.memberid = memberid;
        this.lastname = lastname;
        this.firstname = firstname;
        this.fulladress = fulladress;
        this.gender = gender;
        this.phonenumber = phonenumber;
    }
}
