package com.androidvigo.cloud;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

public class RVMemeAdapter extends RecyclerView.Adapter<RVMemeAdapter.MemeViewHolder> {
    private List<MemeEntity> mMemeEntitiesList;

    public static class MemeViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView emotionTextView;
        ImageView memeImageView;

        MemeViewHolder(View itemView) {
            super(itemView);
            titleTextView = (TextView) itemView.findViewById(R.id.item_meme_title);
            TextView emotionTextView = (TextView) itemView.findViewById(R.id.item_meme_emotion);
            ImageView memeImageView = (ImageView) itemView.findViewById(R.id.item_meme_image);
        }
    }

    RVMemeAdapter(List<MemeEntity> mMemeEntitiesList) {
        this.mMemeEntitiesList = mMemeEntitiesList;
    }


    @Override
    public int getItemCount() {
        return mMemeEntitiesList.size();
    }

    @Override
    public MemeViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_meme, viewGroup, false);
        MemeViewHolder mvh = new MemeViewHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(MemeViewHolder memeViewHolder, int i) {
        memeViewHolder.titleTextView.setText(mMemeEntitiesList.get(i).getTitle());
        //memeViewHolder.emotionTextView.setText(mMemeEntitiesList.get(i).getEmotion());
        //memeViewHolder.memeImageView.setImageResource(Integer.parseInt(mMemeEntitiesList.get(i).getId()));
    }
}
