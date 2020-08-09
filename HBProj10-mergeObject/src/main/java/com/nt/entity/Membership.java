package com.nt.entity;

public class Membership {
	private long mid;
	private String mname;
	private String addrs;
	private long rewardspoints;
	
	public long getMid() {
		return mid;
	}
	public void setMid(long mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getAddrs() {
		return addrs;
	}
	public void setAddrs(String addrs) {
		this.addrs = addrs;
	}
	public long getRewardspoints() {
		return rewardspoints;
	}
	public void setRewardspoints(long rewardspoints) {
		this.rewardspoints = rewardspoints;
	}
	@Override
	public String toString() {
		return "Membership [mid=" + mid + ", mname=" + mname + ", addrs=" + addrs + ", rewardspoints=" + rewardspoints
				+ "]";
	}

}
