package jepm.examen.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.util.List;

import javax.swing.JTextField;

import jepm.examen.controller.ContinenteController;
import jepm.examen.controller.MarcaController;
import jepm.examen.controller.PaisController;
import jepm.examen.model.Continente;
import jepm.examen.model.Marca;
import jepm.examen.model.Pais;
import jepm.examen.model.Portatil;


import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MarcaGestionPanel extends JPanel {
	
	private static MarcaGestionPanel instance = null;

	private JTextField jtf_id;
	private JTextField jtf_denominacion;
	private JComboBox jcb_Continente;
	private JComboBox jcb_Pais; 
	
	/**
	 * 
	 * @return
	 */
	public static MarcaGestionPanel getInstance() {
		if (instance == null) {
			instance = new MarcaGestionPanel();
		}
		return instance;
	}

	/**
	 * Create the panel.
	 */
	public MarcaGestionPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Gestión de Marcas");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
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
		
		jtf_id = new JTextField();
		jtf_id.setEditable(false);
		GridBagConstraints gbc_jtf_id = new GridBagConstraints();
		gbc_jtf_id.insets = new Insets(0, 0, 5, 0);
		gbc_jtf_id.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtf_id.gridx = 1;
		gbc_jtf_id.gridy = 1;
		add(jtf_id, gbc_jtf_id);
		jtf_id.setColumns(10);
		
		JLabel lblDenominacin = new JLabel("Denominación:");
		lblDenominacin.setFont(new Font("Tahoma", Font.BOLD, 10));
		GridBagConstraints gbc_lblDenominacin = new GridBagConstraints();
		gbc_lblDenominacin.anchor = GridBagConstraints.EAST;
		gbc_lblDenominacin.insets = new Insets(0, 0, 5, 5);
		gbc_lblDenominacin.gridx = 0;
		gbc_lblDenominacin.gridy = 2;
		add(lblDenominacin, gbc_lblDenominacin);
		
		jtf_denominacion = new JTextField();
		jtf_denominacion.setColumns(10);
		GridBagConstraints gbc_jtf_denominacion = new GridBagConstraints();
		gbc_jtf_denominacion.insets = new Insets(0, 0, 5, 0);
		gbc_jtf_denominacion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtf_denominacion.gridx = 1;
		gbc_jtf_denominacion.gridy = 2;
		add(jtf_denominacion, gbc_jtf_denominacion);
		
		JLabel lblContinente = new JLabel("Continente:");
		lblContinente.setFont(new Font("Tahoma", Font.BOLD, 10));
		GridBagConstraints gbc_lblContinente = new GridBagConstraints();
		gbc_lblContinente.anchor = GridBagConstraints.EAST;
		gbc_lblContinente.insets = new Insets(0, 0, 5, 5);
		gbc_lblContinente.gridx = 0;
		gbc_lblContinente.gridy = 3;
		add(lblContinente, gbc_lblContinente);
		
		jcb_Continente = new JComboBox();
		jcb_Continente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addValuesToPaisCombo();
			}
		});
		GridBagConstraints gbc_jcb_Continente = new GridBagConstraints();
		gbc_jcb_Continente.insets = new Insets(0, 0, 5, 0);
		gbc_jcb_Continente.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcb_Continente.gridx = 1;
		gbc_jcb_Continente.gridy = 3;
		add(jcb_Continente, gbc_jcb_Continente);
		
		JLabel lblPas = new JLabel("País:");
		lblPas.setFont(new Font("Tahoma", Font.BOLD, 10));
		GridBagConstraints gbc_lblPas = new GridBagConstraints();
		gbc_lblPas.anchor = GridBagConstraints.EAST;
		gbc_lblPas.insets = new Insets(0, 0, 5, 5);
		gbc_lblPas.gridx = 0;
		gbc_lblPas.gridy = 4;
		add(lblPas, gbc_lblPas);
		
		jcb_Pais = new JComboBox();
		GridBagConstraints gbc_jcb_Pais = new GridBagConstraints();
		gbc_jcb_Pais.insets = new Insets(0, 0, 5, 0);
		gbc_jcb_Pais.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcb_Pais.gridx = 1;
		gbc_jcb_Pais.gridy = 4;
		add(jcb_Pais, gbc_jcb_Pais);
		
		JButton btn_updateMarcas = new JButton("Guardar");
		btn_updateMarcas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jtf_denominacion.getText().length() >= 2) {
					realizeUpdate();
					PcGestionPanel.getInstance().chargeMarcaIntoMarcaCombo();
				}
				else {
					JOptionPane.showMessageDialog(null, "La denominacion debe contener al menos dos dígitos");
				}
			}
		});
		GridBagConstraints gbc_btn_updateMarcas = new GridBagConstraints();
		gbc_btn_updateMarcas.gridwidth = 2;
		gbc_btn_updateMarcas.gridx = 0;
		gbc_btn_updateMarcas.gridy = 5;
		add(btn_updateMarcas, gbc_btn_updateMarcas);
		setPanelValues();
	}
	
	
	/**
	 * 
	 */
	private void setPanelValues() {
		chargeValuesToContinenteCombo();
		Marca marca = (Marca) PcGestionPanel.getInstance().getJcb_marca().getSelectedItem();
		jtf_id.setText(marca.getId() + "");
		jtf_denominacion.setText(marca.getDenominacion());
		setDefaultValuesToCombo(marca);
		
	}
	
	
	/**
	 * 
	 */
	private void chargeValuesToContinenteCombo() {
		List<Continente> continentes = ContinenteController.getInstance().findAll();
		
		for (Continente continente : continentes) {
			jcb_Continente.addItem(continente);
		}
	}
	
	
	/**
	 * 
	 */
	private void addValuesToPaisCombo() {
		jcb_Pais.removeAllItems();
		Continente c = (Continente) jcb_Continente.getSelectedItem();
		List<Pais> paises = PaisController.getInstance().findbyId(c.getId());
		
		for (Pais pais : paises) {
			jcb_Pais.addItem(pais);
		}
	}
	
	
	/*
	 * 
	 */
	private void realizeUpdate() {
		Marca updtMarca = new Marca();
		
		updtMarca.setId(Integer.parseInt(jtf_id.getText()));
		updtMarca.setDenominacion(jtf_denominacion.getText());
		updtMarca.setPai((Pais) jcb_Pais.getSelectedItem());
		
		MarcaController.getInstance().realizeUpdate(updtMarca);
	}
	
	
	/**
	 * 
	 */
	public void setDefaultValuesToCombo(Marca m) {
		for (int i = 0; i < jcb_Continente.getItemCount(); i++) {
		    Continente continente = (Continente) jcb_Continente.getItemAt(i);
		    if (continente.getId() == m.getPai().getContinente().getId()) {
		        jcb_Continente.setSelectedItem(continente);
		        break;
		    }
		}
		
		for (int i = 0; i < jcb_Pais.getItemCount(); i++) {
		    Pais pais = (Pais) jcb_Pais.getItemAt(i);
		    if (pais.getId() == m.getPai().getId()) {
		        jcb_Pais.setSelectedItem(pais);
		        break;
		    }
		}
	}
}
