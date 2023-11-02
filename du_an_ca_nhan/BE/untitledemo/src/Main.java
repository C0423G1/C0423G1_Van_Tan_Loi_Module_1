public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Person person = new Employee();
        person.work();
        person.study();
        Employee employee = new Employee();
        System.out.println( employee.work("Hoc Lam IT"));
    }
}