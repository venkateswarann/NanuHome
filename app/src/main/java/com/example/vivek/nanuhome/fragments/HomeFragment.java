package com.example.vivek.nanuhome.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.vivek.nanuhome.R;

import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

public class HomeFragment extends Fragment implements View.OnClickListener {


    Button btnThings;
    Button btnWorks,btnAddnewItems;
    View view;
    NavHostFragment navhost;

    public HomeFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
         view= inflater.inflate(R.layout.home_fragment, container, false);
        btnThings=view.findViewById(R.id.btnThings);
        btnWorks=view.findViewById(R.id.btnWorks);
        btnAddnewItems=view.findViewById(R.id.btnAddnewItems);
        btnThings.setOnClickListener(this);
        btnWorks.setOnClickListener(this);

        btnAddnewItems.setOnClickListener(this);


        return view;
    }




    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnThings:
                Navigation.findNavController(view).navigate(R.id.listItems);
                break;
            case R.id.btnWorks:
                Navigation.findNavController(view).navigate(R.id.workToFinish);
                break;
            case R.id.btnAddnewItems:
                Navigation.findNavController(view).navigate(R.id.addItemsFragment);
                break;
        }

    }



}
