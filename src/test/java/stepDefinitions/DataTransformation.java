package stepDefinitions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DataTransformation {
	static int i;
	static int p;
	static int t;
	static String row;

	@Given("Read CSV Data")
	public static List<String> readCsvData() throws Exception {
		// Write code here that turns the phrase above into concrete actions
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

	@When("Initialize DB")
	public static void initDb() {
		// Write code here that turns the phrase above into concrete actions
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Then("Read DB Data")
	public static List<String> readDbData() {
		// Write code here that turns the phrase above into concrete actions
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

	@Then("Validation CSV with DB data")
	public static boolean AreCsvDataSameAsDb() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		List<String> csvData = readCsvData();
		List<String> dbData = readDbData();
		return csvData.equals(dbData);
	}

	@Then("Test Execution")
	@Test
	public void test_execution() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		if (AreCsvDataSameAsDb() == true) {
			System.out.println("CSV and DB data are same");
		} else {
			System.out.println("CSV and DB data are not matching");
		}
	}
}
