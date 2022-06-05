package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
d 
import dao.AddrBookDao;
import dto.AddrBookDto;

public class AddrBookInsertService {

	public AddrBookInsertService() {}
	
	public AddrBookDto execute(HttpServletRequest request, HttpServletResponse response) {
		AddrBookDao dao = AddrBookDao.getInstance();
		return dao.insertAddr(null);
	}
}
