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
import travel.vo.FlightVO;



public class BookingGui {
	ArrayList<FlightVO> blist;
	int bookidCol;
	int priceCol;

	public BookingGui(JFrame j) {// 2s
		JPanel bookPanel = new JPanel();
		bookPage(bookPanel);
		j.add(bookPanel);

	} // 2e

	public void bookPage(JPanel bookPanel) {// 3s
		// �˻�
		JLabel searchLa = new JLabel("�װ��� �˻�");
		JTextField searchText = new JTextField(30);
		JButton searchBt = new JButton("�˻�");
		// ���, ����, ����
		JLabel bookNameLa = new JLabel("�װ��� �̸�");
		JTextField bookNameText = new JTextField(30);

		JLabel publisherLa = new JLabel("���ǻ�");
		JTextField publisherText = new JTextField(30);

		JLabel priceLa = new JLabel("����");
		JTextField priceText = new JTextField(40);

		JButton insertBt = new JButton("���");
		JButton updateBt = new JButton("����");
		JButton deleteBt = new JButton("����");
		JButton orderBt = new JButton("�ֹ�");

		// ���̺� - �˻����� ����
		JTable bookTable = new JTable();
		JPanel tablePanel = new JPanel();

		// ���̺� ����� (�÷�)
		Vector<String> header = new Vector<String>();
		header.addElement("��ȣ");
		header.addElement("å�̸�");
		header.addElement("���ǻ�");
		header.addElement("����");

		// ���̺� ��

		DefaultTableModel model = new DefaultTableModel(header, 0);
		bookTable.setModel(model);

		// ���̺� ������
		FlightDAO bdao = new FlightDAO();
		BookingDAO odao = new BookingDAO();
		blist = bdao.selectAll();
		setUpdateTableData(bookTable);
		bookTable.setModel(model);

		tablePanel.add(new JScrollPane(bookTable));

		bookPanel.add(searchLa);
		bookPanel.add(searchText);
		bookPanel.add(searchBt);
		bookPanel.add(tablePanel);
		bookPanel.add(orderBt);

		JPanel bookNamePanel = new JPanel();
		bookNamePanel.add(bookNameLa);
		bookNamePanel.add(bookNameText);
		bookPanel.add(bookNamePanel);

		JPanel publisherPanel = new JPanel();
		publisherPanel.add(publisherLa);
		publisherPanel.add(publisherText);
		bookPanel.add(publisherPanel);

		JPanel pricePanel = new JPanel();
		pricePanel.add(priceLa);
		pricePanel.add(priceText);
		bookPanel.add(pricePanel);

		JPanel insertBtPanel = new JPanel();
		insertBtPanel.add(insertBt);
		bookPanel.add(insertBtPanel);

		JPanel updateBtPanel = new JPanel();
		updateBtPanel.add(updateBt);
		bookPanel.add(updateBtPanel);

		JPanel deleteBtPanel = new JPanel();
		deleteBtPanel.add(deleteBt);
		bookPanel.add(deleteBtPanel);

		searchBt.addActionListener(new ActionListener() {// 4s

			@Override
			public void actionPerformed(ActionEvent e) {// 5s
				System.out.println(searchText.getText());
				blist = bdao.selectSearch(searchText.getText());
				setUpdateTableData(bookTable);
			}// 5e
		});// 4e

		insertBt.addActionListener(new ActionListener() {// 6s

			@Override
			public void actionPerformed(ActionEvent e) {// 7s
				System.out.println(bookNameText.getText() + " " + publisherText.getText() + " " + priceText.getText());
				FlightVO bvo = new FlightVO();
				bvo.setFlightid(bookNameText.getInt());
				bvo.setTocity(toCityText.getString());
				bvo.setPrice(Integer.parseInt(priceText.getText()));
				int result = bdao.insert(bvo);
				if (result != 0) {// 8s
					JOptionPane.showMessageDialog(null, "��ϿϷ�!!", "success", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "��Ͻ���!!", "error", JOptionPane.ERROR_MESSAGE);
				} // 8e
				blist = bdao.selectAll();
				setUpdateTableData(bookTable);
			}// 7e
		});// 6e

		bookTable.addMouseListener(new MouseListener() {// 9s

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
			public void mouseClicked(MouseEvent e) {// 10s
				int updateRow = bookTable.getSelectedRow();
				bookidCol = (int) bookTable.getValueAt(updateRow, 0);
				String booknameCol = (String) bookTable.getValueAt(updateRow, 1);
				String publisherCol = (String) bookTable.getValueAt(updateRow, 2);
				priceCol = (int) bookTable.getValueAt(updateRow, 3);

				bookNameText.setText(booknameCol);
				publisherText.setText(publisherCol);
				priceText.setText(String.valueOf(priceCol));
//				System.out.println(updateRow);
			}// 10e
		});// 9e

		updateBt.addActionListener(new ActionListener() {// 11s

			@Override
			public void actionPerformed(ActionEvent e) {// 12s
				BookVO bvo = new BookVO();
				bvo.setBookid(bookidCol);
				bvo.setBookname(bookNameText.getText());
				bvo.setPublisher(publisherText.getText());
				bvo.setPrice(Integer.parseInt(priceText.getText()));
				int result = bdao.update(bvo);
				if (result != 0) {// 13s
					JOptionPane.showMessageDialog(null, "�����Ϸ�!!", "success", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "��������!!", "error", JOptionPane.ERROR_MESSAGE);
				} // 13e
				blist = bdao.selectAll();
				setUpdateTableData(bookTable);

			}// 12e
		});// 11e

		deleteBt.addActionListener(new ActionListener() {// 14s

			@Override
			public void actionPerformed(ActionEvent e) {// 15s
				int result = bdao.delete(bookidCol);
				if (result != 0) {// 16s
					JOptionPane.showMessageDialog(null, "�����Ϸ�!!", "success", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "��������!!", "error", JOptionPane.ERROR_MESSAGE);
				} // 16e
				blist = bdao.selectAll();
				setUpdateTableData(bookTable);

			}// 15e
		});// 14e

		orderBt.addActionListener(new ActionListener() {// 17s

			@Override
			public void actionPerformed(ActionEvent e) {// 18s
				OrdersVO ovo = new OrdersVO();
				ovo.setBookid(bookidCol); // ****
				ovo.setSaleprice(priceCol);
				ovo.setCustid(1);
				int result = bdao.delete(bookidCol);
				if (result != 0) {// 19s
					JOptionPane.showMessageDialog(null, "�ֹ��Ϸ�!!", "success", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "�ֹ�����!!", "error", JOptionPane.ERROR_MESSAGE);
				} // 19e
				blist = bdao.selectAll();
				setUpdateTableData(bookTable);

			}// 18e
		});// 17e
	}// 3e

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
}// 1e
