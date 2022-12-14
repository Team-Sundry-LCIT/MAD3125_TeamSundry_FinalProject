package mad3125.teamsundry.finalproject;

import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
import mad3125.teamsundry.finalproject.Part1.Employee;

public class EmployeeViewModel extends ViewModel {

    public static ArrayList<Employee> searchEmployee(String text) {
        ArrayList<Employee> matches = new ArrayList<>();
        for(Employee member : Employee.employeeList) {
            if (member.getName().toLowerCase().contains(text.toLowerCase())) {
                matches.add(member);
            }else  if (member.getClass().getName().toLowerCase().contains(text.toLowerCase())) {
                matches.add(member);
            }
        }
        return matches;
    }
}
