package ca.sheridancollege.chomuham.bootstrapping;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ca.sheridancollege.chomuham.beans.Course;
import ca.sheridancollege.chomuham.beans.Professor;
import ca.sheridancollege.chomuham.beans.Student;
import ca.sheridancollege.chomuham.repositories.CourseRepo;
import ca.sheridancollege.chomuham.repositories.ProfRepo;
import ca.sheridancollege.chomuham.repositories.StudentRepo;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class BootstrapData implements CommandLineRunner {
	
	private StudentRepo stuRepo;
	private ProfRepo profRepo;
	private CourseRepo courseRepo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Professor p1 = Professor.builder()
				.name("Byakuya")
				.courses(new ArrayList<Course>())
				.build();
		Professor p2 = Professor.builder()
				.name("Aizen")
				.courses(new ArrayList<Course>())
				.build();
		Professor p3 = Professor.builder()
				.name("Yhwach")
				.courses(new ArrayList<Course>())
				.build();
		
		Course c1 = Course.builder()
				.name("Sword Fighting")
				.code("SWORD512")
				.students(new ArrayList<Student>())
				.prof(p2)
				.build();
		Course c2 = Course.builder()
				.name("Movement and Speed")
				.code("SPEED789")
				.students(new ArrayList<Student>())
				.prof(p1)
				.build();
		Course c3 = Course.builder()
				.name("Hollow Hunting")
				.code("HUNT356")
				.students(new ArrayList<Student>())
				.prof(p1)
				.build();
		Course c4 = Course.builder()
				.name("How to beat Shinigami")
				.code("SOUL588")
				.students(new ArrayList<Student>())
				.prof(p2)
				.build();
		Course c5 = Course.builder()
				.name("All About Quincies")
				.code("QUIN491")
				.students(new ArrayList<Student>())
				.prof(p3)
				.build();
		Course c6 = Course.builder()
				.name("Spiritual Pressure Control")
				.code("SPIR922")
				.students(new ArrayList<Student>())
				.prof(p1)
				.build();
		
		Student[] stuList = new Student[30];
		
		String[] fNames = {"Ichigo","Renji","Rukia","Urahara","Yoruichi",
				"Nelliel","Tia","Gin","Grimmjow","Ulquiorra",
				"Candice","Bambietta","Askin","Uryu","Nnoitra",
				"Retsu","Riruka","Toshiro","Rangiku","Orihime",
				"Isshin","Sung","Stark","Gremmy","Jugram",
				"Nemu","Senjimaru","Shunsui","Shinji","Lisa"};
		String[] lNames = {"Kurosaki","Abarai","Kuchiki","Kisuke","Shihoin",
				"Tu Odel","Halibel","Ichimaru","Jaggerjack","Cifer",
				"Catnip","Basterbine","Nakk Le Varr","Ishida","Gilga",
				"Unohana","Dokugamine","Hitsugaya","Matsumoto","Inoue",
				"Shiba","Sun","Coyote","Thoumeaux","Haschwalth",
				"Kurotsuchi","Shutara","Kyoraku","Hirako","Yadomaru",};
		
		for (int i=0; i < stuList.length; i++) {
			stuList[i] = Student.builder()
					.firstName(fNames[i])
					.lastName(lNames[i])
					.courses(new ArrayList<Course>())
					.build();
		}
		
		profRepo.save(p1);
		profRepo.save(p2);
		profRepo.save(p3);
		
		for (int i=0;i<stuList.length; i++) {
			stuRepo.save(stuList[i]);
		}
		
		c1.getStudents().add(stuList[8]);
		c1.getStudents().add(stuList[24]);
		c1.getStudents().add(stuList[6]);
		c1.getStudents().add(stuList[15]);
		
		c2.getStudents().add(stuList[1]);
		c2.getStudents().add(stuList[24]);
		c2.getStudents().add(stuList[14]);
		c2.getStudents().add(stuList[13]);
		
		c3.getStudents().add(stuList[25]);
		c3.getStudents().add(stuList[19]);
		c3.getStudents().add(stuList[20]);
		c3.getStudents().add(stuList[22]);
		
		c4.getStudents().add(stuList[9]);
		c4.getStudents().add(stuList[18]);
		c4.getStudents().add(stuList[8]);
		c4.getStudents().add(stuList[14]);
		
		c5.getStudents().add(stuList[22]);
		c5.getStudents().add(stuList[6]);
		c5.getStudents().add(stuList[14]);
		c5.getStudents().add(stuList[10]);
		
		c6.getStudents().add(stuList[6]);
		c6.getStudents().add(stuList[7]);
		c6.getStudents().add(stuList[0]);
		c6.getStudents().add(stuList[29]);
		
		courseRepo.save(c1);
		courseRepo.save(c2);
		courseRepo.save(c3);
		courseRepo.save(c4);
		courseRepo.save(c5);
		courseRepo.save(c6);
	}

}
