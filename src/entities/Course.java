package entities;

public class Course {
    private int C_ID;
    private String Name;
    private int Cant;
    private int Income;

    public Course(int c_id, String name, int cant, int income) {
        this.C_ID = c_id;
        this.Name = name;
        this.Cant = cant;
        this.Income = income;
    }

    public int getC_ID() {
        return C_ID;
    }

    public void setC_ID(int c_ID) {
        C_ID = c_ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getCapacity() {
        return Cant;
    }

    public void setCapacity(int cant) {
        Cant = cant;
    }

    public int getIncome() {
        return Income;
    }

    public void setIncome(int income) {
        Income = income;
    }
}
