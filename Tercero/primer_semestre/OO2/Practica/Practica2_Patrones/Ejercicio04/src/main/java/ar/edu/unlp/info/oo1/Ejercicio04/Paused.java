package ar.edu.unlp.info.oo1.Ejercicio04;

public class Paused extends ToDoItemState {

	public Paused(ToDoItem task) {
		super(task);
	}

	@Override
	public void togglePause() {
		this.getTask().changeState(new InProgress(super.getTask()));
	}

	@Override
	public void finish() {
		this.getTask().changeState(new Finished(super.getTask()));		
	}
}
