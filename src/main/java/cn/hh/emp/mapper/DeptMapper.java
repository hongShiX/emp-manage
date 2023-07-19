package cn.hh.emp.mapper;

import cn.hh.emp.entity.Dept;

import java.util.List;

public interface DeptMapper {
    // 查找所有部门
    List<Dept> getAllDept();
}
