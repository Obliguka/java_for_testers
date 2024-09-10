package model;

public record ContactData(String id, String firstname, String middlename, String lastname,
                          String nickname, String address, String home, String mobile,
                          String work, String email) {
    public ContactData(){
        this("","","","","","","","","","");
    }

    public ContactData withFirstName(String firstname) {
        return new ContactData(this.id,firstname, this.middlename, this.lastname,
                this.nickname,this.address,this.home,this.mobile,this.work,this.email);
    }

    public ContactData withAddress(String address) {
        return new ContactData(this.id,this.firstname, this.middlename, this.lastname,
                this.nickname,address,this.home,this.mobile,this.work,this.email);
    }

    public ContactData withLastName(String lastname) {
        return new ContactData(this.id,this.firstname, this.middlename, lastname,
                this.nickname,this.address,this.home,this.mobile,this.work,this.email);
    }


    public ContactData withId(String id) {
        return new ContactData(id, this.firstname, this.middlename, lastname,
                this.nickname,this.address,this.home,this.mobile,this.work,this.email);
    }
}
