import java.util.List;

public class Region {

    private static List<Departement> listedepartements;

    public Region(List<Departement> listedepartements) {
        for (Departement departement : listedepartements) {
            this.listedepartements.add(departement);
        }
    }

    public static List<Departement> getDepartment() {
        return listedepartements;
    }

    public static void afficherStatGlobale() {
        int totalAgent = 0;
        for (Departement departement : listedepartements) {
            System.out.println("le departement:" + departement.getNom() + " compte: " + departement.nombreTotalAgents() + "agents");

            totalAgent += departement.nombreTotalAgents();
            int a1 = 0;
            int a2 = 0;
            int b1 = 0;
            int f = 0;
            int h = 0;

            for (Agent agent : departement.getListeAgent()) {
                a1 += (agent.getGrade() == "a1") ? 1 : 0;
                a2 += (agent.getGrade() == "a2") ? 1 : 0;
                b1 += (agent.getGrade() == "b1") ? 1 : 0;
                f += (agent.getGenre() == "f") ? 1 : 0;
                h += (agent.getGenre() == "h") ? 1 : 0;

            }
             System.out.println("nombres de femmes: " + f );
             System.out.println("nombres d'hommes: " + h );
             System.out.println("agent de grade a1: " + a1 );
             System.out.println("agent de grade a2: " + a2);
             System.out.println("agent de grade b1: " + b1);
        }

    }
    public static void agentProcheRetReg() {
        int tAgentret = 0;
        for (Departement departement : listedepartements) {
            tAgentret += Agent.nombreAgProcheRet(departement.getListeAgent());
        }
        System.out.println("Nombre d'agents proche de la retraite pour toute la region: "+tAgentret);
    }

}
