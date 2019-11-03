package travel.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import travel.dao.CustomerDAO;

public class LoginGui extends JFrame{
	public static int custid = 0;
	public LoginGui() {

		JPanel loginPanel = new JPanel();
		loginPage(loginPanel);
		
		this.add(loginPanel);
		this.setTitle("Login");
		this.setSize(500,80);
		this.setVisible(true);
	}
	
	
	public void loginPage(JPanel loginPanel) {
		JLabel idLa = new JLabel("ID");
		JTextField idText = new JTextField(10);
		
		JLabel pwdLa = new JLabel("PWD");
		JPasswordField pwdText = new JPasswordField(10);
		
		JButton loginBt = new JButton("login");
		
		idLa.setBounds(10, 10 , 50, 50);
		
		loginPanel.add(idLa);
		loginPanel.add(idText);
		loginPanel.add(pwdLa);
		loginPanel.add(pwdText);
		loginPanel.add(loginBt);
		
		CustomerDAO cdao = new CustomerDAO();
		
		loginBt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				custid = Integer.parseInt(idText.getText());
				String pwd = pwdText.getText();
				
				int resultCustid = cdao.login(custid, pwd);
				if(resultCustid == 0) {
					JOptionPane.showMessageDialog(null, "로그인 실패!!","error", 
							JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null,  "로그인 완료!!","success", 
							JOptionPane.INFORMATION_MESSAGE);
					MainGui mainGui = new MainGui();
					setVisible(false);
				}
			}
		});
	}
}
