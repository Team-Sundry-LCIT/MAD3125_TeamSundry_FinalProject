package mad3125.teamsundry.finalproject;

import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import mad3125.teamsundry.finalproject.databinding.FragmentEmployeeListBinding;

public class EmployeeListFragment extends Fragment {
<<<<<<< HEAD
=======

    private FragmentEmployeeListBinding binding;
    ExtendedFloatingActionButton addEmployee;

    public EmployeeListFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_employee_list,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.addEmployee.setOnClickListener(v -> {
        });
    }
>>>>>>> 160dedd (Add Binding for employee list fragment)
}
