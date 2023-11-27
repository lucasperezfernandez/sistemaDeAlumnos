package entities;

public class Form {
    //
    private String password;
    private String firstName;
    private String lastName;
    private int courseId;
    private String name;
    private int capacity;
    private int cost;
    private int passingGrade;

    private int professorId;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getPassingGrade() {
        return passingGrade;
    }

    public void setPassingGrade(int passingGrade) {
        this.passingGrade = passingGrade;
    }

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }

    public Form(String password, String firstName, String lastName, int courseId, String name, int capacity, int cost, int passingGrade, int professorId) {
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.courseId = courseId;
        this.name = name;
        this.capacity = capacity;
        this.cost = cost;
        this.passingGrade = passingGrade;
        this.professorId = professorId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
