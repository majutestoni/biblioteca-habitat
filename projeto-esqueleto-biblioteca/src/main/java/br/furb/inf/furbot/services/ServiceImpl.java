package br.furb.inf.furbot.services;

import java.lang.reflect.Field;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.furb.inf.furbot.exceptions.BadRequestException;
import br.furb.inf.furbot.exceptions.NotFoundException;
import br.furb.inf.furbot.models.ModelImpl;
import br.furb.inf.furbot.repositories.Repository;
import br.furb.inf.furbot.utils.FilterImpl;
import br.furb.inf.furbot.utils.Page;


public abstract class ServiceImpl<T> implements Service<T> {

	public abstract JpaRepository<T, UUID> getRepository();

	public abstract void validator(T entity);

	@Transactional
	@Override
	public T create(T entity) {
		validator(entity);
		if (((ModelImpl) entity).getId() != null) {
			throw new BadRequestException("O ID não pode ser passado na criação de um registro");
		}
		return getRepository().save(entity);
	}
	
	@Transactional
	public T createIgnoreCompany(T entity) {
		return getRepository().save(entity);
	}

	@Override
	public T update(UUID id, T entity) {
		validator(entity);
		T entityFinded = retrieve(id);
		for (Field fieldFinded : entityFinded.getClass().getDeclaredFields()) {
			for (Field field : entity.getClass().getDeclaredFields()) {
				if (field.getName().equals(fieldFinded.getName()) && !"id".equals(field.getName())
						&& !"serialVersionUID".equals(field.getName())) {
					fieldFinded.setAccessible(true);
					field.setAccessible(true);
					try {
						fieldFinded.set(entityFinded, field.get(entity));
					} catch (Exception e) {
						throw new BadRequestException("Verifique o campo " + field.getName());
					}
				}
			}
		}
		return getRepository().save(entityFinded);
	}

	@Transactional(readOnly = true)
	@Override
	public T get(UUID id) {
		return getRepository().findById(id).orElseThrow(() -> new NotFoundException(id.toString()));
	}

	@Override
	public void delete(UUID id) {
		getRepository().delete(retrieve(id));
	}
	
	@Override
    public void delete(T entity) {
        getRepository().delete(entity);
    }

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	@Override
	public T retrieve(UUID id) {
		T entity = ((Repository<T>) getRepository()).retrieve(id);
		if (entity == null) {
			throw new NotFoundException(id.toString());
		}
		return entity;
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	@Override
	public Page<T> list(FilterImpl filter) {
		return ((Repository<T>) getRepository()).list(filter);
	}

	public List<T> getAll() {
		return getRepository().findAll();
	}
}
