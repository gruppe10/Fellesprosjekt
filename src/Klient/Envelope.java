package Klient;

public class Envelope {
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
