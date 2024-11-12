package pe.edu.upc.trabajogrupo2.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajogrupo2.entities.Usuario;
import pe.edu.upc.trabajogrupo2.repositories.IUsuarioRepository;

import java.util.ArrayList;
import java.util.List;


//Clase 2
@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private IUsuarioRepository IUsuarioRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = IUsuarioRepo.findOneByCorreoUsuario(username);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("User not exists", username));
        }

        List<GrantedAuthority> roles = new ArrayList<>();

      user.getRoles().forEach(rol -> {
            roles.add(new SimpleGrantedAuthority(rol.getRolUsuario()));
        });


        UserDetails ud = new org.springframework.security.core.userdetails.User(user.getCorreoUsuario(), user.getClaveUsuario(), user.isHabilitado(), true, true, true, roles);

        return ud;
    }
}