package com.gonzalonm.viewmodelfirebase.view;

import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gonzalonm.viewmodelfirebase.R;
import com.gonzalonm.viewmodelfirebase.domain.Article;
import com.gonzalonm.viewmodelfirebase.viewmodel.ArticleViewModel;

import java.util.List;

public class ArticlesFragment extends LifecycleFragment {

    private RecyclerView recyclerView;

    public static ArticlesFragment newInstance() {
        return new ArticlesFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_articles, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArticleViewModel viewModel = ViewModelProviders.of(this).get(ArticleViewModel.class);
        viewModel.getArticles().observe(this, new Observer<List<Article>>() {
            @Override
            public void onChanged(@Nullable List<Article> articles) {
                recyclerView.setAdapter(new ArticleAdapter(articles));
            }
        });
    }
}
