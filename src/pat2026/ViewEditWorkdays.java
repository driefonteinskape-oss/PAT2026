package pat2026;

import java.time.Duration;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

  

    public class ViewEditWorkdays extends javax.swing.JDialog {

        private String workerCode;
        private Workday[] workdays;
        private int workdayCount;

        private DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd MMM yyyy");
        private DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");

        private static final int COL_JOBID = 0;
        private static final int COL_EDIT = 9;

        public ViewEditWorkdays(java.awt.Frame parent, boolean modal, String workerCode) {
            super(parent, modal);
            this.workerCode = workerCode;
            initComponents();
            tblViewWork.setDefaultEditor(Object.class, null); // read-only cells
            displayTableDetails();
        }

        private void displayTableDetails() {
            DefaultTableModel model = (DefaultTableModel) tblViewWork.getModel();
            model.setRowCount(0); // clears the empty placeholder row from the designer

            try {
                GetWorkerWorkdays workdayFetcher = new GetWorkerWorkdays();

                if (workdayFetcher.getWorkdayData(workerCode)) {
                    workdays = workdayFetcher.getWorkdays();
                    workdayCount = workdayFetcher.getCount();

                    for (int i = 0; i < workdayCount; i++) {
                        Object[] row = {
                            workdays[i].getJobID(),
                            workdays[i].getDateWorked().format(dateFormat),
                            workdays[i].getStartTime().format(timeFormat),
                            workdays[i].getLunchStart().format(timeFormat),
                            workdays[i].getLunchEnd().format(timeFormat),
                            workdays[i].getEndTime().format(timeFormat),
                            formatDuration(workdays[i].getHoursWorked()),
                            workdays[i].getTypeOfWork(),
                            workdays[i].getRowsCompleted(),
                            "Edit"
                        };
                        model.addRow(row);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "No workdays have been logged yet.");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,
                        "Could not load workday records: " + e.getMessage());
            }
        }

// Use the formatDuration you already wrote in ViewWork. This is a simple version:
        private String formatDuration(Duration d) {
            return d.toHours() + "h " + d.toMinutesPart() + "m";
        }

// Designer: right-click tblViewWork > Events > Mouse > mouseClicked
        private void tblViewWorkMouseClicked(java.awt.event.MouseEvent evt) {
            int row = tblViewWork.rowAtPoint(evt.getPoint());
            int col = tblViewWork.columnAtPoint(evt.getPoint());

            if (row < 0 || col != 9) {
                return; // empty space, or not the Edit column
            }

            String jobID = tblViewWork.getValueAt(row, 0).toString();

            // PLACEHOLDER: open the screen for this workday
            // EditWorkday dialog = new EditWorkday((java.awt.Frame) this.getParent(), true, jobID);
            // dialog.setVisible(true);
            // displayTableDetails(); // refresh after edits
        }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrlViewWork = new javax.swing.JScrollPane();
        tblViewWork = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblViewWork.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "JobID", "Date", "Time Start", "Lunch Start", "Lunch End", "Time End", "Time worked", "Type of Work", "Rows Complete", "Type Of Work"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrlViewWork.setViewportView(tblViewWork);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(scrlViewWork, javax.swing.GroupLayout.DEFAULT_SIZE, 1073, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(scrlViewWork, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane scrlViewWork;
    private javax.swing.JTable tblViewWork;
    // End of variables declaration//GEN-END:variables
}
