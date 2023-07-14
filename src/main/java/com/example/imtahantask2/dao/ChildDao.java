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
import java.util.List;
@Component
@RequiredArgsConstructor
public class ChildDao {
    private final JdbcTemplate jdbcTemplate;
    public List<Child> getAllChild() {

        return jdbcTemplate.query("select *from children",(rs, rowNum) -> new Child(rs.getLong(1),
                rs.getString(2),
                rs.getDate(3)));


    }

    public Child creatChild(Child child) {
        String sql = "insert into children (name) values(?,?)";
        PreparedStatementCallback<? extends Object> callback = ps -> {
            ps.setString(1, child.getName());
            ps.setDate(3, (Date) child.getBirth_date());
            ps.execute();
            return ps;
        };
        jdbcTemplate.execute(sql, callback);
        return child;

    }

    public void deleteChild(Long id) {
        String sql = ("delete from children where id=? ");
        PreparedStatementCallback<? extends Object> callback = ps -> {
            ps.setLong(1, id);
            ps.execute();
            return ps;
        };
        jdbcTemplate.execute(sql, callback);
    }



    public Child updateChild(long id, Child child) {
        String sql = "update children set name =?,brith_date=?," +
                "where id = ?";
        PreparedStatementCallback<? extends Object> callback = ps -> {
            ps.setString(1,child.getName());
            ps.setLong(2, child.getId());
            ps.setDate(3,child.getBirth_date());
            ps.execute();
            return ps;
        };
        jdbcTemplate.execute(sql, callback);
        return child;
    }

    public Child getChildById(Long id) {
        return jdbcTemplate.query("select id,name from children where id=?"
                ,this :: rowMapper,id).get(0);
    }
    private Child rowMapper(ResultSet rs, long rowNum)throws SQLException {
        Child child=new Child(rs.getLong(1),
                rs.getString(2),
                rs.getDate(4));

        return child;
    }


    }

