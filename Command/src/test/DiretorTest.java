package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import padrao.command.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiretorTest {
    Diretor diretor;
    Semestre semestre;

    @BeforeEach
    void setup() {
        diretor = new Diretor();
        semestre = new Semestre(2022, 2);
    }

    @Test
    void deveAbrirSemestre() {
        Tarefa aberturaSemestre = new AberturaSemestreFiscal(semestre);
        diretor.executarTarefa(aberturaSemestre);

        assertEquals("Semestre aberto", semestre.getSituacao());
    }

    @Test
    void deveFecharSemestre() {
        Tarefa fechamentoSemestre = new FechamentoSemestreFiscal(semestre);
        diretor.executarTarefa(fechamentoSemestre);

        assertEquals("Semestre fechado", semestre.getSituacao());
    }

    @Test
    void deveCancelarFechamentoSemestre() {
        Tarefa aberturaSemestre = new AberturaSemestreFiscal(semestre);
        Tarefa fechamentoSemestre = new FechamentoSemestreFiscal(semestre);

        diretor.executarTarefa(aberturaSemestre);
        diretor.executarTarefa(fechamentoSemestre);

        diretor.cancelarUltimaTarefa();

        assertEquals("Semestre aberto", semestre.getSituacao());
    }
}
