package br.com.alura.tdd.service;

import static java.math.BigDecimal.*;
import static org.junit.jupiter.api.Assertions.*;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;

import java.math.BigDecimal;
import java.time.LocalDate;

class BonusServiceTest {

	@Test
	void bonusDeveriaSerZeroparaFuncionarioComSalarioMuitoAlto() {
		BonusService service = new BonusService();

		assertThrows(IllegalArgumentException.class,
			()  -> service.calcularBonus(new Funcionario("Ana da Silva", LocalDate.now(), new BigDecimal("25000"))));

		/**try{
			service.calcularBonus(new Funcionario("Ana da Silva", LocalDate.now(), new BigDecimal("25000")));
			fail("Não Caiu na Condição de bonus!");
		} catch (Exception e){
			assertEquals("Funcionario com salario maior que 10000 não pode recerber Bonus!", e.getMessage());
		}*/
	}

	@Test
	void bonusDeveriaSer10PorcentoDoSalario(){
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Ana da Silva", LocalDate.now(), new BigDecimal("2500")));
		assertEquals(new BigDecimal("250.00"), bonus);
		System.out.println(bonus);
	}

	@Test
	void bonusDeveriaSerDezPorcentoParaSalarioDeExatamente10000(){
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Ana da Silva", LocalDate.now(), new BigDecimal("10000")));
		assertEquals(new BigDecimal("1000.00"), bonus);
		System.out.println(bonus);
	}

}
