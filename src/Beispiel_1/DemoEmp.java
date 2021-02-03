package Beispiel_1;

public class DemoEmp {
    public static void main(String[] args) {
        Employee Niki = new Employee("Niki", "IT", 1, 20000);
        Employee Hannes = new Employee("Hannes", "IT", 2, 30000);
        Employee Elsa = new Employee("ELsa", "RT", 2, 30000);

        EmployeeManager em = new EmployeeManager();

        em.addEmployee(Niki);
        em.addEmployee(Hannes);
        em.addEmployee(Elsa);
        System.out.println(em.findByEmpNumber(2));
        System.out.println(em.findByDepartment("IT"));
        System.out.println(em.findByDepartment("RT"));
        System.out.println(em.getAllEmployeesPerDepartment());
    }
}