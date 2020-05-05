package diploma.gametheory.navigation;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import diploma.gametheory.R;
import diploma.gametheory.books.ActivityBooks;
import diploma.gametheory.courses.ActivityCourses;
import diploma.gametheory.notes.ActivityNotes;
import diploma.gametheory.quizzes.ActivityQuizzes;
import diploma.gametheory.userdetails.UserDetails;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHome extends Fragment {

    public FragmentHome() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        CardView menuCourses = v.findViewById(R.id.menu_courses);
        CardView menuBooks = v.findViewById(R.id.menu_books);
        CardView menuNotes = v.findViewById(R.id.menu_notes);
        CardView menuQuizzes = v.findViewById(R.id.menu_quizzes);
        TextView username = v.findViewById(R.id.tvUsername);
        TextView tvRole = v.findViewById(R.id.tvRole);
        username.setText(UserDetails.username);
        tvRole.setText(UserDetails.status);


        menuCourses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePage(ActivityCourses.class);
            }
        });
        menuQuizzes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePage(ActivityQuizzes.class);
            }
        });
        menuBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePage(ActivityBooks.class);
            }
        });
        menuNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePage(ActivityNotes.class);
            }
        });
        return v;
    }
    private void changePage(Class page) {
        Intent intent = new Intent(getActivity(), page);
        startActivity(intent);
    }
}
