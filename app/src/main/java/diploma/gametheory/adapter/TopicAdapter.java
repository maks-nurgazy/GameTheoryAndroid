package diploma.gametheory.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

import diploma.gametheory.R;
import diploma.gametheory.models.Title;
import diploma.gametheory.holders.TitleViewHolder;
import diploma.gametheory.models.Topic;
import diploma.gametheory.holders.TopicViewHolder;

public class TopicAdapter extends ExpandableRecyclerViewAdapter<TitleViewHolder, TopicViewHolder> {
    public TopicAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }
    @Override
    public TitleViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.expandable_recyclerview_title,
                parent,false);
        return new TitleViewHolder(v);
    }

    @Override
    public TopicViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.expandable_recyclerview_topic,
                parent,false);
        return new TopicViewHolder(v);
    }

    @Override
    public void onBindChildViewHolder(TopicViewHolder holder, int flatPosition, ExpandableGroup group,
                                      int childIndex) {
        final Topic topic = (Topic) group.getItems().get(childIndex);
        holder.bind(topic);
    }

    @Override
    public void onBindGroupViewHolder(TitleViewHolder holder, int flatPosition, ExpandableGroup group) {
        final Title title = (Title) group;
        holder.bind(title);
    }
}
