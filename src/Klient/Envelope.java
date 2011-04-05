package Klient;

import java.io.Serializable;

public class Envelope implements Serializable{
	private Action action;
	private Object content;
	
	public Envelope(Action action, Object content){
		this.action = action;
		this.content = content;
	}
	
	public Action getAction(){
		return action;
	}
	
	public Object getContent(){
		return content;
	}
}
