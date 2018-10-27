package com.mypro.basecomponet;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import com.mypro.mainsurface.MainSurface;
import com.mypro.manager.CannonManager;
import com.mypro.manager.GameInitManager;
import com.mypro.manager.LayoutManager;
import com.mypro.model.GamingInfo;

public class AwtMainComponet{
	public static void main(String[] args) throws Exception  {
		// Toolkit类 调用getDefaultToolkit() 获取默认工具包，Toolkit类 可以访问操作系统，可以将各种组件绑定到特定本机工具包实现。
		Toolkit tool = Toolkit.getDefaultToolkit();
		// Dimension类 封装单个对象中 组件的宽度和高度（精确到整数），该类与组件的某个属性相关。
		Dimension d = tool.getScreenSize();
		// JFrame类  是一个容器，提供一个内容窗格 
		JFrame frame = new JFrame();
		// 先导入GamingInfo类， 然后调用其中的 getGamingInfo() 判断需要单例模式操作，然后调用其中的 setGaming() 判断处于游戏状态
        GamingInfo.getGamingInfo().setGaming(true);
        // GamingInfo类 调用getGamingInfo() 判断需要单例模式操作，然后调用setScreenWidth() 设置游戏界面宽度
        GamingInfo.getGamingInfo().setScreenWidth(900);
        //...... 调用setScreenHeight()  设置游戏界面高度
    	GamingInfo.getGamingInfo().setScreenHeight(600);  
    	//设置 容器 的尺寸大小：宽度：与游戏界面宽度相等，高度：与游戏界面高度相等
    	frame.setSize(GamingInfo.getGamingInfo().getScreenWidth(), GamingInfo.getGamingInfo().getScreenHeight());
    	//设置窗口不要装饰
    	frame.setUndecorated(true);
    	//frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE); //采用指定的窗口装饰风格
    	//设置窗口不能被用户调整大小
    	frame.setResizable(false);
    	
    	//设置窗口默认关闭方式
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置窗口相对于指定组件的位置，指定组件为设置  null, 窗口居于屏幕中央
		frame.setLocationRelativeTo(null);
		//创建一个修改图层元素的类 的对象
		MainSurface pane = new MainSurface();
		//判读单例模式操作，然后设置游戏主要图层
		GamingInfo.getGamingInfo().setSurface(pane);
		//设置内容窗格的显示内容
		frame.setContentPane(pane);
		//frame.setAlwaysOnTop(true);		//设置此窗口是否始终位于其他窗口上方
		frame.setVisible(true);
		frame.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {				
			}
			public void mousePressed(MouseEvent e) {
				//游戏初始化管理器
				if(GameInitManager.getGameInitManager().isIniting()){
					return ;
				}
				//鼠标点击
				//先看布局管理器是否有相应
				if(!LayoutManager.getLayoutManager().onClick(e.getX(), e.getY())){
					//发射子弹
					CannonManager.getCannonManager().shot(e.getX(),  e.getY());
				}
			}
			
			public void mouseExited(MouseEvent e) {				
			}
			
			public void mouseEntered(MouseEvent e) {				
			}
			
			public void mouseClicked(MouseEvent e) {				
			}
		});
//		frame.pack();
		pane.action();
		/**
    	 * 创建一个线程来异步初始化游戏内容
    	 */
    	new Thread(new Runnable(){
			public void run() {
				//使用游戏初始化管理器初始化游戏
				GameInitManager.getGameInitManager().init();
			}
    	}).start();  	
	}

}
