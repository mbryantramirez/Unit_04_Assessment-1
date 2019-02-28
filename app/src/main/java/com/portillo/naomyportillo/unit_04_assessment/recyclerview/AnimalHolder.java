package com.portillo.naomyportillo.unit_04_assessment.recyclerview;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.portillo.naomyportillo.unit_04_assessment.AnimalModel;
import com.portillo.naomyportillo.unit_04_assessment.R;
import com.portillo.naomyportillo.unit_04_assessment.SecondActivity;
import com.squareup.picasso.Picasso;

public class AnimalHolder extends RecyclerView.ViewHolder {

    public static final String ANIMALTITLE = "title";
    public static final String ANIMALIMAGE = "image";
    public static final String ANIMALWIKI = "wiki";
    private static CardView animalCardview;
    private static TextView animalTitleTextView;
    private static ImageView animalImageView;

    public AnimalHolder(@NonNull View itemView) {
        super(itemView);
        this.animalCardview = itemView.findViewById(R.id.layout_animal_cardview);
        this.animalTitleTextView = itemView.findViewById(R.id.animal_imageTitle_textView);
        this.animalImageView = itemView.findViewById(R.id.animal_imageview);
    }

    public static void onBind(final AnimalModel animalModel) {

        Picasso.get().load(animalModel.getImage()).into(animalImageView);
        animalTitleTextView.setText(animalModel.getAnimal());

        animalCardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(animalCardview.getContext(), SecondActivity.class);

                intent.putExtra(ANIMALTITLE, animalModel.getAnimal());
                intent.putExtra(ANIMALIMAGE, animalModel.getImage());
                intent.putExtra(ANIMALWIKI, animalModel.getWiki());

                animalCardview.getContext().startActivity(intent);
            }
        });

    }

}
