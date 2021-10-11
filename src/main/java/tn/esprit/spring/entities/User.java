package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import net.minidev.json.annotate.JsonIgnore;

@Entity
public class User implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUser;
	private String LastName ;
	private String FirstName ;
	private String Adress ;
	private String Login ;
    @JsonIgnore
	private String Pw;
	//private String sexe;
    private int tel ;
	@Temporal(TemporalType.DATE)
    private Date DateCreation;
	private String Picture ;
	private String Email ;
	 @OneToOne 
	  private Role1 role;
	
	public User( String lastName, String firstName, String adress, String login, String pw, int tel,
			Date dateCreation, String picture, String email) {
		super();
		LastName = lastName;
		FirstName = firstName;
		Adress = adress;
		Login = login;
		Pw = pw;
		this.tel = tel;
		DateCreation = dateCreation;
		Picture = picture;
		Email = email;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getAdress() {
		return Adress;
	}

	public void setAdress(String adress) {
		Adress = adress;
	}

	public String getLogin() {
		return Login;
	}

	public void setLogin(String login) {
		Login = login;
	}

	public String getPw() {
		return Pw;
	}

	public void setPw(String pw) {
		Pw = pw;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public Date getDateCreation() {
		return DateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		DateCreation = dateCreation;
	}

	public String getPicture() {
		return Picture;
	}

	public void setPicture(String picture) {
		Picture = picture;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Role1 getRole() {
		return role;
	}

	public void setRole(Role1 role) {
		this.role = role;
	}

	
	



	
	
    
	

}
