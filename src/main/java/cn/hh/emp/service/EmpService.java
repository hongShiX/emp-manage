package cn.hh.emp.service;

import cn.hh.emp.entity.Dept;
import cn.hh.emp.entity.Emp;
import cn.hh.emp.vo.EmpQuery;

import java.util.List;

public interface EmpService {
    List<Emp> getEmpList(EmpQuery param);

    Long countEmpList(EmpQuery param);

    void addEmp(Emp emp);

    List<Dept> getAllDept();

    void deleteEmpByIds(String ids);

    Emp getEmpById(Integer id);

    void updateEmp(Emp emp);
}
