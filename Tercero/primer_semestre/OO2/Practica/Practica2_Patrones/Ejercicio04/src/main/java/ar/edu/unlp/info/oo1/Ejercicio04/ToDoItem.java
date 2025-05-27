package ar.edu.unlp.info.oo1.Ejercicio04;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

public class ToDoItem {

	private String name;
	private ToDoItemState state;
	private List<String> comments;
	private Duration time;
	private LocalDateTime startDate;
	private LocalDateTime finishDate;
	
    public ToDoItem(String name) {
    	this.name = name;
    	this.state = new Pending(this);
    	this.comments = new ArrayList<String>();
    }

    public void changeState(ToDoItemState state) {
    	this.state = state;
    }
    
    public void start() {
    	this.state.start();
    }

    public void togglePause() {
    	this.state.togglePause();
    }

    public void finish() {
    	this.state.finish();
    }

    public Duration workedTime() {
    	return this.state.workedTime();
    }

    public void addComment(String comment) {
    	this.state.addComment(comment);
    }
    
    public ToDoItemState getState() {
    	return this.state;
    }
    
    public List<String> getComments(){
    	return this.comments;
    }
    
    public LocalDateTime getStartDate() {
    	return this.startDate;
    }
    
    public void setStartDate() {
    	this.startDate = LocalDateTime.now();
    }
    
    public LocalDateTime getFinishDate() {
    	return this.finishDate;
    }
    
    public void setFinishDate() {
    	this.finishDate = LocalDateTime.now();
    }
}
