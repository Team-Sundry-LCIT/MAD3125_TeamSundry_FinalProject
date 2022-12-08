package mad3125.teamsundry.finalproject;
import android.app.AlertDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;

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

        adapter = new EmployeeListAdapter(requireContext(), R.layout.employee_row_layout);
        binding.employeeList.setAdapter(adapter);

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
                new AlertDialog.Builder(requireContext())
                        .setIcon(R.drawable.ic_delete)
                        .setPositiveButton("View", (dialog, which) -> viewEmployee(position))
                        .setPositiveButton("Edit", (dialog, which) -> editEmployee(position))
                        .setTitle("Are you sure?")
                        .setNegativeButton("Delete", (dialog, which) -> deleteEmployee(position))
                        .create()
                        .show();
            }
        });

        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            // Override onQueryTextSubmit method which is call when submit query is searched
            @Override
            public boolean onQueryTextSubmit(String query) {
                // If the list contains the search query than filter the adapter
                // using the filter method with the query as its argument
                if (Employee.employeeList.contains(query)) {
                    adapter.getFilter().filter(query);
                } else {
                    // Search query not found in List View
                    Toast.makeText(requireContext(), "Not found", Toast.LENGTH_LONG).show();
                }
                return false;
            }

            // This method is overridden to filter the adapter according
            // to a search query when the user is typing search
            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        }

    private void viewEmployee(int position){
        Employee employee = (Employee) adapter.getItem(position);
    }

    private void editEmployee(int position){
        Employee employee = (Employee) adapter.getItem(position);
    }
    
    private void deleteEmployee(int position){
        adapter.remove(position);
    }

    private void addEmployee(){
    }
}
