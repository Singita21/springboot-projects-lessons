package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDao;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
		@Bean
		public CommandLineRunner commandLineRunner(AppDao appDao){
			return runner -> {
				//createInstructor(appDao);
				//findInstructor(appDao);
				//deleteInstructor(appDao);
				//findInstructorDetail(appDao);
				deleteInstructorDetail(appDao);
			};

		}

	private void deleteInstructorDetail(AppDao appDao) {
		int theId =2;
		System.out.println("Deleting instructor detail id: " + theId);
		appDao.deleteInstructorDetailById(theId);
		System.out.println("Done!");
	}

	private void findInstructorDetail(AppDao appDao) {

		int theId = 2;
		System.out.println("Finding instructor id: " + theId);

		InstructorDetail tempInstructorDetail = appDao.findInstructorDetailById(theId);

		System.out.println("tempInstuctorDetail: " + tempInstructorDetail);
		System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor());

		System.out.println("Done!");
	}

	private void deleteInstructor(AppDao appDao) {
		int theId = 1;
		System.out.println("Deleting instructor id: " + theId);
		appDao.deleteInstructorById(theId);
		System.out.println("Done!");
	}

	private void findInstructor(AppDao appDao) {
		int theId = 2;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDao.findInstructorById(theId);

		System.out.println("tempInstuctor: " + tempInstructor);
		System.out.println("the associated instructorDetail only: " + tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDao appDao) {

		//create the instructor
//		Instructor tempInstructor =
//				new Instructor("chad", "Darby", "darby@luv2code.com");
//
//		//create the instructor detail
//		InstructorDetail tempInstructorDetail =
//				new InstructorDetail(
//						"http://www.luv2code.com/youtube",
//						"luv 2 code!!!");

		//create the instructor
		Instructor tempInstructor =
				new Instructor("madhu", "patel", "madhu@luv2code.com");

		//create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.luv2code.com/youtube",
						"Guitar");

		//associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		//save the instructor
		//Note this will save all because of CascadeType.All
		System.out.println("Saving instructor: " + tempInstructor);
		appDao.save(tempInstructor);

		System.out.println("Done!");

	}


}
