package com.gonzalonm.viewmodelfirebase.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.gonzalonm.viewmodelfirebase.data.repository.ArticleRepository;
import com.gonzalonm.viewmodelfirebase.data.repository.FirebaseDatabaseRepository;
import com.gonzalonm.viewmodelfirebase.domain.Article;

import java.util.List;

public class ArticleViewModel extends ViewModel {

    private MutableLiveData<List<Article>> articles;
    private ArticleRepository repository = new ArticleRepository();

    public LiveData<List<Article>> getArticles() {
        if (articles == null) {
            articles = new MutableLiveData<>();
            loadArticles();
        }
        return articles;
    }

    @Override
    protected void onCleared() {
        repository.removeListener();
    }

    private void loadArticles() {
        repository.addListener(new FirebaseDatabaseRepository.FirebaseDatabaseRepositoryCallback<Article>() {
            @Override
            public void onSuccess(List<Article> result) {
                articles.setValue(result);
            }

            @Override
            public void onError(Exception e) {
                articles.setValue(null);
            }
        });
    }
}
