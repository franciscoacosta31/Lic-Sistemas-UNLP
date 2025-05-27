package ar.edu.unlp.info.oo1.Ejercicio04;

import java.time.Duration;

public class Finished extends ToDoItemState {
	
	public Finished(ToDoItem task) {
		super(task);
		this.getTask().setFinishDate();
	}

	@Override
	public void togglePause() {
		throw new RuntimeException("El objeto ToDoItem no se encuentra en pause o in-progress");
	}

	@Override
	public void finish() {}

	@Override
	public Duration workedTime() {
		return Duration.between(this.getTask().getStartDate(), this.getTask().getFinishDate());
	}

	@Override
	public void addComment(String comment) {}

}
