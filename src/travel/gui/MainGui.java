package travel.gui;

import javax.swing.JFrame;

public class MainGui extends JFrame {
	
	public MainGui() {
	FlightGui flightgui = new FlightGui(this);
	
	this.setTitle("Enjoy Travel!!");
	this.setSize(520, 800);
	this.setVisible(true);

	}
}




/*package travel.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import travel.dao.BookingDAO;
import travel.dao.FlightDAO;
import travel.vo.BookingVO;
import travel.vo.FlightVO;

//mainȭ�� ����
public class MainGui extends JFrame{
	ArrayList<FlightVO> flist;
	ArrayList<BookingVO> blist;
	int flightidCol;
	int priceCol;

	public MainGui() {
		flightFrame();
		this.setTitle("ENJOY yourTRAVEL");
		this.setSize(520,770);
		this.setVisible(true);
	}



//�װ��� ��ȸ�ϱ�
	//��-�պ�(�ɼ�)
	//����װ���
	public void flightFrame() {
		JPanel flightPanel = new JPanel();
		flightPage(flightPanel);
		this.add(flightPanel);
	}

	public void flightPage(JPanel flightPanel) {
		
//*�Է�,��ư �����ϱ�*----------------------------------------------------------------------------------------
		//[�˻�] 4���� �˻� ����: ���(f/t)->��¥(f/t)->�˻�

		JLabel fromcityLa = new JLabel("��ߵ���");
		JTextField fromcityText = new JTextField(10);
		
		JLabel tocityLa = new JLabel("��������");
		JTextField tocityText = new JTextField(10);
		
		JLabel fromdateLa = new JLabel("���³�");
		JTextField fromdateText = new JTextField(10);
		
		JLabel todateLa = new JLabel("���³�");
		JTextField todateText = new JTextField(10);
		
		JButton searchBt = new JButton("�˻�");
		
//*�Է�,��ư �����ϱ�*----------------------------------------------------------------------------------------
		//[�װ�������] ��ȸ ȭ��
		
		// ���̺� - �˻��� �ֱ�
		JTable flightTable = new JTable(); //�˻� ��� ���̺�
		JPanel tablePanel = new JPanel();  //�˻� ��� �ǳ�
		
		// ���̺� ����� (�÷�)
		Vector<String> header = new Vector<String>();
		header.addElement("���");
		header.addElement("��ߵ���");
		header.addElement("��������");
		header.addElement("���³�");
		header.addElement("���³�");

		// ���̺� ��
		DefaultTableModel model = new DefaultTableModel(header, 0);
		flightTable.setModel(model);

		// ���̺� ������
		FlightDAO fdao = new FlightDAO();
		flist = fdao.selectAll();
//		setUpdateTableData(flightTable);
		flightTable.setModel(model);

//*�Է�,��ư �����ϱ�*----------------------------------------------------------------------------------------
		//[����] �����ϱ�, ����Ȯ��, �������, �������
		
		JButton bookBt = new JButton("�����ϱ�");
		JButton checkBt = new JButton("����Ȯ��");
		JButton updateBt = new JButton("�������");
		JButton canclegBt = new JButton("�������");

//*�Է�,��ư �����ϱ�*----------------------------------------------------------------------------------------
		//[���೻��] ��ȸȭ��
		
		// ���̺� - �˻��� �ֱ�
		JTable bookTable = new JTable(); //���� ��� ���̺�
		JPanel bookTablePanel = new JPanel();  //���� ��� �ǳ�
		
		// ���̺� ��
		DefaultTableModel bookModel = new DefaultTableModel(header, 0);
		bookTable.setModel(bookModel);

		// ���̺� ������
		BookingDAO bdao = new BookingDAO();
		blist = bdao.selectAll();
//		setUpdateTableData(bookTable);
		bookTable.setModel(model);
		
		
		
//*Panel Design*----------------------------------------------------------------------------------------
		//[Panel1] �˻� �ǳ�
		JPanel searchPanel1 = new JPanel();
		JPanel searchPanel2 = new JPanel();
		
		searchPanel1.add(fromcityLa);
		searchPanel1.add(fromcityText);
		searchPanel1.add(tocityLa);
		searchPanel1.add(tocityText);
		searchPanel2.add(fromdateLa);
		searchPanel2.add(fromdateText);
		searchPanel2.add(todateLa);
		searchPanel2.add(todateText);
		searchPanel2.add(searchBt);

		//[Panel2] �װ������� �ǳ� 
		tablePanel.add(new JScrollPane(flightTable));

		//[Panel3] ���� �ǳ�
		JPanel bookPanel = new JPanel();
		bookPanel.add(bookBt);
		bookPanel.add(checkBt);
		bookPanel.add(updateBt);
		bookPanel.add(canclegBt);
		
		
		//[Panel4] ���೻�� �ǳ�
		bookTablePanel.add(bookTable);

		//[��ü Panel]
		flightPanel.add(searchPanel1);
		flightPanel.add(searchPanel2);
		flightPanel.add(tablePanel);
		flightPanel.add(bookPanel);
		flightPanel.add(bookTablePanel);
*/		
		
/*		searchBt.addActionListener(new ActionListener() {//4s

			@Override
			public void actionPerformed(ActionEvent e) {//5s
				System.out.println(searchText.getText());
				blist = fdao.selectSearch(searchText.getText());
				setUpdateTableData(bookTable);
			}//5e
		});//4e

		insertBt.addActionListener(new ActionListener() {//6s

			@Override
			public void actionPerformed(ActionEvent e) {//7s
				System.out.println(bookNameText.getText() + " " 
									+ publisherText.getText() + " " 
									+ priceText.getText());
				BookVO bvo = new BookVO();
				bvo.setBookname(bookNameText.getText());
				bvo.setPublisher(publisherText.getText());
				bvo.setPrice(Integer.parseInt(priceText.getText()));
				int result = fdao.insert(bvo);
				if (result != 0) {//8s
					JOptionPane.showMessageDialog(null, "��ϿϷ�!!", "success", 
												JOptionPane.INFORMATION_MESSAGE);
				} else { 
					JOptionPane.showMessageDialog(null, "��Ͻ���!!", "error", 
												JOptionPane.ERROR_MESSAGE);
				}//8e
				blist = fdao.selectAll();
				setUpdateTableData(bookTable);
			}//7e
		});//6e

		bookTable.addMouseListener(new MouseListener() {//9s

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {//10s
				int updateRow = bookTable.getSelectedRow();
				bookidCol = (int) bookTable.getValueAt(updateRow, 0);
				String booknameCol = (String) bookTable.getValueAt(updateRow, 1);
				String publisherCol = (String) bookTable.getValueAt(updateRow, 2);
				priceCol = (int) bookTable.getValueAt(updateRow, 3);

				bookNameText.setText(booknameCol);
				publisherText.setText(publisherCol);
				priceText.setText(String.valueOf(priceCol));
//						System.out.println(updateRow);
			}//10e
		});//9e

		updateBt.addActionListener(new ActionListener() {//11s

			@Override
			public void actionPerformed(ActionEvent e) {//12s
				BookVO bvo = new BookVO();
				bvo.setBookid(bookidCol);
				bvo.setBookname(bookNameText.getText());
				bvo.setPublisher(publisherText.getText());
				bvo.setPrice(Integer.parseInt(priceText.getText()));
				int result = fdao.update(bvo);
				if (result != 0) {//13s
					JOptionPane.showMessageDialog(null, "�����Ϸ�!!", "success", 
												JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "��������!!", "error", 
												JOptionPane.ERROR_MESSAGE);
				}//13e
				blist = fdao.selectAll();
				setUpdateTableData(bookTable);

			}//12e
		});//11e

		deleteBt.addActionListener(new ActionListener() {//14s

			@Override
			public void actionPerformed(ActionEvent e) {//15s
				int result = fdao.delete(bookidCol);
				if (result != 0) {//16s
					JOptionPane.showMessageDialog(null, "�����Ϸ�!!", "success", 
												JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "��������!!", "error", 
												JOptionPane.ERROR_MESSAGE);
				}//16e
				blist = fdao.selectAll();
				setUpdateTableData(bookTable);

			}//15e
		});//14e

		orderBt.addActionListener(new ActionListener() {//17s
			
			@Override
			public void actionPerformed(ActionEvent e) {//18s
				OrdersVO ovo = new OrdersVO();
				ovo.setBookid(bookidCol); //****
				ovo.setSaleprice(priceCol);
				ovo.setCustid(1);
				int result = fdao.delete(bookidCol);
				if (result != 0) {//19s
					JOptionPane.showMessageDialog(null, "�ֹ��Ϸ�!!", "success", 
													JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "�ֹ�����!!", "error",
													JOptionPane.ERROR_MESSAGE);
				}//19e
				blist = fdao.selectAll();
				setUpdateTableData(bookTable);
				
			}//18e
		});//17e
	}//3e
	
	public void setUpdateTableData(JTable bookTable) {// 20s
		DefaultTableModel model = (DefaultTableModel) (bookTable.getModel());
		model.setRowCount(0);
		for (BookVO vo : blist) {// 21s
			Vector body = new Vector();
			body.addElement(vo.getBookid());
			body.addElement(vo.getBookname());
			body.addElement(vo.getPublisher());
			body.addElement(vo.getPrice());
			model.addRow(body);
		} // 21e
		bookTable.setModel(model);

	
	}// 20e
}

*/	
		
		
	//�װ���(����)
	//������-����(����)
	//�ҿ�ð���(����)

//�װ��� �����ϱ�

//���� Ȯ���ϱ�

//���� �����ϱ�

//���� ����ϱ�
