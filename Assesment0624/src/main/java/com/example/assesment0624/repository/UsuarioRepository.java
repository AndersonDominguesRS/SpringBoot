package com.example.assesment0624.repository;

import com.example.assesment0624.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository  extends MongoRepository<Usuario, String> {
    Usuario findUsuarioByNome(String nome);
}
