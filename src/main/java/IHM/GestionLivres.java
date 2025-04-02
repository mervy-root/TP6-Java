package IHM;

import DAO.Livre;

import javax.swing.*;
import java.awt.*;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Date;




public class GestionLivres extends JFrame {

    private JPanel panel_main;


    /*Declaraction du panel Gestion des Livres*/

    private JPanel panel_gestion_livres;


    private JLabel Label_ISBN;
    private JTextField txt_isbn;

    private JLabel Titre;
    private JTextField txt_titre;

    private JSpinner date_production;
    private JTextField txt_nbexmp;

    private JTextField txt_auteur;
    private JLabel Label_nom_auteur;

    private JComboBox cbox_domaine;
    private JLabel Label_domaine;

    private JLabel Label_date_production;
    private JLabel Label_nbre_exmpl;

    private JButton btn_enregistrer;
    private JButton btn_modifier;
    private JButton btn_supprimer;
    private JButton btn_lister_les_exemplaires;
    private JButton btn_annuler;

    private JPanel panel_recherche_livres;
    private JPanel panel_listes_livres;


    private final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    public GestionLivres() {
        setTitle("Gestion des Livres");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        setContentPane(panel_main);


        setVisible(true);
        //$$$setupUI$$$(); // Important pour charger les composants du UI Designer
    }

   /* public GestionLivres() {
        $$$SetupUI$$$();

    }*/
    /* public GestionLivres() {
        GestionLivre.setTitle("Gestion des Livres");
        GestionLivre.setSize(600, 500);
        GestionLivre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GestionLivre.setLocationRelativeTo(null);

        $$$SetupUI$$$(); // Initialisation de l'interface
    } */


    private void $$$SetupUI$$$() {
        // Création du panneau principal
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Ajout des sections
        mainPanel.add(createInfoPanel(), BorderLayout.NORTH);
        mainPanel.add(createSearchPanel(), BorderLayout.CENTER);
        mainPanel.add(createListPanel(), BorderLayout.SOUTH);

        // Ajout du panneau principal à la JFrame
        setContentPane(mainPanel);
    }

    private Component createInfoPanel() {

        return null;
    }

    //3. Code du bouton  Enregistrer
    private void btn_saveActionPerformed(java.awt.event.ActionEvent event) {
        int isbn=Integer.parseInt(txt_isbn.getText());
        String titre=txt_titre.getText();
        String dateProduction = formatter.format(date_production.getValue());
        //String dateProduction=date_production.getValue().toString();
        int nbExemplaires=Integer.parseInt(txt_nbexmp.getText());
        String auteur=txt_auteur.getText();
        String domaine=cbox_domaine.getSelectedItem().toString();

        Livre livre = new Livre(isbn, titre, dateProduction, nbExemplaires, auteur, domaine);
        livre.Ajouter(livre);

        JOptionPane.showMessageDialog(null, "Ajoute avec succes !", "Insertion", JOptionPane.INFORMATION_MESSAGE);
        /*booklistes.removeAll();
        Actualiser();*/
        vider();
    }

    private Component createSearchPanel() {
        return null;
    }

    private Component createListPanel() {
        return null;
    }

    public void vider(){
        txt_isbn.setText("");
        txt_titre.setText("");
        txt_nbexmp.setText("");
        txt_auteur.setText("");
        cbox_domaine.setSelectedItem(-1);
    }

    /*String[][] tab;
    public void Actualiser(){
        Livre livre=new Livre();
        int i=0;
3
        List<Livre> livreList = livre.getAllLivre();
        tab=new String[livreList.size()+1][6];
        for(Livre livre1:livreList){
            tab[i][0]=""+livre1.isbn;
            tab[i][1]=livre1.titre;
            tab[i][2]=livre1.dateParution;
            tab[i][3]=""+livre1.nbExemplaire;
            tab[i][4]=""+livre1.auteur;
            tab[i][5]=livre1.domaine;
            i++;
        }
        String[] entet=new String[]{"Isbn", "Titre", "Date Parution", "NombreExemplaire", "Auteur", "Domaine"};
        booklistes.setModel(new javax.swing.table.DefaultTableModel(tab,entet));
    }*/

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GestionLivres Application = new GestionLivres();
            //GestionLivre.setVisible(true);

        });
    }




}
