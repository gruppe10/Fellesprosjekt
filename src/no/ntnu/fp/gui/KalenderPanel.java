
package no.ntnu.fp.gui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
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
  
    private int selectedRow;
    private int selectedCol;
    
    private int startYear;
    private int endYear;
    private int startMonth;
    private int endMonth;
    private int startDay;
    private int endDay;
    
    private int avtaleLengde;
    
    private int[] dayDatos;
    private int[] datoToIndexArray;
    
    private int timeIndexRatio;
    
    private final Avtale[][] data;
    
    private ArrayList<Avtale> avtaleListe;
    
    private KalPanInfoBoks infoBoks;
    
    
	
	public KalenderPanel(Person p, Calendar inDate) {
		
		
				
		Calendar date = inDate;
		int dato= date.get(Calendar.DAY_OF_MONTH);
		
		 final String[] dayNames = 
	        {
	        		"Mandag ",
	        		"Tirsdag ",
	        		"Onsdag ",
	        		"Torsdag ",
	        		"Fredag ",
	        		"L¿rdag ",
	        		"S¿ndag "};
		
				
		int ukedagint=date.get(Calendar.DAY_OF_WEEK)-2;
		
		dayDatos = new int[7];
		
		inDate.add(Calendar.DAY_OF_MONTH, -ukedagint);
		dayDatos[0]=date.get(Calendar.DAY_OF_MONTH);
		dayNames[0]=dayNames[0]+dayDatos[0];
		
		startYear=date.get(Calendar.YEAR);
		startMonth=date.get(Calendar.MONTH)+1;
		startDay=date.get(Calendar.DAY_OF_MONTH);
        
        for (int i=1; i<7; i++) {
        	inDate.add(Calendar.DAY_OF_MONTH, 1);
        	dayDatos[i]=date.get(Calendar.DAY_OF_MONTH);
            dayNames[i]=dayNames[i]+dayDatos[i];
        } //legger inn datoer i header
        
        endYear=date.get(Calendar.YEAR);
		endMonth=date.get(Calendar.MONTH)+1;
		endDay=date.get(Calendar.DAY_OF_MONTH);
        
		
        
        ArrayList<Avtale> ukuttaAvtaleListe= p.getAvtaler();
        avtaleListe = new ArrayList<Avtale>();
        
       
        for (int i=0; i<ukuttaAvtaleListe.size(); i++) {
        	
        	finnUtOmAvtaleErIdenneUka(ukuttaAvtaleListe.get(i));
        }

        timeIndexRatio=6;
        
        data = new Avtale[12][7];
        
        datoToIndexArray = new int[avtaleListe.size()];
        
        for (int i=0; i<avtaleListe.size(); i++) {
        	datoToIndexArray(avtaleListe.get(i),i);
        }
        
        
        for (int i=0; i<avtaleListe.size(); i++) {
        	putAvtaleInnTable(avtaleListe.get(i), i);
        }
        
	   
     
        
        final JTable table = new JTable(data, dayNames) {
        
        	public boolean isCellEditable(int rowIndex, int colIndex) {return false;}
        	
        	};  //Disallow the editing of any cell


            TableCellRenderer renderer = new KalPanRenderer();  
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
                        selectedRow = lsm.getMinSelectionIndex();
                        int selectedTime = selectedRow+6;
                        
                        if (data[selectedRow][selectedCol] instanceof Avtale) {
                        	infoBoks.displayAvtale(data[selectedRow][selectedCol]);
                        }
                        else if (data[selectedRow][selectedCol] == null) {
                        	infoBoks.clear();
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
                        System.out.println("No columns are selected.");
                    } else {
                        selectedCol = lsm.getMinSelectionIndex();
                        if (data[selectedRow][selectedCol] instanceof Avtale) {
                        	infoBoks.displayAvtale(data[selectedRow][selectedCol]);
                        }
                        else if (data[selectedRow][selectedCol] == null) {
                        	infoBoks.clear();
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
       
        KalenderPanel newContentPane = new KalenderPanel(p, d);
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
    
    private void finnUtOmAvtaleErIdenneUka(Avtale a) {
      	
    	if (a.getDatoAar() == startYear || a.getDatoAar() == endYear) {
    		
    		if (startYear != endYear) {
    			if ((a.getDatoMnd() == 12 && a.getDatoAar() == startYear) || (a.getDatoMnd() == 1 && a.getDatoAar() == endYear)) {
    				if (a.getDatoDag() >= startDay || a.getDatoDag() <= endDay) {
    					avtaleListe.add(a);
    				}
    			}
    		}
    		else if (a.getDatoMnd() == startMonth || a.getDatoMnd() == endMonth) {
    			if (startMonth != endMonth) {
            		if ((a.getDatoDag() >= startDay && a.getDatoMnd() == startMonth) || (a.getDatoDag() <= endDay && a.getDatoMnd() == endMonth) ){
            			avtaleListe.add(a);
            		}
            	}
    			else {
    				if (a.getDatoDag() >= startDay && a.getDatoDag() <= endDay) {
    					avtaleListe.add(a);
    				}
    			}
    		}
    	}
    }
    
    private void datoToIndexArray(Avtale a, int i) {
    	for(int j=0; j<dayDatos.length; j++) {
    		if (a.getDatoDag()==dayDatos[j]) {
			datoToIndexArray[i]=j;
			
    		}
    	}
	}
    
    public void putAvtaleInnTable(Avtale a, int i) {
    	avtaleLengde=a.getSluttid()-a.getStarttid();
	
    	data[a.getStarttid()-timeIndexRatio][datoToIndexArray[i]]=a;
	
    	for (int j=1; j<avtaleLengde; j++) {
    		if (a instanceof Mote) {
    			KalPanMoteFiller filler = new KalPanMoteFiller(a);
    			data[(a.getStarttid()-timeIndexRatio)+j][datoToIndexArray[i]]=filler;
    		}
    		else if (a instanceof Avtale) {
    			KalPanAvtaleFiller filler = new KalPanAvtaleFiller(a);
    			data[(a.getStarttid()-timeIndexRatio)+j][datoToIndexArray[i]]=filler;
    		}
    	}
    }
    
    public void addAvtale(Avtale a) {
    	finnUtOmAvtaleErIdenneUka(a);
    	putAvtaleInnTable(a, avtaleListe.size()-1); 
    	
    }
    
    public void removeAvtale(Avtale a) {
    	
    }
}