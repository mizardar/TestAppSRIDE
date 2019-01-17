package in.mizardar.testappsride.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyClient {

    private static Retrofit retrofit = null;
    private static final String BASE_URL = "https://samples.openweathermap.org/data/2.5/";

    public static Retrofit getRetrofitClient(){

        //create a client to call services
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
