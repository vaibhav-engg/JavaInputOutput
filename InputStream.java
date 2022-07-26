import java.io.*;
import java.util.HashMap;

public class InputStream {
	
	private  HashMap<String,String>map;
	String s = "db.user=arisglobal\r\n"
			+ "db.password=password \r\n"
			+ "db.url=localhost \r\n"
			+ "";


	public void createFile() {
		
		try {
			FileOutputStream fout = new FileOutputStream("D:\\config.properties");
			
			byte[] b = s.getBytes();
			fout.write(b);
			fout.close();
			//System.out.println("success");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	public void readFile() throws UserException  {
		String data = "";
		try {
			FileInputStream fin = new FileInputStream("D:\\config.properties");
			
			int i ;
			while((i= fin.read())!=-1) {
				data += (char)i;
				//i= fin.read();

			}
		
			fin.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		if(data.equals(s)) {
			System.out.println("Success");
			System.out.println(data);
			 map = new HashMap<String,String>();
			map.put("user", "arisglobal");
			map.put("password", "password");
			map.put("url", "localhost");
			
		}
		else {
			System.out.println(data);
			
			throw new UserException("This is invalid");
		}
		
	}
	public static void main(String[] args) {
		InputStream input = new InputStream();
		input.createFile();
		try {
			input.readFile();
		} catch (UserException e) {
			
			e.printStackTrace();
		}
	}
}



