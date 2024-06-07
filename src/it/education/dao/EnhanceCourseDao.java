package it.education.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import it.eduction.entity.Course;
import it.eduction.jdbc.utils.JdbcUtil;



public class EnhanceCourseDao extends CourseDao {
	public Collection<Course>
	retrieveAllUserByCourseFees(int course_fees ){
	Collection<Course> allUserwithMatchingCourseFees=new ArrayList<>();
	String sqlQuery="select course_id,course_name,course_provider,course_duration,course_fees from Course_Master where course_fees = ?";
	try (
		Connection dbConnection = JdbcUtil.buildConnection();
		PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery);
	){
		pstmt.setInt(1, course_fees);
		ResultSet rs =pstmt.executeQuery();
		
		while(rs.next()) {
			int course_id = rs.getInt(1);
			String course_name = rs.getString(2) ;
			 String course_provider = rs.getString(3);
			 int course_duration = rs.getInt(4);
		 int newcourse_fees = rs.getInt(5);
			 Course currentUser = new Course(course_id,course_name,course_provider,course_duration,newcourse_fees);
//			 Adding this object into user collection
			 allUserwithMatchingCourseFees.add(currentUser);
					 
		 }
	}
	catch (Exception ex) {
		// TODO: handle exception
		ex.printStackTrace();
	}
	
	return allUserwithMatchingCourseFees;
}
}


