package gigi.myauto.models;

import java.lang.ref.PhantomReference;

import gigi.myauto.SeeMore;

/**
 * Created by UGLemondoTrainings on 4/26/16.
 */
public class User {

    private int id;
    private String firstName;
    private String lastName;
    private String password;
    private String phone;

    // empty constructor
    public User() {}

    public User (String name, String lastname, String Password, String phoneNumber) {
        this.firstName = name;
        this.lastName = lastname;
        this.password = Password;
        this.phone = phoneNumber;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
