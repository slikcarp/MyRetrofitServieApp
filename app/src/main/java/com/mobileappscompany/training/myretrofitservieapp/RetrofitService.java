package com.mobileappscompany.training.myretrofitservieapp;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by User on 2/23/2017.
 */

public class RetrofitService {

    public static final class Factory {
        private static final String BASE_URL = "https://api.github.com/";
        public static Retrofit create() {
            return new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                    .build();
        }

        public static Observable<List<GitHub>> create(String user) {
            Retrofit retrofit = create();
            GitHubService service = retrofit.create(GitHubService.class);
            return service.performCall(user);
        }
    }

    public interface GitHubService {
        @GET("users/{username}/repos")
        Observable<List<GitHub>> performCall(@Path("username")String user);
    }
}
