package mad3125.teamsundry.finalproject;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.RadioGroup;
import mad3125.teamsundry.finalproject.Part1.Employee;
import mad3125.teamsundry.finalproject.Part1.Manager;
import mad3125.teamsundry.finalproject.Part1.Programmer;
import mad3125.teamsundry.finalproject.Part1.Tester;
import mad3125.teamsundry.finalproject.Part2.Car;
import mad3125.teamsundry.finalproject.Part2.Motorcycle;
import mad3125.teamsundry.finalproject.Part3.Permanent;
import mad3125.teamsundry.finalproject.Part3.Temporary;

import com.google.android.material.snackbar.Snackbar;

import mad3125.teamsundry.finalproject.databinding.FragmentRegisterBinding;

public class RegisterFragment extends Fragment {
    private FragmentRegisterBinding binding;
    public RegisterFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(getLayoutInflater(),container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.spnEmployeeType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                switch (position) {
                    case 0:
                        binding.etClients.setVisibility(View.GONE);
                        binding.etTravelDays.setVisibility(View.GONE);
                        binding.etProjects.setVisibility(View.GONE);
                        binding.etBugs.setVisibility(View.GONE);
                        break;
                    case 1:
                        binding.etClients.setVisibility(View.VISIBLE);
                        binding.etTravelDays.setVisibility(View.VISIBLE);
                        binding.etProjects.setVisibility(View.GONE);
                        binding.etBugs.setVisibility(View.GONE);
                        break;
                    case 2:
                        binding.etClients.setVisibility(View.GONE);
                        binding.etTravelDays.setVisibility(View.GONE);
                        binding.etProjects.setVisibility(View.VISIBLE);
                        binding.etBugs.setVisibility(View.GONE);
                        break;
                    case 3:
                        binding.etClients.setVisibility(View.GONE);
                        binding.etTravelDays.setVisibility(View.GONE);
                        binding.etProjects.setVisibility(View.GONE);
                        binding.etBugs.setVisibility(View.VISIBLE);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }

        });

        binding.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rdCar:
                        binding.layoutSidecar.setVisibility(View.GONE);
                        binding.etCarType.setVisibility(View.VISIBLE);
                        break;
                    case R.id.rdMotorbike:
                        binding.layoutSidecar.setVisibility(View.VISIBLE);
                        binding.etCarType.setVisibility(View.GONE);
                        break;
                }
            }
        });


        binding.btnAdd.setOnClickListener( v->{
            if(validateEmployee()){
                String name = binding.etFirstName.getText().toString() + " " + binding.etLastName.getText().toString();
                int birthYear = Integer.parseInt(binding.etBirthYear.getText().toString());
                int monthlySalary = Integer.parseInt(binding.etMonthlySalary.getText().toString());
                int rate = Integer.parseInt(binding.etRate.getText().toString());
                int employeeType = binding.spnEmployeeType.getSelectedItemPosition();
                int vehicleType = binding.radioGroup.getCheckedRadioButtonId();
                String model = binding.etVehicleModel.getText().toString();
                String plateNumber = binding.etPlateNumber.getText().toString();
                String vehicleColor = binding.spnVehicleColor.getSelectedItem().toString();
                String carType = binding.etCarType.getText().toString();
                Car car = new Car(model, plateNumber, vehicleColor, "Manual", "Sport", carType);
                Motorcycle motorcycle = new Motorcycle(model, plateNumber, vehicleColor, "Not for Race", true);

                switch (employeeType) {
                    case 1:
                        int clients = Integer.parseInt(binding.etClients.getText().toString());
                        int travelDays = Integer.parseInt(binding.etTravelDays.getText().toString());
                        Manager manager = new Manager(name, birthYear, travelDays, clients, rate, vehicleType == R.id.rdCar ? car : motorcycle);
                        Employee.employeeList.add(manager);
                        break;
                    case 2:
                        int projects = Integer.parseInt(binding.etProjects.getText().toString());
                        Programmer dev  = new Programmer(name, birthYear, projects, rate, vehicleType == R.id.rdCar ? car : motorcycle);
                        Employee.employeeList.add(dev);
                        break;
                    case 3:
                        int bugs = Integer.parseInt(binding.etBugs.getText().toString());
                        Tester tester  = new Tester(name, birthYear, bugs, rate, vehicleType == R.id.rdCar ? car : motorcycle);
                        Employee.employeeList.add(tester);
                        break;
                }

                new AlertDialog.Builder(requireContext())
                    .setIcon(R.drawable.ic_delete)
                    .setPositiveButton("View employees", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Bundle bundle = new Bundle();
                            Navigation.findNavController(requireActivity(),R.id.fragmentContainer).navigate(R.id.employeeListFragment, bundle);
                        }
                    })
                    .setTitle("Employee registration successful!")
                    .setNegativeButton("Add new", (dialog, which) -> clear())
                    .create()
                    .show();
            }
        });
    }

    private void showMessage(String msg){
        Snackbar.make(binding.getRoot(),msg,Snackbar.LENGTH_SHORT).show();
    }

    private boolean validateEmployee(){
        if(binding.etEmployeeId.getText().toString().equals("")){
            showMessage("Please provide the employee ID to continue.");
            return false;
        } else if(binding.etFirstName.getText().toString().equals("")){
            showMessage("Please provide the first name to continue.");
            return false;
        } else if(binding.etLastName.getText().toString().equals("")){
            showMessage("Please provide the last name to continue.");
            return false;
        } else if(binding.etBirthYear.getText().toString().equals("")){
            showMessage("Please provide the birth year to continue.");
            return false;
        } else if(binding.etMonthlySalary.getText().toString().equals("")){
            showMessage("Please provide the monthly salary to continue.");
            return false;
        } else if(binding.etRate.getText().toString().equals("")){
            showMessage("Please provide the occupation rate to continue.");
            return false;
        } else if(binding.spnEmployeeType.getSelectedItemPosition() == 0){
            showMessage("Please choose the employee type to continue.");
            return false;
        } else if(binding.spnEmployeeType.getSelectedItemPosition() == 1 && binding.etClients.getText().toString().equals("")){
            showMessage("Please provide the number of client to continue.");
            return false;
        } else if(binding.spnEmployeeType.getSelectedItemPosition() == 1 && binding.etTravelDays.getText().toString().equals("")){
            showMessage("Please provide the number of travel days to continue.");
            return false;
        } else if(binding.spnEmployeeType.getSelectedItemPosition() == 2 && binding.etProjects.getText().toString().equals("")){
            showMessage("Please provide the number of project to continue.");
            return false;
        } else if(binding.spnEmployeeType.getSelectedItemPosition() == 3 && binding.etBugs.getText().toString().equals("")){
            showMessage("Please provide the number of bug to continue.");
            return false;
        } else if(binding.radioGroup.getCheckedRadioButtonId() == -1){
            showMessage("Please choose the vehicle to continue.");
            return false;
        } else if(binding.rdCar.isChecked() && binding.etCarType.getText().toString().equals("")){
            showMessage("Please provide the car type to continue.");
            return false;
        } else if(binding.etVehicleModel.getText().toString().equals("")){
            showMessage("Please choose the vehicle model to continue.");
            return false;
        } else if(binding.etPlateNumber.getText().toString().equals("")){
            showMessage("Please choose the vehicle plate number to continue.");
            return false;
        } else if(binding.spnVehicleColor.getSelectedItemPosition() == 0){
            showMessage("Please choose the vehicle color to continue.");
            return false;
        } else {
            return true;
        }
    }

    public void clear(){
        binding.etEmployeeId.setText("");
        binding.etFirstName.setText("");
        binding.etLastName.setText("");
        binding.etBirthYear.setText("");
        binding.etMonthlySalary.setText("");
        binding.etRate.setText("");
        binding.etBugs.setText("");
        binding.etProjects.setText("");
        binding.etClients.setText("");
        binding.etTravelDays.setText("");
        binding.etCarType.setText("");
        binding.etVehicleModel.setText("");
        binding.etPlateNumber.setText("");
        binding.spnVehicleColor.setSelection(0);
        binding.spnEmployeeType.setSelection(0);
        binding.rdNo.setChecked(true);
        binding.radioGroup.clearCheck();
    }
}