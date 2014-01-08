package com.netpace.iem.umair.model;

// Generated Jan 6, 2014 3:30:27 PM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Label generated by hbm2java
 */
@Entity
@Table(name = "label", catalog = "iem2")
public class Label implements java.io.Serializable {

	private Integer id;
	private String name;
	private String description;
	private Set<Income> incomes = new HashSet<Income>(0);
	private Set<Expense> expenses = new HashSet<Expense>(0);

	public Label() {
	}

	public Label(String name, String description, Set<Income> incomes,
			Set<Expense> expenses) {
		this.name = name;
		this.description = description;
		this.incomes = incomes;
		this.expenses = expenses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description", length = 45)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "income_labels", catalog = "iem2", joinColumns = { @JoinColumn(name = "label_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "income_id", nullable = false, updatable = false) })
	public Set<Income> getIncomes() {
		return this.incomes;
	}

	public void setIncomes(Set<Income> incomes) {
		this.incomes = incomes;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "expense_labels", catalog = "iem2", joinColumns = { @JoinColumn(name = "label_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "expense_id", nullable = false, updatable = false) })
	public Set<Expense> getExpenses() {
		return this.expenses;
	}

	public void setExpenses(Set<Expense> expenses) {
		this.expenses = expenses;
	}

}