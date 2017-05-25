

public class Dumper {

	private String TIMESTAMPA;
	private String NAME;
	private int CONNECTION_ID;
	private String USER;
	private String HOST;
	private String IP;
	private String COMMAND_CLASS;
	private String SQLTEXT;
	public Dumper(){
		
	}
	
	public Dumper(String TIMESTAMPA,String NAME, int CONNECTION_ID,String USER,String HOST,String IP,String COMMAND_CLASS,String SQLTEXT) {
		this.TIMESTAMPA = TIMESTAMPA;
		this.NAME = NAME;
		this.CONNECTION_ID  = CONNECTION_ID;
		this.USER = USER;
		this.HOST = HOST;
		this.IP = IP;
		this.COMMAND_CLASS = COMMAND_CLASS;
		this.SQLTEXT = SQLTEXT;
		
	}
	
	public String getTIMESTAMPA() {
		return TIMESTAMPA;
	}

	public String getNAME () {
		return NAME;
	}
	
	public int getCONNECTION_ID() {
		return CONNECTION_ID;
	}

	public String getUSER () {
		return USER;
	}
	public String getHOST () {
		return HOST;
	}
	public String getIP () {
		return IP;
	}
	public String getCOMMAND_CLASS () {
		return COMMAND_CLASS;
	}
	public String getSQLTEXT () {
		return COMMAND_CLASS;
	}
	
	public String toString() 
	{   
		StringBuffer sb = new StringBuffer();
		sb.append("Log Details - \n ");
		sb.append("TIMESTAMP:" + getTIMESTAMPA());
		sb.append(",  ");
		sb.append("NAME:" + getNAME());
		sb.append(",  ");
		sb.append("CONNECTION_ID:" + getCONNECTION_ID());
		sb.append(",\n ");
		sb.append("USER:" + getUSER());
		sb.append(",  ");
		sb.append("HOST:" + getHOST());
		sb.append(",  ");
		sb.append("IP:" + getIP());
		sb.append(",  ");
		sb.append("COMMAND_CLASS:" + getCOMMAND_CLASS());
		sb.append(",  ");
		sb.append("SQLTEXT:" + getSQLTEXT());
		sb.append(",\n");
		return sb.toString();
	}
	
}
