package com.pureboyz.todolist.framework.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component("sessionBean")
@Scope(value="session")
public class SessionBean
{
	String id 		= null;
	String passwd 	= null;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	@Override
	public String toString() {
		return "SessionBean [id=" + id + ", passwd=" + passwd + "]";
	}
	
}
