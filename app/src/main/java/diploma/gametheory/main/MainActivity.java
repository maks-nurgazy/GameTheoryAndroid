package diploma.gametheory.main;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import diploma.gametheory.R;
import diploma.gametheory.listeners.BottomNavigationListener;
import diploma.gametheory.navigation.FragmentHome;

public class MainActivity extends AppCompatActivity {

    BottomNavigationListener bottomNavigationListener;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme_NoActionBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationListener = new BottomNavigationListener(getSupportFragmentManager());
        bottomNavigationView = findViewById(R.id.bottom_nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(bottomNavigationListener);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new FragmentHome()).commit();
        }
    }
}
