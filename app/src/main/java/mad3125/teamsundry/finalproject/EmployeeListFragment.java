package mad3125.teamsundry.finalproject;

<<<<<<< HEAD
=======
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
>>>>>>> aecb178 (List click event)
import androidx.fragment.app.Fragment;

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
                        addEmployee();
                        binding.addEmployee.extend();
                    }
                });

        binding.employeeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                loadEmployee(position);
            }
        });

    }

    private void loadEmployee(int position){
    }

    private void addEmployee(){
    }
>>>>>>> 160dedd (Add Binding for employee list fragment)
}
