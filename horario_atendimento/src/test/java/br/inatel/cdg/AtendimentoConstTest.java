package br.inatel.cdg;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class AtendimentoConstTest {

    @Mock
    private AtendimentoService service;
    private BuscaAtendimento buscaAtendimento;

    @Before
    public void setup() {
        this.buscaAtendimento = new BuscaAtendimento(this.service);
    }

    // 10 Casos de Sucesso

    @Test
    public void testeBuscaPorProfessorRenan() {
        Mockito.when(this.service.buscaPorProfessor("Renan Sthel Duque")).thenReturn(AtendimentoConst.RENAN);
        Atendimento atendimento = this.buscaAtendimento.buscaPorProfessor("Renan Sthel Duque");
        Assert.assertEquals("Renan Sthel Duque", atendimento.getProfessor());
    }

    @Test
    public void testeBuscaPorDiaSegunda() {
        Mockito.when(this.service.buscaPorDia("Segunda")).thenReturn(Collections.singletonList(AtendimentoConst.RENAN));
        List<Atendimento> atendimentos = this.buscaAtendimento.buscaPorDia("Segunda");
        Assert.assertEquals(1, atendimentos.size());
        Assert.assertEquals("Renan Sthel Duque", atendimentos.get(0).getProfessor());
    }

    @Test
    public void testeBuscaPorPredio1() {
        Mockito.when(this.service.buscaPorPredio(1)).thenReturn(AtendimentoConst.RENAN);
        Atendimento atendimento = this.buscaAtendimento.buscaPorPredio(1);
        Assert.assertEquals("Renan Sthel Duque", atendimento.getProfessor());
    }

    @Test
    public void testeBuscaPorSala12() {
        Mockito.when(this.service.buscaPorSala(12)).thenReturn(AtendimentoConst.CARLOS);
        Atendimento atendimento = this.buscaAtendimento.buscaPorSala(12);
        Assert.assertEquals("Carlos Alberto Ynogute", atendimento.getProfessor());
    }

    @Test
    public void testeBuscaPorHorario1630() {
        Mockito.when(this.service.buscaPorHorario("16:30")).thenReturn(AtendimentoConst.MARCELO);
        Atendimento atendimento = this.buscaAtendimento.buscaPorHorario("16:30");
        Assert.assertEquals("Marcelo Cysneiros", atendimento.getProfessor());
    }

    @Test
    public void testeBuscaPorProfessorMarcelo() {
        Mockito.when(this.service.buscaPorProfessor("Marcelo Cysneiros")).thenReturn(AtendimentoConst.MARCELO);
        Atendimento atendimento = this.buscaAtendimento.buscaPorProfessor("Marcelo Cysneiros");
        Assert.assertEquals("Marcelo Cysneiros", atendimento.getProfessor());
    }

    @Test
    public void testeBuscaPorPeriodoNoturno() {
        Mockito.when(this.service.buscaPorPeriodo("Noturno")).thenReturn(AtendimentoConst.CHRISTOPHER);
        Atendimento atendimento = this.buscaAtendimento.buscaPorPeriodo("Noturno");
        Assert.assertEquals("Christopher Lima", atendimento.getProfessor());
    }

    @Test
    public void testeBuscaPorDiaSexta() {
        Mockito.when(this.service.buscaPorDia("Sexta")).thenReturn(Collections.singletonList(AtendimentoConst.GUILHERME));
        List<Atendimento> atendimentos = this.buscaAtendimento.buscaPorDia("Sexta");
        Assert.assertEquals("Guilherme Aquino", atendimentos.get(0).getProfessor());
    }

    @Test
    public void testeBuscaPorSala18() {
        Mockito.when(this.service.buscaPorSala(18)).thenReturn(AtendimentoConst.YVO);
        Atendimento atendimento = this.buscaAtendimento.buscaPorSala(18);
        Assert.assertEquals("Yvo Marcelo", atendimento.getProfessor());
    }

    @Test
    public void testeBuscaPorProfessorGuilherme() {
        Mockito.when(this.service.buscaPorProfessor("Guilherme Aquino")).thenReturn(AtendimentoConst.GUILHERME);
        Atendimento atendimento = this.buscaAtendimento.buscaPorProfessor("Guilherme Aquino");
        Assert.assertEquals("Guilherme Aquino", atendimento.getProfessor());
    }

    // 10 Casos de Falha

    @Test(expected = IllegalArgumentException.class)
    public void testeBuscaPorProfessorNaoEncontrado() {
        Mockito.when(this.service.buscaPorProfessor("João Silva")).thenThrow(new IllegalArgumentException("Professor não encontrado"));
        this.buscaAtendimento.buscaPorProfessor("João Silva");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testeBuscaPorHorarioInvalido() {
        Mockito.when(this.service.buscaPorHorario("25:00")).thenThrow(new IllegalArgumentException("Horário inválido"));
        this.buscaAtendimento.buscaPorHorario("25:00");
    }

    @Test
    public void testeBuscaPorDiaDomingo() {
        Mockito.when(this.service.buscaPorDia("Domingo")).thenReturn(Collections.emptyList());
        List<Atendimento> atendimentos = this.buscaAtendimento.buscaPorDia("Domingo");
        Assert.assertEquals(0, atendimentos.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testeBuscaPorPredioNaoEncontrado() {
        Mockito.when(this.service.buscaPorPredio(7)).thenThrow(new IllegalArgumentException("Prédio não encontrado"));
        this.buscaAtendimento.buscaPorPredio(7);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testeBuscaPorSalaNaoEncontrada() {
        Mockito.when(this.service.buscaPorSala(100)).thenThrow(new IllegalArgumentException("Sala não encontrada"));
        this.buscaAtendimento.buscaPorSala(100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testeBuscaPorPeriodoNaoEncontrado() {
        Mockito.when(this.service.buscaPorPeriodo("Vespertino")).thenThrow(new IllegalArgumentException("Período não encontrado"));
        this.buscaAtendimento.buscaPorPeriodo("Vespertino");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testeBuscaPorNomeComCaracteresEspeciais() {
        Mockito.when(this.service.buscaPorProfessor("!@#$%")).thenThrow(new IllegalArgumentException("Nome contém caracteres inválidos"));
        this.buscaAtendimento.buscaPorProfessor("!@#$%");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testeBuscaPorMateriaNaoEncontrada() {
        Mockito.when(this.service.buscaPorMateria("C999")).thenThrow(new IllegalArgumentException("Matéria não encontrada"));
        this.buscaAtendimento.buscaPorMateria("C999");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testeBuscaPorHorarioVazio() {
        Mockito.when(this.service.buscaPorHorario("")).thenThrow(new IllegalArgumentException("Horário inválido"));
        this.buscaAtendimento.buscaPorHorario("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testeBuscaPorSalaNegativa() {
        Mockito.when(this.service.buscaPorSala(-1)).thenThrow(new IllegalArgumentException("Sala inválida"));
        this.buscaAtendimento.buscaPorSala(-1);
    }
}