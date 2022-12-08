package mad3125.teamsundry.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import mad3125.teamsundry.finalproject.Part1.Employee;
import mad3125.teamsundry.finalproject.Part1.Manager;
import mad3125.teamsundry.finalproject.Part1.Programmer;
import mad3125.teamsundry.finalproject.Part1.Tester;
import mad3125.teamsundry.finalproject.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    NavController controller;
    static ArrayList<Employee> employees = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        hire_test1();
        controller = Navigation.findNavController(this,R.id.employee_list_container);
   }

    public void hire_test1() {

        Employee.employeeList.add(new Manager("Serge", 1985,  30, 4));
        Employee.employeeList.add(new Manager("Cindy", 1974,  20,  6));
        Employee.employeeList.add(new Programmer("Paul",  1993, 3,  75));
        Employee.employeeList.add(new Tester("Pierre", 1987, 124,50));
        Employee.employeeList.add(new Programmer("Matt",  1981,  5,  110));
        Employee.employeeList.add(new Programmer("Sarah", 1986,  3,50));

    }
}