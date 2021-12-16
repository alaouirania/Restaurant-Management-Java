package frames;


import Main.Main;
import Components.ProductPanel;
import Components.ProductPanel1;
import entities.items;
import java.awt.FlowLayout;
import frames.KioskHome;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;
import java.text.SimpleDateFormat;
import frames.Receipt;
import static frames.Receipt.receipt;


/**
 *
 * @author nada
 */
public class Kiosk extends javax.swing.JFrame{

    static int lastId;

    Connection connection = null;
    Statement statement = null;
    ResultSet result = null;

    public void openConnection() {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/risto", "root", "");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error open connection " + e.getMessage());
        }
    }
    
    //int itemPosition;
     
    public void loaditems(int position) {
        //itemPosition = position;
        //itemId = Main.itemsList.get(position).getItemId();
        //nameText.setText(Main.itemsList.get(position).getItemName());
        //priceText.setText(Main.itemsList.get(position).getItemPrice() +"");
    }
    
    public void loaditems_products(){
        
        DefaultTableModel itemsModel = new DefaultTableModel();
        itemsModel.addColumn("Items");
        itemsModel.addColumn("Price");
                
        for(items product : Main.itemsList){
            String[] itemsLine = new String[2];         
            itemsLine[0] = product.getItemName();
            itemsLine[1] = product.getItemPrice() +"";
            System.out.println(itemsLine[1]);
            itemsModel.addRow(itemsLine);
            
        }
        
        
        //System.out.println(Main.itemsList);
        //System.out.println("test");
        OrderTable.setModel(itemsModel);
    }

    
    // Calcul of Price
    public void getSum(){
        int sum = 0;
        for (int i = 0; i < OrderTable.getRowCount(); i++)
        {
            sum = sum +Integer.parseInt(OrderTable.getValueAt(i,1).toString());
        }
        total.setText(Integer.toString(sum));
    }
    /**
     * Creates new form mENU
     */
    public Kiosk() {
        initComponents();
 
        dt();
        times();
            
        //this.setAlwaysOnTop(true);
        // Screen Size
        int screenWidth = getToolkit().getScreenSize().width;
        int screenHeight = getToolkit().getScreenSize().height;
        
        //this.setSize(screenWidth, screenHeight);
        this.setBounds(0, 0, screenWidth, screenHeight);
        
        
        openConnection();
        //////////////////////////////////////////////////////////////////////////
        //Affichage par défaut :
        ProductListPanel.removeAll();
        try {

            statement = connection.createStatement();
            result = statement.executeQuery("SELECT * FROM products WHERE category = 'offers'");
            
            while (result.next()) {
                ProductPanel panel = new ProductPanel();
                panel.initData(result.getInt("id"), "img/products/" + result.getString("image"), result.getString("name"), result.getString("price"));
                ProductListPanel.add(panel);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error on listing products " + e.getMessage());
        }
    }
    
    
    
    public void dt(){
        Date d = new Date();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        String dd = sdf.format(d);
        l_date.setText(dd);
    }
     Timer t;
     SimpleDateFormat st;
    
     //Date & Time
     public void times(){
         t = new Timer(0, new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                  Date dt = new Date();
                    st = new SimpleDateFormat("hh:mm:ss a");
                    String tt = st.format(dt);
                    l_time.setText(tt);
             }
         });
          
        t.start();
     }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        entreesBtn = new javax.swing.JButton();
        mealsBtn = new javax.swing.JButton();
        drinksBtn = new javax.swing.JButton();
        dessertsBtn = new javax.swing.JButton();
        cancel_order_btn = new javax.swing.JButton();
        offersBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        orderPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        OrderTable = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        ProductListPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        receipt = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        RemoveItem = new javax.swing.JButton();
        AddToOrder = new javax.swing.JButton();
        l_date = new javax.swing.JLabel();
        l_time = new javax.swing.JLabel();
        where = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        jPanel2.setBackground(new java.awt.Color(255, 204, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        entreesBtn.setBackground(new java.awt.Color(204, 0, 0));
        entreesBtn.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 15)); // NOI18N
        entreesBtn.setForeground(new java.awt.Color(255, 255, 255));
        entreesBtn.setText("Entrees");
        entreesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entreesBtnActionPerformed(evt);
            }
        });

        mealsBtn.setBackground(new java.awt.Color(204, 0, 0));
        mealsBtn.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 15)); // NOI18N
        mealsBtn.setForeground(new java.awt.Color(255, 255, 255));
        mealsBtn.setText("Meals");
        mealsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mealsBtnActionPerformed(evt);
            }
        });

        drinksBtn.setBackground(new java.awt.Color(204, 0, 0));
        drinksBtn.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 15)); // NOI18N
        drinksBtn.setForeground(new java.awt.Color(255, 255, 255));
        drinksBtn.setText("Drinks");
        drinksBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drinksBtnActionPerformed(evt);
            }
        });

        dessertsBtn.setBackground(new java.awt.Color(204, 0, 0));
        dessertsBtn.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 15)); // NOI18N
        dessertsBtn.setForeground(new java.awt.Color(255, 255, 255));
        dessertsBtn.setText("Desserts");
        dessertsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dessertsBtnActionPerformed(evt);
            }
        });

        cancel_order_btn.setBackground(new java.awt.Color(255, 153, 0));
        cancel_order_btn.setText("Cancel Order");
        cancel_order_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancel_order_btnMouseClicked(evt);
            }
        });
        cancel_order_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_order_btnActionPerformed(evt);
            }
        });

        offersBtn.setBackground(new java.awt.Color(204, 0, 0));
        offersBtn.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 15)); // NOI18N
        offersBtn.setForeground(new java.awt.Color(255, 255, 255));
        offersBtn.setText("Offers");
        offersBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                offersBtnActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Risto_logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(offersBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mealsBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(drinksBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dessertsBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(entreesBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 12, Short.MAX_VALUE)
                        .addComponent(cancel_order_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(offersBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(entreesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(mealsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(drinksBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dessertsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addComponent(cancel_order_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        jPanel3.setBackground(new java.awt.Color(255, 204, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), 5));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 51, 0));
        jLabel2.setText("Total Payment");

        total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 51, 0));
        jLabel12.setText("DH");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addGap(32, 32, 32))
        );

        orderPanel.setBackground(new java.awt.Color(255, 255, 255));
        orderPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        OrderTable.setBackground(new java.awt.Color(255, 204, 0));
        OrderTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 51)));
        OrderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Items", "Price"
            }
        ));
        OrderTable.setGridColor(new java.awt.Color(255, 255, 255));
        OrderTable.setSelectionBackground(new java.awt.Color(204, 0, 0));
        OrderTable.setShowGrid(true);
        OrderTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OrderTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(OrderTable);

        javax.swing.GroupLayout orderPanelLayout = new javax.swing.GroupLayout(orderPanel);
        orderPanel.setLayout(orderPanelLayout);
        orderPanelLayout.setHorizontalGroup(
            orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, orderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                .addContainerGap())
        );
        orderPanelLayout.setVerticalGroup(
            orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 22, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createEtchedBorder());

        ProductListPanel.setBackground(new java.awt.Color(255, 255, 255));
        ProductListPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ProductListPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProductListPanelMouseClicked(evt);
            }
        });
        ProductListPanel.setLayout(new java.awt.GridLayout(15, 2, 1, 1));
        jScrollPane1.setViewportView(ProductListPanel);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 51));
        jLabel3.setText("ORDER HERE !");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 19)); // NOI18N
        jLabel5.setText("Payment ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Your Order");

        receipt.setBackground(new java.awt.Color(204, 0, 0));
        receipt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        receipt.setForeground(new java.awt.Color(255, 204, 0));
        receipt.setText("Valid Command");
        receipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receiptActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Make your choice  ");

        RemoveItem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        RemoveItem.setText("Remove Item");
        RemoveItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RemoveItemMouseClicked(evt);
            }
        });
        RemoveItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveItemActionPerformed(evt);
            }
        });

        AddToOrder.setBackground(new java.awt.Color(0, 153, 0));
        AddToOrder.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        AddToOrder.setText("Add To Order");
        AddToOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddToOrderMouseClicked(evt);
            }
        });
        AddToOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddToOrderActionPerformed(evt);
            }
        });

        l_date.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        l_date.setForeground(new java.awt.Color(51, 51, 51));
        l_date.setText("0");

        l_time.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        l_time.setForeground(new java.awt.Color(51, 51, 51));
        l_time.setText("0");

        where.setBackground(new java.awt.Color(255, 204, 51));
        where.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dine In", "Take Away" }));
        where.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                whereActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(orderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(where, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(l_date)
                                .addGap(18, 18, 18)
                                .addComponent(l_time))
                            .addComponent(AddToOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(RemoveItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(receipt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(l_date, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(l_time))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(where, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(AddToOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(RemoveItem, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(206, 206, 206))
                            .addComponent(orderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(receipt, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancel_order_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel_order_btnMouseClicked
        
        
    }//GEN-LAST:event_cancel_order_btnMouseClicked

    private void entreesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entreesBtnActionPerformed
        // TODO add your handling code here:
        ProductListPanel.removeAll();
        try {

            statement = connection.createStatement();
            result = statement.executeQuery("SELECT * FROM products WHERE category = 'entrees'");
            while (result.next()) {
                ProductPanel panel = new ProductPanel();
                panel.initData(result.getInt("id"), "img/products/" + result.getString("image"), result.getString("name"), result.getString("price"));
                ProductListPanel.add(panel);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error on listing products " + e.getMessage());
        }

    }//GEN-LAST:event_entreesBtnActionPerformed

    private void offersBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_offersBtnActionPerformed
        // TODO add your handling code here:
        ProductListPanel.removeAll();
        ProductListPanel.updateUI();
        try {

            statement = connection.createStatement();
            result = statement.executeQuery("SELECT * FROM products WHERE category = 'offers'");
            while (result.next()) {
                ProductPanel panel = new ProductPanel();
                panel.initData(result.getInt("id"), "img/products/" + result.getString("image"), result.getString("name"), result.getString("price"));
                ProductListPanel.add(panel);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error on listing products " + e.getMessage());
        }
        
    }//GEN-LAST:event_offersBtnActionPerformed

    private void mealsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mealsBtnActionPerformed
        // TODO add your handling code here:
        ProductListPanel.removeAll();
        ProductListPanel.updateUI();
        try {

            statement = connection.createStatement();
            result = statement.executeQuery("SELECT * FROM products WHERE category = 'meals'");
            while (result.next()) {
                ProductPanel panel = new ProductPanel();
                panel.initData(result.getInt("id"), "img/products/" + result.getString("image"), result.getString("name"), result.getString("price"));
                ProductListPanel.add(panel);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error on listing products " + e.getMessage());
        }
    }//GEN-LAST:event_mealsBtnActionPerformed

    private void drinksBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drinksBtnActionPerformed
        ProductListPanel.removeAll();
        ProductListPanel.updateUI();
        try {

            statement = connection.createStatement();
            result = statement.executeQuery("SELECT * FROM products WHERE category = 'drinks'");
            while (result.next()) {
                ProductPanel panel = new ProductPanel();
                panel.initData(result.getInt("id"), "img/products/" + result.getString("image"), result.getString("name"), result.getString("price"));
                ProductListPanel.add(panel);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error on listing products " + e.getMessage());
        }
    }//GEN-LAST:event_drinksBtnActionPerformed

    private void dessertsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dessertsBtnActionPerformed
        ProductListPanel.removeAll();
        ProductListPanel.updateUI();
        try {

            statement = connection.createStatement();
            result = statement.executeQuery("SELECT * FROM products WHERE category = 'desserts'");
            while (result.next()) {
                ProductPanel panel = new ProductPanel();
                panel.initData(result.getInt("id"), "img/products/" + result.getString("image"), result.getString("name"), result.getString("price"));
                ProductListPanel.add(panel);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error on listing products " + e.getMessage());
        }
    }//GEN-LAST:event_dessertsBtnActionPerformed

    private void AddToOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddToOrderActionPerformed
           
    }//GEN-LAST:event_AddToOrderActionPerformed

    private void ProductListPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductListPanelMouseClicked

    }//GEN-LAST:event_ProductListPanelMouseClicked

    private void AddToOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddToOrderMouseClicked
        //OrderTable.clearSelection();
        loaditems_products();
        getSum();
    }//GEN-LAST:event_AddToOrderMouseClicked

    private void RemoveItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemoveItemMouseClicked
        // TODO add your handling code here:
        if ( JOptionPane.showConfirmDialog(this, "Confirm delete", "Delete", JOptionPane.YES_NO_OPTION) == 0 ){
            int position = OrderTable.getSelectedRow();
            //items.delete( Main.itemsList.get( position ).getItemId());
            //Main.itemsList.remove( position );
            //JOptionPane.showMessageDialog(this, "Item Deleted !");
            //loaditems_products();
            System.out.println(position);
        }
    }//GEN-LAST:event_RemoveItemMouseClicked

    private void OrderTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrderTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_OrderTableMouseClicked

    private void receiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receiptActionPerformed
        try {

            statement = connection.createStatement();
            
            
            String query = "INSERT INTO orders VALUES(NULL, 'not payed', "+ total.getText() + "); ";
            statement.execute(query);
            
            
            result = statement.executeQuery("SELECT MAX(order_id) as lastId FROM orders");
            result.next();
            lastId = result.getInt("lastId");
            receipt();
            
            for( items item : Main.itemsList ){
                query = "INSERT INTO orderline VALUES("+ lastId +", "+ item.getItemId() +", '"+ item.getItemName() +"', "+ item.getItemPrice() +"); ";
                statement.execute(query);
            }
            
            System.out.println(query +"\n\n\n");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            //JOptionPane.showMessageDialog(null, "Error on listing products " + e.getMessage());
        }
        
        Receipt r = new Receipt();
        
        r.setVisible(true);
        receipt();
        
      
    }//GEN-LAST:event_receiptActionPerformed

    private void whereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_whereActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_whereActionPerformed

    private void RemoveItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RemoveItemActionPerformed

    private void cancel_order_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_order_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancel_order_btnActionPerformed

    private void totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Kiosk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Kiosk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Kiosk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Kiosk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                // System.out.println("yyyy/MM/dd HH:mm:ss-> "+dtf.format(LocalDateTime.now()));
                new Kiosk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddToOrder;
    public static javax.swing.JTable OrderTable;
    private javax.swing.JPanel ProductListPanel;
    private javax.swing.JButton RemoveItem;
    private javax.swing.JButton cancel_order_btn;
    private javax.swing.JButton dessertsBtn;
    private javax.swing.JButton drinksBtn;
    private javax.swing.JButton entreesBtn;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel l_date;
    private javax.swing.JLabel l_time;
    private javax.swing.JButton mealsBtn;
    private javax.swing.JButton offersBtn;
    private javax.swing.JPanel orderPanel;
    private javax.swing.JButton receipt;
    public static javax.swing.JTextField total;
    public static javax.swing.JComboBox<String> where;
    // End of variables declaration//GEN-END:variables
}
