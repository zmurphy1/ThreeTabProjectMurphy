package css.cis3334.project;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import css.cis3334.project.databinding.FragmentNotificationsBinding;

public class FragmentNotifications extends Fragment {

    private FragmentNotificationsBinding binding;
    private MainViewModel viewModel;
    private DatabaseHelper dbHelper;
    private SQLiteDatabase db;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //NotificationsViewModel notificationsViewModel =  new ViewModelProvider(this).get(NotificationsViewModel.class);
        // Use the shared ViewModel
        viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        // Set the text in the shared ViewModel. This should appear in the other fragments.
        viewModel.setText("Notification Set !!!");

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textNotifications;
        viewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        dbHelper = new DatabaseHelper(getContext());
        db = dbHelper.getWritableDatabase();
        db.close();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    private void insertWorkout(Workout workout) {
        ContentValues values = workout.toContentValues();
        db.insert(DatabaseHelper.TABLE_WORKOUTS, null, values);
    }
}