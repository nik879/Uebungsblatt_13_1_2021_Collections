package Beispiel_1;

public class Employee {
    private String name, department;
    private int empNumber;
    private double salary;

    public Employee(String name, String department, int empNumber, double salary) {
        this.name = name;
        this.department = department;
        this.empNumber = empNumber;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public int getEmpNumber() {
        return empNumber;
    }

    public double getSalary() {
        return salary;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", empNumber=" + empNumber +
                ", salary=" + salary +
                '}';
    }
}
