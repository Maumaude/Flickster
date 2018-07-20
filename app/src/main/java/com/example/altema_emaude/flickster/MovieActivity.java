package com.example.altema_emaude.flickster;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.example.altema_emaude.flickster.adapters.MovieArrayAdapter;
import com.example.altema_emaude.flickster.models.Movies;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class VideoActivity extends AppCompatActivity {
    ArrayList<Movies> movies;
    MovieArrayAdapter movieAdapter;
    ListView lvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);


                    lvItems = findViewById(R.id.lvMovies);
                    movies =  new ArrayList<>();
                    movieAdapter = new MovieArrayAdapter(this, movies);
                    lvItems.setAdapter(movieAdapter);

                    String url = " https://api.themoviedb.org/3/movie/now_playing?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed";

                        AsyncHttpClient client = new AsyncHttpClient();

                        client.get(url, new JsonHttpResponseHandler(){


                        @Override
                            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                               // super.onSuccess(statusCode, headers, response);
                                JSONArray movieJsonResult = null;
                                try {
                                    movieJsonResult = response.getJSONArray("results");
                                    movies.addAll(Movies.fromJSONArray(movieJsonResult));
                                    movieAdapter.notifyDataSetChanged();
                                    Log.d("DEBUG", movies.toString());


                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                                super.onFailure(statusCode, headers, responseString, throwable);
                            }
                        });
                    }
                }