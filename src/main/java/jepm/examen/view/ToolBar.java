package jepm.examen.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import jepm.examen.controller.PortatilController;



public class ToolBar extends JToolBar {
	
	private static ToolBar instance = null;
	private JButton btn_firstResult ;
	private JButton btn_beforeResult ;
	private JButton btn_nextResult ;
	private JButton btn_finalresult ;
	private JButton btn_insert ;
	private JButton btn_update ; 
	private JButton btn_delete;

	
	/**
	 * 
	 * @return
	 */
	public static ToolBar getInstance() {
		if (instance == null) {
			instance = new ToolBar();
		}
		return instance;
	}

	public ToolBar () {
		btn_firstResult = new JButton("<<");
		btn_firstResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkCounter();
				if (PcGestionPanel.getInstance().getCounter() > 1) {
				PcGestionPanel.getInstance().setCounter(1);
				PcGestionPanel.getInstance().findResult();	
				checkCounter();
				}
			}
		});
		btn_firstResult.setEnabled(false);
		this.add(btn_firstResult);
		
		btn_beforeResult = new JButton("<");
		btn_beforeResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkCounter();
				if (PcGestionPanel.getInstance().getCounter() > 1) {
				PcGestionPanel.getInstance().setCounter(
						PcGestionPanel.getInstance().getCounter() - 1
						);
				PcGestionPanel.getInstance().findResult();		
				checkCounter();
				}

			}
		});
		btn_beforeResult.setEnabled(false);
		this.add(btn_beforeResult);
		
		btn_nextResult = new JButton(">");
		btn_nextResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkCounter();
				if (PcGestionPanel.getInstance().getCounter() < PcGestionPanel.getInstance().getAllPortatiles().size() - 1) {
				PcGestionPanel.getInstance().setCounter(PcGestionPanel.getInstance().getCounter() + 1);
				PcGestionPanel.getInstance().findResult();
				checkCounter();
				}

			}
		});
		this.add(btn_nextResult);

		btn_finalresult = new JButton(">>");
		btn_finalresult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkCounter();
				if (PcGestionPanel.getInstance().getCounter() < PcGestionPanel.getInstance().getAllPortatiles().size() - 1) {
					PcGestionPanel.getInstance().setCounter(PortatilController.getInstance().findAll().size() - 1);
					PcGestionPanel.getInstance().findResult();
					checkCounter();
				}
			}
		});
		this.add(btn_finalresult);

		btn_insert = new JButton("Nuevo");
		btn_insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PcGestionPanel.getInstance().realizeInsert();
			}
		});
		this.add(btn_insert);

		btn_update = new JButton("Guardar");
		btn_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PcGestionPanel.getInstance().realizeUpdate();
			}
		});
		this.add(btn_update);

		btn_delete = new JButton("Eliminar");
		btn_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PcGestionPanel.getInstance().realizeDelete();
			}
		});
		this.add(btn_delete);

	}
	
	
	/**
	 * 
	 */
	public void checkCounter() {
		//Descenso
		if(PcGestionPanel.getInstance().getCounter() == 1) {
			btn_firstResult.setEnabled(false);
			btn_beforeResult.setEnabled(false);
		}
		else {
			btn_firstResult.setEnabled(true);
			btn_beforeResult.setEnabled(true);
		}
		//Incremento
		if(PcGestionPanel.getInstance().getCounter() == PcGestionPanel.getInstance().getAllPortatiles().size() - 1) {
			btn_nextResult.setEnabled(false);
			btn_finalresult.setEnabled(false);
		}
		else {
			btn_nextResult.setEnabled(true);
			btn_finalresult.setEnabled(true);
		}
	}

	


}
