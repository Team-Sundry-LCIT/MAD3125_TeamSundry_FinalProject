package mad3125.teamsundry.finalproject;

import androidx.appcompat.app.AppCompatActivity;
<<<<<<< HEAD
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
=======
import androidx.fragment.app.FragmentManager;
>>>>>>> a9de33c (Load the fragment in MainActivity)

import android.os.Bundle;

import mad3125.teamsundry.finalproject.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    NavController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        controller = Navigation.findNavController(this,R.id.fragmentContainer);

=======
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().add(R.id.employee_list_container,new EmployeeListFragment(),"EmployeeList").commit();
>>>>>>> a9de33c (Load the fragment in MainActivity)
    }
}