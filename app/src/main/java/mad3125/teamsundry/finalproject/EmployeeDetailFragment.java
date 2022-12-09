package mad3125.teamsundry.finalproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import mad3125.teamsundry.finalproject.databinding.FragmentEmployeeDetailBinding;

public class EmployeeDetailFragment extends Fragment {

    private FragmentEmployeeDetailBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentEmployeeDetailBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }
}
