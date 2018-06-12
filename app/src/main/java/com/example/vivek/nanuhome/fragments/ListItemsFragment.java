package com.example.vivek.nanuhome.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vivek.nanuhome.R;
import com.example.vivek.nanuhome.adapters.ListItemsAdapters;
import com.example.vivek.nanuhome.pojo.HomeItems;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;


public class ListItemsFragment extends Fragment {

    RecyclerView itemsRecyclerView;
    View  view=null;
    List<HomeItems> homeItemsList=new ArrayList<>();
    HomeItems obj;
     DocumentReference mDatabase;
     FirebaseFirestore db;
     String TAG="firelog";
    ListItemsAdapters listItemsAdapters;



    public ListItemsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      if (view==null){
          view=inflater.inflate(R.layout.fragment_list_items, container, false);

          itemsRecyclerView=(RecyclerView) view.findViewById(R.id.itemsRcylrView);
        adddata();
        initAdapter();
        return view;
    }else
        return view;
    }





    private void initAdapter() {
         listItemsAdapters =new ListItemsAdapters(homeItemsList,getActivity());
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
       itemsRecyclerView.setHasFixedSize(true);
        itemsRecyclerView.setLayoutManager(layoutManager);
        itemsRecyclerView.setAdapter(listItemsAdapters);
    }


    void adddata() {

        db = FirebaseFirestore.getInstance();
        db.collection("MyList").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                if (e != null) {
                    Log.d(TAG, "onEvent: " + e);

                }
                for (DocumentChange doc : queryDocumentSnapshots.getDocumentChanges()) {

                    if (doc.getType() == DocumentChange.Type.ADDED  )  {

                        HomeItems items = doc.getDocument().toObject(HomeItems.class);
                        homeItemsList.add(items);
                        listItemsAdapters.notifyDataSetChanged();

                    }else if ( doc.getType()==DocumentChange.Type.REMOVED ){
                        listItemsAdapters.notifyDataSetChanged();
                    }else if(doc.getType()==DocumentChange.Type.MODIFIED){

                        listItemsAdapters.notifyDataSetChanged();
                    }

                }
            }
        });
    }


}



