package upjv.jeanmichel.pizzaphone.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import upjv.jeanmichel.pizzaphone.R;
import upjv.jeanmichel.pizzaphone.adapters.HomeHorAdapter;
import upjv.jeanmichel.pizzaphone.databinding.FragmentHomeBinding;
import upjv.jeanmichel.pizzaphone.models.HomeHorModel;

public class HomeFragment extends Fragment {
    RecyclerView homeHorizontalRec;
    List<HomeHorModel> homeHorModelList;
    HomeHorAdapter homeHorAdapter;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        homeHorizontalRec = root.findViewById(R.id.home_hor_rec);

        homeHorModelList = new ArrayList<>();
        homeHorModelList.add(new HomeHorModel(R.drawable.pizza1, "Pizza 1"));
        homeHorModelList.add(new HomeHorModel(R.drawable.pizza2, "Pizza 2"));
        homeHorModelList.add(new HomeHorModel(R.drawable.pizza3, "Pizza 3"));
        homeHorModelList.add(new HomeHorModel(R.drawable.pizza4, "Pizza 4"));
        homeHorModelList.add(new HomeHorModel(R.drawable.pizza5, "Pizza 5"));

        homeHorAdapter = new HomeHorAdapter(getActivity(), homeHorModelList);
        homeHorizontalRec.setAdapter(homeHorAdapter);
        homeHorizontalRec.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        homeHorizontalRec.setHasFixedSize(true);
        homeHorizontalRec.setNestedScrollingEnabled(false);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}