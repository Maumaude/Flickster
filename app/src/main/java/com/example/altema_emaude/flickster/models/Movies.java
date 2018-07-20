package com.example.altema_emaude.flickster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Movies {
    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getOrinalTitle() {
        return orinalTitle;
    }

    public String getOverview() {
        return overview;
    }

    String posterPath;
    String orinalTitle;
    String overview;
    public Movies(JSONObject jsonObject) throws JSONException{
        this.posterPath = jsonObject.getString("poster_path");
        this.orinalTitle = jsonObject.getString("original_title");
        this.overview = jsonObject.getString("overview");
    }

    public static ArrayList<Movies> fromJSONArray(JSONArray array){
        ArrayList<Movies> result = new ArrayList<>();
        for (int x = 0; x<array.length(); x++){
            try {
               result.add(new Movies (array.getJSONObject(x)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    return result;
    }

}
