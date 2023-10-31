package css.cis3334.project;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class MainViewModel extends ViewModel {
        private List<Workout> workoutList;

        public List<Workout> getWorkoutList() {
            return workoutList;
        }

        public void setWorkoutList(List<Workout> workoutList) {
            this.workoutList = workoutList;
        }
}

