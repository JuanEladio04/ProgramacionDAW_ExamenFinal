package jepm.examen.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.JTextField;
import jepm.examen.controller.MarcaController;
import jepm.examen.controller.PortatilController;
import jepm.examen.model.Marca;
import jepm.examen.model.Portatil;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class PcGestionPanel extends JPanel {
	private static PcGestionPanel instance = null;
	private JTextField jtf_Id;
	private JTextField jtf_modelo;
	private JTextField jtf_serialNumber;
	private JTextField jtf_fechaVenta; 
	private JComboBox jcb_marca;
	private JCheckBox jcb_vendido; 
	private ButtonGroup jrb_processorGroup = new ButtonGroup();
	private JRadioButton jrb_1p;
	private JRadioButton jrb_2p;
	private JRadioButton jrb_3p;
	private JRadioButton jrb_4p;
	private List<Portatil> allPortatiles = PortatilController.findAll();
	private int counter = 1;
	
	/**
	 * 
	 * @return
	 */
	public static PcGestionPanel getInstance() {
		if (instance == null) {
			instance = new PcGestionPanel();
		}
		return instance;
	}
	
	//Getters and Setter
	
	/**
	 * @return the counter
	 */
	public int getCounter() {
		return counter;
	}

	
	/**
	 * @param counter the counter to set
	 */
	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	
	/**
	 * @return the allPortatiles
	 */
	public List<Portatil> getAllPortatiles() {
		return allPortatiles;
	}

	
	/**
	 * @param allPortatiles the allPortatiles to set
	 */
	public void setAllPortatiles(List<Portatil> allPortatiles) {
		this.allPortatiles = allPortatiles;
	}
	

	/**
	 * @return the jcb_marca
	 */
	public JComboBox getJcb_marca() {
		return jcb_marca;
	}

	
	/**
	 * @param jcb_marca the jcb_marca to set
	 */
	public void setJcb_marca(JComboBox jcb_marca) {
		this.jcb_marca = jcb_marca;
	}

	//Métodos


	/**
	 * Create the panel.
	 */
	public PcGestionPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{114, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Gestión de Ordenadores Portatiles");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 10));
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 1;
		add(lblId, gbc_lblId);
		
		jtf_Id = new JTextField();
		jtf_Id.setEditable(false);
		GridBagConstraints gbc_jtf_Id = new GridBagConstraints();
		gbc_jtf_Id.gridwidth = 2;
		gbc_jtf_Id.insets = new Insets(0, 0, 5, 0);
		gbc_jtf_Id.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtf_Id.gridx = 1;
		gbc_jtf_Id.gridy = 1;
		add(jtf_Id, gbc_jtf_Id);
		jtf_Id.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Tahoma", Font.BOLD, 10));
		GridBagConstraints gbc_lblMarca = new GridBagConstraints();
		gbc_lblMarca.anchor = GridBagConstraints.EAST;
		gbc_lblMarca.insets = new Insets(0, 0, 5, 5);
		gbc_lblMarca.gridx = 0;
		gbc_lblMarca.gridy = 2;
		add(lblMarca, gbc_lblMarca);
		
		jcb_marca = new JComboBox();
		GridBagConstraints gbc_jcb_marca = new GridBagConstraints();
		gbc_jcb_marca.insets = new Insets(0, 0, 5, 5);
		gbc_jcb_marca.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcb_marca.gridx = 1;
		gbc_jcb_marca.gridy = 2;
		add(jcb_marca, gbc_jcb_marca);
		
		JButton btn_marcaDialog = new JButton("Ver Marca");
		btn_marcaDialog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openMarcaGestionWindow();
			}
		});
		GridBagConstraints gbc_btn_marcaDialog = new GridBagConstraints();
		gbc_btn_marcaDialog.insets = new Insets(0, 0, 5, 0);
		gbc_btn_marcaDialog.gridx = 2;
		gbc_btn_marcaDialog.gridy = 2;
		add(btn_marcaDialog, gbc_btn_marcaDialog);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Tahoma", Font.BOLD, 10));
		GridBagConstraints gbc_lblModelo = new GridBagConstraints();
		gbc_lblModelo.anchor = GridBagConstraints.EAST;
		gbc_lblModelo.insets = new Insets(0, 0, 5, 5);
		gbc_lblModelo.gridx = 0;
		gbc_lblModelo.gridy = 3;
		add(lblModelo, gbc_lblModelo);
		
		jtf_modelo = new JTextField();
		GridBagConstraints gbc_jtf_modelo = new GridBagConstraints();
		gbc_jtf_modelo.gridwidth = 2;
		gbc_jtf_modelo.insets = new Insets(0, 0, 5, 0);
		gbc_jtf_modelo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtf_modelo.gridx = 1;
		gbc_jtf_modelo.gridy = 3;
		add(jtf_modelo, gbc_jtf_modelo);
		jtf_modelo.setColumns(10);
		
		JLabel lblSerialNumber = new JLabel("Serial Number:");
		lblSerialNumber.setFont(new Font("Tahoma", Font.BOLD, 10));
		GridBagConstraints gbc_lblSerialNumber = new GridBagConstraints();
		gbc_lblSerialNumber.anchor = GridBagConstraints.EAST;
		gbc_lblSerialNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblSerialNumber.gridx = 0;
		gbc_lblSerialNumber.gridy = 4;
		add(lblSerialNumber, gbc_lblSerialNumber);
		
		jtf_serialNumber = new JTextField();
		GridBagConstraints gbc_jtf_serialNumber = new GridBagConstraints();
		gbc_jtf_serialNumber.gridwidth = 2;
		gbc_jtf_serialNumber.insets = new Insets(0, 0, 5, 0);
		gbc_jtf_serialNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtf_serialNumber.gridx = 1;
		gbc_jtf_serialNumber.gridy = 4;
		add(jtf_serialNumber, gbc_jtf_serialNumber);
		jtf_serialNumber.setColumns(10);
		
		JLabel lblNumProcesadores = new JLabel("Num procesadores:");
		lblNumProcesadores.setFont(new Font("Tahoma", Font.BOLD, 10));
		GridBagConstraints gbc_lblNumProcesadores = new GridBagConstraints();
		gbc_lblNumProcesadores.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumProcesadores.gridx = 0;
		gbc_lblNumProcesadores.gridy = 5;
		add(lblNumProcesadores, gbc_lblNumProcesadores);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 5;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		jrb_1p = new JRadioButton("1 Procesador");
		GridBagConstraints gbc_jrb_1p = new GridBagConstraints();
		gbc_jrb_1p.insets = new Insets(0, 0, 5, 5);
		gbc_jrb_1p.gridx = 0;
		gbc_jrb_1p.gridy = 0;
		panel.add(jrb_1p, gbc_jrb_1p);
		
		jrb_2p = new JRadioButton("2 Procesadores");
		GridBagConstraints gbc_jrb_2p = new GridBagConstraints();
		gbc_jrb_2p.insets = new Insets(0, 0, 5, 0);
		gbc_jrb_2p.gridx = 1;
		gbc_jrb_2p.gridy = 0;
		panel.add(jrb_2p, gbc_jrb_2p);
		
		jrb_3p = new JRadioButton("3 Procesadores");
		GridBagConstraints gbc_jrb_3p = new GridBagConstraints();
		gbc_jrb_3p.insets = new Insets(0, 0, 0, 5);
		gbc_jrb_3p.gridx = 0;
		gbc_jrb_3p.gridy = 1;
		panel.add(jrb_3p, gbc_jrb_3p);
		
		jrb_4p = new JRadioButton("4 Procesadores");
		GridBagConstraints gbc_jrb_4p = new GridBagConstraints();
		gbc_jrb_4p.gridx = 1;
		gbc_jrb_4p.gridy = 1;
		panel.add(jrb_4p, gbc_jrb_4p);
		
		jrb_processorGroup.add(jrb_1p);
		jrb_processorGroup.add(jrb_2p);
		jrb_processorGroup.add(jrb_3p);
		jrb_processorGroup.add(jrb_4p);
		
		JLabel lblVendido = new JLabel("Vendido");
		lblVendido.setFont(new Font("Tahoma", Font.BOLD, 10));
		GridBagConstraints gbc_lblVendido = new GridBagConstraints();
		gbc_lblVendido.insets = new Insets(0, 0, 5, 5);
		gbc_lblVendido.gridx = 0;
		gbc_lblVendido.gridy = 6;
		add(lblVendido, gbc_lblVendido);
		
		jcb_vendido = new JCheckBox("");
		jcb_vendido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jcb_vendido.isSelected()) {
					jtf_fechaVenta.setEditable(true);
				}
				else {
					jtf_fechaVenta.setText("");
					jtf_fechaVenta.setEditable(false);
				}
			}
		});
		GridBagConstraints gbc_jcb_vendido = new GridBagConstraints();
		gbc_jcb_vendido.anchor = GridBagConstraints.WEST;
		gbc_jcb_vendido.insets = new Insets(0, 0, 5, 5);
		gbc_jcb_vendido.gridx = 1;
		gbc_jcb_vendido.gridy = 6;
		add(jcb_vendido, gbc_jcb_vendido);
		
		JLabel lblFechaDeVenta = new JLabel("Fecha de venta:");
		lblFechaDeVenta.setFont(new Font("Tahoma", Font.BOLD, 10));
		GridBagConstraints gbc_lblFechaDeVenta = new GridBagConstraints();
		gbc_lblFechaDeVenta.anchor = GridBagConstraints.EAST;
		gbc_lblFechaDeVenta.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaDeVenta.gridx = 0;
		gbc_lblFechaDeVenta.gridy = 7;
		add(lblFechaDeVenta, gbc_lblFechaDeVenta);
		
		jtf_fechaVenta = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 7;
		add(jtf_fechaVenta, gbc_textField_4);
		jtf_fechaVenta.setColumns(10);
		
		JButton btn_totalPC = new JButton("Número total de portátiles");
		btn_totalPC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btn_totalPC, "Total de portátiles: " + allPortatiles.size());
			}
		});
		GridBagConstraints gbc_btn_totalPC = new GridBagConstraints();
		gbc_btn_totalPC.anchor = GridBagConstraints.SOUTH;
		gbc_btn_totalPC.insets = new Insets(0, 0, 0, 5);
		gbc_btn_totalPC.gridx = 1;
		gbc_btn_totalPC.gridy = 8;
		add(btn_totalPC, gbc_btn_totalPC);
		findResult();
	}
	
	
	
	/**
	 * 
	 */
	public void findResult() {
		jtf_Id.setText(allPortatiles.get(counter).getId() + "");
		chargeMarcaIntoMarcaCombo();
		setDefaultValuesToCombo(allPortatiles.get(counter));
		jtf_modelo.setText(allPortatiles.get(counter).getModelo());
		jtf_serialNumber.setText(allPortatiles.get(counter).getSn());
		checkDateEnable();
		setValuesToRadios(allPortatiles.get(counter));
		
	}

	/**
	 * 
	 */
	private void checkDateEnable() {
		if (allPortatiles.get(counter).getVendido() == 1) {
			jcb_vendido.setSelected(true);
		}
		else {
			jcb_vendido.setSelected(false);
		}
		
		if (jcb_vendido.isSelected()) {
			jtf_fechaVenta.setEditable(true);
			jtf_fechaVenta.setText(allPortatiles.get(counter).getFechaVenta() + "");
		}
		else {
			jtf_fechaVenta.setEditable(false);
		}
	}
	
	
	/**
	 * 
	 */
	public void chargeMarcaIntoMarcaCombo() {
		jcb_marca.removeAllItems();
		List<Marca> m = MarcaController.getInstance().findAll();
		
		for (Marca marca : m) {
			jcb_marca.addItem(marca);
		}
	}
	
	
	/**
	 * 
	 */
	public void setDefaultValuesToCombo(Portatil p) {
		for (int i = 0; i < jcb_marca.getItemCount(); i++) {
		    Marca m = (Marca) jcb_marca.getItemAt(i);
		    if (m.getId() == p.getMarca().getId()) {
		        jcb_marca.setSelectedItem(m);
		    }
		}
	}
	
	
	/**
	 * 
	 */
	public void setValuesToRadios(Portatil p) {
		if(p.getNumProcesadores() == 1) {
			jrb_1p.setSelected(true);
		}
		else if(p.getNumProcesadores() == 2) {
			jrb_2p.setSelected(true);
		}
		else if(p.getNumProcesadores() == 3) {
			jrb_3p.setSelected(true);
		}
		else if(p.getNumProcesadores() == 4) {
			jrb_4p.setSelected(true);
		}
	}
	
	
	/**
	 * 
	 */
	public void openMarcaGestionWindow() {
		JDialog gestionPanel = new JDialog();
		gestionPanel.setResizable(true);
		gestionPanel.setTitle("Gestión de marcas");
		gestionPanel.setContentPane(new MarcaGestionPanel());
		gestionPanel.pack();
		gestionPanel.setModal(true);
		gestionPanel.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width)/2 - gestionPanel.getWidth()/2, 
				(Toolkit.getDefaultToolkit().getScreenSize().height)/2 - gestionPanel.getHeight()/2);
		gestionPanel.setVisible(true);
	}
	
	
	/**
	 * 
	 */
	public Portatil getPortatilActual() {
		Portatil p = new Portatil();
		p.setMarca((Marca) jcb_marca.getSelectedItem());
		p.setModelo(jtf_modelo.getText());
		p.setSn(jtf_serialNumber.getText());
		
		if(jrb_1p.isSelected()) {
			p.setNumProcesadores(1);
		}
		else if(jrb_2p.isSelected()) {
			p.setNumProcesadores(2);
		}
		else if(jrb_3p.isSelected()) {
			p.setNumProcesadores(3);
		}
		else if(jrb_4p.isSelected()) {
			p.setNumProcesadores(4);
		}
		
		if (jcb_vendido.isSelected()) {
			p.setVendido((byte) 1);
			p.setFechaVenta((jtf_fechaVenta.getText()));
		}
		
		return p;
	}
	
	
	/**
	 * 
	 */
	public void realizeInsert() {
		Portatil p = getPortatilActual();
		PortatilController.getInstance().realizeInsert(p);
	}
	
	
	/**
	 * 
	 */
	public void realizeUpdate() {
		Portatil p = getPortatilActual();
		p.setId(Integer.parseInt(jtf_Id.getText()));
		PortatilController.getInstance().realizeUpdate(p);
	}
	
	
	/**
	 * 
	 */
	public void realizeDelete() {
		Portatil p = getPortatilActual();
		p.setId(Integer.parseInt(jtf_Id.getText()));
		PortatilController.getInstance().realizeDelete(p);
		PcGestionPanel.getInstance().setAllPortatiles(
				PortatilController.getInstance().findAll()
		);
		PcGestionPanel.getInstance().setCounter(
				PcGestionPanel.getInstance().getCounter() - 1
		);		
		PcGestionPanel.getInstance().findResult();
	}
}
