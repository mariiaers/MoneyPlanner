package com.example.demo;

import java.util.Optional;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class DespesasRepositoryTest {
	@Autowired private DespesasRepository repo;
	@Test
	public void testAddNew() {
		Despesas despesas = new Despesas();
		despesas.setData("11/02/2021");
		despesas.setTipo("Lucro");
		despesas.setDescricao("Pagamento - cjhj");
		despesas.setValor("50.80");
		despesas.setStatus(null);
		despesas.setFormapg("Dinheiro");
	
		Despesas savedDespesa = repo.save(despesas);
		
		Assertions.assertThat(savedDespesa).isNotNull();
		Assertions.assertThat(savedDespesa.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testListAll() {
		Iterable<Despesas> despesas = repo.findAll();
		Assertions.assertThat(despesas).hasSizeGreaterThan(0);
		
		for (Despesas despesa : despesas) {
			System.out.println(despesa);
		}
	}
	
	@Test
	public void testUpdate() {
		Integer despesasId = 15;
		Optional<Despesas> optionalDespesas = repo.findById(despesasId);
		Despesas despesas = optionalDespesas.get();
		despesas.setFormapg("Pix");
		repo.save(despesas);
		
		Despesas updateDespesa = repo.findById(despesasId).get();
		Assertions.assertThat(updateDespesa.getFormapg()).isEqualTo("Pix");
		
	}
	
	@Test
	public void testGet() {
		Integer despesasId = 15;
		Optional<Despesas> optionalDespesas = repo.findById(despesasId);
		Assertions.assertThat(optionalDespesas).isPresent();
		System.out.println(optionalDespesas.get());
	}
	
	@Test
	public void testDelete() {
		Integer despesasId = 17;
		repo.deleteById(despesasId);
		
		Optional<Despesas> optionalDespesas = repo.findById(despesasId);
		Assertions.assertThat(optionalDespesas).isNotPresent();
	}
}
