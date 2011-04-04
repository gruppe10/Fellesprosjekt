
package no.ntnu.fp.gui;


import java.awt.Color;
import java.awt.Dimension;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import no.ntnu.fp.model.Person;
import no.ntnu.fp.model.Avtale;
import no.ntnu.fp.model.Mote;

import java.util.ArrayList;

import javax.swing.table.TableCellRenderer;

import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListModel;
import javax.swing.BoxLayout;



public class KalenderPanel extends JPanel {
  
   
    
    private KalPanInfoBoks infoBoks;
    private KalenderPanelModel model;
    
    private int timeIndexDiff=6;
    
    private int selectedRow;
    private int selectedCol;

    private boolean illegalSelection=false;
    
    
	
	public KalenderPanel(KalenderPanelModel m) {
		
		model=m;
     
        
        final JTable table = new JTable(model) {
        
        	public boolean isCellEditable(int rowIndex, int colIndex) {return false;} //Disallow the editing of any cell
        	
        }; 


        table.setDefaultRenderer(Object.class,new KalPanRenderer());
      
        table.setPreferredScrollableViewportSize(new Dimension(700, 192));
        table.setFillsViewportHeight(true);
        table.setGridColor(Color.gray);
        
        table.setCellSelectionEnabled(true);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        table.setDragEnabled(false);
        table.getTableHeader().setReorderingAllowed(false);
     
        
        

        JScrollPane scrollPane = new JScrollPane(table);
        
        
    
        ListModel lm = new AbstractListModel() {
            String headers[] = { 
            		"6.00-7.00", 
            		"7.00-8.00", 
            		"8.00-9.00", 
            		"9.00-10.00", 
            		"10.00-11.00",
            		"11.00-12.00", 
            		"12.00-13.00", 
            		"13.00-14.00", 
            		"14.00-15.00", 
            		"15.00-16.00", 
            		"16.00-17.00",
            		"17.00-18.00" 
            		};

            public int getSize() {
              return headers.length;
            }

            public Object getElementAt(int index) {
              return headers[index];
            }
          };
          
          
        
        JList timeRow = new JList(lm);
        timeRow.setFixedCellWidth(80);
        
        timeRow.setFixedCellHeight(table.getRowHeight());
        timeRow.setCellRenderer(new KalPanRowHeaderRenderer(table));
        scrollPane.setRowHeaderView(timeRow);
        
        infoBoks = new KalPanInfoBoks();
        
        add(scrollPane);
        add(infoBoks);
        
        ListSelectionModel rowSM = table.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                //Ignore extra messages.
                if (e.getValueIsAdjusting()) return;

                ListSelectionModel lsm = (ListSelectionModel)e.getSource();
                if (lsm.isSelectionEmpty()) {
                    illegalSelection=true;
                } else {
                    selectedRow = lsm.getMinSelectionIndex();
                    int selectedTime = selectedRow+6;
                    
                    if (model.getData()[selectedRow][selectedCol] instanceof Avtale) {
                    	infoBoks.displayAvtale(model.getData()[selectedRow][selectedCol]);
                    	illegalSelection=true;
                    }
                    else if (model.getData()[selectedRow][selectedCol] == null) {
                    	infoBoks.clear();
                    	illegalSelection=false;
                    }
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
                	illegalSelection=true;
                } else {
                    selectedCol = lsm.getMinSelectionIndex();
                    
                    if (model.getData()[selectedRow][selectedCol] instanceof Avtale) {
                    	infoBoks.displayAvtale(model.getData()[selectedRow][selectedCol]);
                    	illegalSelection=true;
                    }
                    else if (model.getData()[selectedRow][selectedCol] == null) {
                    	infoBoks.clear();
                    	illegalSelection=false;
                    }
                                      
                }
            }
        });
        
    }

    private static void createAndShowGUI() {
    	
        //Create and set up the window.
        JFrame frame = new JFrame("KalenderPanelTestWindow");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        
        //Test Test - Lager en ny person med avtaler
        Person p= new Person();
        ArrayList<Avtale> avtaler = new ArrayList<Avtale>();
        Avtale avtale1 = new Avtale();
        avtale1.setStarttid(10);
        avtale1.setSluttid(12);
        avtale1.setNavn("Lunsj");
        avtale1.setBeskrivelse("Besk rivelse");
        avtale1.setDato(1, 4, 2011);
        avtaler.add(avtale1);
        Avtale avtale2 = new Mote();
        avtale2.setStarttid(13);
        avtale2.setSluttid(18);
        avtale2.setNavn("Brunsj");
        avtale2.setBeskrivelse("lolololololomfgroflmao");
        avtale2.setDato(1, 4, 2011);
        avtaler.add(avtale2);
        
        p.setAvtaler(avtaler);
        
        Calendar d = Calendar.getInstance();
        
       d.add(Calendar.DAY_OF_MONTH, 0);
        
     //Create and set up the content pane.
       
       	KalenderPanelModel model= new 	KalenderPanelModel(p, d);
        KalenderPanel newContentPane = new KalenderPanel(model);
        newContentPane.setOpaque(true); //content panes must be opaque
        newContentPane.setLayout(new BoxLayout(newContentPane, BoxLayout.Y_AXIS));
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
    
   	protected KalPanInfoBoks getInfoBoks() {
   	return infoBoks;
   }
   
    public int getSelectedTime() {
    	if (illegalSelection) {
    		return 6;
    	}
    	else {
    	return selectedRow+timeIndexDiff;
    	}
    }
    
    public int getSelectedDato() {
    	if (illegalSelection) {
    		return model.getDatoAtIndex(0);
    	}
    	else {
    		return model.getDatoAtIndex(selectedCol);
    	}
    }
    
    public int getSelectedMonth() {
    	if (illegalSelection) {
    		return model.getMonthAtIndex(0);
    	}
    	else {
    		return model.getMonthAtIndex(selectedCol);
    	}
    }
    
    public int getSelectedYear() {
    	if (illegalSelection) {
    		return model.getYearAtIndex(0);
    	}
    	else {
    		return model.getYearAtIndex(selectedCol);
    	}
    }
}
    