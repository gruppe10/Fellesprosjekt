package no.ntnu.fp.gui;

import javax.swing.table.AbstractTableModel;
import java.util.Calendar;

import no.ntnu.fp.model.Person;
import no.ntnu.fp.model.Avtale;
import no.ntnu.fp.model.Mote;

import java.util.ArrayList;



class KalenderPanelModel extends AbstractTableModel {
      
	    private int startYear;
	    private int endYear;
	    private int startMonth;
	    private int endMonth;
	    private int startDay;
	    private int endDay;
	    
	    private int avtaleLengde;
	    
	    private int[] dayDatos;
	    private int[] dayMonth;
	    private int[] dayYear;
	    
	    private ArrayList<Integer> datoToIndexList;
	    
	    private int timeIndexDiff=6;
	    
	    private Avtale[][] data;
	    private String[] dayNames= new String[7];
	    
	    private ArrayList<Avtale> avtaleListe;
	    private ArrayList<Avtale> ukuttaAvtaleListe;
	    
	    private kal kal;
	   
	
	public KalenderPanelModel(kal kal, Calendar inDate) {
		
		this.kal=kal;
		Calendar date = inDate;
		
		setDayNames();
		
		setWeek(date);
        
        ukuttaAvtaleListe= kal.getConnectedPerson().getAvtaler();
        
        createAvtaleListe();
        
	}

    public int getColumnCount() {
        return dayNames.length;
    }

