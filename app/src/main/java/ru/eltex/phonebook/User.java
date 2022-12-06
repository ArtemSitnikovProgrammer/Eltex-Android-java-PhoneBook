package ru.eltex.phonebook;

class ENV {
    protected static int ID = 0;

    static boolean compare(User a, User b) {

        return a.getId() == b.getId() &
                a.getName().equals(b.getName()) &
                a.getGender().equals(b.getGender()) &
                a.getPhone().equals(b.getPhone());
    }

}

public abstract class User {

    private final String GENDER_MEN = "Men";
    private final String GENDER_WOMEN = "Woman";

    private int id;
    private String name;
    private String phone;
    private String gender;
    private boolean genderMen;

    public User(String name, String phone, boolean genderMen) {
        id = ENV.ID;
        ENV.ID++;

        this.name = name;
        this.phone = phone;
        this.genderMen = genderMen;
    }

    public User(String name, String phone, String gender){
        id = ENV.ID;
        ENV.ID++;

        this.name = name;
        this.phone = phone;
        this.gender = gender;

        if(gender.equals(GENDER_MEN)) genderMen = true;
        else if(gender.equals(GENDER_WOMEN)) genderMen = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getGender() {
        return genderMen ? GENDER_MEN : GENDER_WOMEN;
    }

    public abstract String toString();

    public abstract String toJSONString();
}
