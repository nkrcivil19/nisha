package View;

import java.util.List;

import javax.swing.JList;

import max.ParentsClass;
import max.dao.ParentsDAO;
import max.dto.ChildDTO;
import max.dto.FatherDTO;

public class ViewCL {
	public static void main(String[] args) {
		ParentsDAO p=new ParentsDAO();
		ParentsClass pdtails = p.viewDeatils();
		List<FatherDTO> flist = pdtails.getFlist();
		  List<ChildDTO> clist = pdtails.getClist();
		  for(FatherDTO f:flist)
		  {    System.out.println("-----------Father Details-------");
			  System.out.println(f.getFid()+" "+f.getName()+" "+f.getPhone());
			  System.out.println("-----Child Details-----");
			  for(ChildDTO c:clist)
			  {
				  
				  if(c.getFid()==f.getFid())
				  {
			     
				  System.out.println(c.getCid()+" "+c.getName()+" "+c.getGndr());
				  }
			  }
		  }
	}
}






