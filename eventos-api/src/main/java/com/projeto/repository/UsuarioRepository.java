package com.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	public Usuario findUsuarioByEmailAndSenha(String email, String senha);
	public Usuario findUsuarioByEmail(String email);
}
