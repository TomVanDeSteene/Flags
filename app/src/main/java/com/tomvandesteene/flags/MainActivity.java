package com.tomvandesteene.flags;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String[] COUNTRIES = {
            "Argentine",
            "Belgium",
            "Brazil",
            "Canada",
            "France",
            "Germany",
            "India",
            "Italy",
            "Netherlands",
            "Norway",
            "Portugal",
            "Russia",
            "Spain",
            "Ukrain",
            "United States",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridLayout layout = (GridLayout)findViewById(R.id.activity_main);

        for (String name : COUNTRIES){
            addFlag(name, layout);
        }
    }

    // countryName = "United States"
    private void addFlag(String countryName, GridLayout layout){
        View flag = getLayoutInflater().inflate(R.layout.flag, /* parent */ null);

        TextView tv = (TextView)flag.findViewById(R.id.flag_text);
        tv.setText(countryName);

        countryName = countryName.replace(" ", "").toLowerCase();

        //R.drawable.United States
        //R.drawable.unitedstates
        int flagImageID = getResources().getIdentifier(countryName, "drawable", getPackageName());

        ImageView img = (ImageView)flag.findViewById(R.id.flag_image);
        img.setImageResource(flagImageID);

        layout.addView(flag);

        // "Brazil => R.drawable.brazil (int)
    }
}
