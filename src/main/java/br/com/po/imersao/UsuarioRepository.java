package br.com.po.imersao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("hasRole('ROLE_USER')")
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Override
	public <S extends Usuario> S save(S entity);

}
