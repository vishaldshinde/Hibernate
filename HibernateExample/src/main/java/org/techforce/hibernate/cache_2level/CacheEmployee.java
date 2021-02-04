package org.techforce.hibernate.cache_2level;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "C_EMPLOYEE")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class CacheEmployee {
	@Id
	@Column(name="ID")
	private Integer emp_id;
	@Column(name="NAME")
	private String name;
	@Column(name="SALARY")
	private Double salary;
	public Integer getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "CacheEmployee [emp_id=" + emp_id + ", name=" + name + ", salary=" + salary + "]";
	}
}
