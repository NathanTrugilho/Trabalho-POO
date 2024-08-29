package model;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MyFirstFrame extends JFrame {

	public MyFirstFrame() {
		// Configurações do JFrame
		setTitle("Minha Primeira Janela");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		// Adicionando um botão
		JButton btnClickMe = new JButton("Clique Aqui");
		btnClickMe.setBackground(new Color(0, 0, 0));
		btnClickMe.setForeground(new Color(220, 138, 221));
		btnClickMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Botão clicado!");
			}
		});
		btnClickMe.setBounds(150, 100, 100, 30);
		getContentPane().add(btnClickMe);
	}

	public static void main(String[] args) {
		// Criando a janela
		MyFirstFrame frame = new MyFirstFrame();
		frame.setVisible(true);
	}
}
