package cst8284.genericTable;

import java.util.List;

public class Table {
	
	public static <E extends Comparable<E>> void outputTable(List<E> arList) {
		
		//reference: https://docs.oracle.com/javase/tutorial/java/data/numberformat.html
		System.out.printf("%15s","");
		for (E columnHeader : arList)
			System.out.printf("%-15s",columnHeader);

		// Print out each row,starting with the name of the object
		for (E solidObjRow : arList) {
			System.out.println(); // Next line
			System.out.printf("%-15s",solidObjRow);
			for (E solidObjColumn : arList)
				System.out.printf("%-15s",compareResults(solidObjColumn, solidObjRow));
		}
		System.out.println("\n");
	}
	
	 public static <E extends Comparable<E>> String compareResults(E obj1, E obj2)
	 {
	 
	  return (obj1.compareTo(obj2) == 0) ? "=" : (obj1.compareTo(obj2) > 0) ? ">" :"<"; }

	/*
	 * public static <E extends Comparable<E>> String compareResults(E solidObjColumn, E solidObjRow)
	 * { if(solidObjColumn.compareTo(solidObjRow) > 0)
	 * { return ">"; }
	 * else if(solidObjColumn.compareTo(solidObjRow) < 0 )
	 * { return "<"; } 
	 * else
	 * return "=";
	 * 
	 * }
	 */
	
	
	
}
