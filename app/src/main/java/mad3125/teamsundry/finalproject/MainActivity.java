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
import mad3125.teamsundry.finalproject.Part2.Car;
import mad3125.teamsundry.finalproject.Part2.Motorcycle;
import mad3125.teamsundry.finalproject.Part3.Permanent;
import mad3125.teamsundry.finalproject.Part3.Temporary;
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
        //hire_test3();
        controller = Navigation.findNavController(this, R.id.fragmentContainer);
    }

    public void hire_test1() {

        Employee.employeeList.add(new Manager("Serge", 1985, 30, 4));
        Employee.employeeList.add(new Manager("Cindy", 1974, 20, 6));
        Employee.employeeList.add(new Programmer("Paul", 1993, 3, 75));
        Employee.employeeList.add(new Tester("Pierre", 1987, 124, 50));
        Employee.employeeList.add(new Programmer("Matt", 1981, 5, 110));
        Employee.employeeList.add(new Programmer("Sarah", 1986, 3, 50));

    }

    public void hire_test3() {
        Motorcycle m1 = new Motorcycle("Kawasaki", "Custom Plate", "Yellow", "Race Motorcycle", false);
        Motorcycle m2 = new Motorcycle("Honda", "Custom Plate", "Black", "Not for Race", true);
        Car vt1 = new Car("Lamborghini", "Custom Plate", "White", "Family", "Manual", "Sport");
        Car vt2 = new Car("BMW", "Custom Plate", "Black", "Family", "Automatic", "Sedan");
        Car vt3 = new Car("Renault Clio", "Custom Plate", "Blue", "Family", "Manual", "Hatchback");
        Car vt4 = new Car("Mazda", "Custom Plate", "White", "Family", "Automatic", "SUV");



        Manager Serge = new Manager("Serge", 1985, 4, 30, vt1);
        Manager Cindy = new Manager("Cindy", 1974, 6, 20, 80, vt2);
        Programmer Paul = new Programmer("Paul", 1983, 3, 75, m1);
        Tester Pierre = new Tester("Pierre", 1987, 124, 50, m2);
        Programmer Matt = new Programmer("Matt", 1981, 5, 100, vt4);
        Programmer Sarah = new Programmer("Sarah", 1986, 3, 100, vt3);

        Permanent p1 = new Permanent(2, true, 6000, 200, 17);
        Permanent p2 = new Permanent(3, false, 5000, 150, 19);
        Temporary t1 = new Temporary(60, 30);
        Temporary t2 = new Temporary(50, 60);
        Permanent p3 = new Permanent(1, true, 4000, 100, 20);
        Permanent p4 = new Permanent(4, true, 4500, 100, 19);

        Serge.signContract(p1);
        Cindy.signContract(p2);
        Paul.signContract(t1);
        Matt.signContract(t2);
        Pierre.signContract(p3);
        Sarah.signContract(p4);

        Employee.employeeList.add(Serge);
        Employee.employeeList.add(Cindy);
        Employee.employeeList.add(Paul);
        Employee.employeeList.add(Pierre);
        Employee.employeeList.add(Matt);
        Employee.employeeList.add(Sarah);
    }
}