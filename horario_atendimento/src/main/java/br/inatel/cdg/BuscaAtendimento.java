package br.inatel.cdg;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

public class BuscaAtendimento {

    AtendimentoService atendimentoService;

    public BuscaAtendimento(AtendimentoService atendimentoService) {
        this.atendimentoService = atendimentoService;
    }

    public Atendimento buscaPorProfessor(String nomeProf) {
        String atendimento = atendimentoService.buscaPorProfessor(nomeProf);
        JsonObject atendimentoRes = JsonParser.parseString(atendimento).getAsJsonObject();

        return new Atendimento(
            atendimentoRes.get("professor").getAsString(),
            atendimentoRes.get("horario").getAsString(),
            atendimentoRes.get("dia").getAsString(),
            atendimentoRes.get("materia").getAsString(),
            atendimentoRes.get("periodo").getAsString(),
            atendimentoRes.get("sala").getAsInt(),
            atendimentoRes.get("predio").getAsInt());

    }

    public Atendimento buscaPorPredio(int predio) {
        String atendimento = atendimentoService.buscaPorPredio(predio);
        JsonObject atendimentoRes = JsonParser.parseString(atendimento).getAsJsonObject();

        return new Atendimento(
            atendimentoRes.get("professor").getAsString(),
            atendimentoRes.get("horario").getAsString(),
            atendimentoRes.get("dia").getAsString(),
            atendimentoRes.get("materia").getAsString(),
            atendimentoRes.get("periodo").getAsString(),
            atendimentoRes.get("sala").getAsInt(),
            atendimentoRes.get("predio").getAsInt());
    }

    public Atendimento buscaPorPeriodo(String periodo) {
        String atendimento = atendimentoService.buscaPorPeriodo(periodo);
        JsonObject atendimentoRes = JsonParser.parseString(atendimento).getAsJsonObject();

        return new Atendimento(
            atendimentoRes.get("professor").getAsString(),
            atendimentoRes.get("horario").getAsString(),
            atendimentoRes.get("dia").getAsString(),
            atendimentoRes.get("materia").getAsString(),
            atendimentoRes.get("periodo").getAsString(),
            atendimentoRes.get("sala").getAsInt(),
            atendimentoRes.get("predio").getAsInt());
    }

    public Atendimento buscaPorSala(int sala) {
        String atendimento = atendimentoService.buscaPorSala(sala);
        JsonObject atendimentoRes = JsonParser.parseString(atendimento).getAsJsonObject();

        return new Atendimento(
            atendimentoRes.get("professor").getAsString(),
            atendimentoRes.get("horario").getAsString(),
            atendimentoRes.get("dia").getAsString(),
            atendimentoRes.get("materia").getAsString(),
            atendimentoRes.get("periodo").getAsString(),
            atendimentoRes.get("sala").getAsInt(),
            atendimentoRes.get("predio").getAsInt());
    }

    public Atendimento buscaPorHorario(String horario) {
        String atendimento = atendimentoService.buscaPorHorario(horario);
        JsonObject atendimentoRes = JsonParser.parseString(atendimento).getAsJsonObject();

        return new Atendimento(
            atendimentoRes.get("professor").getAsString(),
            atendimentoRes.get("horario").getAsString(),
            atendimentoRes.get("dia").getAsString(),
            atendimentoRes.get("materia").getAsString(),
            atendimentoRes.get("periodo").getAsString(),
            atendimentoRes.get("sala").getAsInt(),
            atendimentoRes.get("predio").getAsInt());
    }

    public Atendimento buscaPorMateria(String materia){
        String atendimento = atendimentoService.buscaPorMateria(materia);
        JsonObject atendimentoRes = JsonParser.parseString(atendimento).getAsJsonObject();

        return new Atendimento(
            atendimentoRes.get("professor").getAsString(),
            atendimentoRes.get("horario").getAsString(),
            atendimentoRes.get("dia").getAsString(),
            atendimentoRes.get("materia").getAsString(),
            atendimentoRes.get("periodo").getAsString(),
            atendimentoRes.get("sala").getAsInt(),
            atendimentoRes.get("predio").getAsInt());
    }

    public List<Atendimento> buscaPorDia(String dia) {
        List<String> atendimentos = atendimentoService.buscaPorDia(dia);
        List<Atendimento> atendimentosRes = new ArrayList<>();
        for(String atendimento : atendimentos) {
            JsonObject atendimentoRes = JsonParser.parseString(atendimento).getAsJsonObject();
            atendimentosRes.add( new Atendimento(
                atendimentoRes.get("professor").getAsString(),
                atendimentoRes.get("horario").getAsString(),
                atendimentoRes.get("dia").getAsString(),
                atendimentoRes.get("materia").getAsString(),
                atendimentoRes.get("periodo").getAsString(),
                atendimentoRes.get("sala").getAsInt(),
                atendimentoRes.get("predio").getAsInt()));
        }
        return atendimentosRes;
    }

    public List<Atendimento> listaAtendimentos() {
        List<String> atendimentos = atendimentoService.listaAtendimentos();
        List<Atendimento> atendimentosRes = new ArrayList<>();
        for(String atendimento : atendimentos) {
            JsonObject atendimentoRes = JsonParser.parseString(atendimento).getAsJsonObject();
            atendimentosRes.add( new Atendimento(
                atendimentoRes.get("professor").getAsString(),
                atendimentoRes.get("horario").getAsString(),
                atendimentoRes.get("dia").getAsString(),
                atendimentoRes.get("materia").getAsString(),
                atendimentoRes.get("periodo").getAsString(),
                atendimentoRes.get("sala").getAsInt(),
                atendimentoRes.get("predio").getAsInt()));
        }
        return atendimentosRes;
    }

}