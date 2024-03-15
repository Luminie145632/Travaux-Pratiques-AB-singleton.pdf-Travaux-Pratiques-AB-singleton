public class ArbreBinaire {
    // Attributs clef, gauche et droite
    private Integer clef;
    private ArbreBinaire gauche;
    private ArbreBinaire droite;
    
    // L'attribut Singleton pour l'arbre de Vide
    private static ArbreBinaire arbreVide;
    
    // Constructeur pour l'attribut Singleton
    public ArbreBinaire() {
        this.clef = null;
        this.gauche = null;
        this.droite = null;
    }

    // Constructeur avec les paramètres clef / gauche / droite
    public ArbreBinaire(Integer clef, ArbreBinaire gauche, ArbreBinaire droite) {
        this.clef = clef;
        this.gauche = gauche;
        this.droite = droite;
    }
        
    // Méthode getArbreVide qui permet d'obtenir l'instance unique de l'arbreVide
    public static ArbreBinaire getArbreVide() {
        if (arbreVide == null) {
            arbreVide = new ArbreBinaire();
        }
        return arbreVide;
    }
    
    // Les getters et les setters pour la clef
    public Integer getClef() {
        return clef;
    }
    
    public void setClef(Integer clef) {
        this.clef = clef;
    }
        
    // Les getters et les setters pour le sous-arbre de gauche
    public ArbreBinaire getGauche() {
        return gauche;
    }
    
    public void setGauche(ArbreBinaire gauche) {
        this.gauche = gauche;
    }
        
    // Les getters et les setters pour le sous-arbre de droite
    public ArbreBinaire getDroite() {
        return droite;
    }
    
    public void setDroite(ArbreBinaire droite) {
        this.droite = droite;
    }
    
    // Méthode qui crée l'arbre vide
    public static ArbreBinaire créer() {
        return getArbreVide();
    }
    
    // Méthode pour vérifier si l'arbre est vide
    public boolean estVide() {
        return this == arbreVide;
    }

    // Méthode pour calculer la taille de l'arbre
    public int taille() {
        if (this.estVide()) {
            return 0;
        } else {
            return 1 + this.gauche.taille() + this.droite.taille();
        }
    }

    // Méthode pour rechercher une valeur mis celle qui sont dans l'arbre
    public boolean rechercher(Integer valeur) {
        if (this.estVide()) {
            return false;
        } else if (this.clef.equals(valeur)) {
            return true;
        } else if (valeur < this.clef) {
            return this.gauche.rechercher(valeur);
        } else {
            return this.droite.rechercher(valeur);
        }
    }

    // Méthode pour insérer une valeur dans l'arbre
    public static ArbreBinaire inserer(ArbreBinaire arbre, Integer valeur) {
        // L'arbre est vide alors on crée un nouvel arbre avec la valeur donnée
        if (arbre == null || arbre == ArbreBinaire.getArbreVide()) {
            return new ArbreBinaire(valeur, ArbreBinaire.getArbreVide(), ArbreBinaire.getArbreVide());
        }
        
        // Ajout de la valeur dans l'un des 2 sous-arbres "gauche" ou "droite" en fonction de sa valeur
        if (valeur < arbre.getClef()) {
            arbre.setGauche(inserer(arbre.getGauche(), valeur));
        } else if (valeur > arbre.getClef()) {
            arbre.setDroite(inserer(arbre.getDroite(), valeur));
        }
        
        return arbre;
    }
    
    // Méthode pour afficher l'arbre
    public static void afficherArbre(ArbreBinaire arbre) {
        if (arbre != null && arbre != ArbreBinaire.getArbreVide()) {
            afficherArbre(arbre.getGauche());
            System.out.print(arbre.getClef() + " ");
            afficherArbre(arbre.getDroite());
        }
    }
}
