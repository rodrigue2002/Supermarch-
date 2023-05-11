import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Article{
    private String nom;
    private  double prix;
    private boolean enSolde;

    public Article(String nom, double prix, boolean enSolde){
        this.nom = nom;
        this.prix = prix;
        this.enSolde = enSolde;
    }

    public String getNom(){
        return this.nom;
    }

    public double getPrix(){
        return this.prix;
    }

    public  double quantitePrix(int quantite){
        return quantite * this.prix;
    }
   public static void main(String[] args){
    
        System.out.println("voici les produits que nous avons en stock : ");
        Article choufleur = new Article("Chou-fleur extra", 3.50, false);
        Article roman = new Article("Les malheurs de Sophie", 16.50, true);
        Article camembert = new Article("Cremeux 100%MG", 5.80, false);
        Article cdrom = new Article("C++ en trois jours", 48.50, false);
        Article boisson = new Article("Petit-lait", 2.50, true);
        Article petitspois = new Article("Pois surgeles", 4.35, false);
        Article poisson = new Article("Sardines", 6.50, false);
        Article biscuits = new Article("Cookies de grand-mere", 3.20, false);
        Article poires = new Article("Poires Williams", 4.80, false);
        Article cafe = new Article("100% Arabica", 6.90, true);
        Article pain = new Article("Pain d'epautre", 6.90, false);
        Article[] b = new Article[]{choufleur, roman, camembert, cdrom, boisson, petitspois, poisson, biscuits, poires, cafe, pain};
        System.out.println(choufleur +"\n" + roman +"\n" + camembert +"\n" + cdrom +"\n" + boisson +"\n" + petitspois +"\n" + poisson +"\n" + biscuits +"\n" + poires +"\n" + cafe +"\n" + pain);
        System.out.println("que voulez vous mettre dans votre caddie ?");
        Scanner sc = new Scanner(System.in);
        String[] totalArticle = new String[11];
        System.out.println();
        System.out.println("entrez les noms des articles que vous voulez choisir : ");
        int [] quantite = new int[11];
        for(int i = 0; i < totalArticle.length; i++){
            System.out.print("article " + (i+1) + " : ");
            String s = sc.nextLine();
            totalArticle[i] = verifieArticleIsInListe(b, s); 
            System.out.print("quantité : ");
            int q = sc.nextInt();
            quantite[i] = q;
            sc.nextLine();   // pour vider le scanner   
        }

        System.out.println();
        System.out.println("voici votre facture : \n");
        System.out.println("=====================================");
        Date dateCourante = new Date();
        SimpleDateFormat formatage = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println( formatage.format(dateCourante));
        System.out.println();

        for(int i = 0; i < totalArticle.length; i++){
            System.out.println(totalArticle[i] + " : " + correspondanceArticle(totalArticle[i],b).prix + " x " + quantite[i] + " = " + correspondanceArticle(totalArticle[i], b).quantitePrix(quantite[i]) + " euro");
        }
        double d = 0;
        for(int i = 0; i < totalArticle.length; i++){
            d += correspondancePrix(totalArticle[i], b, quantite);
        }
        System.out.println();
        System.out.println("Montant a payer : " + d + " euro" );
        System.out.println("=====================================");
   }
   

   public static Article correspondanceArticle(String a , Article[] b){
       for (int i = 0 ; i < b.length ; i++){
          if (a.equals(b[i].nom))  return b[i];
       }
          return null;
   }
   public static double correspondancePrix(String a , Article[] b, int[] c){
       double d = 0;
       for (int i = 0 ; i < b.length ; i++){
          if (a.equals(b[i].nom)) d = b[i].prix * c[i];
       }
            return d;
   }

   public String toString(){
        if (this.enSolde == true){
        	  return this.nom + ", " + this.prix + " euro," + " en solde";
        }
        else{
          return this.nom + ", " + this.prix +" euro";
        }
    }
            
    public static String verifieArticleIsInListe(Article[]a ,String s){
            for(int j = 0; j < a.length; j++){
                if(s.equals(a[j].nom)){
                  return s;
                }
            }
            System.out.println("cet article n'est pas dans la liste choisissez en un autre :");
            Scanner sc = new Scanner(System.in);
             String s1 = sc.nextLine();
             s = s1;
            return verifieArticleIsInListe(a, s1);
    }

    public static double montantApayer(double[]s){
        double somme = 0;
        for(int i = 0; i < s.length; i++){
            somme += s[i];
        }
        return somme;
    }
}

