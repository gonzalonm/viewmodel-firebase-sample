package com.gonzalonm.viewmodelfirebase.data.mapper;

public interface IMapper<From, To> {

    To map(From from);
}