    public int getRowCount() {
        return data.length;
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    public void setValueAt(Avtale value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }
    
    public String getColumnName(int col) {
        return dayNames[col];
    }
    
    private boolean avtaleErIdenneUka(Avtale a) {
      	
    	if (a.getDatoAar() == startYear || a.getDatoAar() == endYear) {
    		
    		if (startYear != endYear) {
    			if ((a.getDatoMnd() == 12 && a.getDatoAar() == startYear) || (a.getDatoMnd() == 1 && a.getDatoAar() == endYear)) {
    				if (a.getDatoDag() >= startDay || a.getDatoDag() <= endDay) {
    					return true;
    				}
    			}
    		}
    		else if (a.getDatoMnd() == startMonth || a.getDatoMnd() == endMonth) {
    			if (startMonth != endMonth) {
            		if ((a.getDatoDag() >= startDay && a.getDatoMnd() == startMonth) || (a.getDatoDag() <= endDay && a.getDatoMnd() == endMonth) ){
            			return true;
            		}
            	}
    			else {
    				if (a.getDatoDag() >= startDay && a.getDatoDag() <= endDay) {
    					return true;
    				}
    			}
    		}
    	}
    	return false;
    }
    
    private void datoToIndex(Avtale a) {
    	for(int j=0; j<dayDatos.length; j++) {
    		
    		if (a.getDatoDag()==dayDatos[j]) {
			datoToIndexList.add(j);
			
    		}
    	}
    }
    
    private void setDayNames() {
    	
    	dayNames[0]="Mandag ";
    	dayNames[1]="Tirsdag ";
    	dayNames[2]="Onsdag ";
    	dayNames[3]="Torsdag ";
    	dayNames[4]="Fredag ";
    	dayNames[5]="L\u00F8rdag ";
    	dayNames[6]="S\u00F8ndag "; 	
    	
    }
    
    private void setWeek(Calendar date) {
    	
    	int dato= date.get(Calendar.DAY_OF_MONTH);
		int ukedagint=date.get(Calendar.DAY_OF_WEEK)-2;
		
		dayDatos = new int[7];
		dayMonth = new int[7];
		dayYear = new int[7];
		
		date.add(Calendar.DAY_OF_MONTH, -ukedagint);
		
		dayDatos[0]=date.get(Calendar.DAY_OF_MONTH);
		dayMonth[0]=date.get(Calendar.MONTH)+1;
		dayYear[0]=date.get(Calendar.YEAR);
		
		
		dayNames[0]=dayNames[0]+dayDatos[0];
		
		
		startYear=date.get(Calendar.YEAR);
		startMonth=date.get(Calendar.MONTH)+1;
		startDay=date.get(Calendar.DAY_OF_MONTH);
        
        for (int i=1; i<7; i++) {
        	date.add(Calendar.DAY_OF_MONTH, 1);
        	
        	dayDatos[i]=date.get(Calendar.DAY_OF_MONTH);
        	dayMonth[i]=date.get(Calendar.MONTH)+1;
    		dayYear[i]=date.get(Calendar.YEAR);
        	
            dayNames[i]=dayNames[i]+dayDatos[i];
        } //legger inn datoer i header
        
        endYear=date.get(Calendar.YEAR);
		endMonth=date.get(Calendar.MONTH)+1;
		endDay=date.get(Calendar.DAY_OF_MONTH);
    }

    private void putAvtaleInTable(Avtale a, int i) {
    	avtaleLengde=a.getSluttid()-a.getStarttid();
    	data[a.getStarttid()-timeIndexDiff][datoToIndexList.get(i)]=a;
    	
		fireTableCellUpdated((a.getStarttid()-timeIndexDiff), datoToIndexList.get(i));
		
    	for (int j=1; j<avtaleLengde; j++) {
    		if (a instanceof Mote) {
    			KalPanMoteFiller filler = new KalPanMoteFiller(a);
    			data[(a.getStarttid()-timeIndexDiff)+j][datoToIndexList.get(i)]=filler;
    			
    			fireTableCellUpdated((a.getStarttid()-timeIndexDiff)+j, datoToIndexList.get(i));
    			
    		}
    		else if (a instanceof Avtale) {
    			KalPanAvtaleFiller filler = new KalPanAvtaleFiller(a);
    			data[(a.getStarttid()-timeIndexDiff)+j][datoToIndexList.get(i)]=filler;
    			
    			fireTableCellUpdated((a.getStarttid()-timeIndexDiff)+j, datoToIndexList.get(i));
    		}
    	}
    }
    
    private void createAvtaleListe() {
    	
    	avtaleListe = new ArrayList<Avtale>();
        
        for (int i=0; i<ukuttaAvtaleListe.size(); i++) {
        	
        	if (avtaleErIdenneUka(ukuttaAvtaleListe.get(i))) {
        	avtaleListe.add(ukuttaAvtaleListe.get(i));
        	}
        }

        data = new Avtale[12][7];
        
        datoToIndexList = new ArrayList<Integer>();//int[avtaleListe.size()];
        
        for (int i=0; i<avtaleListe.size(); i++) {
        	datoToIndex(avtaleListe.get(i));
        }
        
        
        for (int i=0; i<avtaleListe.size(); i++) {
        	putAvtaleInTable(avtaleListe.get(i), i);
        }
        
    }
    
    protected Avtale[][] getData() {
    	return data;
    }
    
    protected int getDatoAtIndex(int i) {
    	return dayDatos[i];
    }
    
    protected int getMonthAtIndex(int i) {
    	return dayMonth[i];
    }
    
    protected int getYearAtIndex(int i) {
    	return dayYear[i];
    }
    
    protected kal getKal() {
    	return kal;
    }
    
    
    public void addAvtaleToPanel(Avtale a) {
    	
    	if (avtaleErIdenneUka(a)) {
        	avtaleListe.add(a);
        	datoToIndex(a);
        	avtaleListe.add(a);
        	putAvtaleInTable(a, datoToIndexList.size()-1); 
        }
    	
    }
    
    public void removeAvtaleFromPanel(Avtale a) { //Ikke testa, men den funker sikkert...
    	
    	if (avtaleErIdenneUka(a)) {
    		
    		avtaleListe.remove(a);
    		
    		int i=0;
    		while (a.getDatoDag() != dayDatos[i]) {
    			i++;
    		}
    		
    		data[a.getStarttid()-timeIndexDiff][i]=null;
    		fireTableCellUpdated((a.getStarttid()-timeIndexDiff), i);
    		
    		int avtaleLength = a.getSluttid()-a.getStarttid();
    		
    		for (int j=1; j<avtaleLength; j++) {
    			
    			data[a.getStarttid()-timeIndexDiff+j][i]=null;
    			fireTableCellUpdated((a.getStarttid()-timeIndexDiff+j), i);
    			
    		}
    	}
    }
    
    public void newDate(Calendar nD) {
    	setDayNames();
    	setWeek(nD);
    	createAvtaleListe();
    	fireTableStructureChanged() ;
    }
    
}