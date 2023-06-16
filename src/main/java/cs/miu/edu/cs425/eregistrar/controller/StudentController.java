package cs.miu.edu.cs425.eregistrar.controller;


import cs.miu.edu.cs425.eregistrar.model.Search;
import cs.miu.edu.cs425.eregistrar.model.Student;
import cs.miu.edu.cs425.eregistrar.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = {"/student"})
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
@GetMapping(value = "/list")
  public String listStudents(Model model){
        List<Student> studentList = studentService.getAllStudents();
        model.addAttribute("students", studentList);
        model.addAttribute("search",new Search());
        return "student/students";
  }
  @GetMapping(value="/register")
   public String RegisterForm(Model model)
   {
       Student student = new Student();
//       student.setStudentNumber(1234);
      // System.out.println("testing"+student);
       model.addAttribute("student", student);
       return "student/register";
   }

    @PostMapping(value = "/register")
    public String addNewStudent(@Valid @ModelAttribute("student") Student newStudent,
                                BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("error",bindingResult.getAllErrors());
            return "student/register";
        }
        studentService.addNewStudent(newStudent);
        return "redirect:/student/list";

    }

    @GetMapping("/edit/{studentId}")
    public ModelAndView edit(@PathVariable Long studentId){
        var student = studentService.getStudent(studentId);
        var modelAndView = new ModelAndView();
        modelAndView.addObject("student",student);
        modelAndView.setViewName("/student/edit");
        return modelAndView;
    }

    @PostMapping("/update")
        public String update(@ModelAttribute( "student") Student student, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("error",bindingResult.getAllErrors());
            return "student/edit";
        }
            studentService.addNewStudent(student);
            return "redirect:/student/list";
        }

    @GetMapping("/delete/{studentId}")
    public String   delete (@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
        return "redirect:/student/list";
    }

    @PostMapping("/search")
    public ModelAndView search (@ModelAttribute Search search)
    {

       var students= studentService.searchstudent(search.getName());

       var model = new ModelAndView();
       model.addObject("students",students);

      model.setViewName("/student/result");
      return model;
    }
    }



