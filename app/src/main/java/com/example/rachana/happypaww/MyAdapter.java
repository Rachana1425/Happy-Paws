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

public class MyAdapter extends RecyclerView.Adapter<FoodViewHolder> {
    private Context mContext;
    private List<Food> FoodList;

    public MyAdapter(Context mContext, List<Food> FoodList) {
        this.mContext = mContext;
        this.FoodList = FoodList;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_row_item,viewGroup,false);
        return new FoodViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull final FoodViewHolder foodViewHolder, int i) {
        foodViewHolder.imageView.setImageResource(FoodList.get(i).getItemImage());
        foodViewHolder.mTitle.setText(FoodList.get(i).getItemName());
        foodViewHolder.mDescription.setText(FoodList.get(i).getItemDescription());
        foodViewHolder.mPrice.setText(FoodList.get(i).getItemPrice());


        foodViewHolder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext,DetailActivity.class);
                intent.putExtra("Image",FoodList.get(foodViewHolder.getAdapterPosition()).getItemImage());
                intent.putExtra("Description",FoodList.get(foodViewHolder.getAdapterPosition()).getItemDescription());
                mContext.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return FoodList.size();
    }
}

class FoodViewHolder extends RecyclerView.ViewHolder{

    ImageView imageView;
    TextView mTitle,mDescription,mPrice;
    CardView mCardView;


    public FoodViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.imageView);
        mTitle = itemView.findViewById(R.id.title);
        mDescription = itemView.findViewById(R.id.tvdes);
        mPrice = itemView.findViewById(R.id.price);
        mCardView = itemView.findViewById(R.id.cardView);
    }
}