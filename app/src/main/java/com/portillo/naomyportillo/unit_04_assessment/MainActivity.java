package com.portillo.naomyportillo.unit_04_assessment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.portillo.naomyportillo.unit_04_assessment.recyclerview.AnimalAdapter;
import com.portillo.naomyportillo.unit_04_assessment.retrofit.RetrofitList;
import com.portillo.naomyportillo.unit_04_assessment.retrofit.RetrofitService;
import com.portillo.naomyportillo.unit_04_assessment.retrofit.RetrofitSingleton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = ".MainActivity" ;
    List<AnimalModel> animalModelList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view_container);
        retrofitCall();
    }

    private void retrofitCall(){
        Retrofit retrofit = RetrofitSingleton.getInstance();
        RetrofitService animalService= retrofit.create(RetrofitService.class);
        Call<RetrofitList> animalCall = animalService.getList();
        animalCall.enqueue(new Callback<RetrofitList>() {
            @Override
            public void onResponse(Call<RetrofitList> call, Response<RetrofitList> response) {
                animalModelList = response.body().getMessage();
                Log.d(TAG, "Nummy - This retrofit call was successful" + response.body().toString());
                Log.d(TAG, "Nummy - " + response.body().getMessage().toString());

                rvSetup();
            }
            @Override
            public void onFailure(Call<RetrofitList> call, Throwable t) {
                Log.d(TAG, "Nummy - On Failure, This retrofit call was not successful" + t.getMessage());
            }
        });
    }

    private void rvSetup() {
        recyclerView.setAdapter(new AnimalAdapter(animalModelList));
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

}
