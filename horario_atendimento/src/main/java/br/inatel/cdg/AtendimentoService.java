package br.inatel.cdg;

import java.util.List;

public interface AtendimentoService {

    public String buscaPorProfessor(String nomeProf);

    public String buscaPorPredio(int predio);

    public String buscaPorPeriodo(String periodo);

    public String buscaPorSala(int sala);

    public String buscaPorHorario(String horario);

    public List<String> buscaPorDia(String dia);

    public String buscaPorMateria(String materia);

    public List<String> listaAtendimentos();

    public void adicionaAtendimento(String atendimento);

    public void removeAtendimento(String atendimento);

    public void atualizaAtendimento(String atendimento);

    public void limpaAtendimentos();

 

}