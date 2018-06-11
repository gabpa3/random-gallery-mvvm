package com.gabcode.randomgallery_mvvm.data.source.remote;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServiceApi {

    @GET(Constant.SEARCH_INC)
    Call<ResponseApiArray> getUserProfiles();

}
