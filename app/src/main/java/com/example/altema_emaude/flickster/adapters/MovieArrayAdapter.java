package com.example.altema_emaude.flickster.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.example.altema_emaude.flickster.models.Movies;

import java.util.List;

public class MovieArrayAdapter extends ArrayAdapter<Movies> {
    public MovieArrayAdapter(Context context, List<Movies> movies){
        super(context, android.R.layout.simple_expandable_list_item_1, movies);
    }
}
