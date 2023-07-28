package max;

import java.util.List;

import max.dto.ChildDTO;
import max.dto.FatherDTO;

public class ParentsClass {
	List<FatherDTO> flist;
	List<ChildDTO> clist;
	public List<FatherDTO> getFlist() {
		return flist;
	}
	public void setFlist(List<FatherDTO> flist) {
		this.flist = flist;
	}
	public List<ChildDTO> getClist() {
		return clist;
	}
	public void setClist(List<ChildDTO> clist) {
		this.clist = clist;
	}
	
}

