import java.util.List;
import java.util.ArrayList;

// Задача №1.3
class Name {
    private String firstName;
    private String surname;
    private String patronymic;

    Name(String firstName) {
        this(firstName, null, null);
    }

    Name(String firstName, String surname) {
        this(firstName, surname, null);
    }

    Name(String firstName, String surname, String patronymic) {
        this.firstName = firstName;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (surname != null && !surname.isEmpty()) {
            sb.append(surname);
        }
        if (firstName != null && !firstName.isEmpty()) {
            if (sb.length() > 0) sb.append(" ");
            sb.append(firstName);
        }
        if (patronymic != null && !patronymic.isEmpty()) {
            if (sb.length() > 0) sb.append(" ");
            sb.append(patronymic);
        }
        return sb.toString();
    }
}

// Задача №1.5
class House {
    private int floors;

    House(int floors) {
        this.floors = floors;
    }

    public String toString() {
        String word;
        if (floors % 10 == 1 && floors % 100 != 11) {
            word = "этажом";
        } else {
            word = "этажами";
        }
        return "дом с " + floors + " " + word;
    }
}

// Задача №2.4
class Department {
    private String name;
    private Employee head;
    private List<Employee> employees = new ArrayList<>();

    Department(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    Employee getHead() {
        return head;
    }

    void setHead(Employee head) {
        this.head = head;
    }

    void addEmployee(Employee employee) {
        if (!employees.contains(employee)) {
            employees.add(employee);
        }
    }

    List<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }

    public String toString() {
        List<String> names = new ArrayList<>();
        for (Employee employee : employees) {
            names.add(employee.getName());
        }
        String headName = head == null ? "нет" : head.getName();
        return "Отдел " + name + ", начальник: " + headName + ", сотрудники: " + names;
    }
}

// Задача №3.4
class Employee {
    private String name;
    private Department department;

    Employee(String name, Department department) {
        this.name = name;
        this.department = department;
        if (department != null) {
            department.addEmployee(this);
        }
    }

    String getName() {
        return name;
    }

    List<Employee> getDepartmentEmployees() {
        if (department == null) {
            return new ArrayList<>();
        }
        return department.getEmployees();
    }

    public String toString() {
        if (department != null && department.getHead() == this) {
            return name + " начальник отдела " + department.getName();
        }
        String departmentName = department == null ? "без отдела" : department.getName();
        String headName = department != null && department.getHead() != null
                ? department.getHead().getName()
                : "нет";
        return name + " работает в отделе " + departmentName + ", начальник которого " + headName;
    }
}

// Задача №5.5
class Fraction {
    private int numerator;
    private int denominator;

    Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("denominator = 0");
        }
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        int g = gcd(Math.abs(numerator), Math.abs(denominator));
        this.numerator = numerator / g;
        this.denominator = denominator / g;
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a == 0 ? 1 : a;
    }

    Fraction sum(Fraction other) {
        return new Fraction(
                numerator * other.denominator + other.numerator * denominator,
                denominator * other.denominator
        );
    }

    Fraction sum(int value) {
        return sum(new Fraction(value, 1));
    }

    Fraction sub(Fraction other) {
        return new Fraction(
                numerator * other.denominator - other.numerator * denominator,
                denominator * other.denominator
        );
    }

    Fraction sub(int value) {
        return sub(new Fraction(value, 1));
    }

    Fraction mul(Fraction other) {
        return new Fraction(
                numerator * other.numerator,
                denominator * other.denominator
        );
    }

    Fraction mul(int value) {
        return mul(new Fraction(value, 1));
    }

    Fraction div(Fraction other) {
        return new Fraction(
                numerator * other.denominator,
                denominator * other.numerator
        );
    }

    Fraction div(int value) {
        return div(new Fraction(value, 1));
    }

    Fraction minus(int value) {
        return sub(value);
    }

    public String toString() {
        return numerator + "/" + denominator;
    }
}

// Демонстрация задач №1.3, №1.5, №2.4, №3.4, №4.5, №5.5
public class Main {
    public static void main(String[] args) {
        System.out.println("Задание 1.3");
        Name name1 = new Name("Клеопатра");
        Name name2 = new Name("Александр", "Пушкин", "Сергеевич");
        Name name3 = new Name("Владимир", "Маяковский");
        System.out.println(name1);
        System.out.println(name2);
        System.out.println(name3);
        System.out.println();

        System.out.println("Задание 1.5");
        House house1 = new House(1);
        House house5 = new House(5);
        House house23 = new House(23);
        System.out.println(house1);
        System.out.println(house5);
        System.out.println(house23);
        System.out.println();

        System.out.println("Задание 2.4");
        Department it = new Department("IT");
        Employee petrov = new Employee("Петров", it);
        Employee kozlov = new Employee("Козлов", it);
        Employee sidorov = new Employee("Сидоров", it);
        it.setHead(kozlov);
        System.out.println(petrov);
        System.out.println(kozlov);
        System.out.println(sidorov);
        System.out.println();

        System.out.println("Задание 3.4");
        System.out.println(petrov.getDepartmentEmployees());
        System.out.println(kozlov.getDepartmentEmployees());
        System.out.println(sidorov.getDepartmentEmployees());
        System.out.println();

        System.out.println("Задание 4.5");
        Name name4 = new Name("Клеопатра");
        Name name5 = new Name("Александр", "Пушкин", "Сергеевич");
        Name name6 = new Name("Владимир", "Маяковский");
        Name name7 = new Name("Христофор", "Бонифатьевич");
        System.out.println(name4);
        System.out.println(name5);
        System.out.println(name6);
        System.out.println(name7);
        System.out.println();

        System.out.println("Задание 5.5");
        Fraction f1 = new Fraction(1, 3);
        Fraction f2 = new Fraction(2, 3);
        Fraction f3 = new Fraction(2, 9);
        Fraction f4 = new Fraction(3, 4);

        System.out.println(f1 + " + " + f2 + " = " + f1.sum(f2));
        System.out.println(f1 + " - " + f2 + " = " + f1.sub(f2));
        System.out.println(f1 + " * " + f2 + " = " + f1.mul(f2));
        System.out.println(f1 + " / " + f3 + " = " + f1.div(f3));
        System.out.println(f4 + " + " + 2 + " = " + f4.sum(2));
        System.out.println(f4 + " - " + 1 + " = " + f4.sub(1));
        System.out.println(f4 + " * " + 2 + " = " + f4.mul(2));
        System.out.println(f4 + " / " + 2 + " = " + f4.div(2));
        System.out.println("(" + f1 + " + " + f2 + ") / " + f3 + " - 5 = " + f1.sum(f2).div(f3).minus(5));
    }
}