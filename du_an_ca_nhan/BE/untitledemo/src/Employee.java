public class Employee extends Person {
    private double Salary;

    @Override
    public void work() {
        System.out.println("lam IT");
    }

    public String work(String name) {
        return name;
    }

    public Employee(double salary) {
        Salary = salary;
    }

    public Employee() {
    }

}
