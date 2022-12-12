package mad3125.teamsundry.finalproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import mad3125.teamsundry.finalproject.databinding.ItemOptionsBinding;

public class BsItemOptions extends BottomSheetDialogFragment {

    ItemOptionsBinding binding;

    interface ActionProvider{
        void view();
        void edit();
        void delete();
    }
    ActionProvider provider;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = ItemOptionsBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        binding.viewDetail.setOnClickListener(v ->{
            provider.view();
            dismiss();
        });
        binding.editDetail.setOnClickListener(v ->{
            provider.edit();
            dismiss();
        });
        binding.deleteDetail.setOnClickListener(v ->{
            provider.delete();
            dismiss();
        });
    }
}
