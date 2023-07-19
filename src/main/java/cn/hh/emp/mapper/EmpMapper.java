package cn.hh.emp.mapper;

import cn.hh.emp.entity.Emp;
import cn.hh.emp.vo.EmpQuery;

import java.util.List;

public interface EmpMapper {

    // 根据给定参数查询员工
    List<Emp> getEmpList(EmpQuery param);

    // 查询员工数量
    Long countEmpList(EmpQuery param);

    // 添加员工
    void addEmp(Emp emp);

    // 根据id删除员工
    void deleteEmpByIds(String ids);

    // 根据id查找员工
    Emp getEmpById(Integer id);

    // 修改员工信息
    void updateEmp(Emp emp);
}