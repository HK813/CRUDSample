package com.example.SpringBootTodo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class TestService {
	
	@Autowired
	private TestRepository repository;
	
	private JdbcTemplate jdbcTemplate;

    //コンストラクタ
    @Autowired
    public TestService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public Model sindex(Model model) {
    	List<Map<String, Object>> list = jdbcTemplate.queryForList(repository.selectAll());
        model.addAttribute("testList", list);
        return model;
    }
    
    public TestForm screate(TestForm testForm) {
        jdbcTemplate.update(repository.selectInsert(), testForm.getName(), testForm.getOld());
        return testForm;
    }
    
    public TestForm sedit(TestForm testForm, int id) {
        Map<String, Object> map = jdbcTemplate.queryForMap(repository.selectId(id));
        testForm.setId((int)map.get("id"));
        testForm.setName((String)map.get("name"));
        testForm.setOld((int)map.get("old"));
        return testForm;
    }
    
    public TestForm supdate(TestForm testForm,int id) {
        jdbcTemplate.update(repository.updateId(id), testForm.getName(), testForm.getOld());
        return testForm;
    }
    
    public int sdelete(int id) {
        jdbcTemplate.update(repository.deleteId(id));
        return id;
    }

}
