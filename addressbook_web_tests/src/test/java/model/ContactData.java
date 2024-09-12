package model;

public record ContactData(String id, String firstname, String middlename, String lastname,
                          String nickname, String address, String home, String mobile,
                          String work, String email, String photo) {
    public ContactData(){
        this("","","","","","","","","","", "");
    }

    public ContactData withFirstName(String firstname) {
        return new ContactData(this.id,firstname, this.middlename, this.lastname,
                this.nickname,this.address,this.home,this.mobile,this.work,this.email, this.photo);
    }

    public ContactData withAddress(String address) {
        return new ContactData(this.id,this.firstname, this.middlename, this.lastname,
                this.nickname,address,this.home,this.mobile,this.work,this.email, this.photo);
    }

    public ContactData withLastName(String lastname) {
        return new ContactData(this.id,this.firstname, this.middlename, lastname,
                this.nickname,this.address,this.home,this.mobile,this.work,this.email, this.photo);
    }


    public ContactData withId(String id) {
        return new ContactData(id, this.firstname, this.middlename,
                this.lastname, this.nickname,this.address,
                this.home,this.mobile,this.work,this.email, this.photo);
    }

    public ContactData withPhoto(String photo) {
        return new ContactData(this.id, this.firstname, this.middlename,
                this.lastname, this.nickname,this.address,
                this.home,this.mobile,this.work,this.email, photo);
    }
}
