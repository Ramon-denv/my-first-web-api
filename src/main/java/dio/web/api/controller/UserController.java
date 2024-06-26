package dio.web.api.controller;

import dio.web.api.model.Usuario;
import dio.web.api.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository repository;
    @GetMapping
    public List<Usuario> list(){
        return repository.findAll();
    }
    @PostMapping
    public void save(@RequestBody Usuario usuario){
        repository.save(usuario);
    }
    @PutMapping
    public void update(@RequestBody Usuario usuario){
        repository.save(usuario);
    }
    @GetMapping("/{username}")
    public User find(@PathVariable("/username") String username){
        return (User) repository.findByUsername(username);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("/id") Integer id){
        repository.deleteById(id);
    }
}
