package com.portillo.naomyportillo.unit_04_assessment;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.portillo.naomyportillo.unit_04_assessment.fragments.DetailFragment;
import com.portillo.naomyportillo.unit_04_assessment.fragments.OnFragmentInteractionListener;
import com.portillo.naomyportillo.unit_04_assessment.recyclerview.AnimalHolder;

import java.util.HashMap;

public class SecondActivity extends AppCompatActivity implements OnFragmentInteractionListener {

    HashMap<String, String> animal = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        extractIntentValues(intent);

        DetailFragment detailFragment = DetailFragment.newInstance(animal);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, detailFragment)
                .addToBackStack("detailFragment").commit();
    }

    private void extractIntentValues(Intent intent) {
        animal.put(AnimalHolder.ANIMALTITLE, intent.getStringExtra(AnimalHolder.ANIMALTITLE));
        animal.put(AnimalHolder.ANIMALIMAGE, intent.getStringExtra(AnimalHolder.ANIMALIMAGE));
        animal.put(AnimalHolder.ANIMALWIKI, intent.getStringExtra(AnimalHolder.ANIMALWIKI));
    }

    @Override
    public String onFragmentInteraction(String website) {
        Intent webpageIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(website));
        startActivity(webpageIntent);
        return website;
    }
}
