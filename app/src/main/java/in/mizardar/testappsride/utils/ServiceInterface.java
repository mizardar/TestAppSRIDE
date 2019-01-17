package in.mizardar.testappsride.utils;

import in.mizardar.testappsride.model.ModelWeather;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ServiceInterface {

    @GET("weather")
    Call<ModelWeather> getWeatherDetails(@Query("q") String cityName ,@Query("appid") String appid);
}