package css.cis3334.project;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import css.cis3334.project.databinding.FragmentNotificationsBinding;

public class FragmentNotifications extends Fragment {
    private FragmentNotificationsBinding binding;
    private DatabaseHelper dbHelper;
    private SQLiteDatabase db;
    private RecyclerView recyclerViewWorkouts;
    private WorkoutAdapter workoutAdapter;
    private List<Workout> workoutList;
    EditText workoutTypeEditText;
    EditText workoutMuscleEditText;
    private MainViewModel viewModel;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        dbHelper = new DatabaseHelper(getContext());
        db = dbHelper.getWritableDatabase();

        recyclerViewWorkouts = root.findViewById(R.id.recyclerViewWorkouts);
        recyclerViewWorkouts.setLayoutManager(new LinearLayoutManager(getContext()));
        viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        EditText workoutTypeEditText = root.findViewById(R.id.workoutTypeEditText);
        EditText workoutMuscleEditText = root.findViewById(R.id.workoutMuscleEditText);
        workoutList = new ArrayList<>();
        workoutAdapter = new WorkoutAdapter(workoutList);
        fillWorkout();
        recyclerViewWorkouts.setAdapter(workoutAdapter);
        Button saveButton = root.findViewById(R.id.addButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveWorkouts();
            }
        });

        return root;
    }

    private void saveWorkouts() {
        String workoutType = workoutTypeEditText.getText().toString();
        String workoutMuscle = workoutMuscleEditText.getText().toString();
        int id = 0;
        Workout workout1 = new Workout(id, workoutType, workoutMuscle);
        insertWorkout(workout1);
    }
    private void fillWorkout(){
        workoutAdapter.fillList();
    }
    private void insertWorkout(Workout workout) {
        ContentValues values = workout.toContentValues();
        db.insert(DatabaseHelper.TABLE_WORKOUTS, null, values);
        workoutAdapter.notifyDataSetChanged();
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}