public class Personne {
    public String nom;
    private String prenom;
    private int age;
    public static int poids = 0;

   

    
    public Personne(){
        this.nom = "nom";
        this.prenom = "prenom";
        this.age = 0;
        //poids = 12;

        
    }
    
    public Personne(String nom, String prenom, int age){
        
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
       // poids = 30;
    }

        public Personne(String nom){

        }

    public Personne(String nom, String prenom){

    }

    public Personne(int age){

    }
    
    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    


    public void papa(){
        System.out.println("PaPa");
    }
    

}
