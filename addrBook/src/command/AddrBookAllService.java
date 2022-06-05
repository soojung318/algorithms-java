package command;

import java.util.ArrayList;

import javax.servlet.http.*;

import dao.AddrBookDao;
import dto.AddrBookDto;

public class AddrBookAllService implements Service{
	
	public AddrBookAllService() {}
	
	@Override
	public ArrayList<AddrBookDto> execute(HttpServletRequest request,HttpServletResponse response){
		AddrBookDao dao = AddrBookDao.getInstance();
		return dao.addrBooksAll();
	}
}
