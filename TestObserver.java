package design.pattern;

import java.util.ArrayList;

interface Observer{
	public void update(Subject s);
}
interface Subject{
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyAllObservers();
}
class HeadHunter implements Subject{
	private ArrayList<Observer> userList;
	private ArrayList<String> jobs;
	public HeadHunter() {
		userList = new ArrayList<Observer>();
		jobs = new ArrayList<String>();
	}
	public void registerObserver(Observer o) {
		userList.add(o);
	}
	public void removeObserver(Observer o) {}
	public void notifyAllObservers() {
		for(Observer o:userList){
			o.update(this);
		}
	}
	public void addJob(String job){
		this.jobs.add(job);
		notifyAllObservers();
	}
	public ArrayList<String> getJobs(){
		return jobs;
	}
	public String toString() {
		return jobs.toString();
	}
}
class JobSeeker implements Observer{
	private String name;
	public JobSeeker(String name) {
		this.name = name;
	}
	public void update(Subject s) {
		System.out.println(this.name + " got notified!");
		System.out.println(s);
	}
}
public class TestObserver {
	public static void main(String[] args) {
		HeadHunter headHunter = new HeadHunter();
		headHunter.registerObserver(new JobSeeker("Mike"));
		headHunter.registerObserver(new JobSeeker("Chris"));
		headHunter.registerObserver(new JobSeeker("Jeff"));
		headHunter.addJob("Google");
		headHunter.addJob("Microsoft");
	}
}
