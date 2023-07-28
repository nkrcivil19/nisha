 package max.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import max.ParentsClass;
import max.Utility.ConnecctionUtility;
import max.bean.Child;
import max.bean.Father;
import max.dto.ChildDTO;
import max.dto.FatherDTO;

public class ParentsDAO {
	public void viewDeatilshhh()
	{
		
	}
	
	
	public ParentsClass viewDeatils()
	{
		Connection con = ConnecctionUtility.getDulal();
		List<FatherDTO> flist=new ArrayList<FatherDTO>();
		List<ChildDTO> clist=new ArrayList<ChildDTO>();
		
		try {
			PreparedStatement ps = con.prepareStatement("select * from fmst");
			//ps.setInt(1, fid);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				FatherDTO fdto = new FatherDTO();
				fdto.setFid(rs.getInt(1));
				fdto.setName(rs.getString(2));
				fdto.setPhone(rs.getString(3));
				flist.add(fdto);
			}
			if(flist.size()>0)
			{
				ps=con.prepareStatement("select * from cmst");
				//ps.setInt(1, fid);
				 ResultSet q = ps.executeQuery();
				 while(q.next())
				 {
					ChildDTO cdto = new ChildDTO();
					cdto.setCid(q.getInt(1));
					cdto.setName(q.getString(2));
					cdto.setGndr(q.getString(3));
					cdto.setFid(q.getInt(4));
					clist.add(cdto);
				 }
			}
			
			ParentsClass p=new ParentsClass();
			p.setFlist(flist);
			p.setClist(clist);
			return p;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	
public boolean insertParentsDetails(Father f, List<Child> list)
{
	Connection con = ConnecctionUtility.getDulal();
	  
	  
	try {
   con.setAutoCommit(false);
PreparedStatement ps = con.prepareStatement("insert into fmst values (?,?,?)");
int uid=ConnecctionUtility.getUnique(con);
   int cid=uid;
if(uid>0)
   {
	  ps.setInt(1, uid);
	  ps.setString(2, f.getName());
	  ps.setString(3, f.getPhone());
	  int i=ps.executeUpdate();
	    if(i>0)
	    {
	    	ps=con.prepareStatement("insert into cmst values (?,?,?,?)");
	    	for(Child p:list)
	    	{
	       ps.setInt(1, ++cid);
	       ps.setString(2, p.getName());
	       ps.setString(3, p.getGndr());
	       ps.setInt(4, uid);
	      ps.addBatch();
	      // ps.executeUpdate();
	    	}
	    	int[] k = ps.executeBatch();
	       if(k.length>0)
	       {
	    	   con.commit();
	    	   return true;
	       }
	       else
	       {
	    	   con.rollback();
	       }
	    	}
	    }
	    
	} catch (Exception e) {
		try {
			con.rollback();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		e.printStackTrace();
	}
	finally
	{
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return false;
}
}


