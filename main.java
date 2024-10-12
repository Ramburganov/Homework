public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];

        employees[0] = new Employee("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
        employees[1] = new Employee("Petrov Petr", "Manager", "petrov@mailbox.com", "892312313", 35000, 35);
        employees[2] = new Employee("Sidorov Sidr", "Developer", "sidorov@mailbox.com", "892312314", 40000, 28);
        employees[3] = new Employee("Smirnov Smir", "Designer", "smirnov@mailbox.com", "892312315", 32000, 32);
        employees[4] = new Employee("Kuznetsov Kuzma", "Tester", "kuznetsov@mailbox.com", "892312316", 28000, 26);

        for (Employee employee : employees) {
            employee.printInfo();
            System.out.println();
        }
    }
}

