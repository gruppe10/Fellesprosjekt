package src;
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
public class kal extends javax.swing.JFrame {
	private JLabel minKalenderLAbel;
	private JButton endreMoeteButton;
	private JLabel jLabel1;
	private JLabel soendagLabel;
	private JLabel loerdagLabel;
	private JLabel fradagLabel;
	private JLabel torsdagLabel;
	private JLabel onsdagLAbel;
	private JLabel tirsdagLabel;
	private JPanel jPanel2;
	private JLabel jLabel6;
	private JLabel jLabel5;
	private JLabel jLabel4;
	private JLabel jLabel3;
	private JLabel jLabel2;
	private JLabel datoMandagLabel;
	private JLabel mandagLabel;
	private JTable jTable28;
	private JTable jTable27;
	private JTable jTable26;
	private JTable jTable25;
	private JTable jTable24;
	private JTable jTable23;
	private JTable jTable22;
	private JTable jTable21;
	private JTable jTable20;
	private JTable jTable19;
	private JTable jTable18;
	private JTable jTable17;
	private JTable jTable16;
	private JTable jTable15;
	private JTable jTable14;
	private JTable jTable13;
	private JTable jTable12;
	private JTable jTable11;
	private JTable jTable10;
	private JTable jTable9;
	private JTable jTable8;
	private JTable jTable7;
	private JScrollPane jScrollPane1;
	private JList jList1;
	private JTable jTable6;
	private JTable jTable5;
	private JTable jTable4;
	private JTable jTable3;
	private JTable jTable2;
	private JTable jTable1;
	private JButton nyAvtaleButton;
	private JLabel tidLabel;
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
				jPanel1 = new JPanel();
				GroupLayout jPanel1Layout = new GroupLayout((JComponent)jPanel1);
				jPanel1.setLayout(jPanel1Layout);
				{
					nyttMoeteButton = new JButton();
					nyttMoeteButton.setText("Nytt Møte");
					nyttMoeteButton.setFont(new java.awt.Font("Tahoma",0,12));
				}
				{
					endreMoeteButton = new JButton();
					endreMoeteButton.setText("Endre møte");
					endreMoeteButton.setFont(new java.awt.Font("Tahoma",0,12));
				}
				{
					avlysMoeteButton = new JButton();
					avlysMoeteButton.setText("Avlys møte");
					avlysMoeteButton.setFont(new java.awt.Font("Tahoma",0,12));
				}
				{
					endreAvtaleButton = new JButton();
					endreAvtaleButton.setText("Endre avtale");
					endreAvtaleButton.setFont(new java.awt.Font("Tahoma",0,12));
				}
				{
					sletteAvtaleButton = new JButton();
					sletteAvtaleButton.setText("Slette avtale");
					sletteAvtaleButton.setFont(new java.awt.Font("Tahoma",0,12));
				}
				{
					nyAvtaleButton = new JButton();
					nyAvtaleButton.setText("Ny avtale");
					nyAvtaleButton.setFont(new java.awt.Font("Tahoma",0,12));
				}
				jPanel1Layout.setHorizontalGroup(jPanel1Layout.createSequentialGroup()
					.addGroup(jPanel1Layout.createParallelGroup()
					    .addComponent(endreAvtaleButton, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					    .addComponent(sletteAvtaleButton, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					    .addComponent(nyAvtaleButton, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(jPanel1Layout.createParallelGroup()
					    .addComponent(nyttMoeteButton, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					    .addComponent(endreMoeteButton, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					    .addComponent(avlysMoeteButton, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
					.addContainerGap());
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
					    .addComponent(sletteAvtaleButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap());
			}
			{
				ulestLAbel = new JLabel();
				ulestLAbel.setText("Uleste meldinger:");
				ulestLAbel.setFont(new java.awt.Font("Tahoma",0,14));
			}
			{
				jPanel2 = new JPanel();
				GroupLayout jPanel2Layout = new GroupLayout((JComponent)jPanel2);
				jPanel2.setLayout(jPanel2Layout);
				{
					tidLabel = new JLabel();
					tidLabel.setText("Tid:");
					tidLabel.setFont(new java.awt.Font("Tahoma",0,12));
				}
				{
					mandagLabel = new JLabel();
					mandagLabel.setText("Mandag");
					mandagLabel.setFont(new java.awt.Font("Tahoma",0,12));
				}
				{
					datoMandagLabel = new JLabel();
				}
				{
					tirsdagLabel = new JLabel();
					tirsdagLabel.setText("Tirsdag");
					tirsdagLabel.setFont(new java.awt.Font("Tahoma",0,12));
				}
				{
					jLabel1 = new JLabel();
				}
				{
					onsdagLAbel = new JLabel();
					onsdagLAbel.setText("Onsdag");
					onsdagLAbel.setFont(new java.awt.Font("Tahoma",0,12));
				}
				{
					jLabel2 = new JLabel();
				}
				{
					torsdagLabel = new JLabel();
					torsdagLabel.setText("Torsdag");
					torsdagLabel.setFont(new java.awt.Font("Tahoma",0,12));
				}
				{
					jLabel3 = new JLabel();
				}
				{
					fradagLabel = new JLabel();
					fradagLabel.setText("Fredag");
					fradagLabel.setFont(new java.awt.Font("Tahoma",0,12));
				}
				{
					jLabel4 = new JLabel();
				}
				{
					loerdagLabel = new JLabel();
					loerdagLabel.setText("Lørdag");
					loerdagLabel.setFont(new java.awt.Font("Tahoma",0,12));
				}
				{
					jLabel5 = new JLabel();
				}
				{
					soendagLabel = new JLabel();
					soendagLabel.setText("Søndag");
					soendagLabel.setFont(new java.awt.Font("Tahoma",0,12));
				}
				{
					jLabel6 = new JLabel();
				}
				{
					TableModel jTable1Model = 
						new DefaultTableModel(
								new String[][] { { "One", "Two" }, { "Three", "Four" } },
								new String[] { "Column 1", "Column 2" });
					jTable1 = new JTable();
					jTable1.setModel(jTable1Model);
				}
				{
					TableModel jTable5Model = 
						new DefaultTableModel(
								new String[][] { { "One", "Two" }, { "Three", "Four" } },
								new String[] { "Column 1", "Column 2" });
					jTable5 = new JTable();
					jTable5.setModel(jTable5Model);
				}
				{
					TableModel jTable9Model = 
						new DefaultTableModel(
								new String[][] { { "One", "Two" }, { "Three", "Four" } },
								new String[] { "Column 1", "Column 2" });
					jTable9 = new JTable();
					jTable9.setModel(jTable9Model);
				}
				{
					TableModel jTable13Model = 
						new DefaultTableModel(
								new String[][] { { "One", "Two" }, { "Three", "Four" } },
								new String[] { "Column 1", "Column 2" });
					jTable13 = new JTable();
					jTable13.setModel(jTable13Model);
				}
				{
					TableModel jTable14Model = 
						new DefaultTableModel(
								new String[][] { { "One", "Two" }, { "Three", "Four" } },
								new String[] { "Column 1", "Column 2" });
					jTable14 = new JTable();
					jTable14.setModel(jTable14Model);
				}
				{
					TableModel jTable15Model = 
						new DefaultTableModel(
								new String[][] { { "One", "Two" }, { "Three", "Four" } },
								new String[] { "Column 1", "Column 2" });
					jTable15 = new JTable();
					jTable15.setModel(jTable15Model);
				}
				{
					TableModel jTable16Model = 
						new DefaultTableModel(
								new String[][] { { "One", "Two" }, { "Three", "Four" } },
								new String[] { "Column 1", "Column 2" });
					jTable16 = new JTable();
					jTable16.setModel(jTable16Model);
				}
				{
					TableModel jTable2Model = 
						new DefaultTableModel(
								new String[][] { { "One", "Two" }, { "Three", "Four" } },
								new String[] { "Column 1", "Column 2" });
					jTable2 = new JTable();
					jTable2.setModel(jTable2Model);
				}
				{
					TableModel jTable6Model = 
						new DefaultTableModel(
								new String[][] { { "One", "Two" }, { "Three", "Four" } },
								new String[] { "Column 1", "Column 2" });
					jTable6 = new JTable();
					jTable6.setModel(jTable6Model);
				}
				{
					TableModel jTable10Model = 
						new DefaultTableModel(
								new String[][] { { "One", "Two" }, { "Three", "Four" } },
								new String[] { "Column 1", "Column 2" });
					jTable10 = new JTable();
					jTable10.setModel(jTable10Model);
				}
				{
					TableModel jTable17Model = 
						new DefaultTableModel(
								new String[][] { { "One", "Two" }, { "Three", "Four" } },
								new String[] { "Column 1", "Column 2" });
					jTable17 = new JTable();
					jTable17.setModel(jTable17Model);
				}
				{
					TableModel jTable20Model = 
						new DefaultTableModel(
								new String[][] { { "One", "Two" }, { "Three", "Four" } },
								new String[] { "Column 1", "Column 2" });
					jTable20 = new JTable();
					jTable20.setModel(jTable20Model);
				}
				{
					TableModel jTable23Model = 
						new DefaultTableModel(
								new String[][] { { "One", "Two" }, { "Three", "Four" } },
								new String[] { "Column 1", "Column 2" });
					jTable23 = new JTable();
					jTable23.setModel(jTable23Model);
				}
				{
					TableModel jTable26Model = 
						new DefaultTableModel(
								new String[][] { { "One", "Two" }, { "Three", "Four" } },
								new String[] { "Column 1", "Column 2" });
					jTable26 = new JTable();
					jTable26.setModel(jTable26Model);
				}
				{
					TableModel jTable3Model = 
						new DefaultTableModel(
								new String[][] { { "One", "Two" }, { "Three", "Four" } },
								new String[] { "Column 1", "Column 2" });
					jTable3 = new JTable();
					jTable3.setModel(jTable3Model);
				}
				{
					TableModel jTable7Model = 
						new DefaultTableModel(
								new String[][] { { "One", "Two" }, { "Three", "Four" } },
								new String[] { "Column 1", "Column 2" });
					jTable7 = new JTable();
					jTable7.setModel(jTable7Model);
				}
				{
					TableModel jTable11Model = 
						new DefaultTableModel(
								new String[][] { { "One", "Two" }, { "Three", "Four" } },
								new String[] { "Column 1", "Column 2" });
					jTable11 = new JTable();
					jTable11.setModel(jTable11Model);
				}
				{
					TableModel jTable18Model = 
						new DefaultTableModel(
								new String[][] { { "One", "Two" }, { "Three", "Four" } },
								new String[] { "Column 1", "Column 2" });
					jTable18 = new JTable();
					jTable18.setModel(jTable18Model);
				}
				{
					TableModel jTable21Model = 
						new DefaultTableModel(
								new String[][] { { "One", "Two" }, { "Three", "Four" } },
								new String[] { "Column 1", "Column 2" });
					jTable21 = new JTable();
					jTable21.setModel(jTable21Model);
				}
				{
					TableModel jTable24Model = 
						new DefaultTableModel(
								new String[][] { { "One", "Two" }, { "Three", "Four" } },
								new String[] { "Column 1", "Column 2" });
					jTable24 = new JTable();
					jTable24.setModel(jTable24Model);
				}
				{
					TableModel jTable27Model = 
						new DefaultTableModel(
								new String[][] { { "One", "Two" }, { "Three", "Four" } },
								new String[] { "Column 1", "Column 2" });
					jTable27 = new JTable();
					jTable27.setModel(jTable27Model);
				}
				{
					TableModel jTable28Model = 
						new DefaultTableModel(
								new String[][] { { "One", "Two" }, { "Three", "Four" } },
								new String[] { "Column 1", "Column 2" });
					jTable28 = new JTable();
					jTable28.setModel(jTable28Model);
				}
				{
					TableModel jTable25Model = 
						new DefaultTableModel(
								new String[][] { { "One", "Two" }, { "Three", "Four" } },
								new String[] { "Column 1", "Column 2" });
					jTable25 = new JTable();
					jTable25.setModel(jTable25Model);
				}
				{
					TableModel jTable22Model = 
						new DefaultTableModel(
								new String[][] { { "One", "Two" }, { "Three", "Four" } },
								new String[] { "Column 1", "Column 2" });
					jTable22 = new JTable();
					jTable22.setModel(jTable22Model);
				}
				{
					TableModel jTable19Model = 
						new DefaultTableModel(
								new String[][] { { "One", "Two" }, { "Three", "Four" } },
								new String[] { "Column 1", "Column 2" });
					jTable19 = new JTable();
					jTable19.setModel(jTable19Model);
				}
				{
					TableModel jTable12Model = 
						new DefaultTableModel(
								new String[][] { { "One", "Two" }, { "Three", "Four" } },
								new String[] { "Column 1", "Column 2" });
					jTable12 = new JTable();
					jTable12.setModel(jTable12Model);
				}
				{
					TableModel jTable8Model = 
						new DefaultTableModel(
								new String[][] { { "One", "Two" }, { "Three", "Four" } },
								new String[] { "Column 1", "Column 2" });
					jTable8 = new JTable();
					jTable8.setModel(jTable8Model);
				}
				{
					TableModel jTable4Model = 
						new DefaultTableModel(
								new String[][] { { "One", "Two" }, { "Three", "Four" } },
								new String[] { "Column 1", "Column 2" });
					jTable4 = new JTable();
					jTable4.setModel(jTable4Model);
				}
				jPanel2Layout.setVerticalGroup(jPanel2Layout.createSequentialGroup()
						.addGroup(jPanel2Layout.createParallelGroup()
								.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(mandagLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
										.addComponent(tirsdagLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
										.addComponent(onsdagLAbel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
										.addComponent(torsdagLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
										.addComponent(fradagLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
										.addComponent(loerdagLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
										.addComponent(soendagLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(jPanel2Layout.createSequentialGroup()
												.addGap(12)
												.addGroup(jPanel2Layout.createParallelGroup()
														.addGroup(jPanel2Layout.createSequentialGroup()
																.addComponent(tidLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
																.addGroup(jPanel2Layout.createSequentialGroup()
																		.addComponent(datoMandagLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
																		.addGroup(jPanel2Layout.createSequentialGroup()
																				.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
																				.addGroup(jPanel2Layout.createSequentialGroup()
																						.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
																						.addGroup(jPanel2Layout.createSequentialGroup()
																								.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
																								.addGroup(jPanel2Layout.createSequentialGroup()
																										.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
																										.addGroup(jPanel2Layout.createSequentialGroup()
																												.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
																												.addGroup(jPanel2Layout.createSequentialGroup()
																														.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)))))
																														.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																														.addGroup(jPanel2Layout.createParallelGroup()
																																.addGroup(jPanel2Layout.createSequentialGroup()
																																		.addComponent(jTable1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
																																		.addGroup(jPanel2Layout.createSequentialGroup()
																																				.addComponent(jTable2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
																																				.addGroup(jPanel2Layout.createSequentialGroup()
																																						.addComponent(jTable3, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
																																						.addGroup(jPanel2Layout.createSequentialGroup()
																																								.addComponent(jTable4, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
																																								.addGroup(jPanel2Layout.createParallelGroup()
																																										.addGroup(jPanel2Layout.createSequentialGroup()
																																												.addComponent(jTable5, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
																																												.addGroup(jPanel2Layout.createSequentialGroup()
																																														.addComponent(jTable6, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
																																														.addGroup(jPanel2Layout.createSequentialGroup()
																																																.addComponent(jTable7, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
																																																.addGroup(jPanel2Layout.createSequentialGroup()
																																																		.addComponent(jTable8, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
																																																		.addGroup(jPanel2Layout.createParallelGroup()
																																																				.addGroup(jPanel2Layout.createSequentialGroup()
																																																						.addComponent(jTable9, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
																																																						.addGroup(jPanel2Layout.createSequentialGroup()
																																																								.addComponent(jTable10, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
																																																								.addGroup(jPanel2Layout.createSequentialGroup()
																																																										.addComponent(jTable11, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
																																																										.addGroup(jPanel2Layout.createSequentialGroup()
																																																												.addComponent(jTable12, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
																																																												.addGroup(jPanel2Layout.createParallelGroup()
																																																														.addGroup(jPanel2Layout.createSequentialGroup()
																																																																.addComponent(jTable13, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
																																																																.addGroup(jPanel2Layout.createSequentialGroup()
																																																																		.addComponent(jTable17, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
																																																																		.addGroup(jPanel2Layout.createSequentialGroup()
																																																																				.addComponent(jTable18, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
																																																																				.addGroup(jPanel2Layout.createSequentialGroup()
																																																																						.addComponent(jTable19, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
																																																																						.addGroup(jPanel2Layout.createParallelGroup()
																																																																								.addGroup(jPanel2Layout.createSequentialGroup()
																																																																										.addComponent(jTable14, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
																																																																										.addGroup(jPanel2Layout.createSequentialGroup()
																																																																												.addComponent(jTable20, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
																																																																												.addGroup(jPanel2Layout.createSequentialGroup()
																																																																														.addComponent(jTable21, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
																																																																														.addGroup(jPanel2Layout.createSequentialGroup()
																																																																																.addComponent(jTable22, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
																																																																																.addGroup(jPanel2Layout.createParallelGroup()
																																																																																		.addGroup(jPanel2Layout.createSequentialGroup()
																																																																																				.addComponent(jTable15, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
																																																																																				.addGroup(jPanel2Layout.createSequentialGroup()
																																																																																						.addComponent(jTable23, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
																																																																																						.addGroup(jPanel2Layout.createSequentialGroup()
																																																																																								.addComponent(jTable24, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
																																																																																								.addGroup(jPanel2Layout.createSequentialGroup()
																																																																																										.addComponent(jTable25, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
																																																																																										.addGroup(jPanel2Layout.createParallelGroup()
																																																																																												.addGroup(jPanel2Layout.createSequentialGroup()
																																																																																														.addComponent(jTable16, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
																																																																																														.addGroup(jPanel2Layout.createSequentialGroup()
																																																																																																.addComponent(jTable26, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
																																																																																																.addGroup(jPanel2Layout.createSequentialGroup()
																																																																																																		.addComponent(jTable27, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
																																																																																																		.addGroup(jPanel2Layout.createSequentialGroup()
																																																																																																				.addComponent(jTable28, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))));
				jPanel2Layout.setHorizontalGroup(jPanel2Layout.createSequentialGroup()
						.addGroup(jPanel2Layout.createParallelGroup()
								.addGroup(jPanel2Layout.createSequentialGroup()
										.addComponent(tidLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
										.addGap(28)
										.addGroup(jPanel2Layout.createParallelGroup()
												.addGroup(jPanel2Layout.createSequentialGroup()
														.addComponent(mandagLabel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
														.addGroup(jPanel2Layout.createSequentialGroup()
																.addComponent(datoMandagLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
																.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
																.addGroup(jPanel2Layout.createParallelGroup()
																		.addGroup(jPanel2Layout.createSequentialGroup()
																				.addComponent(tirsdagLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
																				.addGroup(jPanel2Layout.createSequentialGroup()
																						.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
																						.addGap(18)
																						.addGroup(jPanel2Layout.createParallelGroup()
																								.addGroup(jPanel2Layout.createSequentialGroup()
																										.addComponent(onsdagLAbel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
																										.addGroup(jPanel2Layout.createSequentialGroup()
																												.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))))
																												.addGroup(jPanel2Layout.createSequentialGroup()
																														.addGroup(jPanel2Layout.createParallelGroup()
																																.addGroup(jPanel2Layout.createSequentialGroup()
																																		.addComponent(jTable1, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
																																		.addGroup(jPanel2Layout.createSequentialGroup()
																																				.addComponent(jTable5, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
																																				.addGroup(jPanel2Layout.createSequentialGroup()
																																						.addComponent(jTable9, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
																																						.addGroup(jPanel2Layout.createSequentialGroup()
																																								.addComponent(jTable13, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
																																								.addGroup(jPanel2Layout.createSequentialGroup()
																																										.addComponent(jTable14, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
																																										.addGroup(jPanel2Layout.createSequentialGroup()
																																												.addComponent(jTable15, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
																																												.addGroup(jPanel2Layout.createSequentialGroup()
																																														.addComponent(jTable16, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)))
																																														.addGroup(jPanel2Layout.createParallelGroup()
																																																.addGroup(jPanel2Layout.createSequentialGroup()
																																																		.addComponent(jTable2, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
																																																		.addGroup(jPanel2Layout.createSequentialGroup()
																																																				.addComponent(jTable6, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
																																																				.addGroup(jPanel2Layout.createSequentialGroup()
																																																						.addComponent(jTable10, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
																																																						.addGroup(jPanel2Layout.createSequentialGroup()
																																																								.addComponent(jTable17, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
																																																								.addGroup(jPanel2Layout.createSequentialGroup()
																																																										.addComponent(jTable20, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
																																																										.addGroup(jPanel2Layout.createSequentialGroup()
																																																												.addComponent(jTable23, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
																																																												.addGroup(jPanel2Layout.createSequentialGroup()
																																																														.addComponent(jTable26, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)))))
																																																														.addGroup(jPanel2Layout.createParallelGroup()
																																																																.addGroup(jPanel2Layout.createSequentialGroup()
																																																																		.addGroup(jPanel2Layout.createParallelGroup()
																																																																				.addGroup(jPanel2Layout.createSequentialGroup()
																																																																						.addComponent(torsdagLabel, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
																																																																						.addGroup(jPanel2Layout.createSequentialGroup()
																																																																								.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
																																																																								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
																																																																								.addGroup(jPanel2Layout.createParallelGroup()
																																																																										.addGroup(jPanel2Layout.createSequentialGroup()
																																																																												.addComponent(fradagLabel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
																																																																												.addGroup(jPanel2Layout.createSequentialGroup()
																																																																														.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))))
																																																																														.addGroup(jPanel2Layout.createSequentialGroup()
																																																																																.addComponent(jTable3, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
																																																																																.addGroup(jPanel2Layout.createSequentialGroup()
																																																																																		.addComponent(jTable7, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
																																																																																		.addGroup(jPanel2Layout.createSequentialGroup()
																																																																																				.addComponent(jTable11, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
																																																																																				.addGroup(jPanel2Layout.createSequentialGroup()
																																																																																						.addComponent(jTable18, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
																																																																																						.addGroup(jPanel2Layout.createSequentialGroup()
																																																																																								.addComponent(jTable21, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
																																																																																								.addGroup(jPanel2Layout.createSequentialGroup()
																																																																																										.addComponent(jTable24, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
																																																																																										.addGroup(jPanel2Layout.createSequentialGroup()
																																																																																												.addComponent(jTable27, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)))
																																																																																												.addGroup(jPanel2Layout.createParallelGroup()
																																																																																														.addGroup(jPanel2Layout.createSequentialGroup()
																																																																																																.addGroup(jPanel2Layout.createParallelGroup()
																																																																																																		.addGroup(jPanel2Layout.createSequentialGroup()
																																																																																																				.addComponent(loerdagLabel, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
																																																																																																				.addGroup(jPanel2Layout.createSequentialGroup()
																																																																																																						.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
																																																																																																						.addGap(18)
																																																																																																						.addGroup(jPanel2Layout.createParallelGroup()
																																																																																																								.addGroup(jPanel2Layout.createSequentialGroup()
																																																																																																										.addComponent(soendagLabel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
																																																																																																										.addGroup(jPanel2Layout.createSequentialGroup()
																																																																																																												.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))))
																																																																																																												.addGroup(jPanel2Layout.createSequentialGroup()
																																																																																																														.addComponent(jTable28, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
																																																																																																														.addGroup(jPanel2Layout.createSequentialGroup()
																																																																																																																.addComponent(jTable25, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
																																																																																																																.addGroup(jPanel2Layout.createSequentialGroup()
																																																																																																																		.addComponent(jTable22, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
																																																																																																																		.addGroup(jPanel2Layout.createSequentialGroup()
																																																																																																																				.addComponent(jTable19, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
																																																																																																																				.addGroup(jPanel2Layout.createSequentialGroup()
																																																																																																																						.addComponent(jTable12, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
																																																																																																																						.addGroup(jPanel2Layout.createSequentialGroup()
																																																																																																																								.addComponent(jTable8, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
																																																																																																																								.addGroup(jPanel2Layout.createSequentialGroup()
																																																																																																																										.addComponent(jTable4, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))));
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
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap(12, 12)
				.addGroup(thisLayout.createParallelGroup()
				    .addComponent(jPanel1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
				    .addComponent(ulestLAbel, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
				    .addComponent(jScrollPane1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
				.addGap(27)
				.addGroup(thisLayout.createParallelGroup()
				    .addComponent(jPanel2, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 512, GroupLayout.PREFERRED_SIZE)
				    .addGroup(thisLayout.createSequentialGroup()
				        .addGap(62)
				        .addComponent(minKalenderLAbel, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(72, 72));
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap(12, 12)
				.addComponent(minKalenderLAbel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(thisLayout.createParallelGroup()
				    .addComponent(jPanel2, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)
				    .addGroup(thisLayout.createSequentialGroup()
				        .addGap(12)
				        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
				        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				        .addComponent(ulestLAbel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(63, 63));
			pack();
			this.setSize(828, 392);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
