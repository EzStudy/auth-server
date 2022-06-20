package com.iam.authserver.jwt.mapper;

public interface GenericMapper<D, E> {

    D toDto(E e);
    E toEntity(D d);

}
