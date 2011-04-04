package no.ntnu.fp.gui;
import java.awt.Component;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import no.ntnu.fp.model.Avtale;
import no.ntnu.fp.model.Mote;

public class KalPanRenderer extends DefaultTableCellRenderer{
   
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) 
	{
		Component cell = super.getTableCellRendererComponent
        (table, value, isSelected, hasFocus, row, column);
		if( value instanceof Mote) {
			
			Color lyseblaa = new Color(130,180,250);
			
			cell.setBackground(lyseblaa);
		}
		else if( value instanceof Avtale ) {
			
			Color lysegronn = new Color(140,250,160);
			
			cell.setBackground(lysegronn);
		}
		else {
            cell.setBackground( Color.white );
		}
	
     return cell;
	}
}