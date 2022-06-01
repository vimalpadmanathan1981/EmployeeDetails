package dao;

import java.util.List;

import entity.TrackDetail;

public interface DaoInterface {
	public void insertDb(int id, String name, String track, int mobile, String role);
	public void deleteDb(int id);
	public void update(int id,int num);
	public void getTrack(String t,List<TrackDetail> list);
	public void insertTrack(String t,int n);
	public int retrieveValue(String t);

}
