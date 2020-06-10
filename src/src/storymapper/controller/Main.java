package src.storymapper.controller;

/**
 * Entry point to the RPG Story Mapper program
 * 
 * @author Hodge
 * @version 6.10.2020
 */

public class Main {

	public static void main(String[] args) throws Exception {
		System.out.println("Hello World");
        MySQLAccess dao = new MySQLAccess();
        dao.readDataBase();
	}

}
