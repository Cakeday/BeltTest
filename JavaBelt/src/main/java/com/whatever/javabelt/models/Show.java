package com.whatever.javabelt.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

/**
 * Show
 */
@Entity
@Table(name="shows", uniqueConstraints = {@UniqueConstraint(columnNames ={"title", "network"})})
public class Show {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Size(min=1, message="Title must be present")
    @Column(unique = true)
    private String title;
    @Size(min=1, message="Network must be present")
    private String network;

    @ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name="shows_users",
		joinColumns = @JoinColumn(name = "show_id"),
		inverseJoinColumns = @JoinColumn(name = "user_id")
	)
    private List<User> raters;

    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;



    public Show() {
    }
    public Show(Long id, String title, String network) {
        this.id = id;
        this.title = title;
        this.network = network;
    }



    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getNetwork() {
        return this.network;
    }
    public void setNetwork(String network) {
        this.network = network;
    }
    public List<User> getRaters() {
        return this.raters;
    }
    public void setRaters(List<User> raters) {
        this.raters = raters;
    }
    
    public Date getCreatedAt() {
        return this.createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public Date getUpdatedAt() {
        return this.updatedAt;
    }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }



    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }



}