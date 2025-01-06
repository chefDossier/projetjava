import java.util.List;

public class Departement {


    private String nom;
    private static List<Agent> listeAgent;

    public Departement (String name,List<Agent> listeAgent){
        nom = name;
        for(Agent agent: listeAgent){
            this.listeAgent.add(agent);
        }
    }

    public static List<Agent> getListeAgent(){
        return listeAgent;
    }

    public String getNom(){
        return this.nom;
    }

    public void setNom(String nomD){
        nom = nomD;
    };
    public int nombreTotalAgents(){
        return listeAgent.size();
    }

    public static void genererRapport(List<Agent>listeAgent){
        int f = 0;
        int h = 0;
        int a1 = 0;
        int a2 = 0;
        int b1 = 0;
        for(Agent agent:listeAgent){
            if(agent.getGenre() == "f"){
                ++f;
            }else{
                ++h;
            }
            if(agent.getGrade() == "a1"){
                ++a1;
            }
            if(agent.getGrade() == "a2"){
                ++a2;
            }
            if(agent.getGrade() == "b1"){
                ++b1;
            }
        }
        System.out.println("nombre toral d'agents:"+listeAgent.size());
        System.out.println("Nombres d'agent proche de la retraite:"+Agent.nombreAgProcheRet(listeAgent));
    }

    public static void ajouterDepartements(Departement departement){
        Region.getDepartment().add(departement);
    };






}
