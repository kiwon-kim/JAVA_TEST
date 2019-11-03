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

//main화면 설정
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



//항공권 조회하기
	//편도-왕복(옵션)
	//모든항공권
	public void flightFrame() {
		JPanel flightPanel = new JPanel();
		flightPage(flightPanel);
		this.add(flightPanel);
	}

	public void flightPage(JPanel flightPanel) {
		
//*입력,버튼 구성하기*----------------------------------------------------------------------------------------
		//[검색] 4가지 검색 조건: 장소(f/t)->날짜(f/t)->검색

		JLabel fromcityLa = new JLabel("출발도시");
		JTextField fromcityText = new JTextField(10);
		
		JLabel tocityLa = new JLabel("도착도시");
		JTextField tocityText = new JTextField(10);
		
		JLabel fromdateLa = new JLabel("가는날");
		JTextField fromdateText = new JTextField(10);
		
		JLabel todateLa = new JLabel("오는날");
		JTextField todateText = new JTextField(10);
		
		JButton searchBt = new JButton("검색");
		
//*입력,버튼 구성하기*----------------------------------------------------------------------------------------
		//[항공스케줄] 조회 화면
		
		// 테이블 - 검색값 넣기
		JTable flightTable = new JTable(); //검색 결과 테이블
		JPanel tablePanel = new JPanel();  //검색 결과 판넬
		
		// 테이블 헤더값 (컬럼)
		Vector<String> header = new Vector<String>();
		header.addElement("편명");
		header.addElement("출발도시");
		header.addElement("도착도시");
		header.addElement("가는날");
		header.addElement("오는날");

		// 테이블 모델
		DefaultTableModel model = new DefaultTableModel(header, 0);
		flightTable.setModel(model);

		// 테이블에 데이터
		FlightDAO fdao = new FlightDAO();
		flist = fdao.selectAll();
//		setUpdateTableData(flightTable);
		flightTable.setModel(model);

//*입력,버튼 구성하기*----------------------------------------------------------------------------------------
		//[예약] 예약하기, 예약확인, 예약수정, 예약취소
		
		JButton bookBt = new JButton("예약하기");
		JButton checkBt = new JButton("예약확인");
		JButton updateBt = new JButton("예약수정");
		JButton canclegBt = new JButton("예약취소");

//*입력,버튼 구성하기*----------------------------------------------------------------------------------------
		//[예약내역] 조회화면
		
		// 테이블 - 검색값 넣기
		JTable bookTable = new JTable(); //예약 결과 테이블
		JPanel bookTablePanel = new JPanel();  //예약 결과 판넬
		
		// 테이블 모델
		DefaultTableModel bookModel = new DefaultTableModel(header, 0);
		bookTable.setModel(bookModel);

		// 테이블에 데이터
		BookingDAO bdao = new BookingDAO();
		blist = bdao.selectAll();
//		setUpdateTableData(bookTable);
		bookTable.setModel(model);
		
		
		
//*Panel Design*----------------------------------------------------------------------------------------
		//[Panel1] 검색 판넬
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

		//[Panel2] 항공스케줄 판넬 
		tablePanel.add(new JScrollPane(flightTable));

		//[Panel3] 예약 판넬
		JPanel bookPanel = new JPanel();
		bookPanel.add(bookBt);
		bookPanel.add(checkBt);
		bookPanel.add(updateBt);
		bookPanel.add(canclegBt);
		
		
		//[Panel4] 예약내역 판넬
		bookTablePanel.add(bookTable);

		//[전체 Panel]
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
					JOptionPane.showMessageDialog(null, "등록완료!!", "success", 
												JOptionPane.INFORMATION_MESSAGE);
				} else { 
					JOptionPane.showMessageDialog(null, "등록실패!!", "error", 
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
					JOptionPane.showMessageDialog(null, "수정완료!!", "success", 
												JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "수정실패!!", "error", 
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
					JOptionPane.showMessageDialog(null, "수정완료!!", "success", 
												JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "수정실패!!", "error", 
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
					JOptionPane.showMessageDialog(null, "주문완료!!", "success", 
													JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "주문실패!!", "error",
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
		
		
	//항공사(필터)
	//저가순-고가순(정렬)
	//소요시간순(정렬)

//항공권 예매하기

//예매 확인하기

//예매 수정하기

//예매 취소하기
