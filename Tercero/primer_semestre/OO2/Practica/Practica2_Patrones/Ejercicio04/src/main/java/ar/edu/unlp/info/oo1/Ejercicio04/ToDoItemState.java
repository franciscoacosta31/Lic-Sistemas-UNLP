package ar.edu.unlp.info.oo1.Ejercicio04;

import java.time.Duration;
import java.time.LocalDateTime;

public abstract class ToDoItemState {
		
	private ToDoItem task;
	
	public ToDoItemState(ToDoItem task) {
		this.task = task;
	}
	
	protected ToDoItem getTask() {
		return this.task;
	}
	
	public void start() {}
	public abstract void togglePause();
	public abstract void finish();
	
	public Duration workedTime() {
		LocalDateTime startDate = this.task.getStartDate();
		if (startDate != null) {
			return Duration.between(startDate, LocalDateTime.now());
		} else {
			throw new RuntimeException("El objeto ToDoItem no pasó por el estado 'InProgress'");
		}
	}
	
	public void addComment(String comment) {
		this.task.getComments().add(comment);
	}

}
