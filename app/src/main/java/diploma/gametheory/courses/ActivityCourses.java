package diploma.gametheory.courses;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;

import diploma.gametheory.R;
import diploma.gametheory.adapter.TopicAdapter;
import diploma.gametheory.models.Title;
import diploma.gametheory.models.Topic;

public class ActivityCourses extends AppCompatActivity {
    public static Lifecycle lifecycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);
        lifecycle = getLifecycle();

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Title> companies = new ArrayList<>();
        ArrayList<Topic> intoductionTopic = new ArrayList<>();
        intoductionTopic.add(new Topic("Course Content", "MknV3t5QbUc", "Course Link"));

        Title intoduction = new Title("Introduction", intoductionTopic);
        companies.add(intoduction);

        ArrayList<Topic> lessonTopic = new ArrayList<>();
        lessonTopic.add(new Topic("Second Content", "Second video", "Second link"));

        Title microsoft = new Title("Second Title", lessonTopic);
        companies.add(microsoft);


        ArrayList<Topic> lessonTopic2 = new ArrayList<>();
        lessonTopic2.add(new Topic("Second Content2", "eK0NzsGRceg", "Second link2"));

        Title microsoft2 = new Title("Second Title2", lessonTopic2);
        companies.add(microsoft2);


        ArrayList<Topic> lessonTopic3 = new ArrayList<>();
        lessonTopic3.add(new Topic("Second Content3", "UHwVyplU3Pg", "Second link3"));

        Title microsoft3 = new Title("Second Title3", lessonTopic3);
        companies.add(microsoft3);

        ArrayList<Topic> lessonTopic4 = new ArrayList<>();
        lessonTopic4.add(new Topic("Second Content4", "H0-WkpmTPrM", "Second link4"));

        Title microsoft4 = new Title("Second Title4", lessonTopic4);
        companies.add(microsoft4);

        ArrayList<Topic> lessonTopic5 = new ArrayList<>();
        lessonTopic5.add(new Topic("Second Conten5t", "foVMwJtlR5s", "Second link5"));

        Title microsoft5 = new Title("Second Title5", lessonTopic5);
        companies.add(microsoft5);

        TopicAdapter adapter = new TopicAdapter(companies);
        recyclerView.setAdapter(adapter);

    }

    public static void addObserver(YouTubePlayerView youTubePlayerView) {
        lifecycle.addObserver(youTubePlayerView);
    }

}
