package LifeGame;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Setting extends JFrame{

	private JPanel contentPane;
	private JTextField textField;



	/**
	 * Create the frame.
	 */
	public Setting(MAINGUI gui) {
		setTitle("\u968F\u673A\u751F\u6210\u6D3B\u7EC6\u80DE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 299);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 2, 10, 10));
		setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setVgap(25);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("\u521D\u59CB\u6D3B\u7EC6\u80DE\u4E2A\u6570(0-400)\uFF1A");
		panel_1.add(lblNewLabel);
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setVgap(25);
		contentPane.add(panel_2);
		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str=textField.getText();
				try{
					   int num=Integer.parseInt(str);
					   if(num<0||num>400) 
					          throw new NumberFormatException();
					   gui.getNum(num);
					   dispose();
					  }catch(NumberFormatException e){
						  JOptionPane.showMessageDialog(null, "Êý×ÖÒì³£");
					  }

			}
		});
		panel_2.add(button);
	}

}
