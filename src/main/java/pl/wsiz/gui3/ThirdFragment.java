package pl.wsiz.gui3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class ThirdFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_third, container, false);

        final TextView textView =  myView.findViewById(R.id.text_view_result);

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.warframestat.us/pc/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPH jsonPH=retrofit.create(JsonPH.class);

        Call<List<FlashSales>> call = jsonPH.getFlashSales();

        call.enqueue(new Callback<List<FlashSales>>() {
            @Override
            public void onResponse(Call<List<FlashSales>> call, Response<List<FlashSales>> response) {
                if (!response.isSuccessful()){
                    textView.setText("Code: "+response.code());
                    return;
                }
                String content = "";
                List<FlashSales> posts=response.body();

                for (FlashSales post:posts){

                    content = "Item name: " + post.getItem() + "\n"
                                +"Expiry: " + DateFormat.getDateTimeInstance().format(post.getExpiry()) + "\n"
                                +"Original price: "+post.getOriginalPrice().toString()+"  "
                                +"Discount: "+  post.getDiscount().toString() +"%" +"\n"
                                +"New price: " + post.getSalePrice() +"\n"
                                +"Items left: "+  (post.getTotal()-post.getSold())+"\n"
                    ;

                    textView.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<FlashSales>> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });
        return myView;
    }
}
