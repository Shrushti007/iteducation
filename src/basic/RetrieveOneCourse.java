package basic;


import it.education.dao.CourseDao;
import it.education.dao.DaoInterface;
import it.eduction.entity.Course;

public class RetrieveOneCourse {

	public static void main(String[] args) {
		DaoInterface<Course, Integer> daoRef = new CourseDao();
		Course CourseRef=daoRef.retrieveOne(4);
		if(CourseRef != null)
			System.out.println(CourseRef);
		else
			System.out.println("user with given Id does not exists");

	}

}
