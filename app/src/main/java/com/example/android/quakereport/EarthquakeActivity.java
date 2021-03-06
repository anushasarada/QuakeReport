/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        /*// Create a fake list of earthquake locations.
        ArrayList<Earthquake> earthquakes = new ArrayList<Earthquake>();
        earthquakes.add(new Earthquake("8.9","San Francisco","Mar 6,2010"));
        earthquakes.add(new Earthquake("4.5","London","Mar 6,2010"));
        earthquakes.add(new Earthquake("2.8","Tokyo","Mar 6,2010"));
        earthquakes.add(new Earthquake("3.2","Mexico City","Mar 6,2010"));
        earthquakes.add(new Earthquake("4.8","Moscow","Mar 6,2010"));
        earthquakes.add(new Earthquake("8.9","Rio de Janeiro","Mar 6,2010"));
        earthquakes.add(new Earthquake("8.9","Paris","Mar 6,2010"));*/

        // Create a fake list of earthquake locations.
        ArrayList<Earthquake> earthquakes = QueryUtils.extractEarthquakes();


        // Create a new {@link ArrayAdapter} of earthquakes
        final EarthquakeAdapter earthquakeAdapter = new EarthquakeAdapter(this,earthquakes);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);
        earthquakeListView.setAdapter(earthquakeAdapter);

        earthquakeListView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                // Find the current earthquake that was clicked on
                Earthquake currentEarthquake = earthquakeAdapter.getItem(position);

                // Convert the String URL into a URI object (to pass into the Intent constructor)
                Uri earthquakeUri = Uri.parse(currentEarthquake.getUrl());

                // Create a new intent to view the earthquake URI
                Intent intent = new Intent(Intent.ACTION_VIEW, earthquakeUri);

                // Send the intent to launch a new activity
                startActivity(intent);

            }
        });
    }
}
