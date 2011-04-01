package no.ntnu.fp.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import no.ntnu.fp.model.Avtale;
import no.ntnu.fp.model.Person;

import Klient.KlientOS;


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
public class endreAvtale extends javax.swing.JFrame implements ActionListener{
	private JPanel jPanel1;
	private JTextField headerTextField;
	private JLabel romLabel3;
	private JComboBox romComboBox3;
	private JLabel jLabel2;
	private JLabel jLabel1;
	private JComboBox sluttid;
	private JComboBox starttid;
	private JButton slettButton;
	private JPanel jPanel2;
	private JButton avbrytButton;
	private JLabel nyAvtaleLabel;
	private JLabel datoLabel;
	private JLabel headerLabel;
	private JLabel starttidLabel;
	private JLabel sluttidLabel;
	private JLabel beskrivelseLabel;
	private JButton lagreButton;
	private JTextArea jTextArea1;
	private JTextField datoField;
	
	private kal mainKal;
	private Avtale gammelAvtale;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				endreAvtale inst = new endreAvtale(new Avtale());
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	
	public endreAvtale(Avtale avt) {
		super();
		this.gammelAvtale = avt;
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				this.setSize(388, 355);
			}
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				GroupLayout jPanel1Layout = new GroupLayout((JComponent)jPanel1);
				jPanel1.setLayout(jPanel1Layout);
				jPanel1.setPreferredSize(new java.awt.Dimension(392, 301));
				{
					jPanel2 = new JPanel();
					GroupLayout jPanel2Layout = new GroupLayout((JComponent)jPanel2);
					jPanel2.setLayout(jPanel2Layout);
					{
						nyAvtaleLabel = new JLabel();
						nyAvtaleLabel.setText("Endre avtale");
						nyAvtaleLabel.setFont(new java.awt.Font("Tahoma",1,16));
					}
					{
						jLabel1 = new JLabel();
						jLabel1.setText("a");
						jLabel1.setFont(new java.awt.Font("Tahoma",2,12));
					}
					{
						jLabel2 = new JLabel();
						jLabel2.setText("b");
						jLabel2.setFont(new java.awt.Font("Tahoma",2,12));
					}
					{
						ComboBoxModel romComboBox3Model = 
							new DefaultComboBoxModel(
									new String[] { "Item One", "Item Two" });
						romComboBox3 = new JComboBox();
						romComboBox3.setModel(romComboBox3Model);
					}
					{
						romLabel3 = new JLabel();
						romLabel3.setText("Rom:");
						romLabel3.setFont(new java.awt.Font("Tahoma",0,12));
					}
					{
						datoLabel = new JLabel();
						datoLabel.setText("Dato:");
						datoLabel.setFont(new java.awt.Font("Tahoma",0,12));
					}
					{
						datoField = new JTextField();
						datoField.setText("dd.mm.aaaa");
						datoField.setFont(new java.awt.Font("Tahoma",2,11));
					}
					{
						headerTextField = new JTextField();
						headerTextField.getText();
					}
					{
						headerLabel = new JLabel();
						headerLabel.setText("Tittel:");
						headerLabel.setFont(new java.awt.Font("Tahoma",0,12));
					}
					{
						starttidLabel = new JLabel();
						starttidLabel.setText("Starttid:");
						starttidLabel.setFont(new java.awt.Font("Tahoma",0,12));
					}
					{
						sluttidLabel = new JLabel();
						sluttidLabel.setText("Sluttid:");
						sluttidLabel.setFont(new java.awt.Font("Tahoma",0,12));
					}
					{
						beskrivelseLabel = new JLabel();
						beskrivelseLabel.setText("Beskrivelse:");
						beskrivelseLabel.setFont(new java.awt.Font("Tahoma",0,12));
					}
					{
						jTextArea1 = new JTextArea();
						jTextArea1.setText("Skriv inn beskrivelse");
						jTextArea1.setFont(new java.awt.Font("Tahoma",2,11));
						jTextArea1.getText();
					}
					{
						avbrytButton = new JButton();
						avbrytButton.setText("Avbryt");
						avbrytButton.setFont(new java.awt.Font("Tahoma",0,12));
						avbrytButton.addActionListener(this);
					}
					{
						lagreButton = new JButton();
						lagreButton.setText("Lagre");
						lagreButton.setFont(new java.awt.Font("Tahoma",0,12));
						lagreButton.addActionListener(this);
					}
					{
						ComboBoxModel jComboBox1Model = 
							new DefaultComboBoxModel(
									new String[] { "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00" });
						starttid = new JComboBox();
						starttid.setModel(jComboBox1Model);
						starttid.getSelectedItem();
					}
					{
						ComboBoxModel jComboBox2Model = 
							new DefaultComboBoxModel(
									new String[] { "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00" });
						sluttid = new JComboBox();
						sluttid.setModel(jComboBox2Model);
						sluttid.getSelectedItem();
					}
					{
						slettButton = new JButton();
						slettButton.setText("Slett");
						slettButton.setFont(new java.awt.Font("Tahoma",0,12));
						slettButton.addActionListener(this);
					}
					jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup()
						.addGroup(jPanel2Layout.createSequentialGroup()
						    .addGroup(jPanel2Layout.createParallelGroup()
						        .addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
						            .addComponent(lagreButton, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
						            .addGroup(jPanel2Layout.createParallelGroup()
						                .addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
						                    .addComponent(starttid, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						                    .addGap(0, 20, Short.MAX_VALUE))
						                .addGroup(jPanel2Layout.createSequentialGroup()
						                    .addComponent(headerTextField, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
						                    .addGap(0, 0, Short.MAX_VALUE))
						                .addGroup(jPanel2Layout.createSequentialGroup()
						                    .addComponent(datoField, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
						                    .addGap(0, 0, Short.MAX_VALUE))))
						        .addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
						            .addComponent(nyAvtaleLabel, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
						            .addGap(0, 47, Short.MAX_VALUE)))
						    .addContainerGap(98, 98))
						.addGroup(jPanel2Layout.createSequentialGroup()
						    .addPreferredGap(lagreButton, starttidLabel, LayoutStyle.ComponentPlacement.INDENT)
						    .addGroup(jPanel2Layout.createParallelGroup()
						        .addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
						            .addComponent(starttidLabel, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						            .addGap(8))
						        .addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
						            .addComponent(headerLabel, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						            .addGap(8))
						        .addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
						            .addComponent(datoLabel, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						            .addGap(17))
						        .addComponent(beskrivelseLabel, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
						        .addComponent(sluttidLabel, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
						        .addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
						            .addComponent(romLabel3, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						            .addGap(31)))
						    .addGap(17)
						    .addGroup(jPanel2Layout.createParallelGroup()
						        .addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
						            .addGroup(jPanel2Layout.createParallelGroup()
						                .addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
						                    .addGap(0, 0, Short.MAX_VALUE)
						                    .addComponent(sluttid, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						                    .addGap(7)
						                    .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
						                .addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
						                    .addComponent(avbrytButton, 0, 90, Short.MAX_VALUE)
						                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
						            .addComponent(slettButton, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
						        .addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
						            .addGap(0, 0, Short.MAX_VALUE)
						            .addComponent(jTextArea1, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
						            .addGap(57))
						        .addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
						            .addComponent(romComboBox3, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						            .addGap(7)
						            .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						            .addGap(0, 52, Short.MAX_VALUE)))
						    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 3, GroupLayout.PREFERRED_SIZE)));
					jPanel2Layout.setVerticalGroup(jPanel2Layout.createSequentialGroup()
						.addComponent(nyAvtaleLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(19)
						.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						    .addComponent(datoField, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(datoLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(jLabel1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						    .addComponent(headerTextField, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(headerLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel2Layout.createParallelGroup()
						    .addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						        .addComponent(starttid, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						        .addComponent(starttidLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
						    .addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
						        .addGap(14)
						        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						    .addComponent(sluttid, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(sluttidLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						    .addComponent(romComboBox3, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(romLabel3, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
						.addGroup(jPanel2Layout.createParallelGroup()
						    .addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
						        .addComponent(beskrivelseLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						        .addGap(29))
						    .addComponent(jTextArea1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						    .addComponent(avbrytButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(slettButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(lagreButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)));
				}
					jPanel1Layout.setHorizontalGroup(jPanel1Layout.createSequentialGroup()
					.addContainerGap(47, 47)
					.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(87, Short.MAX_VALUE));
					jPanel1Layout.setVerticalGroup(jPanel1Layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jPanel2, 0, 254, Short.MAX_VALUE));
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource() == lagreButton){
			boolean gyldigeFelt = true;
			if (headerTextField.getText().equals("")){
				gyldigeFelt = false;
			}
			else if (jTextArea1.getText().equals("")){
				gyldigeFelt = false;
			}
			if (gyldigeFelt) {
				try{
					String[] dato = datoField.getText().replace("/", ".").split(".");
					int year = Integer.parseInt(dato[2]);
					int month = Integer.parseInt(dato[1]);
					int day = Integer.parseInt(dato[0]);
					Avtale tempAvtale = new Avtale(gammelAvtale.getAvtaleId(), headerTextField.getText(), jTextArea1.getText(), mainKal.getConnectedPerson(), Integer.parseInt((String) starttid.getSelectedItem()), Integer.parseInt((String)sluttid.getSelectedItem()), day, month, year );
					mainKal = new kal();
					dispose();
				}
				catch(Exception error){
					error.printStackTrace();
				}
			// lagre endringene, også i kalenderen
		}
		else if(evt.getSource() == avbrytButton){
			kal kal = new kal();
			kal.show();
			hide();
		}
		if(evt.getSource() == slettButton){
			slett slett = new slett();
			slett.show();
		}
	}

	}
}
