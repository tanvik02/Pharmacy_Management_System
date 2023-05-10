/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pharmacy_management_sys;
import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;




public class Medicine extends javax.swing.JFrame {
    private static final String username="root";
    private static final String password="tk4159";
    private static final String dataConn="jdbc:mysql://localhost:3306/pharma";


    Connection sqlConn =null;
    PreparedStatement pst=null;
    Statement St;
    ResultSet rs = null;
    int q,i,id,deleteItem;
    
    public Medicine() {
        initComponents();
        updateDB();
        GetCompany();
        
        
}
   public void GetCompany(){
       String q="select * from pharma.companytb";
       try{
           
           OpenConnection();
           St = sqlConn.createStatement();
           rs= St.executeQuery(q);
           while(rs.next()){
               String comp= rs.getString("cname");
               cbC.addItem(comp);
           }
           
           
       }catch(Exception ex){
                   JOptionPane.showMessageDialog(null,ex);
                   }
   } 
    
    public void updateDB(){
        try
        {
            OpenConnection();
            pst= sqlConn.prepareStatement("select * from medicinetb;");
            
            rs = pst.executeQuery();
            ResultSetMetaData stData= rs.getMetaData();
            q= stData.getColumnCount();
            
            DefaultTableModel RecordTable = (DefaultTableModel)tbMedicine.getModel();
            RecordTable.setRowCount(0);
            
            while(rs.next()){
                Vector columnData= new Vector();
                
                for(i=1;i<=q;i++){
                    columnData.add(rs.getInt("MedId"));
                    columnData.add(rs.getString("MedName"));
                    columnData.add(rs.getInt("MedPrice"));
                    columnData.add(rs.getInt("MedQty"));
                    columnData.add(rs.getDate("MedFab"));
                    columnData.add(rs.getDate("MedExp"));
                    columnData.add(rs.getString("MedComp"));
                    
                }
                RecordTable.addRow(columnData);
            }
            
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_mname = new javax.swing.JTextField();
        txt_mid = new javax.swing.JTextField();
        txt_mp = new javax.swing.JTextField();
        txt_mqty = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbC = new javax.swing.JComboBox<>();
        dcF = new com.toedter.calendar.JDateChooser();
        dcE = new com.toedter.calendar.JDateChooser();
        add_btn = new javax.swing.JButton();
        update_btn = new javax.swing.JButton();
        delete_btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMedicine = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 51));
        jPanel1.setForeground(new java.awt.Color(0, 153, 0));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(java.awt.Color.white);
        jLabel8.setText("AGENTS");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(java.awt.Color.white);
        jLabel10.setText("SELLING");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(java.awt.Color.white);
        jLabel11.setText("COMPANY");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(java.awt.Color.white);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 0));
        jLabel1.setText("MANAGE MEDICINE");

        jLabel2.setText("ID");

        jLabel3.setText("MEDICINE NAME");

        jLabel4.setText("PRICE");

        jLabel5.setText("QUANTITY");

        jLabel6.setText("FABDATE");

        jLabel7.setText("EXPDATE");

        jLabel9.setText("COMPANY");

        cbC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCActionPerformed(evt);
            }
        });

        add_btn.setBackground(new java.awt.Color(204, 204, 204));
        add_btn.setText("ADD");
        add_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_btnMouseClicked(evt);
            }
        });
        add_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_btnActionPerformed(evt);
            }
        });

        update_btn.setBackground(new java.awt.Color(204, 204, 204));
        update_btn.setText("UPDATE");
        update_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                update_btnMouseClicked(evt);
            }
        });
        update_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_btnActionPerformed(evt);
            }
        });

        delete_btn.setBackground(new java.awt.Color(204, 204, 204));
        delete_btn.setText("DELETE");
        delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btnActionPerformed(evt);
            }
        });

        tbMedicine.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "MedId", "MedName", "MedPrice", "MedQty", "MedFab", "MedExp", "MedComp"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbMedicine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMedicineMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbMedicine);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("MEDICINE LIST");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(170, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(add_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(update_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(delete_btn)
                        .addGap(142, 142, 142))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(180, 180, 180))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(133, 133, 133)
                        .addComponent(txt_mid, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_mqty, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_mp, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_mname, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(dcE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(dcF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbC, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(35, 35, 35))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(227, 227, 227)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_mid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel6))
                            .addComponent(dcF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(dcE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(cbC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_mname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_mp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txt_mqty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 public ResultSet getMedicineResultSet() {
    ResultSet rs = null;
    try {
        String sql = "SELECT * FROM medicinetb";
        PreparedStatement pst = sqlConn.prepareStatement(sql);
        rs = pst.executeQuery();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);
    }
    return rs;
}
  
    private void add_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_btnMouseClicked
        
try
        {
            OpenConnection();
            pst = sqlConn.prepareStatement("INSERT INTO medicinetb (MedId, MedName, MedPrice,"
                    + " MedQty, MedFab, MedExp, MedComp) VALUES (?, ?, ?, ?, ?, ?, ?)");
            pst.setInt(1, Integer.parseInt(txt_mid.getText()));
            pst.setString(2, txt_mname.getText());
            pst.setDouble(3, Double.parseDouble(txt_mp.getText()));
            pst.setInt(4, Integer.parseInt(txt_mqty.getText()));
            
        SimpleDateFormat s= new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date fromDate = dcF.getDate();
        java.sql.Date sqlFromDate = new java.sql.Date(fromDate.getTime());
        
            pst.setDate(5, sqlFromDate);

        java.util.Date toDate = dcE.getDate();
        java.sql.Date sqlToDate = new java.sql.Date(toDate.getTime());
        
            pst.setDate(6, sqlToDate);
            pst.setString(7, (String)cbC.getSelectedItem());
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this,"Record Added");
            updateDB();
            clear();
        }
        catch(SQLException ex){
            java.util.logging.Logger.getLogger(Medicine.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } 
    }//GEN-LAST:event_add_btnMouseClicked

    private void add_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_btnActionPerformed
 updateDB();
// TODO add your handling code here:
    }//GEN-LAST:event_add_btnActionPerformed

    private void update_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_btnActionPerformed
try {
        String medid = txt_mid.getText();
        String mname = txt_mname.getText();
        double price = Double.parseDouble(txt_mp.getText());
        int qty = Integer.parseInt(txt_mqty.getText());
        SimpleDateFormat s= new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date fromDate = dcF.getDate();
        java.sql.Date sqlFromDate = new java.sql.Date(fromDate.getTime());
        
        java.util.Date toDate = dcE.getDate();
        java.sql.Date sqlToDate = new java.sql.Date(toDate.getTime());
        String comp = (String) cbC.getSelectedItem();
        
        OpenConnection();
        pst = sqlConn.prepareStatement("UPDATE medicinetb SET MedName = ?, MedPrice = ?, MedQty = ?, MedFab = ?, MedExp = ?, MedComp = ? WHERE MedId = ?");
        pst.setString(1, mname);
        pst.setDouble(2, price);
        pst.setInt(3, qty);
        pst.setDate(4, sqlFromDate);
        pst.setDate(5, sqlToDate);
        pst.setString(6, comp);
        pst.setString(7, medid);
        pst.executeUpdate();
        
            JOptionPane.showMessageDialog(null, "Medicine record updated successfully");
            clear();
            updateDB();
        
    }
    catch(Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
    }//GEN-LAST:event_update_btnActionPerformed

    private void update_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_update_btnMouseClicked
   
        // TODO add your handling code here:
    }//GEN-LAST:event_update_btnMouseClicked

    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnActionPerformed
        try{
            String x=JOptionPane.showInputDialog("Enter the Medicine ID");
            if(x.compareTo("")!=0)
            {
                SetDataU(x);
                int c= JOptionPane.showConfirmDialog(null, "Confirm");
                String q="null";
                if(c==0){
                    OpenConnection();
                    String medid=txt_mid.getText();
                    q="delete from medicinetb where MedId="+medid; 

                }
                else{
                    JOptionPane.showMessageDialog(null,"Record not deleted");

                }
                pst.executeUpdate(q);
                sqlConn.close();
                JOptionPane.showMessageDialog(null,"Record deleted");
                clear();
                updateDB();
                
            }
            else
              {  
                  JOptionPane.showMessageDialog(null, "Medical ID not entered");
              }
            
        }
        catch(Exception e)
            {
                  JOptionPane.showMessageDialog(null,e.getMessage());  
             }  


        // TODO add your handling code here:
    }//GEN-LAST:event_delete_btnActionPerformed

    private void tbMedicineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMedicineMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbMedicineMouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
    Billing B1=new Billing();
        B1.setVisible(true);
        setVisible(false);          // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
     Agents A1=new Agents();
        A1.setVisible(true);
        setVisible(false);          // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
    Company C1=new Company();
        C1.setVisible(true);
        setVisible(false);         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseClicked

    private void cbCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCActionPerformed

