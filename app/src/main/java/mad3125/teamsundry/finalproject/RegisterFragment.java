package mad3125.teamsundry.finalproject;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import mad3125.teamsundry.finalproject.Part1.Employee;
import mad3125.teamsundry.finalproject.Part1.Manager;
import mad3125.teamsundry.finalproject.Part1.Programmer;
import mad3125.teamsundry.finalproject.Part1.Tester;
import mad3125.teamsundry.finalproject.Part2.Car;
import mad3125.teamsundry.finalproject.Part2.Motorcycle;

import com.google.android.material.snackbar.Snackbar;

import mad3125.teamsundry.finalproject.Part3.EmployeeContract;
import mad3125.teamsundry.finalproject.Part3.Permanent;
import mad3125.teamsundry.finalproject.Part3.Temporary;
import mad3125.teamsundry.finalproject.databinding.FragmentRegisterBinding;

public class RegisterFragment extends Fragment {
    private FragmentRegisterBinding binding;

    private @Nullable Employee employee;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        try{
            employee = (Employee) getArguments().getSerializable("data");
        }
        catch (Exception e){
            employee = null;
        }



        binding.etEmployeeId.setText(String.valueOf(
                Employee.employeeList.size() + 1
        ));

        binding.spnEmployeeType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                switch (position) {
                    case 0:
                        binding.tilClients.setVisibility(View.GONE);
                        binding.tilTravelDays.setVisibility(View.GONE);
                        binding.tilProjects.setVisibility(View.GONE);
                        binding.tilBugs.setVisibility(View.GONE);
                        break;
                    case 1:
                        binding.tilClients.setVisibility(View.VISIBLE);
                        binding.tilTravelDays.setVisibility(View.VISIBLE);
                        binding.tilProjects.setVisibility(View.GONE);
                        binding.tilBugs.setVisibility(View.GONE);
                        break;
                    case 2:
                        binding.tilClients.setVisibility(View.GONE);
                        binding.tilTravelDays.setVisibility(View.GONE);
                        binding.tilProjects.setVisibility(View.VISIBLE);
                        binding.tilBugs.setVisibility(View.GONE);
                        break;
                    case 3:
                        binding.tilClients.setVisibility(View.GONE);
                        binding.tilTravelDays.setVisibility(View.GONE);
                        binding.tilProjects.setVisibility(View.GONE);
                        binding.tilBugs.setVisibility(View.VISIBLE);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }

        });

        binding.radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
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
        });

        binding.radioGroup3.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.rdPermanent:
                    binding.tilHourSalary.setVisibility(View.GONE);
                    binding.tilAccumulatedHours.setVisibility(View.GONE);

                    binding.tilMonthlySalary.setVisibility(View.VISIBLE);
                    binding.tilChildren.setVisibility(View.VISIBLE);
                    binding.tilBonus.setVisibility(View.VISIBLE);
                    binding.tilAccumulatedDays.setVisibility(View.VISIBLE);
                    binding.layoutMarried.setVisibility(View.VISIBLE);
                    break;
                case R.id.rdTemporary:
                    binding.tilHourSalary.setVisibility(View.VISIBLE);
                    binding.tilAccumulatedHours.setVisibility(View.VISIBLE);

                    binding.tilMonthlySalary.setVisibility(View.GONE);
                    binding.tilChildren.setVisibility(View.GONE);
                    binding.tilBonus.setVisibility(View.GONE);
                    binding.tilAccumulatedDays.setVisibility(View.GONE);
                    binding.layoutMarried.setVisibility(View.GONE);
                    break;
            }
        });


        binding.btnAdd.setOnClickListener( v->{
            if(validateEmployee()) {
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

                Employee newEmployee;
                EmployeeContract contract;

                if (binding.radioGroup3.getCheckedRadioButtonId() == R.id.rdPermanent) {
                    contract= new Permanent(
                            Integer.parseInt(binding.etChildren.getText().toString()),
                            binding.radioGroup4.getCheckedRadioButtonId() == R.id.rdMarried ? true : false,
                            Double.parseDouble(binding.etMonthlySalary.getText().toString()),
                            Integer.parseInt(binding.etBonus.getText().toString()),
                            Integer.parseInt(binding.etAccumulatedDays.getText().toString())
                    );
                } else {
                    contract = new Temporary(
                            Integer.parseInt(binding.etHourSalary.getText().toString()),
                            Integer.parseInt(binding.etAccumulatedHours.getText().toString())
                    );
                }

                switch (binding.spnEmployeeType.getSelectedItemPosition()) {
                    case 1:
                        newEmployee = new Manager(
                                binding.etFirstName.getText().toString() + " " + binding.etLastName.getText().toString(),
                                Integer.parseInt(binding.etBirthYear.getText().toString()),
                                Integer.parseInt(binding.etTravelDays.getText().toString()),
                                Integer.parseInt(binding.etClients.getText().toString()),
                                Integer.parseInt(binding.etRate.getText().toString()),
                                binding.radioGroup.getCheckedRadioButtonId() == R.id.rdCar ? car : motorcycle
                        );
                        break;
                    case 2:
                        newEmployee  = new Programmer(
                                binding.etFirstName.getText().toString() + " " + binding.etLastName.getText().toString(),
                                Integer.parseInt(binding.etBirthYear.getText().toString()),
                                Integer.parseInt(binding.etProjects.getText().toString()),
                                Integer.parseInt(binding.etRate.getText().toString()),
                                binding.radioGroup.getCheckedRadioButtonId() == R.id.rdCar ? car : motorcycle
                        );
                        break;
                    default:
                        newEmployee = new Tester(
                                binding.etFirstName.getText().toString() + " " + binding.etLastName.getText().toString(),
                                Integer.parseInt(binding.etBirthYear.getText().toString()),
                                Integer.parseInt(binding.etBugs.getText().toString()),
                                Integer.parseInt(binding.etRate.getText().toString()),
                                binding.radioGroup.getCheckedRadioButtonId() == R.id.rdCar ? car : motorcycle
                        );
                        break;
                }

                newEmployee.signContract(contract);

                if(employee == null){
                    Employee.employeeList.add(newEmployee);

                    new AlertDialog.Builder(requireContext())
                            .setPositiveButton("View employees", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Navigation.findNavController(requireActivity(),R.id.fragmentContainer).popBackStack();
                                }
                            })
                            .setTitle("Employee registration successful!")
                            .setNegativeButton("Add new", (dialog, which) -> clear())
                            .setCancelable(false)
                            .create()
                            .show();
                }
                else{
                    Employee.employeeList.set(employee.getEmployeeID(),newEmployee);
                    Snackbar.make(binding.getRoot(),"Edited Successfully",Snackbar.LENGTH_SHORT).show();
                    Navigation.findNavController(requireActivity(),R.id.fragmentContainer).popBackStack();
                }


            }
        });

        if(employee != null){
            binding.textView.setText("Edit Detail");
            showUserData(employee);
        }
    }

    private void showUserData(Employee model){
        binding.btnAdd.setText("Update");

        binding.tilID.setEnabled(false);
        binding.etEmployeeId.setText(
                String.valueOf(model.getEmployeeID()+1)
        );
        String[] name = model.getName().split(" ");
        binding.etFirstName.setText(name[0]);
        binding.etLastName.setText(name[1]);
        binding.etBirthYear.setText(String.valueOf(model.getBirthYear()));

        binding.etRate.setText(String.valueOf(model.getRate()));

        String myType = model.getClass().getSimpleName();
        String p = Programmer.class.getSimpleName();
        String m = Manager.class.getSimpleName();
        String t = Tester.class.getSimpleName();

        //is a Manager
        if(myType.equals(m)){
            binding.spnEmployeeType.setSelection(1);
            binding.etClients.setText(
                    String.valueOf(((Manager) model).getClients())
            );
            binding.etTravelDays.setText(
                    String.valueOf(((Manager) model).getTravelDays())
            );
        }
        //is a Programmer
        else if(myType.equals(p)){
            binding.spnEmployeeType.setSelection(2);
            binding.etProjects.setText(
                    String.valueOf(((Programmer) model).getProjects())
            );
        }
        //is a Tester
        else{
            binding.spnEmployeeType.setSelection(3);
            binding.etBugs.setText(
                    String.valueOf(((Tester) model).getBugs())
            );
        }

        String vehicleType = model.getVehicle().getClass().getSimpleName();
        String bike = Motorcycle.class.getSimpleName();
        String car = Car.class.getSimpleName();
        //is a Bike
        if(vehicleType.equals(bike)){
            binding.rdMotorbike.setChecked(true);

            binding.rdYes.setChecked(((Motorcycle)model.getVehicle()).getSideCar());

            String myCategory = model.getVehicle().getCategory();
            String[] options = requireContext().getResources().getStringArray(R.array.motorbikeCategories);
            for(int i = 0;i< options.length;i++){
                if(options[i].equals(myCategory)){
                    binding.spnMotorCycleCategory.setSelection(i);
                    break;
                }
            }

        }
        //is a Car
        else{
            binding.rdCar.setChecked(true);

            String carType = ((Car)model.getVehicle()).getType();
            String[] typeOptions = requireContext().getResources().getStringArray(R.array.carTypes);
            for(int i = 0;i< typeOptions.length;i++){
                if(typeOptions[i].equals(carType)){
                    binding.spnCarType.setSelection(i);
                    break;
                }
            }

            String myCategory = model.getVehicle().getCategory();
            String[] options = requireContext().getResources().getStringArray(R.array.carCategories);
            for(int i = 0;i< options.length;i++){
                if(options[i].equals(myCategory)){
                    binding.spnCarCategory.setSelection(i);
                    break;
                }
            }

            String gear = ((Car)model.getVehicle()).getGear();
            String[] gearOptions = requireContext().getResources().getStringArray(R.array.gears);
            for(int i = 0;i< gearOptions.length;i++){
                if(gearOptions[i].equals(gear)){
                    binding.spnGear.setSelection(i);
                    break;
                }
            }
        }
        binding.etVehicleModel.setText(model.getVehicle().getMake());
        binding.etPlateNumber.setText(model.getVehicle().getPlate());



        String myColor = model.getVehicle().getColor();
        String[] colorOptions = requireContext().getResources().getStringArray(R.array.colors);
        for(int i = 0;i< colorOptions.length;i++){
            if(colorOptions[i].equals(myColor)){
                binding.spnVehicleColor.setSelection(i);
                break;
            }
        }

        String contractType = model.getContract().getClass().getSimpleName();
        String permanent = Permanent.class.getSimpleName();
        // is permanent employee
        if(contractType.equals(permanent)){
            binding.rdPermanent.setChecked(true);

            binding.etMonthlySalary.setText(
                    String.valueOf(((Permanent) model.getContract()).getMonthlySalary())
            );

            binding.etChildren.setText(
                    String.valueOf(((Permanent) model.getContract()).getChildren())
            );
            binding.etBonus.setText(
                    String.valueOf(((Permanent) model.getContract()).getBonusPerChildPerMonth())
            );
            binding.etAccumulatedDays.setText(
                    String.valueOf(((Permanent) model.getContract()).getAccumulatedDays())
            );

            boolean isMarried = ((Permanent) model.getContract()).getMarried();
            if(isMarried){
                binding.rdMarried.setChecked(true);
            }
            else{
                binding.rdNotMarriedYet.setChecked(true);
            }
        }
        else{
            binding.rdTemporary.setChecked(true);
            binding.etHourSalary.setText(
                    String.valueOf(((Temporary) model.getContract()).getHourlySalary())
            );
            binding.etAccumulatedHours.setText(
                    String.valueOf(((Temporary) model.getContract()).getAccumulatedHours())
            );
        }

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
        }
        else if(binding.etRate.getText().toString().equals("")){
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
        }
        else if(binding.rdCar.isChecked() && binding.spnCarType.getSelectedItemPosition() == 0){
            showMessage("Please provide the car type to continue.");
            return false;
        }
        else if(binding.etVehicleModel.getText().toString().equals("")){
            showMessage("Please choose the vehicle model to continue.");
            return false;
        }else if(binding.rdCar.isChecked() && binding.spnCarCategory.getSelectedItemPosition() == 0){
            showMessage("Please provide the car category to continue.");
            return false;
        } else if(binding.rdCar.isChecked() && binding.spnGear.getSelectedItemPosition() == 0){
            showMessage("Please provide the gear of car to continue.");
            return false;
        }
        else if(binding.rdMotorbike.isChecked() && binding.spnMotorCycleCategory.getSelectedItemPosition() == 0){
            showMessage("Please provide the motorcycle category to continue.");
            return false;
        }  else if(binding.etPlateNumber.getText().toString().equals("")){
            showMessage("Please choose the vehicle plate number to continue.");
            return false;
        } else if(binding.spnVehicleColor.getSelectedItemPosition() == 0){
            showMessage("Please choose the vehicle color to continue.");
            return false;
        }
        else if(binding.radioGroup3.getCheckedRadioButtonId() == -1){
            showMessage("Please choose a contract.");
            return false;
        }
        else if(binding.rdPermanent.isChecked() && binding.etMonthlySalary.getText().toString().equals("")){
            showMessage("Please provide the monthly salary to continue.");
            return false;
        }else if(binding.rdPermanent.isChecked() && binding.etChildren.getText().toString().equals("")){
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
        binding.etEmployeeId.setText(
                String.valueOf(Employee.employeeList.size() + 1)
        );
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