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

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        homeHorizontalRec = root.findViewById(R.id.home_hor_rec);
        homeVerticalRec = root.findViewById(R.id.home_ver_rec);

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

        homeVerModelList = new ArrayList<>();
        homeVerModelList.add(new HomeVerModel(R.drawable.pizza1, "Pizza 1", 12.5, "Cheese"));
        homeVerModelList.add(new HomeVerModel(R.drawable.pizza2, "Pizza 2", 10.0, "Cheese"));
        homeVerModelList.add(new HomeVerModel(R.drawable.pizza3, "Pizza 3", 13.8, "Cheese"));

        homeVerAdapter = new HomeVerAdapter(getActivity(), homeVerModelList);
        homeVerticalRec.setAdapter(homeVerAdapter);
        homeVerticalRec.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        homeVerticalRec.setHasFixedSize(true);
        homeVerticalRec.setNestedScrollingEnabled(false);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}