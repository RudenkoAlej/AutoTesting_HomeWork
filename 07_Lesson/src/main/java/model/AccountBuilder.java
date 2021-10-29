package model;

public class AccountBuilder {
    private String gender;
    private String firstCustomerName;
    private String lastCustomerName;
    private String email;
    private String passwd;
    private String day;
    private String month;
    private String year;
    private String firstName;
    private String lastName;
    private String company;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String postCode;
    private String country;
    private String additional;
    private String phone;
    private String mobile;
    private String alias;

    public AccountBuilder withGender(String gender) {
        this.gender = gender;
        return this;
    }

    public AccountBuilder withFirstCustomerName(String firstCustomerName) {
        this.firstCustomerName = firstCustomerName;
        return this;
    }

    public AccountBuilder withSecondCustomerName(String lastCustomerName) {
        this.lastCustomerName = lastCustomerName;
        return this;
    }

    public AccountBuilder withPassword(String passwd) {
        this.passwd = passwd;
        return this;
    }

    public AccountBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public AccountBuilder withDay(String day) {
        this.day = day;
        return this;
    }

    public AccountBuilder withMonth(String month) {
        this.month = month;
        return this;
    }

    public AccountBuilder withYear(String year) {
        this.year = year;
        return this;
    }

    public AccountBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public AccountBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public AccountBuilder withCompany(String company) {
        this.company = company;
        return this;
    }

    public AccountBuilder withAddress1(String address1) {
        this.address1 = address1;
        return this;
    }

    public AccountBuilder withAddress2(String address1) {
        this.address2 = address2;
        return this;
    }

    public AccountBuilder withCity(String city) {
        this.city = city;
        return this;
    }

    public AccountBuilder withState(String state) {
        this.state = state;
        return this;
    }

    public AccountBuilder withPostCode(String postCode) {
        this.postCode = postCode;
        return this;
    }

    public AccountBuilder withCountry(String country) {
        this.country = country;
        return this;
    }

    public AccountBuilder withAdditional(String additional) {
        this.additional = additional;
        return this;
    }

    public AccountBuilder withPhone (String phone) {
        this.phone = phone;
        return this;
    }

    public AccountBuilder withMobile (String mobile) {
        this.mobile = mobile;
        return this;
    }

    public AccountBuilder withAlias (String alias) {
        this.alias = alias;
        return this;
    }

    public Account build() {
        return new Account(gender, firstCustomerName, lastCustomerName, email, passwd, day, month, year,
                firstName, lastName, company, address1, address2, city, state, postCode, country,
                additional, phone, mobile, alias);
    }

}
