package com.nhtu0805.controller;

import com.nhtu0805.bean.Emp;
import com.nhtu0805.dao.EmpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmpController {

    @Autowired
    EmpDao empDao;

    @RequestMapping("/empform")
    public ModelAndView show(){
        return new ModelAndView("empform", "command", new Emp());
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("emp") Emp emp){
        empDao.save(emp);
        return new ModelAndView("redirect:/viewemp/1/");
    }

//    @RequestMapping("/viewemp")
//    public ModelAndView viewemp(){
//        List<Emp>  list = empDao.getEmp();
//        return new ModelAndView("/viewemp", "list", list);
//    }

    @RequestMapping(value="viewemp/{pageid}/editemp/{id}/")
    public ModelAndView edit(@PathVariable int id){
        Emp emp=empDao.getEmpById(id);
        return new ModelAndView("empeditform","command",emp);
    }
    /* It updates model object. */
    @RequestMapping(value="viewemp/{pageid}/editemp/{id}/editsave/",method = RequestMethod.POST)
    public ModelAndView editsave(@ModelAttribute("emp") Emp emp){
        empDao.update(emp);
        return new ModelAndView("redirect:/viewemp/{pageid}/");
    }
    /* It deletes record for the given id in URL and redirects to /viewemp */
    @RequestMapping(value="viewemp/{pageid}/deleteemp/{id}",method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int id){
        empDao.delete(id);
        return new ModelAndView("redirect:/viewemp/{pageid}/");
    }

    @RequestMapping(value="/viewemp/{pageid}")
    public ModelAndView editpage(@PathVariable int pageid){
        int total=5;
        if(pageid==1){}
        else{
            pageid=(pageid-1)*total+1;
        }
        List<Emp> list=empDao.getEmployeesByPage(pageid,total);

        return new ModelAndView("viewemp","list",list);
    }

}
