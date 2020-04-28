package com.xp.springboot204.controller;

import com.xp.springboot204.dao.GradeDao;
import com.xp.springboot204.dao.StudentDao;
import com.xp.springboot204.pojo.Grade;
import com.xp.springboot204.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author Climb.Xu
 * @date 2020/4/4 20:39
 */
@Controller
public class StudentController {
    @Autowired
    StudentDao studentDao;
    @Autowired
    GradeDao gradeDao;
    //查询所有学生,返回列表页面
    @GetMapping("/students")
    public String list(Model model) {
        Collection<Student> students = studentDao.getAll();
        model.addAttribute("students", students);
        return "student/list";
    }

    //来到添加学生页面
    @GetMapping("/student")
    public String toAddPage(ModelMap modelMap) {
        //查出所有年级,在页面显示
        Collection<Grade> grades = gradeDao.getGrades();
        modelMap.addAttribute("grades", grades);
        return "student/add";
    }
    @PostMapping("/student")
    public String addStudent(Student student) {
        studentDao.save(student);
        return "redirect:/students";
    }
    //来到修改页面
    @GetMapping("/student/{id}")
    public String toEditPage(@PathVariable("id") Integer id, ModelMap modelMap) {
        //查出学生信息,在各个input框内显示
        Student student = studentDao.get(id);
        modelMap.addAttribute("student", student);
        //查出所有年级,在页面显示
        Collection<Grade> grades = gradeDao.getGrades();
        modelMap.addAttribute("grades", grades);
        return "student/add";
    }
    //修改学生信息
    @PutMapping("/student")
    public String updateStudent(Student student) {
        studentDao.save(student);
        return "redirect:/students";
    }
    //删除学生信息
    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable("id") Integer id) {
        studentDao.delete(id);
        return "redirect:/students";
    }
}
