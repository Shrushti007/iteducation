package basic;

import it.education.dao.CourseDao;
import it.education.dao.DaoInterface;
import it.eduction.entity.Course;

public class DeleteCourse {

	public static void main(String[] args) {
		DaoInterface<Course, Integer> daoRef = new CourseDao();
		//delete
		daoRef.delete(1);

	}

}
