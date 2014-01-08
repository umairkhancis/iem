package com.netpace.iem.umair.model;

// Generated Jan 6, 2014 3:30:27 PM by Hibernate Tools 4.0.0

import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Expense generated by hbm2java
 */
@Entity
@Table(name = "expense", catalog = "iem2")
public class Expense implements java.io.Serializable {

	private Integer id;
	private Category category;
	private Double total;
	private Date date;
	private Set<Item> items = new HashSet<Item>(0);
	private Set<Label> labels = new HashSet<Label>(0);

	public Expense() {
	}

	public Expense(Category category, Double total, Date date, Set<Item> items,
			Set<Label> labels) {
		this.category = category;
		this.total = total;
		this.date = date;
		this.items = items;
		this.labels = labels;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Column(name = "total", precision = 22, scale = 0)
	public Double getTotal() {
		return this.total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date", length = 10)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "expense")
	public Set<Item> getItems() {
		return this.items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "expense_labels", catalog = "iem2", joinColumns = { @JoinColumn(name = "expense_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "label_id", nullable = false, updatable = false) })
	public Set<Label> getLabels() {
		return this.labels;
	}

	public void setLabels(Set<Label> labels) {
		this.labels = labels;
	}

}
