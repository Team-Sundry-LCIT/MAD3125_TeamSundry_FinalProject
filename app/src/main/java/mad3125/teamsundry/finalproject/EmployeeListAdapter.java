package mad3125.teamsundry.finalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import mad3125.teamsundry.finalproject.Part1.Employee;
import mad3125.teamsundry.finalproject.databinding.EmployeeRowLayoutBinding;

public class EmployeeListAdapter extends ArrayAdapter {
    private Context context;
    int resLayout;

    public EmployeeListAdapter(@NonNull Context context, int resource) {
        super(context, resource);
        this.context = context;
        this.resLayout = resource;
    }

    public void remove(int position) {
        Employee.employeeList.remove(position);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return Employee.employeeList.size();
    }

    @Override
    public Object getItem(int position) {
        return Employee.employeeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        EmployeeRowLayoutBinding binding = EmployeeRowLayoutBinding.inflate(LayoutInflater.from(context));

        binding.nameTV.setText(Employee.employeeList.get(position).getName());
        binding.typeTV.setText(Employee.employeeList.get(position).getClass().getName());
        binding.incomeTV.setText(Double.toString(Employee.employeeList.get(position).getAnnualIncome()));
        return binding.getRoot();
    }
}
