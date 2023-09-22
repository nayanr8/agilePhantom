package com.example.restdemo.repository;

import java.util.List;

import com.example.restdemo.entity.Employee;

public interface EmpRepository {
	public void store(Employee e);
	public Employee retrieve(int id);
	public Employee search(String name);
	public Employee delete(int id);
	public List<Employee> getAll();
}
