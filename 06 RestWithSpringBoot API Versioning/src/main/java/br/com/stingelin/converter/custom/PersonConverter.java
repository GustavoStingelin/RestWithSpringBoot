package br.com.stingelin.converter.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.stingelin.data.model.Person;
import br.com.stingelin.data.vo.v2.PersonVOV2;

@Service
public class PersonConverter {
	
	public PersonVOV2 convertEntityToVO(Person person) {
		PersonVOV2 vo = new PersonVOV2();
		vo.setFirstName(person.getFirstName());
		vo.setLastName(person.getLastName());
		vo.setId(person.getId());
		vo.setGender(person.getGender());
		vo.setAddress(person.getAddress());
		vo.setBirthday(new Date());
		return vo;
	}
	
	public Person convertVOToEntity(PersonVOV2 vo) {
		Person entity = new Person();
		entity.setFirstName(vo.getFirstName());
		entity.setLastName(vo.getLastName());
		entity.setId(vo.getId());
		entity.setGender(vo.getGender());
		entity.setAddress(vo.getAddress());
		return entity;
	}
}
