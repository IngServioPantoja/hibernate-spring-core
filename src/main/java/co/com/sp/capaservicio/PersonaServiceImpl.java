package co.com.sp.capaservicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.sp.capadatos.PersonaDao;
import co.com.sp.capadatos.domain.Persona;

@Service("personaService")
@Transactional
public class PersonaServiceImpl implements PersonaService {
	
	@Autowired
	private PersonaDao personaDao;

	public List<Persona> listarPersonas() {
		List<Persona> lstResult = personaDao.findAllPersonas();
		for (Persona persona : lstResult) {
			System.out.println(persona.getApeMaterno());
		}
		return lstResult;
	}

	public Persona recuperarPersona(Persona persona) {
		return personaDao.findPersonaById(persona.getIdPersona());
	}

	public void agregarPersona(Persona persona) {
		personaDao.insertPersona(persona);
	}

	public void modificarPersona(Persona persona) {
		personaDao.updatePersona(persona);
	}

	public void eliminarPersona(Persona persona) {
		personaDao.deletePersona(persona);
	}
}