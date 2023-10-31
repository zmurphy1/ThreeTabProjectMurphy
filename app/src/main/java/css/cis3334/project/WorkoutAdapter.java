package css.cis3334.project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WorkoutAdapter extends RecyclerView.Adapter<WorkoutAdapter.WorkoutViewHolder> {

    private List<Workout> workoutList;

    public WorkoutAdapter(List<Workout> workoutList) {
        this.workoutList = workoutList;
    }

    @NonNull
    @Override
    public WorkoutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_workout, parent, false);
        return new WorkoutViewHolder(view);
    }
    public void fillList(){
        int id = 0;
        String n = " ";
        String n1 = "";
        Workout w1 = new Workout(id, n , n1);
        Workout w2 = new Workout(id, n , n1);
        Workout w3 = new Workout(id, n , n1);
        Workout w4 = new Workout(id, n , n1);
        workoutList.add(w1);
        workoutList.add(w2);
        workoutList.add(w3);
        workoutList.add(w4);
    }
    @Override
    public void onBindViewHolder(@NonNull WorkoutViewHolder holder, int position) {
        Workout workout = workoutList.get(position);
        holder.bind(workout);
    }

    @Override
    public int getItemCount() {
        return workoutList.size();
    }

    public class WorkoutViewHolder extends RecyclerView.ViewHolder {
        private EditText typeEditText;
        private EditText muscleEditText;

        public WorkoutViewHolder(@NonNull View itemView) {
            super(itemView);
            typeEditText = itemView.findViewById(R.id.workoutTypeEditText);
            muscleEditText = itemView.findViewById(R.id.workoutMuscleEditText);
        }

        public void bind(Workout workout) {
            typeEditText.setText(workout.getType());
            muscleEditText.setText(workout.getMuscle());
        }
    }
}
