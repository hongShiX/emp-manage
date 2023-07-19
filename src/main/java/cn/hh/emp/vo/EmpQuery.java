package cn.hh.emp.vo;

import cn.hh.common.vo.Page;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class EmpQuery extends Page {
    private String name;

    private Character sex;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    private Integer age;

    // 做性别转换，以查询
    public void setSex(Character sex) {
        if (sex == null) {
            this.sex = sex;
        } else if (sex == '男') {
            this.sex = 'M';
        } else if (sex == '女') {
            this.sex = 'F';
        } else if (sex == '妖') {
            this.sex = 'D';
        } else {
            this.sex = sex;
        }
    }
}
