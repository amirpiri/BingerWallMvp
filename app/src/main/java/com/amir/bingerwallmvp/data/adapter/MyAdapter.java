package com.amir.bingerwallmvp.data.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.amir.bingerwallmvp.R;
import com.amir.bingerwallmvp.mainscreen.MainActivity;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

/**
 * Created by Amir on 2016-02-20.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private ArrayList<String> LinkDataset;
    private ArrayList<String> mDataset;
    private ArrayList<String> ImageDataset;
    private ArrayList<String> jsonStringDataset;
    private Context context;


    public void setLinkDataset(ArrayList<String> linkDataset) {
        LinkDataset = linkDataset;
    }

    public void setmDataset(ArrayList<String> mDataset) {
        this.mDataset = mDataset;
    }

    public void setImageDataset(ArrayList<String> imageDataset) {
        ImageDataset = imageDataset;
    }

    public void setJsonStringDataset(ArrayList<String> jsonStringDataset) {
        this.jsonStringDataset = jsonStringDataset;
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public CardView cv;
        public TextView txtHeader;
        public Button BingSearchBtn;
        public SimpleDraweeView Bing_photoIW;

        public ViewHolder(View v) {
            super(v);
            cv = (CardView) v.findViewById(R.id.cv);
            Bing_photoIW = (SimpleDraweeView) v.findViewById(R.id.Bing_photoIW);
            txtHeader = (TextView) v.findViewById(R.id.person_name);
            BingSearchBtn = (Button) v.findViewById(R.id.BingSearchBtn);
        }
    }

    public void add(int position, String myDataset , String ImageDataset , String LinkDataset ,
                    String jsonStringDataset) {
        this.mDataset.add(position, myDataset);
        this.ImageDataset.add(position,ImageDataset);
        this.LinkDataset.add(position,LinkDataset);
        this.jsonStringDataset.add(position,jsonStringDataset);
        notifyItemInserted(getItemCount());
    }

    public void remove(String item) {
        int position = mDataset.indexOf(item);
        mDataset.remove(position);
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(ArrayList<String> myDataset , ArrayList<String> ImageDataset , ArrayList<String> LinkDataset ,
                     ArrayList<String> jsonStringDataset) {
        super();
        this.mDataset = myDataset;
        this.ImageDataset = ImageDataset;
        this.LinkDataset = LinkDataset;
        this.jsonStringDataset = jsonStringDataset;
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter() {
        super();
        this.mDataset = new ArrayList<>();
        this.ImageDataset = new ArrayList<>();
        this.LinkDataset = new ArrayList<>();
        this.jsonStringDataset = new ArrayList<>();
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        context = parent.getContext();

        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final String name = mDataset.get(position);
        holder.txtHeader.setText(mDataset.get(position));
//        holder.txtHeader.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                remove(name);
//            }
//        });

//        holder.BingSearchBtn.setText("Link: " + LinkDataset.get(position));

        holder.BingSearchBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(LinkDataset.get(position)));
                context.startActivity(intent);
            }
        });

        Uri uri = Uri.parse(ImageDataset.get(position));
        holder.Bing_photoIW.setImageURI(uri);

        holder.Bing_photoIW.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(context, MainActivity.class);
                myIntent.putExtra("BingJson" , jsonStringDataset.get(position));
                context.startActivity(myIntent);
            }
        });


        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                .setProgressiveRenderingEnabled(true)
                .build();
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setImageRequest(request)
                .setTapToRetryEnabled(true)
                .setOldController(holder.Bing_photoIW.getController())
                .build();
        holder.Bing_photoIW.setController(controller);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }


}

