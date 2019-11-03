package travel.gui;

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
public class FlightGui {
	ArrayList<FlightVO> flist = new ArrayList<FlightVO>();
	ArrayList<BookingVO> blist = new ArrayList<BookingVO>();
	ArrayList<BookingVO> bvo = new ArrayList<BookingVO>();
	

	int bookingidCol;
	int flightidCol;
	String fromcityCol; 
	String tocityCol; 
	String fromdateCol; 
	String todateCol;
	int priceCol;
	int custidCol;
	

	public FlightGui(JFrame j) {
		JPanel flightPanel = new JPanel();

		flightPage(flightPanel);
		j.add(flightPanel);

	}

//�װ��� ��ȸ�ϱ�
	// ��-�պ�(�ɼ�)
	// ����װ���

	public void flightPage(JPanel flightPanel) {

//*�Է�,��ư �����ϱ�*----------------------------------------------------------------------------------------
		// [�˻�] 4���� �˻� ����: ���(f/t)->��¥(f/t)->�˻�

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
		// [�װ�������] ��ȸ ȭ��

		// ���̺� - �˻��� �ֱ�
		JTable flightTable = new JTable(); // �˻� ��� ���̺�
		JPanel tablePanel = new JPanel(); // �˻� ��� �ǳ�

		// ���̺� ����� (�÷�)
		Vector<String> header = new Vector<String>();
		header.add("�װ���ȣ");
		header.add("��ߵ���");
		header.add("��������");
		header.add("���³�");
		header.add("���³�");
		header.add("����");

		// ���̺� ��
		DefaultTableModel model = new DefaultTableModel(header, 0);
		flightTable.setModel(model);

		// ���̺� ������
		FlightDAO fdao = new FlightDAO();
		flist = fdao.selectAll();

		setUpdateFlightTableData(flightTable);

		tablePanel.add(new JScrollPane(flightTable));

		flightPanel.add(tablePanel);
//*�Է�,��ư �����ϱ�*----------------------------------------------------------------------------------------
		// [����] �����ϱ�, ����Ȯ��, �������, �������

		JButton bookBt = new JButton("�����ϱ�");
		JButton checkBt = new JButton("����Ȯ��");
		JButton updateBt = new JButton("�������");
		JButton cancelgBt = new JButton("�������");

//*�Է�,��ư �����ϱ�*----------------------------------------------------------------------------------------
		// [���೻��] ��ȸȭ��

		// ���̺� - �˻��� �ֱ�
		JTable bookTable = new JTable(); // ���� ��� ���̺�
		JPanel bookTablePanel = new JPanel(); // ���� ��� �ǳ�

		// ���̺� ��
		DefaultTableModel bookModel = new DefaultTableModel(header, 0);
		bookTable.setModel(bookModel);

		// ���̺� ������
		BookingDAO bdao = new BookingDAO();
		blist = bdao.selectAll();

		setUpdateBookTableData(bookTable);
//      bookTable.setModel(model);

//*Panel Design*----------------------------------------------------------------------------------------
		// [Panel1] �˻� �ǳ�
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

		// [Panel2] �װ������� �ǳ�
		tablePanel.add(new JScrollPane(flightTable));

		// [Panel3] ���� �ǳ�
		JPanel bookPanel = new JPanel();
		bookPanel.add(bookBt);
		bookPanel.add(checkBt);
		bookPanel.add(updateBt);
		bookPanel.add(cancelgBt);

		// [Panel4] ���೻�� �ǳ�
		bookTablePanel.add(new JScrollPane(bookTable));

		// [��ü Panel]
		flightPanel.add(searchPanel1);
		flightPanel.add(searchPanel2);
		flightPanel.add(tablePanel);
		flightPanel.add(bookPanel);
		flightPanel.add(bookTablePanel);

		searchBt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				flist = fdao.selectSearch(fromcityText.getText(), tocityText.getText(), fromdateText.getText(),
						todateText.getText());
				setUpdateFlightTableData(bookTable);
			}
		});

		flightTable.addMouseListener(new MouseListener() {

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
			public void mouseClicked(MouseEvent e) {
				int updateRow1 = flightTable.getSelectedRow();
				
			
				
				flightidCol = (int) flightTable.getValueAt(updateRow1, 0);
				fromcityCol = (String) flightTable.getValueAt(updateRow1, 1);
				tocityCol = (String) flightTable.getValueAt(updateRow1, 2);
				fromdateCol = (String) flightTable.getValueAt(updateRow1, 3);
				todateCol = (String) flightTable.getValueAt(updateRow1, 4);
				priceCol = (int) flightTable.getValueAt(updateRow1, 5);				
				custidCol = LoginGui.custid;
				
				System.out.println(flightidCol+ " "+
						fromcityCol+ " "+
						tocityCol+ " "+
						fromdateCol+ " "+
						todateCol+ " "+
						priceCol+ " "+
						custidCol);
				
//				ArrayList<BookingVO> bvo = new ArrayList<BookingVO>();
//				
//				
//				
//				int updateRow2 = bookTable.getSelectedRow();
//				bookingidCol = (int) bookTable.getValueAt(updateRow2, 0);
				
//				String bookNameCol = (String)bookTable.getValueAt(updateRow, 1);
//				String publisherCol = (String)bookTable.getValueAt(updateRow, 2);
//				priceCol = (int) bookTable.getValueAt(updateRow, 3);

//				bookNameText.setText(bookNameCol);
//				publisherText.setText(publisherCol);
//				priceText.setText(String.valueOf(priceCol));

			}
		});
		
		

		bookBt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BookingVO bvo = new BookingVO();
