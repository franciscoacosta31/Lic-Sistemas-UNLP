package ar.edu.unlp.info.oo1.ej10_jobScheduler;

public class MostEffortScheduler extends JobScheduler{

	public MostEffortScheduler() {
		super();
	}
	
	public JobDescription next() {
		JobDescription nextJob = jobs.stream()
				.max((j1, j2) -> Double.compare(j1.getEffort(), j2.getEffort()))
				.orElse(null);
		super.unschedule(nextJob);
		return nextJob;
	}
}
