/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PhoneCallsPanel.java
 *
 * Created on Nov 24, 2010, 3:15:17 PM
 */

package com.wordpress.salaboy.emergencyservice.taskslist.swing;

import com.wordpress.salaboy.call.CallManager;
import com.wordpress.salaboy.call.IncomingCallListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;
import org.example.ws_ht.api.wsdl.IllegalArgumentFault;
import org.example.ws_ht.api.wsdl.IllegalStateFault;
import org.jbpm.task.query.TaskSummary;
import com.wordpress.salaboy.model.Call;
import org.example.ws_ht.api.TTaskAbstract;

/**
 *
 * @author esteban
 */
public class PhoneCallsPanel extends javax.swing.JPanel implements IncomingCallListener, Refreshable {

    private UserTaskListUI parent;
    private UIJTableRefreshManager refreshManager = null;
    /** Creates new form PhoneCallsPanel */
    public PhoneCallsPanel(UserTaskListUI parent) {
        this.parent = parent;
        initComponents();
        CallManager.getInstance().addIncomingCallListener(this);
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        phoneCallsJScrollPane = new javax.swing.JScrollPane();
        phoneCallsJTable = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        refreshJButton = new javax.swing.JButton();
        chk_autoRefresh = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        ftxt_refreshSeconds = new javax.swing.JFormattedTextField();

        setName("Operator Tasks"); // NOI18N
        setPreferredSize(new java.awt.Dimension(300, 480));

        phoneCallsJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id","Incoming Call",
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Number.class,
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        }
    );
    phoneCallsJTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
    phoneCallsJTable.setPreferredSize(new java.awt.Dimension(280, 100));
    phoneCallsJTable.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            phoneCallsJTablerowClick(evt);
        }
    });
    phoneCallsJScrollPane.setViewportView(phoneCallsJTable);

    jLabel11.setText("Incoming Emergency Calls");

    refreshJButton.setText("Refresh");
    refreshJButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            refreshJButtonActionPerformed(evt);
        }
    });

    chk_autoRefresh.setText("auto refresh");
    chk_autoRefresh.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            chk_autoRefreshActionPerformed(evt);
        }
    });

    jLabel1.setText("secs");

    ftxt_refreshSeconds.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
    ftxt_refreshSeconds.setText("3");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(refreshJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(1, 1, 1)
                    .addComponent(ftxt_refreshSeconds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(2, 2, 2)
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(chk_autoRefresh)
                    .addGap(147, 147, 147))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(phoneCallsJScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                    .addContainerGap())
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(jLabel11)
                    .addGap(120, 120, 120))))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel11)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(phoneCallsJScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(refreshJButton)
                .addComponent(jLabel1)
                .addComponent(chk_autoRefresh)
                .addComponent(ftxt_refreshSeconds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18))
    );
    }// </editor-fold>//GEN-END:initComponents

    private void phoneCallsJTablerowClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phoneCallsJTablerowClick
        
        int selected = phoneCallsJTable.rowAtPoint(evt.getPoint());
        String id = phoneCallsJTable.getModel().getValueAt(selected, 0).toString();
        this.callSelected(id);
        
    }//GEN-LAST:event_phoneCallsJTablerowClick

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        this.refresh();
}//GEN-LAST:event_refreshJButtonActionPerformed

    private void chk_autoRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_autoRefreshActionPerformed
       if(chk_autoRefresh.isSelected()){
        UIJTableRefreshManager.start(chk_autoRefresh, Integer.valueOf(ftxt_refreshSeconds.getText()), this); 
       }
       
    }//GEN-LAST:event_chk_autoRefreshActionPerformed

    @Override
    public void processIncomingCall(Call call) {
        //refresh();
    }
    
   
    
    
    private JDialog callPopup;
    public void callSelected(String id) {
        EmergencyMinimalQuestionnairePanel emergencyInfoPanel = new EmergencyMinimalQuestionnairePanel(this,this.parent.getTaskClient(), id);
        callPopup = new JDialog(this.parent, "Ask For Emergency Information",true);
        callPopup.add(emergencyInfoPanel);
        this.callPopup.setSize(300, 350);
        this.callPopup.setVisible(true);
        this.callPopup.requestFocus();
    }
    
    public void hideDialog(){
        this.callPopup.setVisible(false);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chk_autoRefresh;
    private javax.swing.JFormattedTextField ftxt_refreshSeconds;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JScrollPane phoneCallsJScrollPane;
    private javax.swing.JTable phoneCallsJTable;
    private javax.swing.JButton refreshJButton;
    // End of variables declaration//GEN-END:variables

    @Override
    public void refresh() {
//        BlockingTaskSummaryResponseHandler handler = new BlockingTaskSummaryResponseHandler();
//        
//        this.parent.getTaskClient().getTasksAssignedAsPotentialOwner("operator", "en-UK", handler);
//        
//        List<TaskSummary> results = handler.getResults();
        
        List<TTaskAbstract> taskAbstracts = null;
        try {
            taskAbstracts = this.parent.getTaskClient().getMyTaskAbstracts("", "operator", "", null, "", "", "", 0, 0);
        } catch (IllegalArgumentFault ex) {
            Logger.getLogger(PhoneCallsPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalStateFault ex) {
            Logger.getLogger(PhoneCallsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        DefaultTableModel tableModel = ((DefaultTableModel)phoneCallsJTable.getModel());
        
        int rowCount = tableModel.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            tableModel.removeRow(0);
        }
        
        for (TTaskAbstract taskAbstract : taskAbstracts) {
            String id = taskAbstract.getId();
            String name = taskAbstract.getName().toString();
            tableModel.addRow(new Object[]{id,name});
        }
    }

}
