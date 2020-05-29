package com.example.rachana.happypaww;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class ShopAdapter extends RecyclerView.Adapter<ShopViewHolder> {
    private Context mContext;
    private List<Shop> ShopList;

    public ShopAdapter(Context mContext, List<Shop> ShopList) {
        this.mContext = mContext;
        this.ShopList = ShopList;
    }

    @NonNull
    @Override
    public ShopViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_shop_item,viewGroup,false);
        return new ShopViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ShopViewHolder shopViewHolder, int i) {
        shopViewHolder.imageView.setImageResource(ShopList.get(i).getItemImage());
        shopViewHolder.mTitle.setText(ShopList.get(i).getItemName());
        shopViewHolder.mDescription.setText(ShopList.get(i).getItemDescription());
        shopViewHolder.mPrice.setText(ShopList.get(i).getItemPrice());

        shopViewHolder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext,ShopActivity.class);
                intent.putExtra("Image",ShopList.get(shopViewHolder.getAdapterPosition()).getItemImage());
                intent.putExtra("Description",ShopList.get(shopViewHolder.getAdapterPosition()).getItemDescription());
                mContext.startActivity(intent);

            }
        });
    }
    @Override
    public int getItemCount() {
        return ShopList.size();
    }
}


class ShopViewHolder extends RecyclerView.ViewHolder{
    ImageView imageView;
    TextView mTitle,mDescription,mPrice;
    CardView mCardView;

    public ShopViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.imageViewBed);
        mTitle = itemView.findViewById(R.id.titleBed);
        mDescription = itemView.findViewById(R.id.desBed);
        mPrice = itemView.findViewById(R.id.priceBed);
        mCardView = itemView.findViewById(R.id.cardViewBed);
    }
}
