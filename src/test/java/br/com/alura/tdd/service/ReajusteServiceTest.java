package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {

    @Test
    void reajusteDeveriaSerdeTresPorcentoquandoDesempenhoForADesejar(){
        ReajusteService service = new ReajusteService();
        Funcionario funcionario = new Funcionario("Ana da Silva", LocalDate.now(), new BigDecimal("1000"));

        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);

        assertEquals(new BigDecimal("1030.00"),
                funcionario.getSalario());

    }

    @Test
    void reajusteDeveriaSerdeQuinzePorcentoquandoDesempenhoForBom(){
        ReajusteService service = new ReajusteService();
        Funcionario funcionario = new Funcionario("Ana da Silva", LocalDate.now(), new BigDecimal("1000"));

        service.concederReajuste(funcionario, Desempenho.BOM);

        assertEquals(new BigDecimal("1150.00"),
                funcionario.getSalario());

    }

    @Test
    void reajusteDeveriaSerdeVintePorcentoquandoDesempenhoForOtimo(){
        ReajusteService service = new ReajusteService();
        Funcionario funcionario = new Funcionario("Ana da Silva", LocalDate.now(), new BigDecimal("1000"));

        service.concederReajuste(funcionario, Desempenho.OTIMO);

        assertEquals(new BigDecimal("1200.00"),
                funcionario.getSalario());

    }
}
