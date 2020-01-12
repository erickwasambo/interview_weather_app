package wasambo.erick.job.interview.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import wasambo.erick.job.interview.R;
import wasambo.erick.job.interview.activity.BookMarkedCityActivity;

public class RecyclerViewFragment extends Fragment {


    public RecyclerViewFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setRetainInstance(true);
        Bundle bundle = this.getArguments();
        View view = inflater.inflate(R.layout.fragment_recycler_view, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        BookMarkedCityActivity bookMarkedCityActivity = (BookMarkedCityActivity) getActivity();
        recyclerView.setAdapter(bookMarkedCityActivity.getAdapter(bundle.getInt("day")));
        return view;
    }

}
