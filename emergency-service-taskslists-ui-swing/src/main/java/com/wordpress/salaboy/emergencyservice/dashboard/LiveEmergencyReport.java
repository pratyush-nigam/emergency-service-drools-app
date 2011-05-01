/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * LiveEmergencyReport.java
 *
 * Created on Apr 29, 2011, 11:40:00 PM
 */
package com.wordpress.salaboy.emergencyservice.dashboard;

import com.wordpress.salaboy.emergencyservice.monitor.EmergencyMonitorPanel;
import com.wordpress.salaboy.model.Emergency;
import com.wordpress.salaboy.model.serviceclient.DistributedPeristenceServerService;

/**
 *
 * @author salaboy
 */
public class LiveEmergencyReport extends javax.swing.JFrame {
    private Long emergencyId;
    private Emergency emergency;
    private EmergencyMonitorPanel monitor;
    /** Creates new form LiveEmergencyReport */
    public LiveEmergencyReport(Long emergencyId) {
        this.emergencyId = emergencyId;
        System.out.println(">>>>>>>>>> Getting the emergency selected -> "+emergencyId);
        this.emergency = DistributedPeristenceServerService.getInstance().loadEmergency(emergencyId);
        System.out.println(">>>>>>>The emergency selected -> "+emergency);
        initComponents();
        configure();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        auditLogjTextArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        monitorjPanel = new javax.swing.JPanel();

        auditLogjTextArea.setColumns(20);
        auditLogjTextArea.setRows(5);
        jScrollPane1.setViewportView(auditLogjTextArea);
        auditLogjTextArea.setText(DistributedPeristenceServerService.getInstance().getReportByCallId(this.emergency.getCall().getId()).getReportString());

        jLabel1.setText("Contextual Area");

        jLabel2.setText("Audit Log");

        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        monitorjPanel.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))), null)));

        org.jdesktop.layout.GroupLayout monitorjPanelLayout = new org.jdesktop.layout.GroupLayout(monitorjPanel);
        monitorjPanel.setLayout(monitorjPanelLayout);
        monitorjPanelLayout.setHorizontalGroup(
            monitorjPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 573, Short.MAX_VALUE)
        );
        monitorjPanelLayout.setVerticalGroup(
            monitorjPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 237, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, monitorjPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel1)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel2)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jButton1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(20, 20, 20)
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(monitorjPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel2)
                .add(5, 5, 5)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            // TODO add your handling code here:
        auditLogjTextArea.setText(DistributedPeristenceServerService.getInstance().getReportByCallId(this.emergency.getCall().getId()).getReportString());
    }//GEN-LAST:event_jButton1ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea auditLogjTextArea;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel monitorjPanel;
    // End of variables declaration//GEN-END:variables

    private void configure() {
        monitor = new EmergencyMonitorPanel(emergency.getCall().getId());
        monitorjPanel.add(monitor);
        this.validate();
    }
}
