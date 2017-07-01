package br.com.po.imersao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/users")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping()
	public @ResponseBody Iterable<Usuario> all(){
		return usuarioRepository.findAll();
	}
	
	@PostMapping()
	public @ResponseBody String add(@RequestBody Usuario usuario){
		usuarioRepository.save(usuario);
		return "Saved";
	}
	
	
	@DeleteMapping(path="/{id}")
	public @ResponseBody String delete(@PathVariable String id){
		usuarioRepository.delete(Integer.parseInt(id));
		return "Deleted";
	}

	@GetMapping(path="/{id}")
	public ResponseEntity<Usuario> getOne(@PathVariable String id){
		Usuario usuario =  usuarioRepository.findOne(Integer.parseInt(id));
		if(usuario == null){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return new ResponseEntity<Usuario>(usuario, HttpStatus.CREATED );
	}
	
	
	@PutMapping()
	public ResponseEntity<Usuario> update(@RequestBody Usuario usuario){
		usuarioRepository.save(usuario);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.ACCEPTED);
	}
	
	
	
}
