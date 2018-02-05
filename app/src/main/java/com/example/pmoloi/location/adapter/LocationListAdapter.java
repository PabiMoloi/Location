package com.example.pmoloi.location.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pmoloi.location.R;
import com.example.pmoloi.location.model.LocationModel;

import java.util.List;

public class LocationListAdapter extends RecyclerView.Adapter<LocationListAdapter.LocationViewHolder>{

    public class LocationViewHolder extends RecyclerView.ViewHolder

    {
        private final TextView textViewLocationName, textViewLocationBestFeature, textViewLocationNumberOfVisits;

        private LocationViewHolder(View textView)
        {
            super(textView);
            textViewLocationName = textView.findViewById(R.id.textViewListItemLocationName);
            textViewLocationBestFeature = textView.findViewById(R.id.textViewListItemBestFeature);
            textViewLocationNumberOfVisits = textView.findViewById(R.id.textViewListItemNumberOfVisits);
        }
    }

    private final LayoutInflater layoutInflater;
    private List<LocationModel> mLocations;

   public LocationListAdapter(Context context){layoutInflater = LayoutInflater.from(context);}

    @Override
    public LocationViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View listView = layoutInflater.inflate(R.layout.recyclerview_item,parent,false);
        return new LocationViewHolder(listView);
    }

    @Override
    public void onBindViewHolder(LocationViewHolder holder, int position)
    {
        LocationModel currentLocation = mLocations.get(position);
        holder.textViewLocationName.setText(currentLocation.getLocationName());
        holder.textViewLocationBestFeature.setText(currentLocation.getLocationBestFeature());
        holder.textViewLocationNumberOfVisits.setText(currentLocation.getLocationNumberOfVisits());
    }

    public void setLocations(List<LocationModel> locations)
    {
        mLocations = locations;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount()
    {
        if(mLocations != null)
        {
            return mLocations.size();
        }
        else
        {
            return 0;
        }
    }
}


