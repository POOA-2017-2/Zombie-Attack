package juego.ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import juego.elementos.Marcador;
import juego.elementos.Serializadora;
import juego.game.JuegoCliente;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;

import javax.swing.SwingConstants;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class VentanaDeRangos extends JFrame {

	private JPanel contentPane;

	// private DefaultListModel<Marcador> p;

	private JuegoCliente juegoC;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaDeRangos frame = new VentanaDeRangos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaDeRangos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 805, 453);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Zombie Attack _ Rangos");// coloca el titulo a la ventana
		setIconImage(new ImageIcon(getClass().getResource("/imagenes/Zombie-icon.png")).getImage());

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JButton btnRegresar = new JButton("REGRESAR");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnRegresar.setBackground(new Color(255, 140, 0));
		btnRegresar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRegresar.setBounds(668, 381, 121, 23);
		panel.add(btnRegresar);

		JLabel lblFondo = new JLabel("");
		lblFondo.setHorizontalAlignment(SwingConstants.CENTER);
		lblFondo.setIcon(new ImageIcon(VentanaDeRangos.class.getResource("/imagenes/EnemY2.png")));
		lblFondo.setBounds(460, 0, 329, 383);
		panel.add(lblFondo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 24, 461, 359);
		panel.add(scrollPane);

		final JList list = new JList();
		scrollPane.setViewportView(list);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

			}
		});
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {

				//
			}
		});
		scrollPane.setViewportView(list);// barra espaciadora

		/*
		 * try { FileInputStream file = new
		 * FileInputStream("PuntajesFinales.txt"); ObjectInputStream ois = new
		 * ObjectInputStream(file); // p = (p) ois.readObject(); file.close();
		 * ois.close();
		 * 
		 * } catch (Exception e2) { // TODO Auto-generated catch block
		 * e2.printStackTrace(); }
		 * 
		 * list.setModel(p);
		 */
	}
}
