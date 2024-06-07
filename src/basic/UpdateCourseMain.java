package basic;


import it.education.dao.CourseDao;
import it.education.dao.DaoInterface;
import it.eduction.entity.Course;

public class UpdateCourseMain {

	public static void main(String[] args) {
		DaoInterface<Course, Integer> daoRef = new CourseDao();
		daoRef.retrieveOne(6);
		Course courseRef = daoRef.retrieveOne(3);
		//Update name and age in database table
		courseRef.setCourse_name("AI");
//		courseRef.setCourse_provider("coder");
		daoRef.update(courseRef);
	}

}
		