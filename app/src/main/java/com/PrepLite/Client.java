package com.PrepLite;

import static com.PrepLite.app.Constants.BASE_URL;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {

    private static Retrofit retrofit = null;
    private static HttpLoggingInterceptor interceptor =
            new HttpLoggingInterceptor();
    private static OkHttpClient.Builder builder = new OkHttpClient.Builder();

    private Client(){
//     retrofit =  new Retrofit.Builder()
//                    .baseUrl(BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build();
    }

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            if (BuildConfig.DEBUG) {
                builder.addInterceptor(interceptor);
            }

            retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .client(builder.build())
                    .build();
        }
        return retrofit;
    }

//    public static synchronized Client getInstance(){
//
//        if(client == null){
//            client= new Client();
//        }
//        return  client;
//    }

//    public ApiCalls getApi(){
//        return retrofit.create(ApiCalls.class);
//    }
}
