package com.example.vivek.nanuhome.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.vivek.nanuhome.R;
import com.example.vivek.nanuhome.adapters.ListAddedItemsLocalAdapter;
import com.example.vivek.nanuhome.adapters.ListItemsAdapters;

import java.util.ArrayList;
import java.util.List;


public class AddItemsFragment extends Fragment {

    View view;
    RecyclerView addedItemRecyclerView;
    List<String> addedItemsList;
    EditText txtinputItem;
    Button btnAddItem;
    ListAddedItemsLocalAdapter listItemsAdapters;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_add_items, container, false);
        addedItemRecyclerView=view.findViewById(R.id.addedRcyclrView);
        txtinputItem=view.findViewById(R.id.txtinputItem);
        btnAddItem=view.findViewById(R.id.btnAdd);
        addedItemsList=new ArrayList<>();
        initAdapter();
        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                initList(txtinputItem.getText().toString());
                listItemsAdapters.notifyDataSetChanged();

            }
        });

        return view;

    }

    private void initList(String value) {
        addedItemsList.add(value);
    }

    private void initAdapter() {
        listItemsAdapters = new ListAddedItemsLocalAdapter(addedItemsList,getActivity());
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        addedItemRecyclerView.setHasFixedSize(true);
        addedItemRecyclerView.setLayoutManager(layoutManager);
        addedItemRecyclerView.setAdapter(listItemsAdapters);

    }

}
