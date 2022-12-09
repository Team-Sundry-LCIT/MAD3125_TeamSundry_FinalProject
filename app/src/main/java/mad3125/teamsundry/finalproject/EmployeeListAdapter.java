package mad3125.teamsundry.finalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import mad3125.teamsundry.finalproject.Part1.Employee;
import mad3125.teamsundry.finalproject.databinding.EmployeeRowLayoutBinding;

public class EmployeeListAdapter extends ArrayAdapter {
    private Context context;
    int resLayout;
    private ArrayList<Employee> employeeList;

    public EmployeeListAdapter(@NonNull Context context, int resource, ArrayList<Employee> list) {
        super(context, resource);
        this.context = context;
        this.resLayout = resource;
        this.employeeList = list;
    }

    public void setEmployeeList(ArrayList<Employee> employeeList) {
        this.employeeList = employeeList;
        notifyDataSetChanged();
    }

    public void remove(Employee employee) {
        Employee.employeeList.remove(employee);
        employeeList.remove(employee);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return this.employeeList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.employeeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        EmployeeRowLayoutBinding binding = EmployeeRowLayoutBinding.inflate(LayoutInflater.from(context));

        binding.nameTV.setText("Name : " + this.employeeList.get(position).getName());
        binding.typeTV.setText("Position : " +this.employeeList.get(position).getClass().getSimpleName());
        binding.incomeTV.setText("Income : " +Double.toString(this.employeeList.get(position).getAnnualIncome()));
        return binding.getRoot();
    }
}
