package jepm.examen;

import jepm.examen.controller.PortatilController;
import jepm.examen.model.Portatil;
import jepm.examen.view.MainWindow;

public class Main {

	public static void main(String[] args) {
		PortatilController.getInstance().findAll();
		MainWindow.main(args);
	}

}
