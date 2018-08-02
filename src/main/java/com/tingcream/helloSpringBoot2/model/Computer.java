package com.tingcream.helloSpringBoot2.model;

import java.util.Random;

import org.springframework.stereotype.Component;
 

/**
 * 电脑对象 
 *
 */
@Component
public class Computer {
	 
	private Random random =new Random();
	
	
	 /**
	  * 电脑  随机出拳
	  * @return
	  */
	public int  getNextGesture(){
	   return 	random.nextInt(3);//0  1  2 
	}
	
	/**
	 * 根据手势代号获取手势名称
	 * @param code
	 * @return
	 */
	public  String  getGestureName(int  code){
		switch(code){
		  case 0:
			return "石头";
		  case 1:
			  return "剪刀";
		  case 2:
			  return "布";
		  default:
			  return "未知";
		}
	}

}
