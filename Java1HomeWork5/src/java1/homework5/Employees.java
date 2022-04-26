package java1.homework5;

public class Employees {
    private String fullName;
    private String position;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;

    public Employees(String fullName, String position, String email, String phoneNumber, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    void printInfo(){
        System.out.println("Employee: Full name: " + fullName + " | Position: " + position + " | email: " + email + " | Phone number: " + phoneNumber + " | Salary: " + salary + " | Age: " + age);
    }


}
