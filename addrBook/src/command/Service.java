package command;

import java.util.ArrayList;
import javax.servlet.http.*;
import dto.AddrBookDto;

public interface Service {
	public ArrayList<AddrBookDto> execute(HttpServletRequest request, HttpServletResponse response);
}
