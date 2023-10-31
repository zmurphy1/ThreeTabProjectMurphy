package css.cis3334.project;

import android.content.ContentValues;

public class Workout {
    private int id;
    private String type;
    private String muscle;

    public Workout(int id, String type, String muscle) {
        this.id = id;
        this.type = type;
        this.muscle = muscle;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMuscle() {
        return muscle;
    }

    public void setMuscle(String muscle) {
        this.muscle = muscle;
    }
    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_TYPE, this.type);
        values.put(DatabaseHelper.COLUMN_MUSCLE, this.muscle);
        return values;
    }
}
