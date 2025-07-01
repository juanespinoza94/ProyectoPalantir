package com.cibertec.serviceImpl;

import com.cibertec.model.Usuario;
import com.cibertec.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplement implements UserDetailsService {

    @Autowired
    private UsuarioRepository dao;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = dao.findOneByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario con dicho email: "+email+ "no existe."));

        return new UserDetailImplement(usuario);
    }

}