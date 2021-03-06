package de.inces.nearcon.app.overview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import de.inces.nearcon.R;
import de.inces.nearcon.core.model.events.Event;
import de.inces.nearcon.app.util.DynamicResources;

public class EventAdapter extends ArrayAdapter<Event> {

    private DynamicResources dynamicResources;

    public EventAdapter(Context context) {
        super(context, 0);
        this.dynamicResources = new DynamicResources(this.getContext());
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Event event = this.getItem(position);
        if (view == null) {
            view = LayoutInflater.from(this.getContext()).inflate(R.layout.item_event, parent, false);
        }
        ImageView imgIcon = (ImageView) view.findViewById(R.id.img_icon);
        TextView txtDescription = (TextView) view.findViewById(R.id.txt_description);
        txtDescription.setText(event.getDescription());
        imgIcon.setImageResource(this.dynamicResources.findDrawableByName(event.getIcon().getId()));
        return view;
    }

}
