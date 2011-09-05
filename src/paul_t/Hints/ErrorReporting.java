package paul_t.Hints;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;

import java.net.URL;
import java.net.URLEncoder;
import java.net.URLConnection;

public class ErrorReporting {
	//Error Reporting code
	public static void Report(Throwable error)
	{
	  try {
		  System.out.println("[Hints] An error has occured, please wait while it is trasmitted to the developers...");
	      // Construct data
	      String data = URLEncoder.encode("Exception", "UTF-8") + "=" + URLEncoder.encode(StackToString(error), "UTF-8");
	      data += "&" + URLEncoder.encode("Version", "UTF-8") + "=" + URLEncoder.encode(Integer.toString(Hints.getBuild()), "UTF-8");
	      data += "&" + URLEncoder.encode("Ident", "UTF-8") + "=" + URLEncoder.encode("ComingSoon", "UTF-8");

	      // Send data
	      URL url = new URL("http://errorreport.citizensnpcs.net");
	      URLConnection conn = url.openConnection();
	      conn.setDoOutput(true);
	      OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
	      wr.write(data);
	      wr.flush();

	      // Get the response
	      BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	      String line;
	      while ((line = rd.readLine()) != null) {
	    	  System.out.println("[Hints] Your error has been successfully transmitted!");
	      }
	      wr.close();
	      rd.close();
	  } catch (Exception e) {
		  System.out.println("[Hints] An error has occured while trasmitting your error report.");
	  }
	  error.printStackTrace();
	  System.out.println("[Hints] Above is the stacktrace that has been trasmitted to the developers, no other information has been included, other than the build number.");
	}
	 private static String StackToString(Throwable e) {
		  try {
		    StringWriter sw = new StringWriter();
		    PrintWriter pw = new PrintWriter(sw);
		    e.printStackTrace(pw);
		    return sw.toString();
		  }
		  catch(Exception e2) {
		    return "Invalid Stacktrace...";
		  }
	 }
}
