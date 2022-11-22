package ru.eltex.phonebook;

public class Manager extends User{

    public Manager(String name, String phone, boolean genderMen) {
        super(name, phone,genderMen);
    }

    @Override
    public String toString() {
        return "Manager: " + this.getName() + " " + this.getPhone();
    }

    @Override
    public String toJSONString() {
        return "{\"name\": " + this.getName() + ", \"phone\": " + this.getPhone() + "}";
    }
}
