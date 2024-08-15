package model;

public record ContactData(String firstname, String middlename, String lastname,
                          String nickname, String address, String home, String mobile,
                          String work, String email) {
    public ContactData(){
        this("","","","","","","","","");
    }

    public ContactData withFirstName(String name) {
        return new ContactData(firstname, this.middlename, this.lastname,
                this.nickname,this.address,this.home,this.mobile,this.work,this.email);
    }

    public ContactData withMiddleName(String name) {
        return new ContactData(firstname, this.middlename, this.lastname,
                this.nickname,this.address,this.home,this.mobile,this.work,this.email);
    }

    public ContactData withLastName(String name) {
        return new ContactData(firstname, this.middlename, this.lastname,
                this.nickname,this.address,this.home,this.mobile,this.work,this.email);
    }


}
