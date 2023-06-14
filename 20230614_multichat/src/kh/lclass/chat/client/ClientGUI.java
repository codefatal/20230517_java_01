package kh.lclass.chat.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class ClientGUI extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JTextArea jta = new JTextArea(10, 25); // 채팅창
	private JScrollPane jsp = new JScrollPane(jta);
	private JTextField jtf = new JTextField(25); // 글 입력 부분
	
	private String nickname; // 클라이언트 닉네임
	private ClientBackground cb = new ClientBackground(); // 채팅 socket 기능을 담당할 객체 
	
	public ClientGUI(String nickname, String ip) {
		// 생성자에서는 초기화(즉 화면 초기화)
		this.nickname = nickname;
		
		setBounds(200, 100, 400, 600);
		setTitle("IP : "+ip+" / 닉네임 : "+nickname+"님의 창");
		jta.setEditable(false);
		jta.setFont(new Font("맑은고딕", Font.PLAIN, 18));
		jta.setBackground(new Color(255, 255, 255));
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
//		add(jta, BorderLayout.CENTER);
		add(jsp, BorderLayout.CENTER);
		add(jtf, BorderLayout.SOUTH);
		jtf.addActionListener(this);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		cb.setNickname(nickname);
		cb.setGui(this);
		cb.connection(ip);
		
	}
	
	public void appendMsg(String msg) {
		jta.append(msg+"\n");
		jta.setCaretPosition(jta.getDocument().getLength());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String msg = jtf.getText();
//		appendMsg(msg);
		jtf.setText("");
		cb.sendMsg(nickname+" >> "+msg);
	}
	
}
