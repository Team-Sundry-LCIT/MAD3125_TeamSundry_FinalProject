package mad3125.teamsundry.finalproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import mad3125.teamsundry.finalproject.Part1.Employee;
import mad3125.teamsundry.finalproject.databinding.FragmentEmployeeDetailBinding;

public class EmployeeDetailFragment extends Fragment {

    private FragmentEmployeeDetailBinding binding;
    private Employee employee;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentEmployeeDetailBinding.inflate(getLayoutInflater(), container, false);


        employee = (Employee) getArguments().getSerializable("data");

        binding.textViewName.setText(employee.getName());
        binding.textViewTitle.setText(employee.getClass().getSimpleName());
        binding.textViewDetail.setText(employee.toString());

        return binding.getRoot();
    }
}
