package it.education.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import it.eduction.entity.Course;
import it.eduction.jdbc.utils.JdbcUtil;

public class CourseDao implements DaoInterface<Course, Integer> {

	@Override
	public Collection<Course> retrieveAll() {
		// creating an empty collection of users
		Collection<Course> allCourse = new ArrayList<>();
		// some code to get data from database and fill that
		// into this collection
		String sqlQuery = " select course_id,course_name,course_provider,course_duration,course_fees from Course_Master;";
		try (Connection dbConnection = it.eduction.jdbc.utils.JdbcUtil.buildConnection();
				Statement stmt = dbConnection.createStatement();
				ResultSet rs = stmt.executeQuery(sqlQuery);) {
			while (rs.next()) {
				int course_id = rs.getInt(1);
				String course_name = rs.getString(2);
				String course_provider = rs.getString(3);
				int course_duration = rs.getInt(4);
				int course_fees = rs.getInt(5);
//						 Populating an object of customer class based
//						 upon : id ,name,age
				Course currentCourse = new Course(course_id, course_name, course_provider, course_duration,
						course_fees);
//						 Adding this object into user collection
				allCourse.add(currentCourse);

			}

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return allCourse;

	}

	@Override
	public Course retrieveOne(Integer id) {
		Course foundCourse = null;
		String sqlQuery = " select course_id,course_name,course_provider,course_duration,course_fees from Course_Master where course_id = ?;";
		try (Connection dbConnection = JdbcUtil.buildConnection();
				PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery);) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				// If user exists
				int course_id = rs.getInt(1);
				String course_name = rs.getString(2);
				String course_provider = rs.getString(3);
				int course_duration = rs.getInt(4);
				int course_fees = rs.getInt(5);
				foundCourse = new Course(course_id, course_name, course_provider, course_duration, course_fees);
			}
		}

		catch (Exception e) {
			// TODO: handle exception
		}
		return foundCourse;
	}

	@Override
	public void create(Course CourseRef) {
		String sqlQuery = "insert into Course_Master values(?,?,?,?,?)";
		try (Connection dbConnection = JdbcUtil.buildConnection();
				PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery);)

		{
//				Retrieving

			int course_id = CourseRef.getCourse_id();
			String course_name = CourseRef.getCourse_name();
			String course_provider = CourseRef.getCourse_provider();
			int course_duration = CourseRef.getCourse_duration();
			int course_fees = CourseRef.getCourse_fees();

			// setting the data
			pstmt.setInt(1, course_id);
			pstmt.setString(2, course_name);
			pstmt.setString(3, course_provider);
			pstmt.setInt(4, course_duration);
			pstmt.setInt(5, course_fees);

			int updateCount = pstmt.executeUpdate();
			System.out.println(updateCount + " record inserted.");
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public void delete(Integer id) {
		String sqlQuery = " delete from Course_Master where course_id = ?";
		try (Connection dbConnection = JdbcUtil.buildConnection();
				PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery);) {
			pstmt.setInt(1, id);

			int updateCount = pstmt.executeUpdate();
			System.out.println(updateCount + " record deleted.");
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public void update(Course modifiedCourse) {
		String sqlQuery = "update Course_Master set course_name = ?,course_provider = ?,course_duration = ?,course_fees = ? where course_id = ?";
		int newcourse_id = modifiedCourse.getCourse_id();
		String newcourse_name = modifiedCourse.getCourse_name();
		String newcourse_provider = modifiedCourse.getCourse_provider();
		int newcourse_duration = modifiedCourse.getCourse_duration();
		int newcourse_fees = modifiedCourse.getCourse_fees();
		try (Connection dbConnection = JdbcUtil.buildConnection();
				PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery);) {
			pstmt.setInt(1, newcourse_id);
			pstmt.setString(2, newcourse_name);
			pstmt.setString(3, newcourse_provider);
			pstmt.setInt(4, newcourse_duration);
			pstmt.setInt(5, newcourse_fees);

			int updateCount = pstmt.executeUpdate();
			System.out.println(updateCount + " record updated.");
		} catch (Exception ex) {

			ex.printStackTrace();
		}
	}

}
