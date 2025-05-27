package ar.edu.unlp.info.oo1.Ejercicio04;

public class Pending extends ToDoItemState{

	public Pending(ToDoItem task) {
		super(task);
	}

	@Override
	public void start() {
		this.getTask().changeState(new InProgress(super.getTask()));
	}

	@Override
	public void togglePause() {
		throw new RuntimeException("El objeto ToDoItem no se encuentra en pause o in-progress");
	}

	@Override
	public void finish() {}

}
