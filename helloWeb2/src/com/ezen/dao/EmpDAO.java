package com.ezen.dao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.ezen.vo.EmpVO;

public class EmpDAO {
	
	private static String path = "C:/Users/fille/OneDrive/바탕 화면/java/emp.txt";
	
	public List<EmpVO> getList(){
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
		
			String line = null;	//한 행씩 저장하는 문자열
			List<EmpVO> list = new ArrayList<>();
			
			while((line = br.readLine())!= null) {
				String[] info = line.split(" ");
				EmpVO emp = new EmpVO(Integer.valueOf(info[0]),info[1],info[2],info[3]);
				list.add(emp);
			}
			br.close();
			return list;
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public EmpVO getEmp(String sNum) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line = null;
			
			while((line=br.readLine())!=null) {
				String[] info = line.split(" ");
				if(info[0].equals(sNum)) {// EmpVO의 equals 활용 변경
					br.close();
					return new EmpVO(Integer.valueOf(info[0]),info[1],info[2],info[3]);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean delete(String sNum) {
		//getList()와 동일
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
		
			String line = null;	//한 행씩 저장하는 문자열
			List<EmpVO> list = new ArrayList<>();
			
			while((line = br.readLine())!= null) {
				String[] info = line.split(" ");
				EmpVO emp = new EmpVO(Integer.valueOf(info[0]),info[1],info[2],info[3]);
				list.add(emp);		//한사람한사람의 정보를 list에 담아둠.
			}
			br.close();
			
			//삭제 코드 핵심
			EmpVO empToDel = new EmpVO(Integer.valueOf(sNum));
			if(list.remove(empToDel)) {		// remove는 boolean 값을 return. true or false
				return overwrite(list);		//메모리 상에 있는 list 를 overwrite 하라.
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	private boolean overwrite(List<EmpVO> list) {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(EmpDAO.path));		//ture라고 붙이면 append : 이어쓰기.그냥 쓸경우 덮어쓰기.
			for(int i=0; i<list.size(); i++) {
				pw.println(list.get(i));
			}
			pw.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(EmpVO key) {
		//파일에서 로드하면서 동일객체를 검색, setPhone(),setEmail() 호출
		//로드된 리스트 데이터를 기존 파일에 덮어쓰기
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			
			String line = null;
			List<EmpVO> list = new ArrayList<>();
			
			while((line=br.readLine())!= null) {
				EmpVO emp = new EmpVO(line.split(" "));
				if(emp.equals(key)) {
					emp.setPhone(key.getPhone());
					emp.setEmail(key.getEmail());
				}
				list.add(emp);
			}
			br.close();
			return overwrite(list);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean add(EmpVO emp) {
		System.out.println("dao:"+emp);
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(EmpDAO.path,true));
			pw.println(emp);
		//	pw.flush();
			pw.close();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
