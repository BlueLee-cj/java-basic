package com.example.lcj.spring.bean.AutowiringCollaborators;

public class AutoService {
	DmzService service;
	public void setService(DmzService dmzService){
		System.out.println("注入dmzService"+dmzService);
		service = dmzService;
	}
	public void print() {
		System.out.println(service);
	}
}