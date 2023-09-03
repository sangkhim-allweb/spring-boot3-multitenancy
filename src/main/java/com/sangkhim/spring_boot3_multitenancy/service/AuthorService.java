package com.sangkhim.spring_boot3_multitenancy.service;

import com.sangkhim.spring_boot3_multitenancy.SpringBoot3MultitenancyApplication;
import com.sangkhim.spring_boot3_multitenancy.exception.BadRequestException;
import com.sangkhim.spring_boot3_multitenancy.exception.DataNotFoundException;
import com.sangkhim.spring_boot3_multitenancy.model.entity.Author;
import com.sangkhim.spring_boot3_multitenancy.repository.AuthorRepository;
import com.sangkhim.spring_boot3_multitenancy.utils.Translator;
import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorService {

  private final AuthorRepository authorRepository;

  public List<Author> getAllAuthors() {
    SpringBoot3MultitenancyApplication.defaultProperties.setProperty("lang", "en");

    List<Author> authorList = authorRepository.findAll();
    return authorList;
  }

  public Author getById(Long id) {
    return authorRepository
        .findById(id)
        .orElseThrow(
            () ->
                new DataNotFoundException(
                    MessageFormat.format("Author id {0} not found", String.valueOf(id))));
  }

  public Author createOrUpdate(Author authorRequest) {
    Optional<Author> existingAuthor = authorRepository.findById(authorRequest.getId());

    if (existingAuthor.isPresent()) {
      Author authorUpdate = existingAuthor.get();

      authorUpdate.setName(authorRequest.getName());

      return authorRepository.save(authorUpdate);
    } else {
      return authorRepository.save(authorRequest);
    }
  }

  public void deleteById(Long id) {
    Optional<Author> author = authorRepository.findById(id);
    if (author.isPresent()) {
      authorRepository.deleteById(id);
    } else {
      throw new BadRequestException(Translator.toLocale("DELETE_ERROR_PLEASE_CHECK_ID"));
    }
  }
}
