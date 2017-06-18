package kr.pe.ghp.batch.model;

/**
 * 
 * @author geunhui park
 *
 */
public class CronDetails {
	private String groupName;
	private String jobName;
	private String jobParams;
	private String cronExp;

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobParams() {
		return jobParams;
	}

	public void setJobParams(String jobParams) {
		this.jobParams = jobParams;
	}

	public String getCronExp() {
		return cronExp;
	}

	public void setCronExp(String cronExp) {
		this.cronExp = cronExp;
	}
}
