package entity;

public class TrackDetail {
	private String track;
	private int noOfMinds;
	public String getTrack() {
		return track;
	}
	public void setTrack(String track) {
		this.track = track;
	}
	public int getNoOfMinds() {
		return noOfMinds;
	}
	public void setNoOfMinds(int noOfMinds) {
		this.noOfMinds = noOfMinds;
	}
	public TrackDetail(String track, int noOfMinds) {
		super();
		this.track = track;
		this.noOfMinds = noOfMinds;
	}
	@Override
	public String toString() {
		return "TrackDetail [track=" + track + ", noOfMinds=" + noOfMinds + "]";
	}

}
