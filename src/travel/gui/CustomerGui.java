package travel.gui;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CustomerGui {
	private JPanel customerPanel;

	public JPanel getCustomerPanel() {
		return customerPanel;
	}

	public void setCustomerPanel(JPanel customerPanel) {
		this.customerPanel = customerPanel;
	}

	public CustomerGui() {
		customerPanel = new JPanel();
		CustomerPage();
	}

	public void CustomerPage() {
		JLabel la = new JLabel("Ãâ·Â");
		customerPanel.add(la);
	}
}
