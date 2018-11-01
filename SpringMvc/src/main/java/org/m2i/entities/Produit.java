package org.m2i.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;


@Entity
public class Produit implements Serializable {
	@Id
	@GeneratedValue
	private Long id;
	@Column(length=40)
	@NotNull
	//la designation chaine carct ne depasse pas 30car
	@Length(min=3,max=30)
	private String designation;
	//la valeur prix doit etre > 150 dh 
	@DecimalMin("150")
	private double prix;
	@DecimalMin("1")
	private int quantite;
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//sans param id car est il auto increment
	public Produit(String designation, double prix, int quantite) {
		super();
		this.designation = designation;
		this.prix = prix;
		this.quantite = quantite;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	

}
