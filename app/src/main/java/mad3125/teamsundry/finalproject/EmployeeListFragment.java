package mad3125.teamsundry.finalproject;

import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import mad3125.teamsundry.finalproject.databinding.ActivityMainBinding;
import mad3125.teamsundry.finalproject.databinding.FragmentEmployeeListBinding;

public class EmployeeListFragment extends Fragment {
<<<<<<< HEAD
=======

    private FragmentEmployeeListBinding binding;

    public EmployeeListFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentEmployeeListBinding.inflate(getLayoutInflater(),container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.addEmployee.shrink();
        binding.addEmployee.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        binding.addEmployee.extend();
                    }
                });

    }
>>>>>>> 160dedd (Add Binding for employee list fragment)
}
