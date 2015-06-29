package com.androidvigo.cloud;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ProgressBar;

import java.util.List;


public class MainActivity extends Activity
        implements GetMemesCallback {

    private RecyclerView mMemesRecyclerView;
    private ProgressBar mLoadingProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMemesRecyclerView = (RecyclerView) findViewById(R.id.activity_main_memes_recyclerview);
        mMemesRecyclerView.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this.getBaseContext());
        mMemesRecyclerView.setLayoutManager(llm);

        mLoadingProgressBar = (ProgressBar) findViewById(R.id.activity_main_loading_indicator);
    }

    public void startGetMemesRequest(View requestButton) {

        requestButton.setVisibility(View.GONE);
        mLoadingProgressBar.setVisibility(View.VISIBLE);

        GetMemesHelper.getInstance().loadMemesWithIon(this, this);
    }

    @Override
    public void onMemesResult(List<MemeEntity> memesList) {

        mLoadingProgressBar.setVisibility(View.GONE);

        String[] memesNames = new String[memesList.size()];

        for (int i = 0; i < memesList.size(); i++)
            memesNames[i] = memesList.get(i).getTitle();

        RVMemeAdapter memesAdapter = new RVMemeAdapter(memesList);
        mMemesRecyclerView.setAdapter(memesAdapter);
    }

    @Override
    public void onMemesError() {

    }
}
