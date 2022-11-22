package ru.eltex.phonebook;

public class User {

    private final String GENDER_MEN = "Men";
    private final String GENDER_WOMEN = "Woman";

    private String name;
    private String phone;
    private boolean genderMen;

    public User(String name, String phone, boolean genderMen){
        this.name = name;
        this.phone = phone;
        this.genderMen = genderMen;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean getGenderMen() {
        return genderMen;
    }

    public void setGender(boolean genderMen) {
        this.genderMen = genderMen;
    }

    public String getGender(){
        return genderMen ? GENDER_MEN : GENDER_WOMEN;
    }
}
