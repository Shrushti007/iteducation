package basic;

import it.education.dao.CourseDao;
import it.education.dao.DaoInterface;
import it.eduction.entity.Course;

public class CreateCourse {

	public static void main(String[] args) {
		DaoInterface<Course, Integer> daoRef = new CourseDao();
		Course CourseObj=new Course(5,"javascript","edurekha",150,40000);
		daoRef.create(CourseObj);
	}

}
