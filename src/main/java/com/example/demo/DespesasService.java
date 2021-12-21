package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DespesasService {

	@Autowired private DespesasRepository repo;
	
	public List<Despesas> listAll(){
		return (List<Despesas>) repo.findAll();
	}

	public void save(Despesas despesa) {
		repo.save(despesa);
	}
	
	public Despesas get(Integer id) throws DespesaNotFoundException {
		Optional<Despesas> result = repo.findById(id);
		if (result.isPresent()) {
			return result.get();
		}
		throw new DespesaNotFoundException("Não foi possivel encontrar despesas com esse id:" + id);
	}
	
	public void delete(Integer id) throws DespesaNotFoundException {
		Long count = repo.countById(id);
		if (count == null || count == 0) {
			throw new DespesaNotFoundException("Não foi possivel encontrar despesas com esse id:" + id);
		}
		repo.deleteById(id);
	}
}
