package css.cis3334.project;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import css.cis3334.project.databinding.FragmentDashboardBinding;

public class FragmentDashboard extends Fragment {

    private FragmentDashboardBinding binding;
    private MainViewModel viewModel;
    CheckBox checkBoxWorkouts;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //DashboardViewModel dashboardViewModel =  new ViewModelProvider(this).get(DashboardViewModel.class);
        // Use the shared ViewModel
        viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textDashboard;
        viewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        checkBoxWorkouts = checkBoxWorkouts.findViewById(R.id.checkBoxWorkouts);
        setCheckBoxWorkouts();
        return root;
    }

    public boolean setCheckBoxWorkouts(){
        if(checkBoxWorkouts.isChecked()){
            return true;
        }
        else{
            return false;
        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}