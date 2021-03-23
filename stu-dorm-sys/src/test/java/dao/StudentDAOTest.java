package dao;

import model.Page;
import model.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StudentDAOTest {

    @Test
    public void query() {
        Page p = new Page();
        p.setSearchText("");
        p.setSortOrder("asc");
        p.setPageNumber(6);
        p.setPageSize(2);
        List<Student> list = StudentDAO.query(p);
        for (Object o : list) {
            System.out.println(o.toString());
        }
    }

    @Test
    public void queryById() {
        Student s1 = StudentDAO.queryById(5);
        Student s2 = StudentDAO.queryById(10);
        Student s3 = StudentDAO.queryById(18);
        System.out.println(s1.toString());
        System.out.println(s2.toString());
        System.out.println(s3.toString());
    }

    @Test
    public void insert() {
        Student s = new Student();
        s.setStudentName("小杜");
        s.setStudentMajor("英语系");
        s.setStudentGraduateYear("2019");
        s.setBuildingName("男生楼-1");
        s.setDormId(1);
        int num = StudentDAO.insert(s);
        System.out.println(num);
    }

    @Test
    public void update() {
        Student s = StudentDAO.queryById(23);
        System.out.println(s.toString());
        Student s2 = new Student();
        s2.setStudentName("大杜");
        s2.setStudentMajor("英语系");
        s2.setStudentGraduateYear("2019");
        s2.setBuildingName("男生楼-1");
        s2.setDormId(1);
        s2.setId(23);
        int num = StudentDAO.update(s2);
        System.out.println(s.toString());
    }

    @Test
    public void delete() {
        String[] ids = {"1", "2", "3"};
        int num = StudentDAO.delete(ids);
        System.out.println(num);
    }

    @Test
    public void apply() {
        Student s = StudentDAO.queryById(17);
        List<Integer> ids = new ArrayList<>();
        ids.add(9);
        ids.add(14);
        ids.add(18);
        s.setIds(ids);
        s.setDormId(5);
        int num = StudentDAO.apply(s);
        Student s1 = StudentDAO.queryById(9);
        Student s2 = StudentDAO.queryById(14);
        Student s3 = StudentDAO.queryById(18);
        System.out.println(s1.toString());
        System.out.println(s2.toString());
        System.out.println(s3.toString());
    }
}