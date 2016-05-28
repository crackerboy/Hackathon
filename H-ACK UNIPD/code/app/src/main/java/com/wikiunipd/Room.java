/*
 * Copyright (c) 2015. Created by PopUp Team. All right Reserved
 */

package com.wikiunipd;

public class Room implements Comparable{
	//functions
	public Room(int kind, String name, String school, String address, int floor, String link, int seats){
		this.kind = kind;
		this.name = name;
		this.school = school;
		this.address = address;
		this.floor = floor;
		this.link = link;
		this.seats = seats;
	}

	//comparison
	public int compareTo(Object other_room){
		if(((Room) other_room).name.compareTo(this.name) == 0 && ((Room) other_room).address.compareTo(this.address) == 0 && ((Room) other_room).floor == (this.floor)){
			return 0;
		}else{
			return -1;
		}
	}

	public int compareTo(Room other_room, sortingMethods SORTBY){
		if(SORTBY == sortingMethods.NAME){
			//sorting alphabetically
			return this.name.compareTo(other_room.name);
		}else if(SORTBY == sortingMethods.SEATS){
			//sorting basing on #seats
			return (this.seats) - (other_room.seats);
		}else{
			//sorting basing on distance
			return 0;
		}
	}

	//get data
	public int getKind(){
		return this.kind;
	}

	public String getName(){
		return this.name;
	}

	public String getSchool(){
		return this.school;
	}

	public String getAddress(){
		return this.address;
	}

	public int getFloor(){
		return this.floor;
	}

	public String getLink(){
		return this.link;
	}

	public int getSeats(){
		return this.seats;
	}


	public double[] getScore(){
		return this.score;
	}

	public double getAvgScore() {

		double partial_sum = 0.0;
		for ( int index = 0; index < this.score.length; index++) {

			partial_sum += this.score[index];
		}

		this.avgScore = partial_sum/this.score.length;
		return partial_sum/this.score.length;
	}

	public double getDistance(){
		return this.distance;
	}

	public String getDrivingIstr(){
		return this.driving_istr;
	}

	public String getHours(){
		return this.hours;
	}

	public String getFacilities(){
		return this.facilities;
	}

	public String[] getComments(){
		return this.comments;
	}

	public double getLatitude() {
		return this.latitude;
	}

	public double getLongitude() {

		return this.longitude;
	}

	public int getImage() {

		return this.image;
	}

	//set data
	public void setKind(int kind){
		this.kind = kind;
	}

	public void setName(String name){
		this.name = name;
	}

	public void setSchool(String school){
		this.school = school;
	}

	public void setAddress(String address){
		this.address = address;
	}

	public void setFloor(int floor){
		this.floor = floor;
	}

	public void setLink(String link){
		this.link = link;
	}

	public void setSeats(int seats){
		this.seats = seats;
	}

	public void setScore(double[] score){
		this.score = score;
	}

	public void setDistance(double distance){
		this.distance = distance;
	}

	public void setDrivingIstr(String driving_istr){
		this.driving_istr = driving_istr;
	}

	public void setHours(String hours){
		this.hours = hours;
	}

	public void setFacilities(String facilities){
		this.facilities = facilities;
	}

	public void setComments(String[] comments){
		this.comments = comments;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(double longitude) {

		this.longitude = longitude;

	}

	public void setImage(int image) {

		this.image = image;
	}

	//parameters
	private int kind;
	private String name;
	private String school;
	private String address;
	private int floor;
	private String link;
	private int seats;
	private double[] score;
	private double distance;
	private String driving_istr;
	private String hours;
	private String facilities;
	private String[] comments;
	private double avgScore;
	private double latitude;
	private double longitude;
	private int image;

	public enum sortingMethods {NAME, SEATS, DISTANCE};
}