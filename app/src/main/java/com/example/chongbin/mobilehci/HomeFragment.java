package com.example.chongbin.mobilehci;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;



public class HomeFragment extends Fragment {


    private RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        SearchView simpleSearchView = (SearchView) view.findViewById(R.id.search_bar);
        simpleSearchView.setIconifiedByDefault(false);
        // perform set on query text listener event
        simpleSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Intent myIntent = new Intent(getActivity(), SearchActivity.class);
                HomeFragment.this.startActivity(myIntent);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // do something when text changes
                return false;
            }
        });


        ImageButton button1 = (ImageButton) view.findViewById(R.id.imageButton1);
        startNewActivity(button1);
        ImageButton button2 = (ImageButton) view.findViewById(R.id.imageButton2);
        startNewActivity(button2);
        ImageButton button3 = (ImageButton) view.findViewById(R.id.imageButton3);
        startNewActivity(button3);


        return view;
    }

    //start the search acitvity
    private void startNewActivity(ImageButton button) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });

    }

}
