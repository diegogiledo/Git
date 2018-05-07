package Vista;

import javax.swing.table.DefaultTableModel;

public class ModeloTabla extends DefaultTableModel {

	private static final long serialVersionUID = -190728332166083634L;

	public ModeloTabla(Object[][] data, Object[] columnNames) {
		super(data, columnNames);
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}

}
