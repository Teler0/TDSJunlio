package vista;


import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controlador.ControladorChat;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class LoginView {

	private JFrame frmLoginAppChat;
	private JTextField textLogin;
	private JPasswordField textPassword;

	/**
	 * Create the application.
	 */
	public LoginView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoginAppChat = new JFrame();
		frmLoginAppChat.setTitle("Login AppChat");
		frmLoginAppChat.setBounds(100, 100, 420, 325);
		frmLoginAppChat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLoginAppChat.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel_center = new JPanel();
		frmLoginAppChat.getContentPane().add(panel_center, BorderLayout.CENTER);
		GridBagLayout gbl_panel_center = new GridBagLayout();
		gbl_panel_center.columnWidths = new int[]{30, 30, 0, 0, 0, 45, 0, 0};
		gbl_panel_center.rowHeights = new int[]{15, 30, 0, 0, 30, 0, 0};
		gbl_panel_center.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_center.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_center.setLayout(gbl_panel_center);
		
		JLabel lblUsuario = new JLabel("Usuario: ");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblUsuario.gridx = 2;
		gbc_lblUsuario.gridy = 2;
		panel_center.add(lblUsuario, gbc_lblUsuario);
		
		textLogin = new JTextField();
		GridBagConstraints gbc_textLogin = new GridBagConstraints();
		gbc_textLogin.gridwidth = 2;
		gbc_textLogin.insets = new Insets(0, 0, 5, 5);
		gbc_textLogin.fill = GridBagConstraints.HORIZONTAL;
		gbc_textLogin.gridx = 3;
		gbc_textLogin.gridy = 2;
		panel_center.add(textLogin, gbc_textLogin);
		textLogin.setColumns(10);
		
		JLabel lblCalve = new JLabel("Clave: ");
		GridBagConstraints gbc_lblCalve = new GridBagConstraints();
		gbc_lblCalve.anchor = GridBagConstraints.EAST;
		gbc_lblCalve.insets = new Insets(0, 0, 5, 5);
		gbc_lblCalve.gridx = 2;
		gbc_lblCalve.gridy = 3;
		panel_center.add(lblCalve, gbc_lblCalve);
		
		textPassword = new JPasswordField();
		GridBagConstraints gbc_textPassword = new GridBagConstraints();
		gbc_textPassword.gridwidth = 2;
		gbc_textPassword.insets = new Insets(0, 0, 5, 5);
		gbc_textPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPassword.gridx = 3;
		gbc_textPassword.gridy = 3;
		panel_center.add(textPassword, gbc_textPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean login;
				login = ControladorChat.getUnicaInstancia().loginUsuario(
						textLogin.getText(), new String(textPassword.getPassword()));
				if (login) {
						AppChatMain window = new AppChatMain();
						window.setVisible(true);
						frmLoginAppChat.dispose();
				} else
						JOptionPane.showMessageDialog(frmLoginAppChat,
								"Nombre de usuario o contrase\u00F1a no válidos",
								"Error", JOptionPane.ERROR_MESSAGE);

			}
		});
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLoginAppChat.dispose(); 
				System.exit(0);  /*no seria necesario en este caso*/
			}
		});
		GridBagConstraints gbc_btnSalir = new GridBagConstraints();
		gbc_btnSalir.gridheight = 2;
		gbc_btnSalir.insets = new Insets(0, 0, 5, 0);
		gbc_btnSalir.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSalir.gridx = 6;
		gbc_btnSalir.gridy = 2;
		panel_center.add(btnSalir, gbc_btnSalir);
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.insets = new Insets(0, 0, 0, 5);
		gbc_btnLogin.gridx = 3;
		gbc_btnLogin.gridy = 5;
		panel_center.add(btnLogin, gbc_btnLogin);
		
		JButton btnRegistro = new JButton("Registro");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLoginAppChat.setTitle("Registro AppChat");	
				frmLoginAppChat.setSize(500, 400);
				new RegistroUsuarioView(frmLoginAppChat);
			}
		});
		btnRegistro.setForeground(Color.BLACK);
		GridBagConstraints gbc_btnRegistro = new GridBagConstraints();
		gbc_btnRegistro.insets = new Insets(0, 0, 0, 5);
		gbc_btnRegistro.gridx = 4;
		gbc_btnRegistro.gridy = 5;
		panel_center.add(btnRegistro, gbc_btnRegistro);
		
		JPanel panel_north = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_north.getLayout();
		flowLayout.setVgap(15);
		frmLoginAppChat.getContentPane().add(panel_north, BorderLayout.NORTH);
		
		JLabel lblAppChat = new JLabel("Entrada de AppChat");
		lblAppChat.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblAppChat.setForeground(Color.BLUE);
		panel_north.add(lblAppChat);
	}
	
	public void mostrarVentana() {
		frmLoginAppChat.setVisible(true);
		
	}

}
