package com.database.jpa.mappers.Impl;

import com.database.jpa.mappers.Mapper;
import com.database.jpa.model.Author;
import com.database.jpa.model.Dto.AuthorDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapperImpl implements Mapper<Author, AuthorDTO> {

    private final ModelMapper modelMapper;

    public AuthorMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public AuthorDTO mapTo(Author author) {
        return modelMapper.map(author, AuthorDTO.class);
    }

    @Override
    public Author mapFrom(AuthorDTO authorDTO) {
        return modelMapper.map(authorDTO, Author.class);
    }
}
