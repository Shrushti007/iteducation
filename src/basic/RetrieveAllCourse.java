package basic;

import java.util.Collection;

import it.education.dao.CourseDao;
import it.education.dao.DaoInterface;
import it.eduction.entity.Course;

public class RetrieveAllCourse {

	public static void main(String[] args) {
		DaoInterface<Course, Integer> daoRef = new CourseDao();
		Collection<Course> allCourse = daoRef.retrieveAll();
		for (Course us : allCourse) {
			System.out.println(us);

		}
	}
}
