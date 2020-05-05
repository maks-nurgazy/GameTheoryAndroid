package diploma.gametheory.notes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import diploma.gametheory.R;
import diploma.gametheory.adapter.MemoriesAdapter;
import diploma.gametheory.databases.DbHelperMemory;


public class ActivityNotes extends AppCompatActivity {
    private DbHelperMemory dbHelper;
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        this.gridView = (GridView) findViewById(R.id.activity_main_grid_view);
        this.dbHelper = new DbHelperMemory(this);
        this.gridView.setAdapter(new MemoriesAdapter(this, this.dbHelper.readAllMemories(), false));
        this.gridView.setEmptyView(findViewById(R.id.activity_main_empty_view));
    }

    @Override
    protected void onResume() {
        super.onResume();
        ((CursorAdapter) gridView.getAdapter()).swapCursor(this.dbHelper.readAllMemories());
    }

    public void addNewMemory(View view) {
        Intent intent = new Intent(this, ActivityNewMemory.class);
        startActivity(intent);
    }
}
