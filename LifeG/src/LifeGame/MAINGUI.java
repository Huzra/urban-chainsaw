package LifeGame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MAINGUI extends JFrame {

	private JPanel contentPane;
	private World world;
	private Thread World;
	private int Num=50;
	private MAINGUI gui;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MAINGUI frame = new MAINGUI();
					frame.setLocationRelativeTo(null); 
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void getNum(int num)
	{
		this.Num=num;
		synchronized(this)
		{
			notifyAll();
		}
	}
	/**
	 * Create the frame.
	 */
	public MAINGUI() {
		setTitle("Life Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 435, 488);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		this.gui=this;
		Button button = new Button("start");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					world.RandomInitialize(Num);
			}
		});
		menuBar.add(button);
		
		Button button_2 = new Button("Setting");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Setting setting=new Setting(gui);
				setting.setVisible(true);
			}
		});
		menuBar.add(button_2);
		
		Button button_1 = new Button("Exit");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		menuBar.add(button_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		world =new World(20,20);
		World=new Thread(world);
		World.start();
		getContentPane().add(world);
	}

}
