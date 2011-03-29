package no.ntnu.fp.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.JComponent;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/** 
 * Funksjonl¿s versjon
 */
public class KalenderPanel extends JPanel {
  
    
	
	public KalenderPanel() {
        super(new GridLayout(1,0));

        final String[] dayNames = 
        {"Mandag","Tirsdag","Onsdag","Torsdag","Fredag","L¿rdag","S¿ndag"};

        final Object[][] data = {
	    {"","","","","","",""}, //8
	    {"","","","","","",""}, //9
	    {"","","","","","",""}, //10
	    {"","","","","","",""}, //11
	    {"","","","","","",""}, //12
	    {"","","","","","",""}, //13
	    {"","","","","","",""}, //14
	    {"","","","","","",""}, //15
	    {"","","","","","",""}  //16
	   
        };
     
        
        JTable table = new JTable(data, dayNames) {
        	
        	public boolean isCellEditable(int rowIndex, int colIndex) {return false;}
        	
        	};  //Disallow the editing of any cell
        
      
        table.setPreferredScrollableViewportSize(new Dimension(600, 200));
        table.setFillsViewportHeight(true);
        table.setGridColor(Color.gray);
        
        table.setCellSelectionEnabled(true);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        table.setDragEnabled(false);
        table.getTableHeader().setReorderingAllowed(false);

        
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
        
       
        /**
         * Listeners
         */
            ListSelectionModel rowSM = table.getSelectionModel();
            rowSM.addListSelectionListener(new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent e) {
                    //Ignore extra messages.
                    if (e.getValueIsAdjusting()) return;

                    ListSelectionModel lsm = (ListSelectionModel)e.getSource();
                    if (lsm.isSelectionEmpty()) {
                        System.out.println("No rows are selected.");
                    } else {
                        int selectedRow = lsm.getMinSelectionIndex();
                        int selectedTime = selectedRow+8;
                        System.out.println("Time: " + selectedTime
                                           + ".00 - "+ (selectedTime+1) + ".00");
                    }
                }
            });
            
            table.setColumnSelectionAllowed(true);
            ListSelectionModel colSM =
                table.getColumnModel().getSelectionModel();
            colSM.addListSelectionListener(new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent e) {
                    //Ignore extra messages.
                    if (e.getValueIsAdjusting()) return;

                    ListSelectionModel lsm = (ListSelectionModel)e.getSource();
                    if (lsm.isSelectionEmpty()) {
                        System.out.println("No columns are selected.");
                    } else {
                        int selectedCol = lsm.getMinSelectionIndex();
                        System.out.println("Day: " + dayNames[selectedCol]);
                                          
                    }
                }
            });
        
    }

    
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("KalenderPanelTestWindow");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        KalenderPanel newContentPane = new KalenderPanel();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
