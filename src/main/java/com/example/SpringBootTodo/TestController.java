package com.example.SpringBootTodo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample")
public class TestController {
	
	@Autowired
	private TestService service;

    //�ꗗ��ʂ̕\��
    @GetMapping
    public String index(Model model) {
    	service.sindex(model);
        return "sample/index";
    }
    
    //�V�K���̓t�H�[���̕\��
    @GetMapping("/form")
    public String form(@ModelAttribute TestForm testForm) {
        return "sample/form";
    }

    //�V�K���̓f�[�^�̕ۑ�
    @PostMapping("/form")
    public String create(TestForm testForm) {
    	service.screate(testForm);
        return "redirect:/sample";
    }

    //�ҏW�t�H�[���̕\��
    @GetMapping("/edit/{id}")
    public String edit(@ModelAttribute TestForm testForm, @PathVariable int id) {
    	service.sedit(testForm,id);
        return "sample/edit";
    }

    //�ҏW�f�[�^�̕ۑ�
    @PostMapping("/edit/{id}")
    public String update(TestForm testForm, @PathVariable int id) {
    	service.supdate(testForm,id);
        return "redirect:/sample";
    }

    //�f�[�^�̍폜
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
    	service.sdelete(id);
        return "redirect:/sample";
    }
}
