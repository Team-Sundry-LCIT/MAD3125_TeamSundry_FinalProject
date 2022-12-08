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

public class EmployeeListAdapter extends ArrayAdapter {
    private Context context;
    int resLayout;

    public EmployeeListAdapter(@NonNull Context context, int resource) {
        super(context, resource);
        this.context = context;
        this.resLayout = resource;
    }

    @Override
    public int getCount() {
        return Employee.employeeList.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

    }
}
