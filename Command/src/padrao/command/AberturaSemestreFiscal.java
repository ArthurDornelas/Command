package padrao.command;

public class AberturaSemestreFiscal implements Tarefa{
    private Semestre semestre;

    public AberturaSemestreFiscal(Semestre semestre) {
        this.semestre = semestre;
    }

    public void executar() {
        this.semestre.abrirSemestre();
    }

    public void cancelar() {
        this.semestre.fecharSemestre();
    }
}
