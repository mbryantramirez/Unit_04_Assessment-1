package com.portillo.naomyportillo.unit_04_assessment.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitService {

    String ENDPOINT = "JDVila/storybook/master/echinoderms.json";

    @GET(ENDPOINT)
    Call<RetrofitList> getList();
}
