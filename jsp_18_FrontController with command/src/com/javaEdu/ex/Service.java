package com.javaEdu.ex;

import java.util.*;

import javax.servlet.http.*;

public interface Service {
	public ArrayList<MemberDto> execute(HttpServletRequest request, HttpServletResponse response);
}
