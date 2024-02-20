package org.example;

import org.example.database.*;
import org.example.prefs.Prefs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
	Database database = Database.getInstance();

	public List<MaxProjectCountClient> findMaxProjectsClient(){
		List<MaxProjectCountClient> list = new ArrayList<>();
		String maxProjectClientQuerySqlFilename = new Prefs().getString(Prefs.MAX_PROJECT_CLIENT_QUERY_SQL_FILE_PATH);

		try(Statement st = database.getConnection().createStatement()){
			ResultSet rs = st.executeQuery(extractedQuery(maxProjectClientQuerySqlFilename));
			while (rs.next()){
				MaxProjectCountClient mpcc = new MaxProjectCountClient(rs.getString("name"), rs.getInt("project_count"));
				list.add(mpcc);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	public List<ProjectPrintPrices> printProjectsPrices(){
		List<ProjectPrintPrices> list = new ArrayList<>();
		String printProjectPricesQuerySqlFilename = new Prefs().getString(Prefs.PRINT_PRICE_PROJECT_QUERY_SQL_FILE_PATH);

		try(Statement st = database.getConnection().createStatement()){
			ResultSet rs = st.executeQuery(extractedQuery(printProjectPricesQuerySqlFilename));
			while (rs.next()){
				ProjectPrintPrices ppp = new ProjectPrintPrices(rs.getString("name"), rs.getLong("project"), rs.getLong("price"));
				list.add(ppp);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	public List<MaxWorkerSalary> findMaxWorkerSalary(){
		List<MaxWorkerSalary> list = new ArrayList<>();
		String maxWorkerSalaryQuerySqlFilename = new Prefs().getString(Prefs.MAX_SALARY_WORKER_QUERY_SQL_FILE_PATH);

		try(Statement st = database.getConnection().createStatement()){
			ResultSet rs = st.executeQuery(extractedQuery(maxWorkerSalaryQuerySqlFilename));
			while (rs.next()){
				MaxWorkerSalary mws = new MaxWorkerSalary(rs.getString("name"), rs.getLong("salary"));
				list.add(mws);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	public List<LongestProject> findLongestProject(){
		List<LongestProject> list = new ArrayList<>();
		String longestProjectQuerySqlFilename = new Prefs().getString(Prefs.LONGEST_PROJECT_QUERY_SQL_FILE_PATH);

		try(Statement st = database.getConnection().createStatement()){
			ResultSet rs = st.executeQuery(extractedQuery(longestProjectQuerySqlFilename));
			while (rs.next()){
				LongestProject longestProject = new LongestProject(rs.getString("name"), rs.getInt("month"));
				list.add(longestProject);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	public List<OldestYoungestWorkers> findOldestYoungestWorker(){
		List<OldestYoungestWorkers> list = new ArrayList<>();
		String oldestYoungestQuerySqlFilename = new Prefs().getString(Prefs.YOUNGEST_OLDEST_WORKER_QUERY_SQL_FILE_PATH);

		try(Statement st = database.getConnection().createStatement()){
			ResultSet rs = st.executeQuery(extractedQuery(oldestYoungestQuerySqlFilename));
			while (rs.next()){
				OldestYoungestWorkers oldestYoungestWorkers = new OldestYoungestWorkers(rs.getString("type"),
						rs.getString("name"), rs.getString("birthday"));
				list.add(oldestYoungestWorkers);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	public static void main(String[] args) {

		List<MaxProjectCountClient> maxProjectCountClients = new DatabaseQueryService().findMaxProjectsClient();
		System.out.println(maxProjectCountClients.toString());

		List<ProjectPrintPrices> projectPrintPrices = new DatabaseQueryService().printProjectsPrices();
		System.out.println(projectPrintPrices.toString());

		List<MaxWorkerSalary> maxWorkerSalaries = new DatabaseQueryService().findMaxWorkerSalary();
		System.out.println(maxWorkerSalaries.toString());

		List<OldestYoungestWorkers> oldestYoungestWorkersList = new DatabaseQueryService().findOldestYoungestWorker();
		System.out.println(oldestYoungestWorkersList.toString());

		List<LongestProject> longestProjects = new DatabaseQueryService().findLongestProject();
		System.out.println(longestProjects.toString());
	}

	private static String extractedQuery(String maxProjectClientQuerySqlFilename) {
		try {
			String query = String.join(
					"\n",
					Files.readString(Paths.get(maxProjectClientQuerySqlFilename))
			);
			return query;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
