

public class Auditor {

	private String TIMESTAMPA;
	private String NAME;
	private int CONNECTION_ID;
	private String USER;
	private String HOST;
	private String IP;
	private String COMMAND_CLASS;
	private String SQLTEXT;
	public Auditor(){
		
	}
	
	public Auditor(String TIMESTAMPA,String NAME, int CONNECTION_ID,String USER,String HOST,String IP,String COMMAND_CLASS,String SQLTEXT) {
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
		String time,name,user,host,ip,comm,sql;
		int connid;
		time=getTIMESTAMPA();
		name=getNAME();
		user=getUSER();
		host=getHOST();
		ip=getIP();
		comm=getCOMMAND_CLASS();
		sql=getSQLTEXT();
		connid=getCONNECTION_ID();
		if(user.equals("root"))
		{	
			if (comm.equals("create_db"))
			{	System.out.println(user);
				System.out.println("[Info] Root user created a new Database @ " +time+"\n");
			}
			
			
		}
		else if(user.equals("user"))
		{	
			if (comm.equals("create_db"))
			{	System.out.println(user);
				System.out.println("[Alert] User not authorised to create Database \n");
			}
			else if (comm.equals("insert") || comm.equals("update"))
			{	System.out.println(user);
				System.out.println("[Info] User attempted to  <<"+ comm +">>\n");
			}
				
			
			
		}
		else if (!(user.equals("root") || user.equals("user") ))
			{
			System.out.println("[Alert]Unauthorised user");
			System.out.println("[Alert] Unauthorised actions detected ");
			System.out.println("This user is not allowed to perform <<" +comm+ ">>  queries ");
			System.out.println("connection id="+connid);
			System.out.println("ip="+ip+"\n");
			}
		
		return null;
	}

	
}
