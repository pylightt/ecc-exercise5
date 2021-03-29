package xyz.merccurion;

import java.util.Scanner;
import java.util.Random;
import java.io.*;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		try {
		String menu;
		do {
		GetSetInput set = new GetSetInput();
		GetSetInput get = new GetSetInput();

		set.setFilePath();

		// get dimensions
		set.setRowInput();
		set.setColInput();

		// table data
		TableData table = new TableData();
		table.resetTable();
		table.keyValue();
		table.writeToFile();
		table.printTable();

		// get menu input
		set.setMenu();
		Menu choose = new Menu();
		menu = get.getMenu();

		switch (menu){
			case "search":
				choose.menuSearch();
				break;

			case "edit":
				choose.menuEdit();
				break;

			case "print":
				table.printTable();
				break;

			case "add row":
				choose.menuAddRow();
				break;

			case "sort":
				choose.menuSortRow();
				break;

			case "reset":
				break;

			case "exit":
				choose.menuExit();
				break;
			default:
				choose.menuDefault();
		}
		}
		while (menu.equals("reset"));
		} catch (Exception e) {
			System.out.println("Invalid input.");
			e.printStackTrace();
		}
	}
}