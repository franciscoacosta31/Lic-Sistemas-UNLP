package ar.edu.unlp.info.oo1.ej10_jobScheduler;

public class HighestPriorityScheduler extends JobScheduler{

	public HighestPriorityScheduler() {
		super();
	}
	
	public JobDescription next() {
		JobDescription nextJob = super.getJobs().stream()
				.max((j1,j2) -> Double.compare(j1.getPriority(), j2.getPriority()))
				.orElse(null);
		super.unschedule(nextJob);
		return nextJob;
	}
}
