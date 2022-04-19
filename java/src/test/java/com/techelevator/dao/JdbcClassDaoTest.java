package com.techelevator.dao;

import com.techelevator.model.Class;
import com.techelevator.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class JdbcClassDaoTest extends FinalCapstoneDaoTests{

    private JdbcClassDao sut;

    @Before
    public void setup() {
        DataSource dataSource = this.getDataSource();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcClassDao(jdbcTemplate);
    }
  //  @Test
   // public void findAllShouldReturnListOfClasses() {
  //  List<Class> userCreated = sut.findAll();
  //      Assert.assertTrue(userCreated);
  //      User user = sut.findByUsername("TEST_USER");
  //      Assert.assertEquals("TEST_USER", user.getUsername());
    }


