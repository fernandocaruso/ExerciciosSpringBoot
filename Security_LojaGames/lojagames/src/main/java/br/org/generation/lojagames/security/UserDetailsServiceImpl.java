package br.org.generation.lojagames.security;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.org.generation.lojagames.model.Usuario;
import br.org.generation.lojagames.repository.UsuarioRepository;

@Service //UserDetailsServiceImpl classe de serviço
public class UserDetailsServiceImpl {
	
	private UsuarioRepository userRepository;
	
	public UserDetails loadUserByUsername (String userName) throws UsernameNotFoundException{
		
		Optional <Usuario> usuario = userRepository.findByUsuario(userName);
		usuario.orElseThrow(() -> new UsernameNotFoundException(userName + " not found. "));
		
		return usuario.map(UserDetailsImpl::new).get();
	}
}