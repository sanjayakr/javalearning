import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
class Connect_mysql 
{
		  public static void main(String[] args) throws ClassNotFoundException {
		    Connection con = null;
		    String url = "jdbc:mysql://localhost:3306/test";
		    String username = "root";
		    String password = "mysql";

		    try {
		      Class.forName("com.mysql.jdbc.Driver");
		      con = (Connection) DriverManager.getConnection(url, username, password);
		      System.out.println("Connected!");
		      Statement stmt  = (Statement) con.createStatement();
		      String sql = "SELECT * from student ";
        	  ResultSet rs    = (ResultSet) stmt.executeQuery(sql);
        	  while (rs.next()) 
        	  {
        		System.out.println(rs.getInt("studentid") + "\t" + 
        		                      rs.getString("studentname")  + "\t" +
        		                      rs.getString("studentaddress"));
        		                    
        		}

		    } catch (SQLException ex) {
		        throw new Error("Error ", ex);
		    } finally {
		      try {
		        if (con != null) {
		            con.close();
		        }
		      } catch (SQLException ex) {
		          System.out.println(ex.getMessage());
		      }
		    }
		  }
		}
