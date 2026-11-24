package academia;

public class PlanoPremium extends Plano {
    public PlanoPremium() { super("Premium"); }

    @Override
    protected boolean permite(Atividade atividade) { return true; }
}
