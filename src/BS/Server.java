package BS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class server {
	public static void main(String[] args) throws IOException {
		  
		  ServerSocket serverSocket =new ServerSocket(10086);
		  System.out.println("正在等待客户端连接");
		  Socket socket = serverSocket.accept();
		  System.out.println("客户端已连接，正在接受信息");
		  InputStream is = socket.getInputStream();
		  InputStreamReader isr =new InputStreamReader(is);
		  BufferedReader br =new BufferedReader(isr);
		  StringBuffer msg = new StringBuffer();
		  String info =null;
		  while((info=br.readLine())!=null){
		    msg.append(info);
		  }
		  System.out.println(msg);
		  socket.shutdownInput();
		  String[] arrMsg = msg.toString().split(",");
		  String message = server.login(arrMsg[0], arrMsg[1]);
		  OutputStream os = socket.getOutputStream();
		  PrintWriter pw = new PrintWriter(os);
		  pw.write(message);
		  pw.flush();
		  System.out.println("发送成功");
		  pw.close();
		  os.close();
		  br.close();
		  isr.close();
		  is.close();
		  socket.close();
		  serverSocket.close();
		  
	   }
	   public static String login(String acc,String pwd) {
		   String user = "root";
		   String password = "123456";
		   String url = "com.mysql.jdbc.Driver";
		   String driver = "jdbc:mysql:///web";
		   try {
			   Class.forName(driver);
				Connection connection = DriverManager.getConnection(url, user, password);
			Statement state = connection.createStatement();
			ResultSet set = state.executeQuery("select * from test");
			while(set.next()) {
				String accfrom = set.getString("username");
				String pwdFrom = set.getString("password");
				if(acc.equals(accfrom)) {
					if(pwd.equals(pwdFrom)) {
						return "登陆成功";
					}else {
						return "密码错误";
					}
				}
			}
			return "账号错误";
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null; 
	   }
	
}
