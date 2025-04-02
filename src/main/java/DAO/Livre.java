package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Livre {
    public int isbn;
    public String titre;
    public String dateParution;
    public String domaine;
    public String auteur;
    public int nbExemplaire;

    public Livre() {

    }

    public Livre(int isbn, String titre, String dateParution, int nbExemplaire, String domaine, String auteur) {
        this.isbn = isbn;
        this.titre = titre;
        this.dateParution = dateParution;
        this.nbExemplaire = nbExemplaire;
        this.domaine = domaine;
        this.auteur = auteur;
    }

    public void Ajouter(Livre livre) {
        try {
            Statement statement= ConnexionBD.seConnecter().createStatement();
            statement.executeUpdate("insert into livre values("+this.isbn+",'"+this.titre+",'"+this.dateParution+",'"+this.nbExemplaire+",'"+this.auteur+",'"+this.domaine+",')");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void Supprimer(int isbn){
        try {
            Statement statement=ConnexionBD.seConnecter().createStatement();
            statement.executeUpdate("delete from livre where isbn="+isbn+"");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void modifier(int isbn, String titre, String dateParution, int nbExemplaire, String auteur, String domaine){
        try {
            Statement statement=ConnexionBD.seConnecter().createStatement();
            statement.executeUpdate("update livre set titre'"+titre+"',date_produ='"+dateParution+"',Nb_exemplaire="+nbExemplaire+",nom_auteur'"+auteur+"',domaine='"+domaine+"'where isbn="+isbn);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<Livre> getAllLivre(){
        List<Livre> ListLivre = new ArrayList<Livre>();
        try {
            Statement statement=ConnexionBD.seConnecter().createStatement();
            ResultSet resultSet=statement.executeQuery("select * from livre");

            setLivres((List<Livre>) ListLivre, resultSet);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return ListLivre;
    }
    public List<Livre> afficherParisbn(int isbn){
        List<Livre> ListLivre = new ArrayList<Livre>();
        try {
            Statement statement=ConnexionBD.seConnecter().createStatement();
            ResultSet resultSet=statement.executeQuery("select * from livre where isbn="+isbn+"");

            setLivres((List<Livre>) ListLivre, resultSet);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return ListLivre;
    }

    private void setLivres(List<Livre> listLivre, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            int isbn1=resultSet.getInt("isbn");
            String titre1=resultSet.getString("titre");
            String dateProdu1=resultSet.getString("date_produ");
            int nbExemplaire1=resultSet.getInt("Nb_exemplaire");
            String domaine1=resultSet.getString("domaine");
            String auteur1=resultSet.getString("auteur");
            listLivre.add(new Livre(isbn1,titre1, dateProdu1, nbExemplaire1, domaine1, auteur1));
        }
    }

}