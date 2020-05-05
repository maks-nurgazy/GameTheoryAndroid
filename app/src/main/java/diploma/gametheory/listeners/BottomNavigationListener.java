package diploma.gametheory.listeners;

import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import diploma.gametheory.R;
import diploma.gametheory.navigation.FragmentFind;
import diploma.gametheory.navigation.FragmentHome;
import diploma.gametheory.navigation.FragmentOffer;

public class BottomNavigationListener implements BottomNavigationView.OnNavigationItemSelectedListener {
    private FragmentManager fragmentManager;

    public BottomNavigationListener(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment select = null;
        switch (item.getItemId()) {
            case R.id.find_nav:
                select = new FragmentFind();
                break;
            case R.id.offer_nav:
                select = new FragmentOffer();
                break;
            default:
                select = new FragmentHome();
        }
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, select)
                .commit();
        return true;
    }
}
