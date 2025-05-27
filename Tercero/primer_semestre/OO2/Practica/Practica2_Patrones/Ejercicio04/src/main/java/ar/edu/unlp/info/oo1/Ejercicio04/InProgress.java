package ar.edu.unlp.info.oo1.Ejercicio04;

public class InProgress extends ToDoItemState {

	public InProgress(ToDoItem task) {
		super(task);
		this.getTask().setStartDate();
	}

	@Override
	public void togglePause() {
		this.getTask().changeState(new Paused(super.getTask()));
	}

	@Override
	public void finish() {
		this.getTask().changeState(new Finished(super.getTask()));
	}
	
}