void OpenConnection(){
    try{
    Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dataConn,username,password);
    }
    catch(Exception e)
            {
                  JOptionPane.showMessageDialog(null,e.getMessage());  
             } 
    
}

void clear(){
    txt_mid.setText("");
    txt_mname.setText("");
    txt_mp.setText("");
    txt_mqty.setText("");
    dcF.setDate(null);
    dcE.setDate(null);
    cbC.setSelectedIndex(0);
}

void SetDataU(String x){
    try{
        OpenConnection();
        int x1=Integer.parseInt(x);
        String q="Select * from medicinetb where medid="+x1;
        rs=pst.executeQuery(q);
        if(rs.next()){
            txt_mid.setText(x);
            String name=rs.getString("MedName");
            txt_mname.setText(name);
            double pr = rs.getDouble("MedPrice");
            txt_mp.setText(Double.toString(pr));
            int qty = rs.getInt("MedQty");
            txt_mqty.setText(String.valueOf(qty));
            Date df=rs.getDate("MedFab");
            dcF.setDate(df);
            Date de=rs.getDate("MedExp");
            dcF.setDate(de);
            String comp=rs.getString("MedComp");
            cbC.setSelectedItem(comp);

        }
    }
    catch(Exception e)
            {
                  JOptionPane.showMessageDialog(null,e.getMessage());  
             }
}
void delete1()
{
   DefaultTableModel RecordTable = (DefaultTableModel)tbMedicine.getModel();
    int rows=RecordTable.getRowCount();
   if(rows>0)
   {
       for(int i=0;i<rows;i++)
       {
           RecordTable.removeRow(0);
       }
   }
}

    
    
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
            java.util.logging.Logger.getLogger(Medicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Medicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Medicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Medicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_btn;
    public javax.swing.JComboBox<String> cbC;
    private com.toedter.calendar.JDateChooser dcE;
    private com.toedter.calendar.JDateChooser dcF;
    private javax.swing.JButton delete_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbMedicine;
    private javax.swing.JTextField txt_mid;
    private javax.swing.JTextField txt_mname;
    private javax.swing.JTextField txt_mp;
    private javax.swing.JTextField txt_mqty;
    private javax.swing.JButton update_btn;
    // End of variables declaration//GEN-END:variables
}
