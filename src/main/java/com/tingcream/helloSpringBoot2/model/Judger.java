package com.tingcream.helloSpringBoot2.model;

import org.springframework.stereotype.Component;

/**
 * 裁判对象 ，判定玩家vs电脑的胜负
 * @author jelly
 *
 */
@Component
public class Judger {
	
	/**
	 * 判定胜负  
	 * 
	 *    石头、剪刀、布   
	 *    0   1   2 
	 *    
	 *   游戏规则：  0胜1  ，1胜2 ,2胜利 0,数字相同则平局
	 * 
	 * @param a  玩家出拳
	 * @param b  电脑出拳
	 * @return
	 */
	public String judge(int a ,int b ){
		if(a==b){
			return "平局";
		}
		if(a==2 && b==0){
			return "恭喜，您获得了胜利";
		} 
		if(a-b==-1){
			return "恭喜，您获得了胜利";
		}else {
			return "抱歉，您输了，请再接再厉";
		}
	}
	

}
