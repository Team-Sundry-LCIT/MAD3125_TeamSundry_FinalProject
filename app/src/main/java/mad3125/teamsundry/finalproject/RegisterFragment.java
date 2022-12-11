package mad3125.teamsundry.finalproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

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
                        binding.etProjects.setVisibility(View.GONE);
                        binding.etBugs.setVisibility(View.GONE);
                        break;
                    case 1:
                        binding.etClients.setVisibility(View.VISIBLE);
                        binding.etProjects.setVisibility(View.GONE);
                        binding.etBugs.setVisibility(View.GONE);
                        break;
                    case 2:
                        binding.etClients.setVisibility(View.GONE);
                        binding.etProjects.setVisibility(View.VISIBLE);
                        binding.etBugs.setVisibility(View.GONE);
                        break;
                    case 3:
                        binding.etClients.setVisibility(View.GONE);
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
                        binding.dtCarType.setVisibility(View.VISIBLE);
                        break;
                    case R.id.rdMotorbike:
                        binding.layoutSidecar.setVisibility(View.VISIBLE);
                        binding.dtCarType.setVisibility(View.GONE);
                        break;
                }
            }
        });


    }

    private void showMessage(String msg){
        Snackbar.make(binding.getRoot(),msg,Snackbar.LENGTH_SHORT).show();
    }


}