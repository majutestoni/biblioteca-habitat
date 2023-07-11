package br.furb.inf.furbot.repositories.material;

import br.furb.inf.furbot.models.material.Material;
import br.furb.inf.furbot.models.material.QMaterial;
import br.furb.inf.furbot.repositories.RepositoryImpl;
import com.querydsl.core.types.dsl.EntityPathBase;

public class MaterialCustomRepositoryImpl extends RepositoryImpl<Material> implements MaterialCustomRepository {

	@Override
	public EntityPathBase<Material> getEntity() {
		return QMaterial.material;
	}

}
