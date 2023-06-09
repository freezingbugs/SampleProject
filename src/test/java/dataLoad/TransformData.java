package dataLoad;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import org.testng.Assert;

public class TransformData {

	static int i;
	static int p;
	static int t;
	static String row;

	public static List<String> readCsvData() throws Exception {
		List<String> csvData = new ArrayList<String>();
		BufferedReader csvReader = new BufferedReader(new FileReader(".\\ReadFiles\\PositionReport.csv"));
		try {
			// String row;
			String line = "";
			boolean skip = true;
			while ((line = csvReader.readLine()) != null) {
				if (skip) {
					skip = false; // Skip only the first line
					continue;
				}
				String[] data = line.split(",");

				row = String.join("\t", data[0], data[1], data[2], data[3], data[4]);
				System.out.println(row);
				csvData.add(row);
			}
			System.out.println("--------------------------------");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return csvData;
	}

	public static void initDb() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static List<String> readDbData() {
		initDb();
		String url = "jdbc:mysql://localhost:3306/demo";
		String user = "root";
		String password = "root";
		String sql = "select * from positionReport";
		List<String> dbData = new ArrayList<String>();
		try {
			Connection conn = DriverManager.getConnection(url, user, password);

			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				String row = String.join("\t", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5));
				System.out.println(row);
				dbData.add(row);
			}
		} catch (Exception exc) {
			exc.printStackTrace();
			throw new RuntimeException(exc);
		}
		return dbData;

	}

	public static boolean AreCsvDataSameAsDb() throws Exception {
		List<String> csvData = readCsvData();
		List<String> dbData = readDbData();
		return csvData.equals(dbData);
	}

	public static void main(String[] args) throws Exception {
		if (AreCsvDataSameAsDb() == true) {
			System.out.println("CSV and DB data are same");
		} else {
			System.out.println("CSV and DB data are not matching");
		}
	}

}
