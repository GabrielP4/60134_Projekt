package pl.wsiz.gui3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

import pl.wsiz.gui3.sortie.Sortie;
import pl.wsiz.gui3.sortie.Variant;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.ContentValues.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View myView = inflater.inflate(R.layout.fragment_second, container, false);
        final TextView textViewBoss = myView.findViewById(R.id.text_view_boss);
        final TextView textViewExpiry = myView.findViewById(R.id.text_view_expiry);
        final TextView textViewFaction = myView.findViewById(R.id.text_view_faction);
        final TextView textViewRewardPool = myView.findViewById(R.id.text_view_reard_pool);

        final TextView textView = myView.findViewById(R.id.text_view_result);


        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.warframestat.us/pc/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPH jsonPH=retrofit.create(JsonPH.class);

        Call<Sortie> call = jsonPH.getSortie();

        call.enqueue(new Callback<Sortie>() {
            @Override
            public void onResponse(Call<Sortie> call, Response<Sortie> response) {

                ArrayList<Variant> variantsList = response.body().getVariants();

                String TVBoss = "Boss: " +"\n"+ response.body().getBoss();
                String TVExpiry = "Expiry: " + DateFormat.getDateTimeInstance().format(response.body().getExpiry());
                String TVFaction = "Faction: " + response.body().getFaction();
                String TVRewardPool = "Reward pool: " +"\n"+ response.body().getRewardPool();


                textViewBoss.append(TVBoss);
                textViewExpiry.append(TVExpiry);
                textViewFaction.append(TVFaction);
                textViewRewardPool.append(TVRewardPool);

                String content="";
                for (int i = 0; i<variantsList.size();i++){

                    content ="Stage: "+ (i+1) +"\n"+
                             "Mission type: " + variantsList.get(i).getMissionType()+"\n"
                                + "Node: " + variantsList.get(i).getNode()+"\n"
                                +"Modifier: "+"\n"
                            + variantsList.get(i).getModifier()+"\n"
                                +"Modifier description: " +"\n"
                            + variantsList.get(i).getModifierDescription()+"\n"+"\n";

                    textView.append(content);

                }

            }

            @Override
            public void onFailure(Call<Sortie> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });


        return myView;


    }
}
