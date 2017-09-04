package com.gonzalonm.viewmodelfirebase.data.repository;

import com.gonzalonm.viewmodelfirebase.data.mapper.FirebaseMapper;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class BaseValueEventListener<Model, Entity> implements ValueEventListener {

    private FirebaseMapper<Entity, Model> mapper;
    private FirebaseDatabaseRepository.FirebaseDatabaseRepositoryCallback<Model> callback;

    public BaseValueEventListener(FirebaseMapper<Entity, Model> mapper,
                                  FirebaseDatabaseRepository.FirebaseDatabaseRepositoryCallback<Model> callback) {
        this.mapper = mapper;
        this.callback = callback;
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        List<Model> data = mapper.mapList(dataSnapshot);
        callback.onSuccess(data);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        callback.onError(databaseError.toException());
    }
}
