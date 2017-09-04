package com.gonzalonm.viewmodelfirebase.data.repository;

import com.gonzalonm.viewmodelfirebase.data.mapper.ArticleMapper;
import com.gonzalonm.viewmodelfirebase.domain.Article;

public class ArticleRepository extends FirebaseDatabaseRepository<Article> {

    public ArticleRepository() {
        super(new ArticleMapper());
    }

    @Override
    protected String getRootNode() {
        return "articles";
    }
}
