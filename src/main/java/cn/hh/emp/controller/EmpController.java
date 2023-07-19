package cn.hh.emp.controller;

import cn.hh.common.vo.Result;
import cn.hh.emp.entity.Dept;
import cn.hh.emp.entity.Emp;
import cn.hh.emp.service.EmpService;
import cn.hh.emp.vo.EmpQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping("/list")
    @ResponseBody
    public Result<Object> getEmpList(EmpQuery param) {
        List<Emp> list = empService.getEmpList(param);
        Long count = empService.countEmpList(param);
        return Result.success(list, count);
    }

    @GetMapping("")
    public String toEmpListUI() {
        return "/emp/empList";
    }

    @PostMapping("/add")
    @ResponseBody
    public Result<Object> addEmp(Emp emp) {
        empService.addEmp(emp);
        return Result.success("新增员工成功");
    }

    @GetMapping("/add/ui")
    public String toAddUI(Model model) {
        List<Dept> deptList = empService.getAllDept();
        model.addAttribute("deptList", deptList);
        return "emp/empAdd";
    }

    @DeleteMapping("/{ids}")
    @ResponseBody
    public Result<Object> deleteEmpByIds(@PathVariable("ids") String ids) {
        empService.deleteEmpByIds(ids);
        return Result.success("删除成功");
    }

    @GetMapping("/{id}")
    public String  getEmpById(@PathVariable("id") Integer id, Model model) {
        Emp emp = empService.getEmpById(id);
        List<Dept> depts = empService.getAllDept();
        model.addAttribute("emp", emp);
        model.addAttribute("deptList", depts);
        return "emp/empEdit";
    }

    @PutMapping("")
    @ResponseBody
    public Result<Object> updateEmp(Emp emp) {
        empService.updateEmp(emp);
        return Result.success("修改成功");
    }
}
