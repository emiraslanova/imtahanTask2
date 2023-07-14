package com.example.imtahantask2.dao;

import com.example.imtahantask2.entity.Child;
import com.example.imtahantask2.entity.Parent;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ParentDao {
    private final JdbcTemplate jdbcTemplate;
    public List<Parent> getAllParent() {


        return jdbcTemplate.query("select *from parents",(rs, rowNum) -> new Parent(rs.getLong(1),
                rs.getString(2),
                rs.getString(3),
                rs.getDate(4),
                rs.getString(5)));



    }

    public Parent creatParent(Parent parent) {
        String sql = "insert into parents (name,surname,birth_date,job_name) values(?,?,?,?)";
        PreparedStatementCallback<? extends Object> callback = ps -> {
            ps.setString(1, parent.getName());
            ps.setString(2,parent.getSurname());
            ps.setDate(3, (Date) parent.getBirth_date());
            ps.setString(4,parent.getJob_name());
            ps.execute();
            return ps;
        };
        jdbcTemplate.execute(sql, callback);
        return parent;

    }

    public Parent getParentById(long id) {
        return jdbcTemplate.query("select *from parents where id=?"
                ,this :: rowMapper,id).get(0);
    }
    private Parent rowMapper(ResultSet rs, long rowNum)throws SQLException {
        Parent parent=new Parent(rs.getLong(1),
                rs.getString(2),
                rs.getString(3),
                rs.getDate(4),
                rs.getString(5));

        return parent;
    }



    public void deleteParent(long id) {
        String sql = ("delete from parent  where id=? ");
        PreparedStatementCallback<? extends Object> callback = ps -> {
            ps.setLong(1, id);
            ps.execute();
            return ps;
        };
        jdbcTemplate.execute(sql, callback);
    }



    public Parent updateParent(long id, Parent parent) {
        String sql = "update parent set name =?, surname=?,brith_date=?,job_name=?" +
                "where id = ?";
        PreparedStatementCallback<? extends Object> callback = ps -> {
            ps.setString(1, parent.getName());
            ps.setLong(2, parent.getId());
            ps.setString(3,parent.getSurname());
         ps.setDate(4, (Date) parent.getBirth_date());
            ps.setString(5,parent.getJob_name());
            ps.execute();
            return ps;
        };
        jdbcTemplate.execute(sql, callback);
        return parent;
    }
}
