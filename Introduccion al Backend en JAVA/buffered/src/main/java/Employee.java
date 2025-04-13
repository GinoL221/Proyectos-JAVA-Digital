import java.io.Serializable;

public class Employee implements Serializable {

    private String name;
    private String lastName;
    private Integer employeeFile;
    private Double salary;

    public Employee(String name, String lastName, Integer employeeFile, Double salary) {
        this.name = name;
        this.lastName = lastName;
        this.employeeFile = employeeFile;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getEmployeeFile() {
        return employeeFile;
    }

    public void setEmployeeFile(Integer employeeFile) {
        this.employeeFile = employeeFile;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + ", " + lastName + ", " + employeeFile + ", " + salary;
    }
}
