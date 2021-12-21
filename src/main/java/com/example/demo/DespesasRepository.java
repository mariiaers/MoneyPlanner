package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface DespesasRepository extends CrudRepository<Despesas, Integer>{
	public Long countById(Integer id);
}
