package pl.wsiz.gui3;

import java.util.List;

import pl.wsiz.gui3.sortie.Sortie;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface JsonPH {
    @GET("fissures")
    Call<List<Fissures>> getPosts();

    @GET("dailyDeals")
    Call<List<FlashSales>> getFlashSales();

    @Headers("Content-Type: application/json")
    @GET("sortie")
    Call<Sortie> getSortie();
}
