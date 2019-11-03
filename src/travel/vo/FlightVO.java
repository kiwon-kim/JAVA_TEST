package travel.vo;

public class FlightVO {
	/*
	 * flightid number, fromcity varchar2(20), tocity varchar2(50), fromdate
	 * varchar2(50), todate varchar2(50), price number, CONSTRAINT
	 * flight_flightid_pk primary key(flightid)
	 */
    private int flightid;
    private String fromcity;
    private String tocity;
    private String fromdate;
    private String todate;
    private int price;
    
    


	public int getFlightid() {
		return flightid;
	}
	public void setFlightid(int flightid) {
		this.flightid = flightid;
	}
	public String getFromcity() {
		return fromcity;
	}
	public void setFromcity(String fromcity) {
		this.fromcity = fromcity;
	}
	public String getTocity() {
		return tocity;
	}
	public void setTocity(String tocity) {
		this.tocity = tocity;
	}

	public String getFromdate() {
		return fromdate;
	}
	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}
	public String getTodate() {
		return todate;
	}
	public void setTodate(String todate) {
		this.todate = todate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

    
}
