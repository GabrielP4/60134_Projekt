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
public class FirstFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_first, container, false);

        final TextView textView =  myView.findViewById(R.id.text_view_result);

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.warframestat.us/pc/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPH jsonPH=retrofit.create(JsonPH.class);

        Call<List<Fissures>> call = jsonPH.getPosts();

        call.enqueue(new Callback<List<Fissures>>() {
            @Override
            public void onResponse(Call<List<Fissures>> call, Response<List<Fissures>> response) {
                if (!response.isSuccessful()){
                    textView.setText("Code: "+response.code());
                    return;
                }
                int i = 1;
                List<Fissures> posts=response.body();
                for (Fissures post:posts){
                    String content = "";
                    content+="Fissure number: " + (i++) +"\n";
                    content += "Expiry: " + DateFormat.getDateTimeInstance().format(post.getExpiry()) + "\n";
                    content += "Tier: " + post.getTierNum() + "  " + post.getTier() + "\n";
                    content += "Mission type: " + post.getMissionType() + "\n";
                    content += "Enemy: " + post.getEnemy() + "\n";
                    content += "Node: " + post.getNode() + "\n\n";

                    textView.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Fissures>> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });

        return myView;
    }
}
