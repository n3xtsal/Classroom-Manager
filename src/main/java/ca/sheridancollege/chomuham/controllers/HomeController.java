package ca.sheridancollege.chomuham.controllers;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.chomuham.beans.Course;
import ca.sheridancollege.chomuham.beans.Professor;
import ca.sheridancollege.chomuham.beans.ProfessorCourse;
import ca.sheridancollege.chomuham.beans.Student;
import ca.sheridancollege.chomuham.repositories.CourseRepo;
import ca.sheridancollege.chomuham.repositories.ProfRepo;
import ca.sheridancollege.chomuham.repositories.StudentRepo;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class HomeController {

	private StudentRepo stuRepo;
	private ProfRepo profRepo;
	private CourseRepo courseRepo;

	@GetMapping("/")
	public String openRoot() {
		return "rootpage.html";
	}
	
//	@GetMapping("/addProf")
//	public String loadAddProfessor() {
//		ProfessorCourse profC = new ProfessorCourse(new Professor(), new Course());
//		//in th:field do prof.name or course.name to access their names
//		//in modelattribute you would do @ModelAttribute ProfessorCourse 
//		//from ProfessorCourse you could read in values from each entity individually, i.e profC.getCourse()
//	}

	// Adding a student
	@GetMapping("/addStudent")
	public String goToAddStu(Model mod) {
		mod.addAttribute("student", new Student());
		return "addStudent.html";
	}

	@PostMapping("/addStudent")
	public String saveStudent(@ModelAttribute Student student) {
		stuRepo.save(student);
		return "redirect:/addStudent";
	}

	// Viewing all students
	@GetMapping("/viewStudents")
	public String showStudents(Model mod) {
		mod.addAttribute("students", stuRepo.findAll());
		return "viewStudents.html";
	}

	// Adding a prof
	@GetMapping("/addProf")
	public String goToAddProf(Model mod) {
		mod.addAttribute("prof", new Professor());
		return "addProf.html";
	}

	@PostMapping("/addProf")
	public String saveProf(@ModelAttribute Professor prof) {
		profRepo.save(prof);
		return "redirect:/addProf";
	}

	// Viewing all professors
	@GetMapping("/viewProfs")
	public String showProfs(Model mod) {
		mod.addAttribute("professors", profRepo.findAll());
		return "viewProfessors.html";
	}

	// Adding a course
	@GetMapping("/addCourse")
	public String goToAddCourse(Model mod) {
		mod.addAttribute("course", new Course());
		return "addCourse.html";
	}

	@PostMapping("/addCourse")
	public String saveCourse(@ModelAttribute Course course) {
		courseRepo.save(course);
		return "redirect:/addCourse";
	}

	// Viewing all courses
	@GetMapping("/viewCourses")
	public String showCourses(Model mod) {
		mod.addAttribute("courses", courseRepo.findAll());
		return "viewCourses.html";
	}

	// Viewing a course
	@GetMapping("/viewCourse/{id}")
	public String showCourse(Model mod, @PathVariable Long id) {
		Optional<Course> course = courseRepo.findById(id);
		if (course.isPresent()) {
			Course selectedCourse = course.get();
			mod.addAttribute("course", selectedCourse);
			return "viewCourse.html";
		} else {
			return "redirect:/viewCourses";
		}
	}

	// Viewing a professor
	@GetMapping("/viewProf/{id}")
	public String showProf(Model mod, @PathVariable Long id) {
		Optional<Professor> prof = profRepo.findById(id);

		if (prof.isPresent()) {
			Professor selectedProf = prof.get();
			mod.addAttribute("prof", selectedProf);
			return "viewProf.html";
		} else {
			return "redirect:/viewProfs";
		}
	}

	// Viewing a student
	@GetMapping("/viewStudent/{id}")
	public String showStudent(Model mod, @PathVariable Long id) {
		Optional<Student> stu = stuRepo.findById(id);

		if (stu.isPresent()) {
			Student selectedStu = stu.get();
			mod.addAttribute("student", selectedStu);
			return "viewStudent.html";
		} else {
			return "redirect:/viewStudents";
		}
	}

	// Dropping a student (link)
//	@GetMapping("/dropStu/{id}/{cId}")
//	public String dropStu(@PathVariable Long id, @PathVariable Long cId) {
//		
//		return "redirect:/viewCourses";
//	}

	// Dropping a student
	@GetMapping("/dropStudent")
	public String dropStudent(@RequestParam Long cId, @RequestParam Long sId) {
		Student tempS = stuRepo.getById(sId);
		Course tempC = courseRepo.getById(cId);
		tempC.getStudents().remove(tempS);
		courseRepo.save(tempC);
		return "redirect:/viewCourses";
	}

	// Assign prof to course
	@GetMapping("/assignProf")
	public String goToAssignProf(Model mod) {
		mod.addAttribute("professors", profRepo.findAll());
		mod.addAttribute("courses", courseRepo.findAll());
		return "assignProf.html";
	}

	@PostMapping("/assignProf")
	public String assignProfToCourse(@RequestParam Long pId, @RequestParam Long cId) {
		Professor tempP = profRepo.getById(pId);
		Course tempC = courseRepo.getById(cId);
		tempC.setProf(tempP);
		courseRepo.save(tempC);
		return "redirect:/viewProfs";
	}

	// Assign student to course
	@GetMapping("/assignStu")
	public String goToAssignStu(Model mod) {
		mod.addAttribute("students", stuRepo.findAll());
		mod.addAttribute("courses", courseRepo.findAll());
		return "assignStudent.html";
	}

	@PostMapping("/assignStu")
	public String assignStuToCourse(@RequestParam Long sId, @RequestParam Long cId) {
		Student tempS = stuRepo.getById(sId);
		Course tempC = courseRepo.getById(cId);
		tempC.getStudents().add(tempS);
		courseRepo.save(tempC);
		return "redirect:/viewStudents";
	}
}