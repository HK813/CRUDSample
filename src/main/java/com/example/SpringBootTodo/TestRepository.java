package com.example.SpringBootTodo;

import org.springframework.stereotype.Repository;

@Repository
public class TestRepository {
	
	private String Select_All = "SELECT * FROM test_table";
	private String Select_Insert = "INSERT INTO test_table(name, old) VALUES(?, ?);";
	private String Update = "UPDATE test_table SET name = ?, old = ?";
	private String Delete = "DELETE from test_table";
	private String WI = "WHERE id = ";
	
	public String selectAll() {
		return Select_All;
	}
	
	public String selectInsert(){
		return Select_Insert;
	}
	
	public String selectId(int id){
		String Select_Id = Select_All + WI + id;
		return Select_Id;
	}
	
	public String updateId(int id){
		String Update_Id = Update + WI + id;
		return Update_Id;
	}
	
	public String deleteId(int id){
		String Delete_Id = Delete + WI + id;
		return Delete_Id;
	}

}
