package com.tingcream.helloSpringBoot2.model;


import org.springframework.stereotype.Service;

/**
 * 玩家对象
 */
@Service
public class Player {
	 

	public  String getWelcomeMsg(String name){
		return "欢迎您:"+name+"，欢迎参加石头、剪刀、布的游戏!!!";
	}
	
}
