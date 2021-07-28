package net.klott.event;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Main extends JFrame implements ActionListener {

	
	private static final long serialVersionUID = 7569475361020095813L;
	
	private JButton bpusher = new JButton("Appuyez deux fois !");
	String t1Annex = "Entrez votre nom !";
	JTextField t1 = new JTextField(t1Annex);
	JButton b1 = new JButton("Valider");
	JTextField search = new JTextField("Recherche..");
	boolean bpusherType = false;
	
	static Main method = new Main();
   boolean txtType = true;
	
	public JPanel generateRightPanel() {
		JPanel panel = new JPanel( new GridLayout(2, 1)); 
		
		
		
		
		
		
		
		b1.setPreferredSize(new Dimension(150, 30));
		t1.setPreferredSize(new Dimension(120, 40));
		
		panel.add(t1);
		panel.add(b1);
		
		return panel;
	}
	public JPanel generateStatusBar() {
		Dimension sD /*statusDimensions*/ = new Dimension(120, 30);
		JPanel statusBar = new JPanel( new FlowLayout()); 
		
		JLabel status1 = new JLabel ("Maquette Swing !");
		status1.setPreferredSize(sD);
		
		JLabel status2 = new JLabel("v0.1 !");
		
		statusBar.add(status1);
		statusBar.add(status2);
		
		return statusBar;
	}
	
	private JToolBar generateToolBar () { 
		
		JMenuItem ex1 = new JMenuItem("Exemple1");
		JMenuItem ex2 = new JMenuItem("Exemple2");
		JMenuItem ex3 = new JMenuItem("Exemple3");
		JMenuItem ex4 = new JMenuItem("Exemple4");
		
		JMenuBar bar = new JMenuBar();
		
		JToolBar toolBar = new JToolBar();
		JMenu files = new JMenu("Fichiers");
		JMenu edits = new JMenu("Edition");
		JMenu display = new JMenu("Affichage");
		JMenu help = new JMenu("Aide");
	
		search.setPreferredSize(new Dimension(140, 30));
		
		
		
		files.add(ex1);
		bar.add(files);
		
		
		edits.add(ex2);
		bar.add(edits);
		display.add(ex3);
		bar.add(display);
		help.add(ex4);
		bar.add(help);
		toolBar.add(bar);
		toolBar.add(search);
		
		
		
		
		return toolBar;
		
	}
	


	public Main() {
		super("Maquette Swing - HideInBush"); 
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
		setSize(720, 240);	
		setLocationRelativeTo(null);	
	
		
		JPanel content = (JPanel) getContentPane();
		content.setLayout(new BorderLayout());		
		

		
		
		bpusher.addActionListener(this);
		
		content.add( generateToolBar(), BorderLayout.BEFORE_FIRST_LINE);
		content.add(bpusher, BorderLayout.CENTER);
		content.add(generateRightPanel(), BorderLayout.EAST);
		content.add(generateStatusBar(), BorderLayout.SOUTH);
		
		search.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				search.setText(null);
			}
		});
		
		
		t1.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getSource() == t1) {
					t1.setText(null);
				txtType = false;
				}
				
			}
		});
		
		b1.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Thread th = new Thread(new Runnable() {

					@Override
					public void run() {
						
						
						JFrame frame = new JFrame();
						if(txtType == false) {
							String tf = t1.getText();
							JOptionPane.showMessageDialog(frame, "Votre nom est : "+tf+" !");
							
							txtType = true;
							t1.setText(t1Annex);
							
							return;
						}else {
							if(txtType == true) {
								JOptionPane.showMessageDialog(frame, "Vous n'avez communiqué aucun nom !");
								
								return;
							}
						}
						
					}});
				
				th.start();
				
				
				
				
			};
			
			
		});
		 													
		 													
	}
	
	
	
	
	public static void main(String[] args) throws Exception {
		
		UIManager.setLookAndFeel(new NimbusLookAndFeel()); 
		
		
		method.setVisible(true); 
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource() == bpusher){
			
			bpusher.addMouseListener(new MouseAdapter() {
				
				@Override
				public void mouseClicked(MouseEvent e) {
					
					if(bpusherType == false) {
					bpusher.setForeground(Color.RED);
					bpusherType = true;
					}else {
						if(bpusherType == true) {
							bpusher.setForeground(Color.BLACK);
							bpusherType = false;
						}
					}
				}
			
		
	});

	
}
		
		
	}

}
