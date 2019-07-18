package BS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

class client {
	public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",10086);
        OutputStream os = socket.getOutputStream();
        String msgPack = "admin,123";
        PrintWriter writer =new PrintWriter(os);
        writer.write(msgPack);
        writer.flush();
        socket.shutdownOutput();
        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String info = null;
		while((info=br.readLine())!=null){
		 System.out.println(info);
		}
		br.close();
		is.close();
		writer.close();
		os.close();
        socket.close();


   }
}
