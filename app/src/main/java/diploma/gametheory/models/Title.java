package diploma.gametheory.models;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class Title extends ExpandableGroup<Topic> {
    public Title(String title, List<Topic> items) {
        super(title, items);
    }
}
