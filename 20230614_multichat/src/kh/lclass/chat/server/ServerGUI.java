package kh.lclass.chat.server;

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

public class ServerGUI extends JFrame implements ActionListener {
	// 컴파일 시 인식할 객체 고유 ID
	private static final long serialVersionUID = 1L;
	private JTextArea jta = new JTextArea(10,20);
	private JScrollPane jsp = new JScrollPane(jta);
	private JTextField jtf = new JTextField(25);
	private ServerBackground sb = new ServerBackground();
	
	public ServerGUI() {
		
		setBounds(1000, 100, 400, 600);
		setTitle("서버창");
		jta.setEditable(false); // 채팅창은 입력되지 않도록 함
		jta.setFont(new Font("맑은고딕", Font.PLAIN, 18)); // 글자 폰트, 크기
		jta.setBackground(new Color(255, 255, 255));
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
//		add(jta, BorderLayout.CENTER);
		add(jsp, BorderLayout.CENTER);
		add(jtf, BorderLayout.SOUTH);
		jtf.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		sb.setGui(this);
		sb.setting();
	}
	
	// TODO 새 메시지를 받았을때 메소드 호출됨
	public void appendMsg(String msg) {
		// jta(채팅창)에 msg를 추가함.
		jta.append(msg+"\n");
		jta.setCaretPosition(jta.getDocument().getLength());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String msg = jtf.getText();
		appendMsg(msg);
		sb.sendMsg(msg);
		jtf.setText(""); // 입력창 입력된 글을 초기화
	}
	
		
	
}
