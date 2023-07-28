package cl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import max.bean.Child;
import max.bean.Father;
import max.dao.ParentsDAO;

public class ParentsCL {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		 Father f = new Father();
		  
		  List<Child> list=new ArrayList<Child>();
		System.out.println("Enter Father Name");
		String fn = s.nextLine();
		f.setName(fn);
		System.out.println("enter Phone");
		String fp = s.nextLine();
		f.setPhone(fp);
		while(true)
		{
			 Child ch = new Child();
			System.out.println("Enter Child Details");
			System.out.println("Child Name");
			String cn = s.nextLine();
			 ch.setName(cn);
			System.out.println("Child Gndr");
			String cg = s.nextLine();
			ch.setGndr(cg);
			System.out.println("Y/N");
			list.add(ch);
			String yn = s.nextLine();
			
			if(yn.equalsIgnoreCase("N"))
			{
				break;
			}
		}
		
		ParentsDAO parentsDAO=new ParentsDAO();
		if(parentsDAO.insertParentsDetails(f, list))
		{
			System.out.println("Successss");
		}
		else
		{
			System.out.println("Faillll");
		}
		
	}
}




