package ru.eltex.phonebook;

public class Developer extends User {

    public Developer(String name, String phone, boolean genderMen) {
        super(name, phone, genderMen);
    }

    public Developer(String name, String phone, String gender) {
        super(name, phone, gender);
    }

    @Override
    public String toString() {
        return "Developer: " + this.getName() + " " + this.getPhone();
    }

    @Override
    public String toJSONString() {
        return "{\"name\": " + this.getName() + ", \"phone\": " + this.getPhone() + "}";
    }
}
