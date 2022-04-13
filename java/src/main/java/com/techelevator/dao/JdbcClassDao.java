package com.techelevator.dao;

import com.techelevator.exceptions.ClassNotFoundException;
import com.techelevator.model.Class;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Service
public class JdbcClassDao implements ClassDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcClassDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Class> findAll() {
        List<Class> classList = new ArrayList<>();
        String sql = "SELECT * FROM classes;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            Class newClass = mapRowToClass(results);
            classList.add(newClass);
        }
        return classList;
    }

    @Override
    public Class getClassById(Long id) throws ClassNotFoundException {
        String sql = "SELECT * FROM classes WHERE class_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        if(results.next()) {
            return mapRowToClass(results);
        } else {
            throw new ClassNotFoundException(id);
        }
    }

    @Override
    public Class addClass(String name, String instructor, Time time, Date date, int lengthMinutes) {
        String insertClass = "INSERT INTO classes (class_name,instructor_name,start_date,start_time,length_minutes) "+
                "VALUES (?,?,?,?,?) RETURNING class_id;";
        Class newClass = new Class();
        newClass.setId(jdbcTemplate.queryForObject(insertClass,Long.class,name,instructor,date,time,lengthMinutes));
        newClass.setName(name);
        newClass.setInstructor(instructor);
        newClass.setTime(time);
        newClass.setDate(date);
        newClass.setLengthMinutes(lengthMinutes);
        return newClass;
    }

    @Override
    public void updateClass(Long classId, Class updatedClass) throws ClassNotFoundException {
        String sql = "UPDATE classes SET class_name = ?, instructor_name = ?, start_date = ?, start_time = ?, length_minutes = ? "+
                "WHERE class_id = ?;";
        try {
            jdbcTemplate.update(sql, updatedClass.getName(), updatedClass.getInstructor(), updatedClass.getDate(),
                    updatedClass.getTime(), updatedClass.getLengthMinutes(), classId);
        } catch(Exception e) {
            throw new ClassNotFoundException(classId);
        }
    }

    @Override
    public Class removeClass(Long id) throws ClassNotFoundException {
        String sql = "DELETE FROM classes WHERE class_id = ? RETURNING *;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
            return mapRowToClass(results);
        } catch(Exception e) {
            throw new ClassNotFoundException(id);
        }
    }

    @Override
    public void registerMember(Long memberId, Long classId) {
        String sql = "INSERT INTO class_members (class_id,member_id) VALUES (?,?);";
        jdbcTemplate.update(sql,classId,memberId);
    }

    @Override
    public void unregisterMember(Long memberId, Long classId) {
        String sql = "DELETE FROM class_members WHERE member_id = ? AND class_id = ?;";
        jdbcTemplate.update(sql,memberId,classId);
    }

    private Class mapRowToClass(SqlRowSet results) {
        Class newClass = new Class();
        newClass.setId(results.getLong("class_id"));
        newClass.setName(results.getString("class_name"));
        newClass.setInstructor(results.getString("instructor_name"));
        newClass.setTime(results.getTime("start_time"));
        newClass.setDate(results.getDate("start_date"));
        newClass.setLengthMinutes(results.getInt("length_minutes"));
        return newClass;
    }
}
