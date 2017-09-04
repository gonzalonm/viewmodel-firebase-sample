package com.gonzalonm.viewmodelfirebase.data.mapper;

import com.google.firebase.database.DataSnapshot;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public abstract class FirebaseMapper<Entity, Model> implements IMapper<Entity, Model> {

    public Model map(DataSnapshot dataSnapshot) {
        Entity entity = dataSnapshot.getValue(getEntityClass());
        return map(entity);
    }

    public List<Model> mapList(DataSnapshot dataSnapshot) {
        List<Model> list = new ArrayList<>();
        for (DataSnapshot item : dataSnapshot.getChildren()) {
            list.add(map(item));
        }
        return list;
    }

    @SuppressWarnings("unchecked")
    private Class<Entity> getEntityClass() {
        ParameterizedType superclass = (ParameterizedType) getClass().getGenericSuperclass();
        return (Class<Entity>) superclass.getActualTypeArguments()[0];
    }

}
