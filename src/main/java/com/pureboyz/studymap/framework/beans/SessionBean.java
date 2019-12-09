package com.pureboyz.studymap.framework.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component("sessionBean")
@Scope(value="session")
public class SessionBean
{
	String 	SESSION_SEQUSERINFO = null;
	String 	SESSION_ID 		= null;
	String 	SESSION_PASSWD 	= null;
	
	public String getSESSION_SEQUSERINFO() {
		return SESSION_SEQUSERINFO;
	}
	public void setSESSION_SEQUSERINFO(String sESSION_SEQUSERINFO) {
		SESSION_SEQUSERINFO = sESSION_SEQUSERINFO;
	}
	public String getSESSION_ID() {
		return SESSION_ID;
	}
	public void setSESSION_ID(String sESSION_ID) {
		SESSION_ID = sESSION_ID;
	}
	public String getSESSION_PASSWD() {
		return SESSION_PASSWD;
	}
	public void setSESSION_PASSWD(String sESSION_PASSWD) {
		SESSION_PASSWD = sESSION_PASSWD;
	}
	
	@Override
	public String toString() {
		return "SessionBean [SESSION_SEQUSERINFO=" + SESSION_SEQUSERINFO + ", SESSION_ID=" + SESSION_ID + ", SESSION_PASSWD="
				+ SESSION_PASSWD + "]";
	}
	
	
}
