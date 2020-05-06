package vista;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

//import controlador.ControladorChat;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
//import com.toedter.calendar.JDateChooser;
/*
 * crear dependencias de maven*/


@SuppressWarnings("serial")
public class RegistroUsuarioView extends JPanel {	
	private JFrame ventana;
	private JButton btnRegistrar;
	private JButton btnCancelar;
	private JPanel jpanelAnterior;
	private JLabel lblUsuario;
	private JLabel lblClave;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JLabel lblMovil;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtMovil;
	private JTextField txtUsuario;
	private JLabel lblRepite;
	private JPasswordField txtClave;
	private JPasswordField txtClave2;
	private JLabel warningAll;
	private JLabel warningMovil;
	private JLabel warningClave2;
	private JLabel warningExiste;
	private JLabel warningNombre;
	private JLabel warningApellidos;
	private JLabel warningUsuario;
	private JLabel warningClave;
	private JLabel lblNacimiento;
	private JLabel warningDateChooser;
	private JLabel warningExisteMovil;
	private JDateChooser dateChooser;
	private JTextField textField;
	private JLabel lblSaludo;
	
	
	public RegistroUsuarioView(JFrame frame){
		ventana=frame;
		jpanelAnterior = (JPanel) ventana.getContentPane();
		
		setLayout(new BorderLayout());
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		add(tabbedPane, BorderLayout.CENTER);
		
		JPanel datosPersonales = new JPanel ();
		tabbedPane.addTab("Datos Usuario", null, datosPersonales, null);
		GridBagLayout gbl_datosPersonales = new GridBagLayout();
		gbl_datosPersonales.columnWidths = new int[]{30, 0, 0, 0, 0, 0, 0};
		gbl_datosPersonales.rowHeights = new int[]{30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 30, 0, 0, 0, 0, 0, 0};
		gbl_datosPersonales.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_datosPersonales.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		datosPersonales.setLayout(gbl_datosPersonales);
		
		lblNombre = new JLabel("Nombre: ");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 1;
		datosPersonales.add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridwidth = 3;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.gridx = 2;
		gbc_txtNombre.gridy = 1;
		datosPersonales.add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(20);
		
		warningNombre = new JLabel("*");
		warningNombre.setForeground(Color.RED);
		GridBagConstraints gbc_warningNombre = new GridBagConstraints();
		gbc_warningNombre.anchor = GridBagConstraints.WEST;
		gbc_warningNombre.insets = new Insets(0, 0, 5, 0);
		gbc_warningNombre.gridx = 5;
		gbc_warningNombre.gridy = 1;
		datosPersonales.add(warningNombre, gbc_warningNombre);
		
		lblApellidos = new JLabel("Apellidos: ");
		GridBagConstraints gbc_lblApellidos = new GridBagConstraints();
		gbc_lblApellidos.anchor = GridBagConstraints.EAST;
		gbc_lblApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellidos.gridx = 1;
		gbc_lblApellidos.gridy = 2;
		datosPersonales.add(lblApellidos, gbc_lblApellidos);
		
		txtApellidos = new JTextField();
		GridBagConstraints gbc_txtApellidos = new GridBagConstraints();
		gbc_txtApellidos.gridwidth = 3;
		gbc_txtApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_txtApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtApellidos.gridx = 2;
		gbc_txtApellidos.gridy = 2;
		datosPersonales.add(txtApellidos, gbc_txtApellidos);
		txtApellidos.setColumns(20);
		
		warningApellidos = new JLabel("*");
		warningApellidos.setForeground(Color.RED);
		GridBagConstraints gbc_warningApellidos = new GridBagConstraints();
		gbc_warningApellidos.anchor = GridBagConstraints.WEST;
		gbc_warningApellidos.insets = new Insets(0, 0, 5, 0);
		gbc_warningApellidos.gridx = 5;
		gbc_warningApellidos.gridy = 2;
		datosPersonales.add(warningApellidos, gbc_warningApellidos);
		
		lblMovil = new JLabel("Móvil: ");
		GridBagConstraints gbc_lblDni = new GridBagConstraints();
		gbc_lblDni.anchor = GridBagConstraints.EAST;
		gbc_lblDni.insets = new Insets(0, 0, 5, 5);
		gbc_lblDni.gridx = 1;
		gbc_lblDni.gridy = 3;
		datosPersonales.add(lblMovil, gbc_lblDni);
		
		txtMovil = new JTextField();
		GridBagConstraints gbc_txtDNI = new GridBagConstraints();
		gbc_txtDNI.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDNI.insets = new Insets(0, 0, 5, 5);
		gbc_txtDNI.gridx = 2;
		gbc_txtDNI.gridy = 3;
		datosPersonales.add(txtMovil, gbc_txtDNI);
		txtMovil.setColumns(7);
		
		warningMovil = new JLabel("*");
		warningMovil.setForeground(Color.RED);
		GridBagConstraints gbc_warningMovil = new GridBagConstraints();
		gbc_warningMovil.anchor = GridBagConstraints.WEST;
		gbc_warningMovil.insets = new Insets(0, 0, 5, 5);
		gbc_warningMovil.gridx = 3;
		gbc_warningMovil.gridy = 3;
		datosPersonales.add(warningMovil, gbc_warningMovil);
		
		lblUsuario = new JLabel("Usuario: ");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 1;
		gbc_lblUsuario.gridy = 4;
		datosPersonales.add(lblUsuario, gbc_lblUsuario);
		
		txtUsuario = new JTextField();
		GridBagConstraints gbc_txtUsuario = new GridBagConstraints();
		gbc_txtUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_txtUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsuario.gridx = 2;
		gbc_txtUsuario.gridy = 4;
		datosPersonales.add(txtUsuario, gbc_txtUsuario);
		txtUsuario.setColumns(10);
		
		warningUsuario = new JLabel("*");
		warningUsuario.setForeground(Color.RED);
		GridBagConstraints gbc_warningUsurio = new GridBagConstraints();
		gbc_warningUsurio.anchor = GridBagConstraints.WEST;
		gbc_warningUsurio.insets = new Insets(0, 0, 5, 5);
		gbc_warningUsurio.gridx = 3;
		gbc_warningUsurio.gridy = 4;
		datosPersonales.add(warningUsuario, gbc_warningUsurio);
		
		lblNacimiento = new JLabel("Fecha de nacimiento: ");
		GridBagConstraints gbc_lblNacimiento = new GridBagConstraints();
		gbc_lblNacimiento.gridwidth = 2;
		gbc_lblNacimiento.anchor = GridBagConstraints.NORTH;
		gbc_lblNacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_lblNacimiento.gridx = 0;
		gbc_lblNacimiento.gridy = 5;
		datosPersonales.add(lblNacimiento, gbc_lblNacimiento);
		
		dateChooser = new JDateChooser();
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 2;
		gbc_dateChooser.gridy = 5;
		datosPersonales.add(dateChooser, gbc_dateChooser);
		
		warningDateChooser = new JLabel("*");
		warningDateChooser.setForeground(Color.RED);
		GridBagConstraints gbc_warningDateChooser = new GridBagConstraints();
		gbc_warningDateChooser.anchor = GridBagConstraints.WEST;
		gbc_warningDateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_warningDateChooser.gridx = 3;
		gbc_warningDateChooser.gridy = 5;
		datosPersonales.add(warningDateChooser, gbc_warningDateChooser);
		
		lblSaludo = new JLabel("Saludo:");
		GridBagConstraints gbc_lblSaludo = new GridBagConstraints();
		gbc_lblSaludo.insets = new Insets(0, 0, 5, 5);
		gbc_lblSaludo.anchor = GridBagConstraints.EAST;
		gbc_lblSaludo.gridx = 1;
		gbc_lblSaludo.gridy = 6;
		datosPersonales.add(lblSaludo, gbc_lblSaludo);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 6;
		datosPersonales.add(textField, gbc_textField);
		textField.setColumns(10);
		
		warningClave = new JLabel("*");
		warningClave.setForeground(Color.RED);
		GridBagConstraints gbc_warningClave = new GridBagConstraints();
		gbc_warningClave.anchor = GridBagConstraints.WEST;
		gbc_warningClave.insets = new Insets(0, 0, 5, 0);
		gbc_warningClave.gridx = 5;
		gbc_warningClave.gridy = 7;
		datosPersonales.add(warningClave, gbc_warningClave);
		
		lblClave = new JLabel("Clave: ");
		GridBagConstraints gbc_lblClave = new GridBagConstraints();
		gbc_lblClave.anchor = GridBagConstraints.EAST;
		gbc_lblClave.insets = new Insets(0, 0, 5, 5);
		gbc_lblClave.gridx = 1;
		gbc_lblClave.gridy = 7;
		datosPersonales.add(lblClave, gbc_lblClave);
		
		txtClave = new JPasswordField();
		txtClave.setColumns(10);
		GridBagConstraints gbc_txtClave = new GridBagConstraints();
		gbc_txtClave.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtClave.insets = new Insets(0, 0, 5, 5);
		gbc_txtClave.gridx = 2;
		gbc_txtClave.gridy = 7;
		datosPersonales.add(txtClave, gbc_txtClave);
		
		lblRepite = new JLabel("Repite: ");
		GridBagConstraints gbc_lblRepite = new GridBagConstraints();
		gbc_lblRepite.anchor = GridBagConstraints.EAST;
		gbc_lblRepite.insets = new Insets(0, 0, 5, 5);
		gbc_lblRepite.gridx = 3;
		gbc_lblRepite.gridy = 7;
		datosPersonales.add(lblRepite, gbc_lblRepite);
		
		txtClave2 = new JPasswordField();
		txtClave2.setColumns(10);
		GridBagConstraints gbc_txtClave2 = new GridBagConstraints();
		gbc_txtClave2.insets = new Insets(0, 0, 5, 5);
		gbc_txtClave2.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtClave2.gridx = 4;
		gbc_txtClave2.gridy = 7;
		datosPersonales.add(txtClave2, gbc_txtClave2);
		
		btnRegistrar= new JButton("Registrar");
		GridBagConstraints gbc_btnRegistrar = new GridBagConstraints();
		gbc_btnRegistrar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRegistrar.insets = new Insets(10, 0, 5, 5);
		gbc_btnRegistrar.gridx = 2;
		gbc_btnRegistrar.gridy = 10;
		datosPersonales.add(btnRegistrar, gbc_btnRegistrar);
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkFields()) {
						boolean registrado = false;
						registrado = ControladorChat.getUnicaInstancia().registrarUsuario(
										txtUsuario.getText(),
										new String(txtClave.getPassword()),
										txtNombre.getText()+" "+txtApellidos.getText(),
										txtMovil.getText(),
										dateChooser.getDateFormatString(),
										textField.getText());
						if (registrado) {
							JOptionPane.showMessageDialog(
										ventana,
										"Asistente registrado correctamente.",
										"Registro",
										JOptionPane.INFORMATION_MESSAGE);
							ventana.setContentPane(jpanelAnterior);	
							ventana.setSize(420, 325);
							ventana.setTitle("Login AppChat");	
							ventana.revalidate();
						} else JOptionPane.showMessageDialog(ventana,
								"No se ha podido llevar a cabo el registro.\n",
								"Registro",
								JOptionPane.ERROR_MESSAGE);
				}
			} 
		}); 
		
		btnCancelar= new JButton("Cancelar");
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCancelar.insets = new Insets(10, 0, 5, 5);
		gbc_btnCancelar.gridx = 4;
		gbc_btnCancelar.gridy = 10;
		datosPersonales.add(btnCancelar, gbc_btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.setContentPane(jpanelAnterior);
				ventana.setTitle("Login AppChat");	
				ventana.setSize(20, 325);
				ventana.revalidate();
			}
		});
		
		warningAll = new JLabel("* Las campos indicados son obligatorios");
		warningAll.setForeground(Color.RED);
		GridBagConstraints gbc_warningAll = new GridBagConstraints();
		gbc_warningAll.gridwidth = 3;
		gbc_warningAll.anchor = GridBagConstraints.WEST;
		gbc_warningAll.insets = new Insets(5, 0, 5, 5);
		gbc_warningAll.gridx = 2;
		gbc_warningAll.gridy = 11;
		datosPersonales.add(warningAll, gbc_warningAll);
		
		warningClave2 = new JLabel("* Las dos claves deben coincidir");
		warningClave2.setForeground(Color.RED);
		GridBagConstraints gbc_warningClave2 = new GridBagConstraints();
		gbc_warningClave2.gridwidth = 3;
		gbc_warningClave2.anchor = GridBagConstraints.WEST;
		gbc_warningClave2.insets = new Insets(0, 0, 5, 5);
		gbc_warningClave2.gridx = 2;
		gbc_warningClave2.gridy = 12;
		datosPersonales.add(warningClave2, gbc_warningClave2);
		
		warningExiste = new JLabel("* El usuario ya existe");
		warningExiste.setForeground(Color.RED);
		GridBagConstraints gbc_warningExiste = new GridBagConstraints();
		gbc_warningExiste.gridwidth = 3;
		gbc_warningExiste.anchor = GridBagConstraints.WEST;
		gbc_warningExiste.insets = new Insets(0, 0, 5, 5);
		gbc_warningExiste.gridx = 2;
		gbc_warningExiste.gridy = 13;
		datosPersonales.add(warningExiste, gbc_warningExiste);
		
		warningExisteMovil = new JLabel("* El número de móvil ya está registrado");
		warningExisteMovil.setForeground(Color.RED);
		GridBagConstraints gbc_warningExisteMovil = new GridBagConstraints();
		gbc_warningExisteMovil.gridwidth = 3;
		gbc_warningExisteMovil.anchor = GridBagConstraints.WEST;
		gbc_warningExisteMovil.insets = new Insets(0, 0, 5, 5);
		gbc_warningExisteMovil.gridx = 2;
		gbc_warningExisteMovil.gridy = 14;
		datosPersonales.add(warningExisteMovil, gbc_warningExisteMovil);
		
		ocultarErrores();
		ventana.setContentPane(this);

		ventana.revalidate(); /*redibujar con el nuevo JPanel*/
		ventana.repaint();
				
	} /*constructor*/
	
	/**
	 * Comprueba que los campos de registro estan bien
	 */
	private boolean checkFields() {
		boolean ok=true;
//		/*borrar todos los errores en pantalla*/
		ocultarErrores();

		if (txtNombre.getText().trim().isEmpty()) {
			warningNombre.setVisible(true); 
			ok=false;
		}
		if (txtApellidos.getText().trim().isEmpty()) {
			warningApellidos.setVisible(true); 
			ok=false;
		}

		if (txtMovil.getText().trim().isEmpty()) {
			warningMovil.setVisible(true); 
			ok=false;
		}
		
		if (txtUsuario.getText().trim().isEmpty()) {
			warningUsuario.setVisible(true); 
			ok=false;
		}
		
		Date date;
		date = dateChooser.getDate();
		if (date==null) {
			warningDateChooser.setVisible(true);
			ok=false;
		}
		
		String password = new String(txtClave.getPassword());
		String password2 = new String(txtClave2.getPassword());
		
		if (password.equals("")) {
			warningClave.setVisible(true); 
			ok=false;
		} 
		if (!ok) warningAll.setVisible(true);
		
		if (ok && !password.equals(password2)) {
			warningClave.setVisible(true);
			warningClave2.setVisible(true);
			ok=false;
		}
//		/* Comprobar que no exista otro usuario con igual login */
		if (ControladorChat.getUnicaInstancia().existeUsuario(txtUsuario.getText())) {
			warningExiste.setVisible(true); 
			ok=false;		
		}
		
		if (ControladorChat.getUnicaInstancia().existeUsuarioPorMovil(txtMovil.getText())) {
			warningExisteMovil.setVisible(true); 
			ok=false;		
		}
		return ok;
	}
	
	/**
	 * Oculta todos los errores que pueda haber en la pantalla
	 */
	private void ocultarErrores() {
		warningAll.setVisible(false);
		warningNombre.setVisible(false);
		warningApellidos.setVisible(false);
		warningClave.setVisible(false);
		warningClave2.setVisible(false);
		warningExiste.setVisible(false);
		warningMovil.setVisible(false);
		warningUsuario.setVisible(false);
		warningDateChooser.setVisible(false);
		warningExisteMovil.setVisible(false);
	}
}