package com.learningrest.todoapp.mapper;

public interface IMapper <I, O> {
    O mapFrom(I in);
}
