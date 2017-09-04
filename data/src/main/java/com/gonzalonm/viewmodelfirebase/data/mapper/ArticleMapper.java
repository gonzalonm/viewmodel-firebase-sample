package com.gonzalonm.viewmodelfirebase.data.mapper;

import com.gonzalonm.viewmodelfirebase.data.entity.ArticleEntity;
import com.gonzalonm.viewmodelfirebase.domain.Article;

public class ArticleMapper extends FirebaseMapper<ArticleEntity, Article> {

    @Override
    public Article map(ArticleEntity articleEntity) {
        Article article = new Article();
        article.setPrice(articleEntity.getPrice());
        article.setImageUrl(articleEntity.getImageUrl());
        article.setName(articleEntity.getName());
        return article;
    }
}
