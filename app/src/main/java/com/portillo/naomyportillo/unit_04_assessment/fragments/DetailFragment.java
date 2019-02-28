package com.portillo.naomyportillo.unit_04_assessment.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.portillo.naomyportillo.unit_04_assessment.R;
import com.portillo.naomyportillo.unit_04_assessment.recyclerview.AnimalHolder;
import com.squareup.picasso.Picasso;

import java.util.HashMap;


public class DetailFragment extends Fragment {

    private static String animalTitle;
    private static String animalImg;
    private static String animalWiki;

    private ImageView detailImageView;
    private TextView detailTextview;
    private Button detailButton;

    private OnFragmentInteractionListener interactionListener;

    public DetailFragment() {
    }

    public static DetailFragment newInstance(HashMap animalDetails) {
        DetailFragment fragment = new DetailFragment();
        animalTitle = (String) animalDetails.get(AnimalHolder.ANIMALTITLE);
        animalImg = (String) animalDetails.get(AnimalHolder.ANIMALIMAGE);
        animalWiki = (String) animalDetails.get(AnimalHolder.ANIMALWIKI);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void onButtonPressed(String url) {
        if (interactionListener != null) {
            interactionListener.onFragmentInteraction(url);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            interactionListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        detailImageView = view.findViewById(R.id.detail_imageview);
        detailTextview = view.findViewById(R.id.detail_title_textview);
        detailButton = view.findViewById(R.id.detail_button);

        detailTextview.setText(animalTitle);
        Picasso.get().load(animalImg).into(detailImageView);
        detailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonPressed(animalWiki);
            }
        });
    }

    @Override
    public void onDetach() {
        super.onDetach();
        interactionListener = null;
    }
}
