package br.furb.inf.furbot.repositories;

import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import br.furb.inf.furbot.utils.FilterImpl;
import br.furb.inf.furbot.utils.Page;

@org.springframework.stereotype.Repository
public interface Repository<T> {
	
	@Transactional(readOnly = true)
	public T retrieve(UUID id);
	
	@Transactional(readOnly = true)
	public Page<T> list(FilterImpl filter);
}
