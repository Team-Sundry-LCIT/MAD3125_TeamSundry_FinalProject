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
                        binding.loMotorCycleCategory.setVisibility(View.GONE);

                        binding.loCarType.setVisibility(View.VISIBLE);
                        binding.loCarCategory.setVisibility(View.VISIBLE);
                        binding.loGear.setVisibility(View.VISIBLE);
                        break;
                    case R.id.rdMotorbike:
                        binding.layoutSidecar.setVisibility(View.VISIBLE);
                        binding.loMotorCycleCategory.setVisibility(View.VISIBLE);

                        binding.loCarType.setVisibility(View.GONE);
                        binding.loCarCategory.setVisibility(View.GONE);
                        binding.loGear.setVisibility(View.GONE);
                        break;
                }
            }
        });

        binding.radioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rdPermanent:
                        binding.etHourSalary.setVisibility(View.GONE);
                        binding.etAccumulatedHours.setVisibility(View.GONE);

                        binding.etChildren.setVisibility(View.VISIBLE);
                        binding.etBonus.setVisibility(View.VISIBLE);
                        binding.etAccumulatedDays.setVisibility(View.VISIBLE);
                        binding.layoutMarried.setVisibility(View.VISIBLE);
                        break;
                    case R.id.rdTemporary:
                        binding.etHourSalary.setVisibility(View.VISIBLE);
                        binding.etAccumulatedHours.setVisibility(View.VISIBLE);

                        binding.etChildren.setVisibility(View.GONE);
                        binding.etBonus.setVisibility(View.GONE);
                        binding.etAccumulatedDays.setVisibility(View.GONE);
                        binding.layoutMarried.setVisibility(View.GONE);
                        break;
                }
            }
        });


        binding.btnAdd.setOnClickListener( v->{
            if(validateEmployee()){
                Car car = new Car(
                        binding.etVehicleModel.getText().toString(),
                        binding.etPlateNumber.getText().toString(),
                        binding.spnVehicleColor.getSelectedItem().toString(),
                        binding.spnCarCategory.getSelectedItem().toString(),
                        binding.spnGear.getSelectedItem().toString(),
                        binding.spnCarType.getSelectedItem().toString()
                );

                Motorcycle motorcycle = new Motorcycle(
                        binding.etVehicleModel.getText().toString(),
                        binding.etPlateNumber.getText().toString(),
                        binding.spnVehicleColor.getSelectedItem().toString(),
                        binding.spnMotorCycleCategory.getSelectedItem().toString(),
                        binding.radioGroup2.getCheckedRadioButtonId() == R.id.rdYes ? true : false
                );

                switch (binding.spnEmployeeType.getSelectedItemPosition()) {
                    case 1:
                        Manager manager = new Manager(
                                binding.etFirstName.getText().toString() + " " + binding.etLastName.getText().toString(),
                                Integer.parseInt(binding.etBirthYear.getText().toString()),
                                Integer.parseInt(binding.etTravelDays.getText().toString()),
                                Integer.parseInt(binding.etClients.getText().toString()),
                                Integer.parseInt(binding.etRate.getText().toString()),
                                binding.radioGroup.getCheckedRadioButtonId() == R.id.rdCar ? car : motorcycle
                        );
                        Employee.employeeList.add(manager);

//                        if(binding.radioGroup3.getCheckedRadioButtonId() == R.id.rdPermanent){
//                            Permanent p1 = new Permanent(
//                                    Integer.parseInt(binding.etChildren.getText().toString()),
//                                    binding.radioGroup4.getCheckedRadioButtonId() == R.id.rdMarried ? true : false,
//                                    Double.parseDouble(binding.etMonthlySalary.getText().toString()),
//                                    Integer.parseInt(binding.etBonus.getText().toString()),
//                                    Integer.parseInt(binding.etAccumulatedDays.getText().toString())
//                            );
//
//                            manager.signContract(p1);
//                        } else {
//                            Temporary t1 = new Temporary(
//                                    Integer.parseInt(binding.etHourSalary.getText().toString()),
//                                    Integer.parseInt(binding.etAccumulatedHours.getText().toString())
//                            );
//                            manager.signContract(t1);
//                        }
                        break;
                    case 2:
                        Programmer programmer  = new Programmer(
                                binding.etFirstName.getText().toString() + " " + binding.etLastName.getText().toString(),
                                Integer.parseInt(binding.etBirthYear.getText().toString()),
                                Integer.parseInt(binding.etProjects.getText().toString()),
                                Integer.parseInt(binding.etRate.getText().toString()),
                                binding.radioGroup.getCheckedRadioButtonId() == R.id.rdCar ? car : motorcycle
                        );
                        Employee.employeeList.add(programmer);
                        break;
                    case 3:
                        Tester tester  = new Tester(
                                binding.etFirstName.getText().toString() + " " + binding.etLastName.getText().toString(),
                                Integer.parseInt(binding.etBirthYear.getText().toString()),
                                Integer.parseInt(binding.etBugs.getText().toString()),
                                Integer.parseInt(binding.etRate.getText().toString()),
                                binding.radioGroup.getCheckedRadioButtonId() == R.id.rdCar ? car : motorcycle
                        );
                        Employee.employeeList.add(tester);
                        break;
                }

                new AlertDialog.Builder(requireContext())
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
        } else if(binding.rdCar.isChecked() && binding.spnCarType.getSelectedItemPosition() == 0){
            showMessage("Please provide the car type to continue.");
            return false;
        } else if(binding.rdCar.isChecked() && binding.spnCarCategory.getSelectedItemPosition() == 0){
            showMessage("Please provide the car category to continue.");
            return false;
        } else if(binding.rdCar.isChecked() && binding.spnGear.getSelectedItemPosition() == 0){
            showMessage("Please provide the gear of car to continue.");
            return false;
        } else if(binding.rdMotorbike.isChecked() && binding.spnMotorCycleCategory.getSelectedItemPosition() == 0){
            showMessage("Please provide the motorcycle category to continue.");
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
        } else if(binding.rdPermanent.isChecked() && binding.etChildren.getText().toString().equals("")){
            showMessage("Please provide the number of children to continue.");
            return false;
        } else if(binding.rdPermanent.isChecked() && binding.etBonus.getText().toString().equals("")){
            showMessage("Please provide the bonus of children/month of bug to continue.");
            return false;
        } else if(binding.rdPermanent.isChecked() && binding.etAccumulatedDays.getText().toString().equals("")){
            showMessage("Please provide the accumulated days to continue.");
            return false;
        } else if(binding.rdTemporary.isChecked() && binding.etHourSalary.getText().toString().equals("")){
            showMessage("Please provide the hours salary to continue.");
            return false;
        } else if(binding.rdTemporary.isChecked() && binding.etAccumulatedHours.getText().toString().equals("")){
            showMessage("Please provide the accumulated hours to continue.");
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
        binding.spnGear.setSelection(0);
        binding.spnGear.setVisibility(View.GONE);
        binding.spnMotorCycleCategory.setSelection(0);
        binding.spnMotorCycleCategory.setVisibility(View.GONE);
        binding.spnCarCategory.setSelection(0);
        binding.spnCarCategory.setVisibility(View.GONE);
        binding.spnCarType.setSelection(0);
        binding.spnCarType.setVisibility(View.GONE);
        binding.etVehicleModel.setText("");
        binding.etPlateNumber.setText("");
        binding.spnVehicleColor.setSelection(0);
        binding.spnEmployeeType.setSelection(0);
        binding.rdNo.setChecked(true);
        binding.radioGroup.clearCheck();
        binding.etChildren.setText("");
        binding.etBonus.setText("");
        binding.etAccumulatedDays.setText("");
        binding.etAccumulatedHours.setText("");
        binding.etHourSalary.setText("");
        binding.rdMarried.setChecked(true);
        binding.radioGroup3.clearCheck();

    }

}