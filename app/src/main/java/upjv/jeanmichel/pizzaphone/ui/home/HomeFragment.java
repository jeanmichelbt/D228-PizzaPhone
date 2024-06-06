package upjv.jeanmichel.pizzaphone.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
import upjv.jeanmichel.pizzaphone.R;
import upjv.jeanmichel.pizzaphone.adapters.HomeHorAdapter;
import upjv.jeanmichel.pizzaphone.adapters.HomeVerAdapter;
import upjv.jeanmichel.pizzaphone.databinding.FragmentHomeBinding;
import upjv.jeanmichel.pizzaphone.models.HomeHorModel;
import upjv.jeanmichel.pizzaphone.models.HomeVerModel;

public class HomeFragment extends Fragment {
    RecyclerView homeHorizontalRec, homeVerticalRec;
    List<HomeHorModel> homeHorModelList;
    HomeHorAdapter homeHorAdapter;
    List<HomeVerModel> homeVerModelList;
    HomeVerAdapter homeVerAdapter;
    private FragmentHomeBinding binding;
    RequestQueue requestQueue;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        homeHorizontalRec = root.findViewById(R.id.home_hor_rec);
        homeVerticalRec = root.findViewById(R.id.home_ver_rec);

        homeHorModelList = new ArrayList<>();
        homeHorModelList.add(new HomeHorModel(R.drawable.pizza1, "Vegetarienne"));
        homeHorModelList.add(new HomeHorModel(R.drawable.pizza2, "Regina"));
        homeHorModelList.add(new HomeHorModel(R.drawable.pizza3, "Chorizo"));
        homeHorModelList.add(new HomeHorModel(R.drawable.pizza4, "4Fromages"));
        homeHorModelList.add(new HomeHorModel(R.drawable.pizza5, "Marguerita"));
        homeHorModelList.add(new HomeHorModel(R.drawable.pizza6, "Campagne"));
        homeHorModelList.add(new HomeHorModel(R.drawable.pizza7, "Champignons"));
        homeHorModelList.add(new HomeHorModel(R.drawable.pizza8, "Poulet"));
        homeHorModelList.add(new HomeHorModel(R.drawable.pizza9, "3Fromages"));
        homeHorModelList.add(new HomeHorModel(R.drawable.pizza10, "Chevre"));

        homeHorAdapter = new HomeHorAdapter(getActivity(), homeHorModelList);
        homeHorizontalRec.setAdapter(homeHorAdapter);
        homeHorizontalRec.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        homeHorizontalRec.setHasFixedSize(true);
        homeHorizontalRec.setNestedScrollingEnabled(false);

        String url = "https://daviddurand.info/D228/pizza";
        requestQueue = Volley.newRequestQueue(this.getContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    //Retrieving Vegetarienne Pizza
                    JSONObject vegObject = response.getJSONObject("Vegetarienne");
                    //Retrieving Regina Pizza
                    JSONObject reginaObject = response.getJSONObject("Regina");
                    //Retrieving Chorizo Pizza
                    JSONObject chorizoObject = response.getJSONObject("Chorizo");
                    //Retrieving 4Fromages Pizza
                    JSONObject quatreFromagesObject = response.getJSONObject("4Fromages");
                    //Retrieving Marguerita Pizza
                    JSONObject margueritaObject = response.getJSONObject("Marguerita");
                    //Retrieving Campagne Pizza
                    JSONObject campagneObject = response.getJSONObject("Campagne");
                    //Retrieving Champignons Pizza
                    JSONObject champignonsObject = response.getJSONObject("Champignons");
                    //Retrieving Poulet Pizza
                    JSONObject pouletObject = response.getJSONObject("Poulet");
                    //Retrieving 3Fromages Pizza
                    JSONObject troisFromagesObject = response.getJSONObject("3Fromages");
                    //Retrieving Chevre Pizza
                    JSONObject chevreObject = response.getJSONObject("Chevre");

                    homeVerModelList = new ArrayList<>();
                    homeVerModelList.add(new HomeVerModel(R.drawable.pizza1, "Vegetarienne", vegObject.getDouble("prix"), vegObject.getString("ingredients")));
                    homeVerModelList.add(new HomeVerModel(R.drawable.pizza2, "Regina", reginaObject.getDouble("prix"), reginaObject.getString("ingredients")));
                    homeVerModelList.add(new HomeVerModel(R.drawable.pizza3, "Chorizo", chorizoObject.getDouble("prix"), chorizoObject.getString("ingredients")));
                    homeVerModelList.add(new HomeVerModel(R.drawable.pizza4, "4Fromages", quatreFromagesObject.getDouble("prix"), quatreFromagesObject.getString("ingredients")));
                    homeVerModelList.add(new HomeVerModel(R.drawable.pizza5, "Marguerita", margueritaObject.getDouble("prix"), margueritaObject.getString("ingredients")));
                    homeVerModelList.add(new HomeVerModel(R.drawable.pizza6, "Campagne", campagneObject.getDouble("prix"), campagneObject.getString("ingredients")));
                    homeVerModelList.add(new HomeVerModel(R.drawable.pizza7, "Champignons", champignonsObject.getDouble("prix"), champignonsObject.getString("ingredients")));
                    homeVerModelList.add(new HomeVerModel(R.drawable.pizza8, "Poulet", pouletObject.getDouble("prix"), pouletObject.getString("ingredients")));
                    homeVerModelList.add(new HomeVerModel(R.drawable.pizza9, "3Fromages", troisFromagesObject.getDouble("prix"), troisFromagesObject.getString("ingredients")));
                    homeVerModelList.add(new HomeVerModel(R.drawable.pizza10, "Chevre", chevreObject.getDouble("prix"), chevreObject.getString("ingredients")));
                    homeVerAdapter = new HomeVerAdapter(getActivity(), homeVerModelList);
                    homeVerticalRec.setAdapter(homeVerAdapter);
                    homeVerticalRec.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
                    homeVerticalRec.setHasFixedSize(true);
                    homeVerticalRec.setNestedScrollingEnabled(false);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue.add(jsonObjectRequest);
        return root;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}