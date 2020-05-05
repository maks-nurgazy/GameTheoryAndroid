package diploma.gametheory.holders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

import diploma.gametheory.R;
import diploma.gametheory.courses.ActivityCourses;
import diploma.gametheory.models.Topic;
import diploma.gametheory.notes.ActivityNotes;

public class TopicViewHolder extends ChildViewHolder {
    private TextView mTextView;
    private YouTubePlayerView youTubePlayerView;
    private TextView topic_link;

    public TopicViewHolder(View itemView) {
        super(itemView);
        mTextView = itemView.findViewById(R.id.textView);
        youTubePlayerView = itemView.findViewById(R.id.youtube_player_view);
        topic_link = itemView.findViewById(R.id.topic_link);
    }

    public void bind(final Topic topic){
        mTextView.setText(topic.name);
        ActivityCourses.addObserver(youTubePlayerView);
        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = topic.video;
                youTubePlayer.loadVideo(videoId, 0f);
            }});
        topic_link.setText(topic.link);
    }
}
