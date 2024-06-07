package basic;

import java.util.Collection;

import it.education.dao.EnhanceCourseDao;
import it.eduction.entity.Course;


public class DaoEnhancementCourse {

	public static void main(String[] args) {
		EnhanceCourseDao enhancedDaoRef = new EnhanceCourseDao();
		Collection<Course> CoursewithMatchingCourseFees= enhancedDaoRef.retrieveAllUserByCourseFees(25000);
		int size = CoursewithMatchingCourseFees.size();
		if(size !=0) {	
				for(Course CourseRef : CoursewithMatchingCourseFees) 
					System.out.println(CourseRef);
		}
		else {
			System.out.println("No user found");
		}

	}

}
