package model;

public record ContactData(String id, String firstname, String middlename, String lastname,
                          String nickname, String address, String home, String mobile,
                          String work, String email, String photo, String secondary, String email2, String email3) {
    public ContactData(){
        this("","","","","","","","","","", "", "", "", "");
    }

    public ContactData withFirstName(String firstname) {
        return new ContactData(this.id,firstname, this.middlename, this.lastname,
                this.nickname,this.address,this.home,this.mobile,this.work,this.email, this.photo, this.secondary,
                this.email2, this.email3);
    }

    public ContactData withAddress(String address) {
        return new ContactData(this.id,this.firstname, this.middlename, this.lastname,
                this.nickname,address,this.home,this.mobile,this.work,this.email, this.photo, this.secondary,
                this.email2, this.email3);
    }

    public ContactData withLastName(String lastname) {
        return new ContactData(this.id,this.firstname, this.middlename, lastname,
                this.nickname,this.address,this.home,this.mobile,this.work,this.email, this.photo, this.secondary,
                this.email2, this.email3);
    }


    public ContactData withId(String id) {
        return new ContactData(id, this.firstname, this.middlename,
                this.lastname, this.nickname,this.address,
                this.home,this.mobile,this.work,this.email, this.photo, this.secondary, this.email2, this.email3);
    }

    public ContactData withPhoto(String photo) {
        return new ContactData(this.id, this.firstname, this.middlename,
                this.lastname, this.nickname,this.address,
                this.home,this.mobile,this.work,this.email, photo, this.secondary, this.email2, this.email3);
    }

    public ContactData withHome(String home) {
        return new ContactData(this.id, this.firstname, this.middlename,
                this.lastname, this.nickname,this.address,
                home,this.mobile,this.work,this.email, this.photo, this.secondary, this.email2, this.email3);
    }
    public ContactData withMobile(String mobile) {
        return new ContactData(this.id, this.firstname, this.middlename,
                this.lastname, this.nickname,this.address,
                this.home,mobile,this.work,this.email, this.photo, this.secondary, this.email2, this.email3);
    }
    public ContactData withWork(String work) {
        return new ContactData(this.id, this.firstname, this.middlename,
                this.lastname, this.nickname,this.address,
                this.home,this.mobile,work,this.email, this.photo, this.secondary, this.email2, this.email3);
    }
    public ContactData withSecondary(String secondary) {
        return new ContactData(this.id, this.firstname, this.middlename,
                this.lastname, this.nickname,this.address,
                this.home,this.mobile,this.work,this.email, this.photo, secondary, this.email2, this.email3);
    }

    public ContactData withEmail(String email) {
        return new ContactData(this.id, this.firstname, this.middlename,
                this.lastname, this.nickname,this.address,
                this.home,this.mobile,this.work,email, this.photo, this.secondary, this.email2, this.email3);
    }
    public ContactData withEmail2(String email2) {
        return new ContactData(this.id, this.firstname, this.middlename,
                this.lastname, this.nickname,this.address,
                this.home,this.mobile,this.work,this.email, this.photo, this.secondary, email2, this.email3);
    }

    public ContactData withEmail3(String email3) {
        return new ContactData(this.id, this.firstname, this.middlename,
                this.lastname, this.nickname,this.address,
                this.home,this.mobile,this.work,this.email, this.photo, this.secondary, this.email2, email3);
    }

}
