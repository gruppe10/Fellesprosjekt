package src;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import javax.swing.WindowConstants;
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
public class endreAvtale extends javax.swing.JFrame {
	private JPanel jPanel1;
	private JTextField headerTextField;
	private JButton slettButton;
	private JPanel jPanel2;
	private JButton avbrytButton;
	private JTextField sluttidTextField;
	private JLabel nyAvtaleLabel;
	private JLabel datoLabel;
	private JLabel headerLabel;
	private JLabel starttidLabel;
	private JLabel sluttidLabel;
	private JLabel beskrivelseLabel;
	private JButton lagreButton;
	private JTextArea jTextArea1;
	private JTextField starttidTextField;
	private JTextField datoField;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				endreAvtale inst = new endreAvtale();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public endreAvtale() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				GroupLayout jPanel1Layout = new GroupLayout((JComponent)jPanel1);
				jPanel1.setLayout(jPanel1Layout);
				jPanel1.setPreferredSize(new java.awt.Dimension(392, 286));
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
						starttidTextField = new JTextField();
						starttidTextField.setText("tt.mm");
						starttidTextField.setFont(new java.awt.Font("Tahoma",2,11));
					}
					{
						sluttidTextField = new JTextField();
						sluttidTextField.setText("tt.mm");
						sluttidTextField.setFont(new java.awt.Font("Tahoma",2,11));
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
					}
					{
						avbrytButton = new JButton();
						avbrytButton.setText("Avbryt");
						avbrytButton.setFont(new java.awt.Font("Tahoma",0,12));
					}
					{
						lagreButton = new JButton();
						lagreButton.setText("Lagre");
						lagreButton.setFont(new java.awt.Font("Tahoma",0,12));
					}
					{
						slettButton = new JButton();
						slettButton.setText("Slett");
						slettButton.setFont(new java.awt.Font("Tahoma",0,12));
					}
					jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup()
						.addGroup(jPanel2Layout.createSequentialGroup()
						    .addGroup(jPanel2Layout.createParallelGroup()
						        .addGroup(jPanel2Layout.createSequentialGroup()
						            .addComponent(nyAvtaleLabel, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
						            .addGap(0, 0, Short.MAX_VALUE))
						        .addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
						            .addComponent(lagreButton, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						            .addGap(0, 58, Short.MAX_VALUE)))
						    .addContainerGap(95, 95))
						.addGroup(jPanel2Layout.createSequentialGroup()
						    .addPreferredGap(nyAvtaleLabel, datoLabel, LayoutStyle.ComponentPlacement.INDENT)
						    .addGroup(jPanel2Layout.createParallelGroup()
						        .addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
						            .addComponent(datoLabel, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						            .addGap(17))
						        .addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
						            .addComponent(headerLabel, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						            .addGap(8))
						        .addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
						            .addComponent(starttidLabel, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						            .addGap(8))
						        .addComponent(beskrivelseLabel, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
						        .addComponent(sluttidLabel, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
						    .addGroup(jPanel2Layout.createParallelGroup()
						        .addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
						            .addComponent(avbrytButton, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						            .addGap(15)
						            .addComponent(slettButton, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						            .addGap(0, 0, Short.MAX_VALUE))
						        .addGroup(jPanel2Layout.createSequentialGroup()
						            .addPreferredGap(avbrytButton, datoField, LayoutStyle.ComponentPlacement.INDENT)
						            .addGroup(jPanel2Layout.createParallelGroup()
						                .addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
						                    .addComponent(datoField, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
						                    .addGap(0, 32, Short.MAX_VALUE))
						                .addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
						                    .addComponent(headerTextField, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
						                    .addGap(0, 32, Short.MAX_VALUE))
						                .addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
						                    .addComponent(starttidTextField, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
						                    .addGap(0, 32, Short.MAX_VALUE))
						                .addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
						                    .addComponent(sluttidTextField, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
						                    .addGap(0, 32, Short.MAX_VALUE))
						                .addGroup(jPanel2Layout.createSequentialGroup()
						                    .addComponent(jTextArea1, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
						                    .addGap(0, 0, Short.MAX_VALUE)))
						            .addGap(10)))
						    .addGap(6, 6, 6)));
					jPanel2Layout.setVerticalGroup(jPanel2Layout.createSequentialGroup()
						.addComponent(nyAvtaleLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(16)
						.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						    .addComponent(datoField, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(datoLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						    .addComponent(headerTextField, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(headerLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						    .addComponent(starttidTextField, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(starttidLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel2Layout.createParallelGroup()
						    .addComponent(sluttidTextField, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
						        .addGap(9)
						        .addComponent(sluttidLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel2Layout.createParallelGroup()
						    .addComponent(jTextArea1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						    .addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
						        .addComponent(beskrivelseLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						        .addGap(29)))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						    .addComponent(avbrytButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(lagreButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						    .addComponent(slettButton, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED));
				}
					jPanel1Layout.setHorizontalGroup(jPanel1Layout.createSequentialGroup()
					.addContainerGap(47, 47)
					.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(137, Short.MAX_VALUE));
					jPanel1Layout.setVerticalGroup(jPanel1Layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(24, Short.MAX_VALUE));
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
