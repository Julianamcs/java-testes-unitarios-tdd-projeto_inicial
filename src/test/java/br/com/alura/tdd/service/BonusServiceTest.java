package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.*;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

class BonusServiceTest {

	@Test
	void bonusDeveriaSerZeroparaFuncionarioComSalarioMuitoAlto() {

		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Ana da Silva", LocalDate.now(), new BigDecimal("25000")));

		assertEquals(BigDecimal.ZERO, bonus);
	}

}
