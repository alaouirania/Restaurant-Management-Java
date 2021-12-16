package Main;

import entities.items;
import entities.users;
import entities.order;
import entities.orderLine;
import frames.AdminHome;
import frames.Cashier;
import frames.CashierSearch;
import frames.Login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main {

    String category,dishname;
    //public static admin_dashbboard admin_dashbboard = new admin_dashbboard();
    public static AdminHome AdminHome = new AdminHome();
    
    public static ArrayList<items> itemsList = new ArrayList<items>();
    //public static ArrayList<users> userList = new ArrayList<users>();
    public static ArrayList<order> ordersList = new ArrayList<order>();
    public static ArrayList<order> ordersListById = new ArrayList<order>();
    public static ArrayList<orderLine> order_List = new ArrayList<orderLine>();
   
    
    public static Connection connection = null;


    public static void openConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/risto", "root", "");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error on openning connection : " + e.getMessage());
        }
    }

      public static void main(String[] args) {
        AdminHome.loaditems();
        AdminHome.setVisible(true);
        //order.loadordersFromDatabase(Main.ordersList);
                   
       
        //new CashierSearch().setVisible(true);
        //CashierSearch.loadorders();
                    
        new Login().setVisible(true);
        

    }
    
       
}
