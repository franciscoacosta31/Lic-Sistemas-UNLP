package ar.edu.unlp.info.oo1.ej10_jobScheduler;

public class FifoScheduler extends JobScheduler{
	
	public FifoScheduler() {
		super();
	}
	
	public JobDescription next() {
		JobDescription nextJob = super.getJobs().get(0);
		super.unschedule(nextJob);
		return nextJob;
	}
}
