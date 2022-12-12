package mad3125.teamsundry.finalproject;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import java.util.ArrayList;

import mad3125.teamsundry.finalproject.Part1.Employee;
import mad3125.teamsundry.finalproject.databinding.FragmentEmployeeListBinding;

public class EmployeeListFragment extends Fragment {
    private FragmentEmployeeListBinding binding;
    EmployeeListAdapter adapter;

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

        adapter = new EmployeeListAdapter(requireContext(), R.layout.employee_row_layout, Employee.employeeList);
        binding.employeeList.setAdapter(adapter);

        if(Employee.employeeList.isEmpty()){
            binding.groupEmpty.setVisibility(View.VISIBLE);
        }
        else{
            binding.groupEmpty.setVisibility(View.INVISIBLE);
        }

        binding.addEmployee.shrink();
        binding.addEmployee.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        addEmployee();
                        binding.addEmployee.extend();
                    }
                });

        binding.employeeList.setOnItemClickListener((parent, view1, position, id) -> {

            BsItemOptions.ActionProvider provider = new BsItemOptions.ActionProvider() {
                @Override
                public void view() {
                    viewEmployee(position);
                }

                @Override
                public void edit() {
                    editEmployee(position);
                }

                @Override
                public void delete() {
                    deleteEmployee(position);
                }
            };
            BsItemOptions options = new BsItemOptions();
            options.provider = provider;
            options.show(getChildFragmentManager(),"ITEM_OPTIONS");

        });

        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            // Override onQueryTextSubmit method which is call when submit query is searched
            @Override
            public boolean onQueryTextSubmit(String query) {
                ArrayList<Employee> employeeList = EmployeeViewModel.searchEmployee(query);
                if (employeeList.size() > 0) {

                    adapter.setEmployeeList(
                          employeeList
                    );

                } else {
                    Toast.makeText(requireContext(), "No found", Toast.LENGTH_LONG).show();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayList<Employee> employeeList = EmployeeViewModel.searchEmployee(newText);
                adapter.setEmployeeList(
                        employeeList
                );
                return false;
            }
        });

    }

    private void viewEmployee(int position){
        Employee employee = (Employee) adapter.getItem(position);
        Bundle bundle = new Bundle();
        bundle.putSerializable("data", employee);
        Navigation.findNavController(requireActivity(),R.id.fragmentContainer).navigate(R.id.action_employeeListFragment_to_employeeDetailFragment, bundle);
    }

    private void editEmployee(int position){
        Employee employee = (Employee) adapter.getItem(position);
    }
    
    private void deleteEmployee(int position){
        Employee employee = (Employee) adapter.getItem(position);
       adapter.remove(employee);
    }

    private void addEmployee(){
        Bundle bundle = new Bundle();
        Navigation.findNavController(requireActivity(),R.id.fragmentContainer).navigate(R.id.registerFragment, bundle);
    }
}
