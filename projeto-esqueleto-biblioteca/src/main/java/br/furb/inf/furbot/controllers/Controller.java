package br.furb.inf.furbot.controllers;

import java.util.UUID;

import org.springframework.http.ResponseEntity;

import br.furb.inf.furbot.utils.Page;

public interface Controller<T> {

	ResponseEntity<T> retrieve(UUID id);

	ResponseEntity<Page<T>> list(String filter, Integer size, Integer page, String order);

	ResponseEntity<T> create(T entity);

	ResponseEntity<T> update(UUID id, T entity);

	ResponseEntity<?> delete(UUID id);

}
