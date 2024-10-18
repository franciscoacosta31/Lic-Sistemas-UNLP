package ar.edu.unlp.info.oo1.ej10_jobScheduler;

public class LifoScheduler extends JobScheduler{
	
	public LifoScheduler() {
		super();
	}
	
	public JobDescription next() {
		JobDescription nextJob = super.getJobs().get(jobs.size()-1);
		super.unschedule(nextJob);
		return nextJob;
	}
}
