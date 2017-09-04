package com.gonzalonm.viewmodelfirebase.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gonzalonm.viewmodelfirebase.R;
import com.gonzalonm.viewmodelfirebase.domain.Article;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {

    private final List<Article> list;

    public ArticleAdapter(List<Article> list) {
        this.list = list;
    }

    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item_article, parent, false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ArticleViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ArticleViewHolder extends RecyclerView.ViewHolder {

        TextView name;

        public ArticleViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
        }

        public void bind(Article article) {
            name.setText(article.getName());
        }
    }
}
