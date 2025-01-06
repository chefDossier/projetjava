import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Press Alt+Entrée with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("1-Ajouter un agent");
        System.out.println("2-Modifier les infos d'un agent existant");
        System.out.println("3-Rechercher un agent par matricule");
        System.out.println("4-Afficher les agents d'un departement specifique");
        System.out.println("5-Generer des rapports sur un departement (statistiques)");
        System.out.println("6-Afficher les statistiques globales");
        System.out.println("7-Afficher les agents proches de la retraite pour toute la region");


        Scanner scanner = new Scanner(System.in);
        System.out.println("quelle operation souhaitez vous realiser ?");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice){
            case 1:
                System.out.println("entrer le nom de l'agent");
                String nom = scanner.nextLine();
                System.out.println("entrer le prenom de l'agent");
                String prenom = scanner.nextLine();
                System.out.println("entrer le grade de l'agent");
                String grade = scanner.nextLine();
                System.out.println("entrer le matricule de l'agent");
                String matricule = scanner.nextLine();
                System.out.println("entrer le genre de l'agent");
                String genre = scanner.nextLine();
                System.out.println("entrer la date de naissance de l'agent (jj/mm/aaaa)");
                String dnaiss = scanner.nextLine();
                System.out.println("entrer le departement de l'agent");
                String departement = scanner.nextLine();

                LocalDate dateNaiss = null;
                if (Region.getDepartment() != null){
                    for(Departement departement1:Region.getDepartment()){
                        if(departement1.getNom() == departement){
                            try {
                                dateNaiss = LocalDate.parse(dnaiss, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                            }catch (DateTimeParseException e){
                                System.out.println("erreur le format de la date est invalide");
                            }
                            Agent agent = new Agent(matricule,nom,prenom,genre,grade,departement,dateNaiss);
                            System.out.println("agent creer avec success");
                            break;
                        }
                    }

                }
                break;
            case 2:
                System.out.println("entrez le nom de du departement");
                String departement_af = scanner.nextLine();

                LocalDate newdateNaiss = null;
                if (Region.getDepartment() != null){
                    boolean trouver = false;
                    for(Departement departement1:Region.getDepartment()){
                        if(departement1.getNom() == departement_af){
                            System.out.println("entrez un nouveau nom si vous desirez le modifier");
                            String newnom = scanner.nextLine();
                            System.out.println("entrez un nouveau prenom si vous desirez le modifier");
                            String newprenom = scanner.nextLine();
                            System.out.println("entrez un nouveau grade si vous desirez le modifier");
                            String newgrade = scanner.nextLine();
                            System.out.println("entrez un nouveau genre si vous desirez le modifier");
                            String newgenre = scanner.nextLine();
                            System.out.println("entrez une nouvelle date de naissance si vous desirez le modifier");
                            String newdnaiss = scanner.nextLine();
                            System.out.println("entrez un nouveau matricule si vous desirez le modifier");
                            String newmatricule = scanner.nextLine();
                            System.out.println("entrez un nouveau departement si vous desirez le modifier");
                            String newdepartement = scanner.nextLine();
                            try {

                                newdateNaiss = LocalDate.parse(newdnaiss, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                            }catch (DateTimeParseException e){
                                System.out.println("erreur le format de la date est invalide");
                            }
                            trouver = true;
                            Agent agent = new Agent(newmatricule,newnom,newprenom,newgenre,newgrade,newdepartement,newdateNaiss);
                            System.out.println("agent modifier avec success");
                            break;
                        }
                    }
                    if(trouver){
                        System.out.println("aucun n'agent ne correspond");
                    }

                }else {
                    System.out.println("aucun departement n'existe pour le moment ");
                }
                break;

            case 3:
                System.out.println("entrer le matricule de l'agent");
                String matricule_re = scanner.nextLine();
                if (Region.getDepartment() != null) {

                    for (Departement departement1 : Region.getDepartment()) {
                        if (Agent.searchAgent(matricule_re, departement1.getListeAgent()) != null) {
                            Agent.searchAgent(matricule_re, departement1.getListeAgent());
                            System.out.println("trouver");
                            break;
                        }
                    }
                }
                break;
            case 4:
                System.out.println("entrer le nom du departement");
                String departement_aff = scanner.nextLine();
                if (Region.getDepartment() != null){
                    for(Departement departement1:Region.getDepartment()){
                        if(departement1.getNom() == departement_aff){
                            Agent.afficherAgents(departement1.getListeAgent());
                            break;
                        }
                    }

                }
                break;
            case 5:
                System.out.println("entrer le nom du departement");
                String nomD = scanner.nextLine();
                if (Region.getDepartment() != null){
                    for(Departement departement1:Region.getDepartment()){
                        if(departement1.getNom() == nomD){
                            Departement.genererRapport(departement1.getListeAgent());
                            break;
                        }
                    }

                }
                break;
            case 6:
                if (Region.getDepartment() != null){
                    Region.afficherStatGlobale();
                }else{
                    System.out.println("impossible car il n'existe aucun departement");
                }
                break;
            case 7:
                if (Region.getDepartment() != null){
                    Region.agentProcheRetReg();
                }else{
                    System.out.println("impossible car il n'existe aucun departement");
                }
                break;
            case 8:
                System.out.println("entrez le nom de la region");
                String nomR = scanner.nextLine();
                System.out.println("entrez des departements ? oui/non");
                String oui = scanner.nextLine();
                List<Departement> list_des_departement = new ArrayList<>();
                List<Agent> list_des_agents = new ArrayList<>();
                LocalDate n = LocalDate.parse("12/08/2000",DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                Agent fictif = new Agent("williamio","shakespeare","shake","h","a1","wouri",n);
                list_des_agents.add(fictif);
                Departement d = new Departement("wouri",list_des_agents);
                list_des_departement.add(d);
                System.out.println(oui);
                LocalDate date_of_burn = null;
                if(oui != "non"){

                        do{
                            System.out.println("entrez le nom du  departement");
                            String nomDep = scanner.nextLine();
                            System.out.println("entrez des agents ? yes/no");
                            String yes = scanner.nextLine();

                            if(yes != "yes"){

                                do{
                                    System.out.println("entrer le nom de l'agent");
                                    String name = scanner.nextLine();
                                    System.out.println("entrer le prenom de l'agent");
                                    String surname = scanner.nextLine();
                                    System.out.println("entrer le grade de l'agent");
                                    String level = scanner.nextLine();
                                    System.out.println("entrer le matricule de l'agent");
                                    String mat = scanner.nextLine();
                                    System.out.println("entrer le genre de l'agent");
                                    String gender = scanner.nextLine();
                                    System.out.println("entrer la date de naissance de l'agent (jj/mm/aaaa)");
                                    String burn = scanner.nextLine();
                                    System.out.println("entrer le departement de l'agent");
                                    String department = scanner.nextLine();
                                    try {
                                        date_of_burn = LocalDate.parse(burn, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                                    }catch (DateTimeParseException e){
                                        System.out.println("erreur le format de la date est invalide");
                                    }
                                    Agent agent = new Agent(mat,name,surname,gender,level,department,date_of_burn);
                                    System.out.println("agent creer avec success");
                                    System.out.println("do you want to add another agent ? yes/no");

                                    list_des_agents.add(agent);
                                    yes = scanner.nextLine();

                                }while(yes == "yes");

                            }
                            Departement dp = new Departement(nomDep,list_des_agents);
                            System.out.println("do you want to add another department ? oui/non");
                            list_des_departement.add(dp);
                            oui = scanner.nextLine();
                        }while (oui == "oui");
                        Region reg = new Region(list_des_departement);
                }
            break;

            default:
                System.out.println("no operations matches");


        }


        // Press Maj+F10 or click the green arrow button in the gutter to run the code.

    }
}