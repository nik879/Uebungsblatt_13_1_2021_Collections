package Beispiel_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EmployeeManager {
    private ArrayList<Employee> Employees = new ArrayList<>();

    void addEmployee(Employee employee) {
        Employees.add(employee);
    }

    Employee findByEmpNumber(int Number) {
        for (Employee employee : Employees) {
            if (employee.getEmpNumber() == Number) {
                return employee;
            }
        }
        return null;
    }

    ArrayList<Employee> findByDepartment(String Department) {
        ArrayList<Employee> employees = new ArrayList<>();
        for (Employee employee : Employees) {
            if (employee.getDepartment().contains(Department)) {
                employees.add(employee);
            }
        }
        return employees;
    }

    public HashMap<String, ArrayList<Employee>> getAllEmployeesPerDepartment() {
        HashMap<String, ArrayList<Employee>> Map = new HashMap<>();
        for (Employee employee : Employees) {

            if (Map.containsKey(employee.getDepartment())) {
                ArrayList listeAngestellte = Map.get(employee.getDepartment());

//                ArrayList listeAngestellte = new ArrayList();
                listeAngestellte.add(employee);
                Map.put(employee.getDepartment(), listeAngestellte);
            } else {
                ArrayList listeAngestellte = new ArrayList();
                listeAngestellte.add(employee);
                Map.put(employee.getDepartment(),listeAngestellte);
            }
        }
        return Map;
    }

//    public HashMap<String, Integer> getNumberOfEmployeesPerDepartment() {
//
//    }


}
