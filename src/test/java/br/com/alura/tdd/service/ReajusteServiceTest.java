package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {

    private ReajusteService service;
    private Funcionario funcionario;

    @BeforeEach
    public void inicializar(){
        this.service = new ReajusteService();
        this.funcionario = new Funcionario("Ana da Silva", LocalDate.now(), new BigDecimal("1000"));
    }

    @AfterEach
    public void resultados(){
        System.out.println(funcionario.getSalario());
    }

    @BeforeAll
    public static void antesDeTodos(){
        System.out.println("Inicializando o teste");
    }

    @AfterAll
    public static void depoisDeTodos(){
        System.out.println("Finalizando o teste");
    }

    @Test
    void reajusteDeveriaSerdeTresPorcentoquandoDesempenhoForADesejar(){
        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"),
                funcionario.getSalario());
    }

    @Test
    void reajusteDeveriaSerdeQuinzePorcentoquandoDesempenhoForBom(){
        service.concederReajuste(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"),
                funcionario.getSalario());
    }

    @Test
    void reajusteDeveriaSerdeVintePorcentoquandoDesempenhoForOtimo(){
        service.concederReajuste(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"),
                funcionario.getSalario());
    }
}
