package ru.eltex.phonebook;

public class Developer extends User{

    public Developer(String name, String phone, boolean genderMen) {
        super(name, phone,genderMen);
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
