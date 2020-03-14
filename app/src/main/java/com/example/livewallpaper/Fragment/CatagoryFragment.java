package com.example.livewallpaper.Fragment;

import android.graphics.ColorSpace;
import android.icu.util.ULocale;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.livewallpaper.Common.common;
import com.example.livewallpaper.Interface.ItemClickListner;
import com.example.livewallpaper.Model.CategoryItem;
import com.example.livewallpaper.R;
import com.example.livewallpaper.ViewHolder.CatagoryViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.common.internal.service.Common;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.Locale;


public class CatagoryFragment extends Fragment {
    //Firebase
    FirebaseDatabase database;
    DatabaseReference categorybackground;

    //Firebaseui Adapter
    FirebaseRecyclerOptions<CategoryItem> options;
    FirebaseRecyclerAdapter<CategoryItem, CatagoryViewHolder> adapter;

    //View
    RecyclerView recyclerView;


    private static CatagoryFragment INSTANCE = null;

    public CatagoryFragment() {
        database = FirebaseDatabase.getInstance();
        categorybackground = database.getReference(common.STR_CATEGORY_BACKGROUND);
        options = new FirebaseRecyclerOptions.Builder<CategoryItem>()
                .setQuery(categorybackground,CategoryItem.class)
                .build();
        adapter =  new FirebaseRecyclerAdapter<CategoryItem, CatagoryViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull final CatagoryViewHolder holder, int i, @NonNull final CategoryItem model) {
                Picasso.with(getActivity())
                        .load(model.getImageLink())
                        .networkPolicy(NetworkPolicy.OFFLINE)
                        .into(holder.background_Image, new Callback() {
                            @Override
                            public void onSuccess() {

                            }

                            @Override
                            public void onError() {
                                Picasso.with(getActivity())
                                        .load(model.getImageLink())
                                        .error(R.drawable.ic_terrain_black_24dp)
                                        .into(holder.background_Image, new Callback() {
                                            @Override
                                            public void onSuccess() {

                                            }

                                            @Override
                                            public void onError() {
                                                Log.e("Error_WallPaper","Couldn't fetch Image");
                                            }
                                        });
                            }
                        });
                holder.category_Name.setText(model.getName());
                holder.setItemClickListner(new ItemClickListner() {
                    @Override
                    public void onClick(View view, int position) {
                        //code late for detailed activity
                    }
                });
            }

            @NonNull
            @Override
            public CatagoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View itemView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_caategory_item,parent, false);

                return new CatagoryViewHolder(itemView);
            }
        };

    }
    public static CatagoryFragment getInstance(){
        if(INSTANCE == null)
            INSTANCE = new CatagoryFragment();
            return INSTANCE;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_catagory, container, false);
        recyclerView =view.findViewById(R.id.Recycler_Catagory);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);

        setCategary();
        return view;
    }

    private void setCategary() {
        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        if(adapter!=null)
            adapter.startListening();
    }

    @Override
    public void onStop() {
        if(adapter!=null)
            adapter.stopListening();
        super.onStop();
    }

    @Override
    public void onResume() {
        super.onResume();
        if(adapter!=null)
            adapter.startListening();
    }
}
