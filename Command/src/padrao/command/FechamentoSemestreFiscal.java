package padrao.command;

public class FechamentoSemestreFiscal implements Tarefa{
    private Semestre semestre;

    public FechamentoSemestreFiscal(Semestre semestre) {
        this.semestre = semestre;
    }

    public void executar() {
        this.semestre.fecharSemestre();
    }

    public void cancelar() {
        this.semestre.abrirSemestre();
    }
}
