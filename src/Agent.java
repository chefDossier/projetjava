import java.time.LocalDate;
import java.time.Period;
import java.util.List;


public class Agent {

    private String matricule;
    private String nom;
    private String prenom;
    private String genre;
    private String grade;
    private LocalDate dateNaissance;
    private String departement;


    public Agent(String mat,String name,String surname,String type,String level,String department,LocalDate naiss){
        matricule = mat;
        nom = name;
        prenom = surname;
        genre = type;
        grade = level;
        departement = department;
        LocalDate dateNaissance = naiss;
    };

    public void afficherInfos(){
        System.out.println(matricule);
        System.out.println(nom);
        System.out.println(prenom);
        System.out.println(genre);
        System.out.println(grade);
        System.out.println(departement);
        System.out.println(dateNaissance);

    }
    public String getMatricule(){
        return matricule;
    }

    public int anneeAvRetraite(){
        return 60 - calculerAge();
    }
    public void setDateNaiss(String naiss){
        LocalDate dateNaissance = LocalDate.parse(naiss);
    }

    public int calculerAge(){
        LocalDate today = LocalDate.now();
        Period period = Period.between(dateNaissance,today);
        return period.getYears();
    }

    public String getGrade(){
        return this.grade;
    }

    public String getGenre(){
        return this.genre;
    }

    public String getPrenom(){
        return this.prenom;
    };

    public String getDepartment(){
        return this.departement;
    };

    public String getNom(){
        return this.nom;
    };

    public LocalDate getDateNaiss(){
        return this.dateNaissance;
    };

    public void setDepartement(String departement){
        this.departement = departement;
    }

    public void setPrenom(String prenom){
        this.prenom = prenom;
    }
    public void setGenre(String genre){
        this.genre = genre;
    }
    public void setGrade(String grade){
        this.grade = grade;
    }

    public void setMatricule(String matricule){
        this.matricule = matricule;
    }

    public void setNom(String nom){
        this.nom = nom;
    }
    public static Agent searchAgent(String matricule, List<Agent> agents){
        for(Agent a:agents){
            if (a.getMatricule().equalsIgnoreCase(matricule)){
                return a;
            }
        }
        return null;
    }

    public static void afficherAgents(List<Agent> agents){
        if(agents.isEmpty()){
            System.out.println("aucun agent trouvé");
        }else{
            System.out.println("liste des agent:");
            for(Agent agent:agents){
                System.out.println("Nom: " + agent.getNom());
                System.out.println("Prenom: " + agent.getPrenom());
                System.out.println("Matricule: " + agent.getMatricule());
                System.out.println("Date de naissance: "+agent.getDateNaiss());
                System.out.println("Grade: "+ agent.getGrade());
                System.out.println("Departement: " + agent.getDepartment());
                System.out.println("Genre:" + agent.getGenre());
            }
        }
    }

    public static void ajouterAgent(Agent agent,List<Agent> agents){
        agents.add(agent);
        System.out.println("Agent" + agent.getNom() + "ajouter avec succes");
    }

    public static void modifierAgent(Agent agent,Departement departement,String newnom,String newprenom,String newdatenaiss,String newmat,String newgrade,String newdepartement,String newgenre){
        if(departement.getListeAgent().contains(agent)){
            if(newdatenaiss != null){
                agent.setDateNaiss(newdatenaiss);
            }
            if(newnom != null){
                agent.setNom(newnom);
            }
            if(newdepartement != null){
                agent.setDepartement(newdepartement);
            }
            if(newprenom != null){
                agent.setPrenom(newprenom);
            }
            if(newgenre != null){
                agent.setGenre(newgenre);
            }
            if(newgrade != null){
                agent.setGrade(newgrade);
            }
            System.out.println("agent modified avec success");
        }else{
            System.out.println("agent non trouver");
        }
    }
    public static int nombreAgProcheRet(List<Agent> agents){
        int t = 0;
        for(Agent agent: agents){
            if(agent.anneeAvRetraite() <= 3){
                ++t;
            }
        }
        return t;
    }
}
