package mad3125.teamsundry.finalproject;

import java.util.ArrayList;

import mad3125.teamsundry.finalproject.Part1.Employee;

public class EmployeeViewModel {

    public static ArrayList<Employee> searchEmployee(String text) {
        ArrayList<Employee> matches = new ArrayList();
        for(Employee member : Employee.employeeList) {
            if (member.getName().contains(text)) {
                matches.add(member);
            }else  if (member.getClass().getName().contains(text)) {
                matches.add(member);
            }
        }
        return matches;
    }
}
