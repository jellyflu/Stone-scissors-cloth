package com.tingcream.helloSpringBoot2;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.tingcream.helloSpringBoot2.model.Computer;
import com.tingcream.helloSpringBoot2.model.Judger;
import com.tingcream.helloSpringBoot2.model.Player;


//@SpringBootApplication
@SpringBootConfiguration
//@EnableAutoConfiguration  //不使用自动配置特性
@ComponentScan
public class SpringBootApp  implements CommandLineRunner {
	
	
	 public static void main(String[] args) throws Exception {

	        SpringApplication.run(SpringBootApp.class, args);

	  }
   
	 
	  @Autowired
	  private  Player player ;//玩家
	  
	  @Autowired
	  private Computer computer;//电脑
	  
	  @Autowired
	  private Judger judger;//裁判
	  
	  
	  /**
	   * 石头、剪刀、布的游戏 
	   * 
	   */
	@Override
	public void run(String... args) throws Exception {
 
		 System.out.println("请输入玩家名字 :");
		Scanner scanner=null;
		 try {
			scanner =new Scanner(System.in);
			String welcomeMsg = player.getWelcomeMsg(scanner.nextLine().trim());
			
			while(true){
				System.out.println("========开始游戏========");
				System.out.println(welcomeMsg);//打印欢迎信息
				System.out.println("请玩家出拳(0石头、1剪刀、2布,按q键可退出游戏):");
				
				String input =scanner.nextLine().trim();
				if(input.equalsIgnoreCase("q")){
					System.out.println("游戏退出");
					return  ;
				}
				 int inputA=-1;
				 try {
					 inputA = Integer.valueOf(input.trim());
				 	if(inputA!=0 && inputA!=1 && inputA!=2){
				 		 System.out.println("输入非法，请重新输入,比赛重新开始");
				 		 continue;
				 	} 
				 	
				 } catch (NumberFormatException e) {
				    System.out.println("输入非法，请重新输入，比赛重新开始！");
					continue ;
				 }catch(Exception e ){
					 System.out.println("程序异常终止！");
					 return ;
				 }
				
				 int inputB = computer.getNextGesture();//电脑出拳 
				 System.out.println("你出的是:"+computer.getGestureName(inputA)+",电脑出的是:"+computer.getGestureName(inputB));
				 
				String result = judger.judge(inputA, inputB);//比赛结果
				System.out.println("比赛结果:"+result);//打印比赛结果
			}
			
		} finally{
			if(scanner!=null){
				scanner.close();
			}
		}
		
		 
		
	}

}
