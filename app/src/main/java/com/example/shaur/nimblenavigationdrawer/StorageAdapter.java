package com.example.shaur.nimblenavigationdrawer;

/**
 * Created by Hopeless on 04-Nov-17.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Hopeless on 04-Nov-17.
 */

public class StorageAdapter extends RecyclerView.Adapter<StorageAdapter.ViewHolder> {
    private Context context;
    private List<Upload> uploads;

    public StorageAdapter(Context context, List<Upload> uploads) {
        this.uploads = uploads;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_files, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Upload upload = uploads.get(position);
        String name = upload.getName();
        String prefix = name.substring(0, 3);
        holder.textViewName.setText(name.substring(4));
        if (prefix.equals("img")) {
            Glide.with(context).load(upload.getUrl()).into(holder.imageView);
        } else if (prefix.equals("pdf")) {
            Glide.with(context).load(R.drawable.pdficon).into(holder.imageView);
        } else if (prefix.equals("txt")) {
            Glide.with(context).load(R.drawable.texticon).into(holder.imageView);
        }

    }

    @Override
    public int getItemCount() {
        return uploads.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewName;
        public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }
}

