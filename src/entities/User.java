package entities;

public class User {
    Integer Uid;
    String password;
    String firstName;
    String lastName;
    String rol;




    //Getters Setters


    public Integer getUid() {return Uid;}

    public void setUid(Integer uid) {Uid = uid;}

    public String getPassword() { return password;};

    public void setPassword(String password) { this.password = password;}

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

    public String getRol() {return rol;}

    public void setRol(String rol) {this.rol = rol;}
};



