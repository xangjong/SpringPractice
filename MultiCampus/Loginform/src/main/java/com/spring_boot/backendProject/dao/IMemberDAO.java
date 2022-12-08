package com.spring_boot.backendProject.dao;

import java.util.HashMap;

public interface IMemberDAO {
	String loginCheck(HashMap<String, Object> map);
}
