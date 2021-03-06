package com.ryantablada.entities;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "posts")
public class Post implements HasId {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(generator="system-uuid")
  @GenericGenerator(name="system-uuid", strategy = "uuid")
  String id;

  public String getId() {
    return id;
  }

  public void setId(String val) {
    this.id = val;
  }

  @Column
  String title;

  @Column(columnDefinition = "text")
  String content;

  @ManyToOne
  User user;

  public void setUser(User u) {
    this.user = u;
  }

  public void setUser(String id) {
    User user = new User();
    user.setId(id);

    this.setUser(user);
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String val) {
    this.title = val;
  }

  public String getContent() {
    return this.content;
  }

  public void setContent(String val) {
    this.content = val;
  }
}
