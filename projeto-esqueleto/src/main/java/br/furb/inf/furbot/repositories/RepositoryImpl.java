package br.furb.inf.furbot.repositories;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.querydsl.core.types.dsl.BooleanPath;
import com.querydsl.core.types.dsl.ComparablePath;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.jpa.JPAQueryBase;
import com.querydsl.jpa.impl.JPAQuery;

import br.furb.inf.furbot.exceptions.BadRequestException;
import br.furb.inf.furbot.exceptions.InternalServerException;
import br.furb.inf.furbot.exceptions.NotFoundException;
import br.furb.inf.furbot.utils.FilterImpl;
import br.furb.inf.furbot.utils.FilterQueryImpl;
import br.furb.inf.furbot.utils.Page;

@Repository
public abstract class RepositoryImpl<T> implements br.furb.inf.furbot.repositories.Repository<T> {

	@PersistenceContext
	protected EntityManager em;

	public abstract EntityPathBase<T> getEntity();

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public T retrieve(UUID id) {

		JPAQueryBase base = new JPAQuery<T>(em).from(getEntity());

		try {
			ComparablePath<UUID> qId = (ComparablePath<UUID>) getEntity().getClass().getField("id").get(getEntity());
			base.where(qId.eq(id));
		} catch (Exception e) {
			throw new InternalServerException(e.getMessage());
		}
		List<T> entity = base.fetch();
		if (entity != null && !entity.isEmpty()) {
			return entity.get(0);
		}
		throw new NotFoundException(id.toString());
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Page<T> list(FilterImpl filter) {

		JPAQueryBase base = new JPAQuery<T>(em).from(getEntity());

		try {
			for (FilterQueryImpl query : filter.getFilter()) {
				if (query.getBoolValue() != null) {
					BooleanPath value = null;
					if (query.getField().contains(".")) {
						String[] subentityFilter = query.getField().split("\\.");
						Object subentity = getEntity().getClass().getField(subentityFilter[0]).get(getEntity());
						value = (BooleanPath) subentity.getClass().getField(subentityFilter[1]).get(subentity);
					} else {
						value = (BooleanPath) getEntity().getClass().getField(query.getField()).get(getEntity());
					}
					base.where(value.eq(query.getBoolValue()));
				}
				if (query.getLongValue() != null) {
					NumberPath<Long> value = null;
					if (query.getField().contains(".")) {
						String[] subentityFilter = query.getField().split("\\.");
						Object subentity = getEntity().getClass().getField(subentityFilter[0]).get(getEntity());
						value = (NumberPath<Long>) subentity.getClass().getField(subentityFilter[1]).get(subentity);
					} else {
						value = (NumberPath<Long>) getEntity().getClass().getField(query.getField()).get(getEntity());
					}
					switch (query.getType()) {
					case IGUAL:
						base.where(value.eq(query.getLongValue()));
						break;
					case MAIOR:
						base.where(value.gt(query.getLongValue()));
						break;
					case MAIOR_IGUAL:
						base.where(value.goe(query.getLongValue()));
						break;
					case MENOR:
						base.where(value.lt(query.getLongValue()));
						break;
					case MENOR_IGUAL:
						base.where(value.loe(query.getLongValue()));
						break;
					default:
						throw new BadRequestException("Modificador incorreto");
					}
				}
				if (query.getDateValue() != null) {
					DateTimePath<Date> value = null;
					if (query.getField().contains(".")) {
						String[] subentityFilter = query.getField().split("\\.");
						Object subentity = getEntity().getClass().getField(subentityFilter[0]).get(getEntity());
						value = (DateTimePath<Date>) subentity.getClass().getField(subentityFilter[1]).get(subentity);
					} else {
						value = (DateTimePath<Date>) getEntity().getClass().getField(query.getField()).get(getEntity());
					}
					switch (query.getType()) {
					case IGUAL:
						base.where(value.eq(query.getDateValue()));
						break;
					case MAIOR:
						base.where(value.gt(query.getDateValue()));
						break;
					case MAIOR_IGUAL:
						base.where(value.goe(query.getDateValue()));
						break;
					case MENOR:
						base.where(value.lt(query.getDateValue()));
						break;
					case MENOR_IGUAL:
						base.where(value.loe(query.getDateValue()));
						break;
					default:
						throw new BadRequestException("Modificador incorreto");
					}
				}
				if (query.getStringValue() != null) {
					try {
						UUID uuid = UUID.fromString(query.getStringValue());
						ComparablePath<java.util.UUID> value = null;
						if (query.getField().contains(".")) {
							String[] subentityFilter = query.getField().split("\\.");
							Object subentity = getEntity().getClass().getField(subentityFilter[0]).get(getEntity());
							value = (ComparablePath<java.util.UUID>) subentity.getClass().getField(subentityFilter[1]).get(subentity);
						} else {
							value = (ComparablePath<java.util.UUID>) getEntity().getClass().getField(query.getField()).get(getEntity());
						}
						switch (query.getType()) {
						case IGUAL:
							base.where(value.eq(uuid));
							break;
						default:
							throw new BadRequestException("Modificador incorreto");
						}
					} catch (Exception e) {
						StringPath value = null;
						if (query.getField().contains(".")) {
							String[] subentityFilter = query.getField().split("\\.");
							Object subentity = getEntity().getClass().getField(subentityFilter[0]).get(getEntity());
							value = (StringPath) subentity.getClass().getField(subentityFilter[1]).get(subentity);
						} else {
							value = (StringPath) getEntity().getClass().getField(query.getField()).get(getEntity());
						}
						switch (query.getType()) {
						case IGUAL:
							base.where(value.eq(query.getStringValue()));
							break;
						case MAIOR:
							base.where(value.gt(query.getStringValue()));
							break;
						case MAIOR_IGUAL:
							base.where(value.goe(query.getStringValue()));
							break;
						case MENOR:
							base.where(value.lt(query.getStringValue()));
							break;
						case MENOR_IGUAL:
							base.where(value.loe(query.getStringValue()));
							break;
						case LIKE:
							base.where(value.containsIgnoreCase(query.getStringValue()));
							break;
						default:
							throw new BadRequestException("Modificador incorreto");
						}
					}
				}
			}
		} catch (NoSuchFieldException e) {
			throw new BadRequestException("Verifique os filtros e tente novamente!");
		} catch (Exception e) {
			if (!e.getMessage().equals("companyId")) {
				throw new InternalServerException(e.getMessage());
			}
		}

		try {
			if (filter.getOrder() != null && !filter.getOrder().isEmpty()) {
				String[] order = filter.getOrder().split("\\s+");
				Field field = getEntity().getClass().getField(order[0]);
				if (field.getType().equals(DateTimePath.class)) {
					DateTimePath<Date> value = (DateTimePath<Date>) field.get(getEntity());
					if (order[1].equalsIgnoreCase("asc")) {
						base.orderBy(value.asc());
					} else {
						base.orderBy(value.desc());
					}
				}
				if (field.getType().equals(StringPath.class)) {
					StringPath value = (StringPath) field.get(getEntity());
					if (order[1].equalsIgnoreCase("asc")) {
						base.orderBy(value.asc());
					} else {
						base.orderBy(value.desc());
					}
				}
				if (field.getType().equals(NumberPath.class)) {
					NumberPath<Long> value = (NumberPath<Long>) field.get(getEntity());
					if (order[1].equalsIgnoreCase("asc")) {
						base.orderBy(value.asc());
					} else {
						base.orderBy(value.desc());
					}
				}
				if (field.getType().equals(BooleanPath.class)) {
					BooleanPath value = (BooleanPath) field.get(getEntity());
					if (order[1].equalsIgnoreCase("asc")) {
						base.orderBy(value.asc());
					} else {
						base.orderBy(value.desc());
					}
				}
				System.out.println(field.getType());
			} else {
				NumberPath<Long> id = (NumberPath) getEntity().getClass().getField("id").get(getEntity());
				base.orderBy(id.desc());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (filter.getSize() != null && filter.getSize() > 0) {
			base.limit(filter.getSize());
		}
		if (filter.getPage() != null && filter.getPage() > 0) {
			base.offset(filter.getPage());
		}

		Long quantity = base.fetchCount();

		List<T> entity = base.fetch();
		return new Page<>(entity, quantity, filter.getSize() > 0 ? quantity / filter.getSize() + 1 : 1L);
	}

}
