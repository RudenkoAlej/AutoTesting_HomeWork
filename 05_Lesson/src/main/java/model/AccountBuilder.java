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

    public class Account {
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

        public Account(String gender, String firstCustomerName, String lastCustomerName, String email,
                       String passwd, String day, String month, String year, String firstName, String lastName,
                       String company, String address1, String address2, String city, String state,
                       String postCode, String country, String additional, String phone, String mobile,
                       String alias) {
            this.gender = gender;
            this.firstCustomerName = firstCustomerName;
            this.lastCustomerName = lastCustomerName;
            this.email = email;
            this.passwd = passwd;
            this.day = day;
            this.month = month;
            this.year = year;
            this.firstName = firstName;
            this.lastName = lastName;
            this.company = company;
            this.address1 = address1;
            this.address2 = address2;
            this.city = city;
            this.state = state;
            this.postCode = postCode;
            this.country = country;
            this.additional = additional;
            this.phone = phone;
            this.mobile = mobile;
            this.alias = alias;
        }


        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getFirstCustomerName() {
            return firstCustomerName;
        }

        public void setFirstCustomerName(String firstCustomerName) {
            this.firstCustomerName = firstCustomerName;
        }

        public String getLastCustomerName() {
            return lastCustomerName;
        }

        public void setLastCustomerName(String lastCustomerName) {
            this.lastCustomerName = lastCustomerName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPasswd() {
            return passwd;
        }

        public void setPasswd(String passwd) {
            this.passwd = passwd;
        }

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public String getMonth() {
            return month;
        }

        public void setMonth(String month) {
            this.month = month;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getAddress1() {
            return address1;
        }

        public void setAddress1(String address1) {
            this.address1 = address1;
        }

        public String getAddress2() {
            return address2;
        }

        public void setAddress2(String address2) {
            this.address2 = address2;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getPostCode() {
            return postCode;
        }

        public void setPostCode(String postCode) {
            this.postCode = postCode;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getAdditional() {
            return additional;
        }

        public void setAdditional(String additional) {
            this.additional = additional;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

    }

}
