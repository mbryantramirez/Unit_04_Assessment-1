package com.portillo.naomyportillo.unit_04_assessment.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.portillo.naomyportillo.unit_04_assessment.AnimalModel;
import com.portillo.naomyportillo.unit_04_assessment.R;

import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalHolder> {

    List<AnimalModel> animalModelList;

    public AnimalAdapter(List<AnimalModel> animalModelList) {
        this.animalModelList = animalModelList;
    }

    @NonNull
    @Override
    public AnimalHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View childView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itemview_recycler, viewGroup, false);
        return new AnimalHolder(childView);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalHolder animalHolder, int pos) {

        AnimalModel animalModel = animalModelList.get(pos);
        AnimalHolder.onBind(animalModel);
    }

    @Override
    public int getItemCount() {
        return animalModelList.size();
    }

}
