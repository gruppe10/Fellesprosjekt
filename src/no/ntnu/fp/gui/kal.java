package no.ntnu.fp.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.ListModel;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class kal extends javax.swing.JFrame implements ActionListener {
	private JLabel minKalenderLAbel;
	private JButton endreMoeteButton;
	private KalenderPanel kalenderPanel1;
	private JScrollPane jScrollPane1;
	private JList jList1;
	private JButton nyAvtaleButton;
	private JLabel ulestLAbel;
	private JPanel jPanel1;
	private JButton avlysMoeteButton;
	private JButton nyttMoeteButton;
	private JButton sletteAvtaleButton;
	private JButton endreAvtaleButton;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				kal inst = new kal();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public kal() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				minKalenderLAbel = new JLabel();
				minKalenderLAbel.setText("Min kalender");
				minKalenderLAbel.setFont(new java.awt.Font("Tahoma",1,16));
			}
			{
				kalenderPanel1 = new KalenderPanel();
			}
			{
				jPanel1 = new KalenderPanel();
				GroupLayout jPanel1Layout = new GroupLayout((JComponent)jPanel1);
				jPanel1.setLayout(jPanel1Layout);
				jPanel1.setVisible(true);
				{
					nyttMoeteButton = new JButton();
					nyttMoeteButton.setText("Nytt Møte");
					nyttMoeteButton.setFont(new java.awt.Font("Tahoma",0,12));
					nyttMoeteButton.addActionListener(this);
				}
				{
					endreMoeteButton = new JButton();
					endreMoeteButton.setText("Endre møte");
					endreMoeteButton.setFont(new java.awt.Font("Tahoma",0,12));
					endreMoeteButton.addActionListener(this);
				}
				{
					avlysMoeteButton = new JButton();
					avlysMoeteButton.setText("Avlys møte");
					avlysMoeteButton.setFont(new java.awt.Font("Tahoma",0,12));
					avlysMoeteButton.addActionListener(this);
				}
				{
					endreAvtaleButton = new JButton();
					endreAvtaleButton.setText("Endre avtale");
					endreAvtaleButton.setFont(new java.awt.Font("Tahoma",0,12));
					endreAvtaleButton.addActionListener(this);
				}
				{
					sletteAvtaleButton = new JButton();
					sletteAvtaleButton.setText("Slette avtale");
					sletteAvtaleButton.setFont(new java.awt.Font("Tahoma",0,12));
					sletteAvtaleButton.addActionListener(this);
				}
				{
					nyAvtaleButton = new JButton();
					nyAvtaleButton.setText("Ny avtale");
					nyAvtaleButton.setFont(new java.awt.Font("Tahoma",0,12));
					nyAvtaleButton.addActionListener(this);
				}
				jPanel1Layout.setHorizontalGroup(jPanel1Layout.createSequentialGroup()
					.addGroup(jPanel1Layout.createParallelGroup()
					    .addComponent(sletteAvtaleButton, GroupLayout.Alignment.LEADING, 0, 110, Short.MAX_VALUE)
					    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup()
					        .addComponent(endreAvtaleButton, GroupLayout.Alignment.LEADING, 0, 101, Short.MAX_VALUE)
					        .addComponent(nyAvtaleButton, GroupLayout.Alignment.LEADING, 0, 101, Short.MAX_VALUE)))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(jPanel1Layout.createParallelGroup()
					    .addComponent(nyttMoeteButton, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					    .addComponent(endreMoeteButton, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					    .addComponent(avlysMoeteButton, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)));
				jPanel1Layout.setVerticalGroup(jPanel1Layout.createSequentialGroup()
					.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(nyAvtaleButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					    .addComponent(nyttMoeteButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(endreMoeteButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(endreAvtaleButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(avlysMoeteButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(sletteAvtaleButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(56, 56));
			}
			{
				ulestLAbel = new JLabel();
				ulestLAbel.setText("Uleste meldinger:");
				ulestLAbel.setFont(new java.awt.Font("Tahoma",0,14));
			}
			{
				jScrollPane1 = new JScrollPane();
				{
					ListModel jList1Model = 
						new DefaultComboBoxModel(
								new String[] { "Item One", "Item Two" });
					jList1 = new JList();
					jScrollPane1.setViewportView(jList1);
					jList1.setModel(jList1Model);
					jList1.setPreferredSize(new java.awt.Dimension(155, 91));
				}
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(minKalenderLAbel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(12)
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
				        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				        .addComponent(ulestLAbel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 0, Short.MAX_VALUE)
				        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(kalenderPanel1, 0, 168, Short.MAX_VALUE)
				        .addGap(77)))
				.addContainerGap(69, 69));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addGroup(thisLayout.createParallelGroup()
				    .addComponent(jPanel1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
				    .addGroup(thisLayout.createSequentialGroup()
				        .addPreferredGap(jPanel1, ulestLAbel, LayoutStyle.ComponentPlacement.INDENT)
				        .addGroup(thisLayout.createParallelGroup()
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(ulestLAbel, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
				                .addGap(65))
				            .addComponent(jScrollPane1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
				        .addGap(32)))
				.addGap(56)
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(thisLayout.createSequentialGroup()
				        .addComponent(kalenderPanel1, GroupLayout.PREFERRED_SIZE, 509, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 0, Short.MAX_VALUE))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addPreferredGap(kalenderPanel1, minKalenderLAbel, LayoutStyle.ComponentPlacement.INDENT)
				        .addComponent(minKalenderLAbel, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 217, Short.MAX_VALUE)))
				.addContainerGap(63, 63));
			pack();
			this.setSize(855, 392);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource() == nyAvtaleButton){
			nyAvtale nyAvtale = new nyAvtale();
			nyAvtale.show();
			hide();
		}
		else if(evt.getSource() == nyttMoeteButton){
			nyttMoete nyttMoete = new nyttMoete();
			nyttMoete.show();
			hide();
		}
		else if(evt.getSource() == endreAvtaleButton){
			endreAvtale endreAvtale = new endreAvtale();
			endreAvtale.show();
			hide();
		}
		else if(evt.getSource() == endreMoeteButton){
			endreMoete endreMoete = new endreMoete();
			endreMoete.show();
			hide();
		}
		else if(evt.getSource() == sletteAvtaleButton){
			
		}
		else if(evt.getSource() == avlysMoeteButton){
			avlysMoete avlysMoete = new avlysMoete();
			avlysMoete.show();
			hide();
		}
	}

}
