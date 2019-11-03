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

//main화면 설정
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

//항공권 조회하기
	// 편도-왕복(옵션)
	// 모든항공권

	public void flightPage(JPanel flightPanel) {

//*입력,버튼 구성하기*----------------------------------------------------------------------------------------
		// [검색] 4가지 검색 조건: 장소(f/t)->날짜(f/t)->검색

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
		// [항공스케줄] 조회 화면

		// 테이블 - 검색값 넣기
		JTable flightTable = new JTable(); // 검색 결과 테이블
		JPanel tablePanel = new JPanel(); // 검색 결과 판넬

		// 테이블 헤더값 (컬럼)
		Vector<String> header = new Vector<String>();
		header.add("항공번호");
		header.add("출발도시");
		header.add("도착도시");
		header.add("가는날");
		header.add("오는날");
		header.add("가격");

		// 테이블 모델
		DefaultTableModel model = new DefaultTableModel(header, 0);
		flightTable.setModel(model);

		// 테이블에 데이터
		FlightDAO fdao = new FlightDAO();
		flist = fdao.selectAll();

		setUpdateFlightTableData(flightTable);

		tablePanel.add(new JScrollPane(flightTable));

		flightPanel.add(tablePanel);
//*입력,버튼 구성하기*----------------------------------------------------------------------------------------
		// [예약] 예약하기, 예약확인, 예약수정, 예약취소

		JButton bookBt = new JButton("예약하기");
		JButton checkBt = new JButton("예약확인");
		JButton updateBt = new JButton("예약수정");
		JButton cancelgBt = new JButton("예약취소");

//*입력,버튼 구성하기*----------------------------------------------------------------------------------------
		// [예약내역] 조회화면

		// 테이블 - 검색값 넣기
		JTable bookTable = new JTable(); // 예약 결과 테이블
		JPanel bookTablePanel = new JPanel(); // 예약 결과 판넬

		// 테이블 모델
		DefaultTableModel bookModel = new DefaultTableModel(header, 0);
		bookTable.setModel(bookModel);

		// 테이블에 데이터
		BookingDAO bdao = new BookingDAO();
		blist = bdao.selectAll();

		setUpdateBookTableData(bookTable);
//      bookTable.setModel(model);

//*Panel Design*----------------------------------------------------------------------------------------
		// [Panel1] 검색 판넬
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

		// [Panel2] 항공스케줄 판넬
		tablePanel.add(new JScrollPane(flightTable));

		// [Panel3] 예약 판넬
		JPanel bookPanel = new JPanel();
		bookPanel.add(bookBt);
		bookPanel.add(checkBt);
		bookPanel.add(updateBt);
		bookPanel.add(cancelgBt);

		// [Panel4] 예약내역 판넬
		bookTablePanel.add(new JScrollPane(bookTable));

		// [전체 Panel]
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
					JOptionPane.showMessageDialog(null,  "등록 완료!!","success", 
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "등록 실패!!","error", 							JOptionPane.ERROR_MESSAGE);
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
					JOptionPane.showMessageDialog(null, "삭제 완료!!", "success", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "삭제 실패!!", "error", JOptionPane.ERROR_MESSAGE);
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

// 항공사(필터)
// 저가순-고가순(정렬)
// 소요시간순(정렬)

//항공권 예매하기

//예매 확인하기

//예매 수정하기

//예매 취소하기