//				bvo.setBookingid(bookingidCol);
				bvo.setFlightid(flightidCol);
				bvo.setFromcity(fromcityCol);
				bvo.setTocity(tocityCol);
				bvo.setFromdate(fromdateCol);
				bvo.setTodate(todateCol);
				bvo.setPrice(priceCol);
				bvo.setCustid(custidCol);
				System.out.println("1234");
				int result = bdao.insert2(bvo);
				
				if(result != 0) {
					JOptionPane.showMessageDialog(null,  "��� �Ϸ�!!","success", 
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "��� ����!!","error", 							JOptionPane.ERROR_MESSAGE);
				}
				blist = bdao.selectAll();
				setUpdateBookTableData(bookTable);
				
			}
		});
		
		bookTable.addMouseListener(new MouseListener() {

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
			public void mouseClicked(MouseEvent e) {
				int updateRow1 = flightTable.getSelectedRow();
				
			
			
				ArrayList<BookingVO> bvo = new ArrayList<BookingVO>();
				
				
				
				int updateRow2 = bookTable.getSelectedRow();
				bookingidCol = (int) bookTable.getValueAt(updateRow2, 0);
				
//				String bookNameCol = (String)bookTable.getValueAt(updateRow, 1);
//				String publisherCol = (String)bookTable.getValueAt(updateRow, 2);
//				priceCol = (int) bookTable.getValueAt(updateRow, 3);

//				bookNameText.setText(bookNameCol);
//				publisherText.setText(publisherCol);
//				priceText.setText(String.valueOf(priceCol));

			}
		});
		
		cancelgBt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int result = bdao.delete(bookingidCol);
				if (result != 0) {
					JOptionPane.showMessageDialog(null, "���� �Ϸ�!!", "success", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "���� ����!!", "error", JOptionPane.ERROR_MESSAGE);
				}
				blist = bdao.selectAll();
				setUpdateBookTableData(bookTable);

			}
		});

	}

	public void setUpdateFlightTableData(JTable flight) {
		DefaultTableModel model = (DefaultTableModel) flight.getModel();
		model.setRowCount(0);
		for (FlightVO vo : flist) {
			Vector body = new Vector();
			body.addElement(vo.getFlightid());
			body.addElement(vo.getFromcity());
			body.addElement(vo.getTocity());
			body.addElement(vo.getFromdate());
			body.addElement(vo.getTodate());
			body.addElement(vo.getPrice());

			model.addRow(body);
		}
		flight.setModel(model);
	}

	public void setUpdateBookTableData(JTable bookTable) {
		DefaultTableModel model = (DefaultTableModel) bookTable.getModel();
		model.setRowCount(0);
		for (BookingVO vo : blist) {
			Vector body = new Vector();
			body.addElement(vo.getFlightid());
			body.addElement(vo.getFromcity());
			body.addElement(vo.getTocity());
			body.addElement(vo.getFromdate());
			body.addElement(vo.getTodate());
			body.addElement(vo.getPrice());

			model.addRow(body);
		}
		bookTable.setModel(model);
	}

}

// �װ���(����)
// ������-����(����)
// �ҿ�ð���(����)

//�װ��� �����ϱ�

//���� Ȯ���ϱ�

//���� �����ϱ�

//���� ����ϱ