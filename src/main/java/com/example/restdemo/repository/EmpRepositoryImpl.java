package com.example.restdemo.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.restdemo.entity.Employee;

@Repository
public class EmpRepositoryImpl implements EmpRepository {

	Map<Integer,Employee> empRepo = new HashMap<>();
	
	public EmpRepositoryImpl(){
		this.empRepo.put(101, new Employee(101,"Neel","Developer"));
		this.empRepo.put(102, new Employee(102,"Tanu","Admin"));
	}
	
	@Override
	public void store(Employee e) {
		this.empRepo.put(e.getId(), e);

	}

	@Override
	public Employee retrieve(int id) {
		return this.empRepo.get(id);
	}

	@Override
	public Employee search(String name) {
		for(Employee emp: empRepo.values()) {
			if(emp.getName().equals(name))
				return emp;
		}
		return null;
	}

	@Override
	public Employee delete(int id) {
		Employee emp = this.empRepo.get(id);
		this.empRepo.remove(id);
		return emp;
	}

	@Override
	public List<Employee> getAll() {
		return new ArrayList<Employee>(empRepo.values());
	}

}
