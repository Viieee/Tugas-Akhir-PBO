import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CGMoveABall extends JFrame{
	private static final int CANVAS_WIDTH=400,CANVAS_HEIGHT=140;
	private int x=CANVAS_WIDTH/2-20,y=CANVAS_HEIGHT/2-20,radius=40;
	private JButton atas,kanan,kiri,bawah,blank,kananAtas,kananBawah,kiriAtas,kiriBawah,changeColor,changeBackground;
	private Color warnaObjek=Color.RED,warnaBackground=Color.GREEN;
	private JPanel panelBtn, panelChanger;
	private DrawCanvas canvas;
	
	
	public CGMoveABall() {
		// Setting panel
		Container container=getContentPane();
		panelBtn=new JPanel(new GridLayout(3,3,3,3));
		panelChanger=new JPanel(new GridLayout(1,1,1,1));
		canvas=new DrawCanvas();
		canvas.setPreferredSize(new Dimension(CANVAS_WIDTH,CANVAS_HEIGHT));
    
		//setting button
		btnListener listener=new btnListener();
		keyListener key=new keyListener();
		atas=new JButton("Keatas");
		bawah=new JButton("Kebawah");
		kiri=new JButton("Kekiri");
		kanan=new JButton("Kekanan");
		blank=new JButton();
		kananAtas=new JButton("Kekanan Atas");
		kananBawah=new JButton("Kekanan Bawah");
		kiriAtas=new JButton("Kekiri Atas");
		kiriBawah=new JButton("Kekiri Bawah");
		atas.addActionListener(listener);
		atas.addKeyListener(key);
		bawah.addActionListener(listener);
		bawah.addKeyListener(key);
		kiri.addActionListener(listener);
		kiri.addKeyListener(key);
		kanan.addActionListener(listener);
		kanan.addKeyListener(key);
		kananAtas.addActionListener(listener);
		kananAtas.addKeyListener(key);
		kananBawah.addActionListener(listener);
		kananBawah.addKeyListener(key);
		kiriAtas.addActionListener(listener);
		kiriAtas.addKeyListener(key);
		kiriBawah.addActionListener(listener);
		kiriBawah.addKeyListener(key);
		panelBtn.add(kiriAtas);
		panelBtn.add(atas);
		panelBtn.add(kananAtas);
		panelBtn.add(kiri);
		panelBtn.add(blank);
		panelBtn.add(kanan);
		panelBtn.add(kiriBawah);
		panelBtn.add(bawah);
		panelBtn.add(kananBawah);
    
		//Changer
		changeColor=new JButton("Rubah warna objek");
		changeBackground=new JButton("Rubah warna background");
		panelChanger.add(changeColor);
		panelChanger.add(changeBackground);
		changeColor.addActionListener(listener);
		changeBackground.addActionListener(listener);
		
		container.add(canvas,BorderLayout.NORTH);
		container.add(panelBtn,BorderLayout.CENTER);
		container.add(panelChanger,BorderLayout.SOUTH);
		
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setTitle("Moving Object UAS");
	}
	private class DrawCanvas extends JPanel{
		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			setBackground(warnaBackground);
			g.setColor(warnaObjek);
			g.fillOval(x, y, radius, radius);
		}
	}
	private class btnListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String baca=e.getActionCommand();
			if(baca.equals("Keatas")) {
				y-=5;
			}
			else if(baca.equals("Kebawah")) {
				y+=5;
			}
			else if(baca.equals("Kekiri")) {
				x-=5;
			}
			else if(baca.equals("Kekanan")) {
				x+=5;
				
			}
			else if(baca.equals("Kekanan Atas")) {
				x+=5;
				y-=5;
			}
			else if(baca.equals("Kekanan Bawah")) {
				x+=5;
				y+=5;
				
			}
			else if(baca.equals("Kekiri Atas")) {
				x-=5;
				y-=5;
				
			}
			else if(baca.equals("Kekiri Bawah")) {
				x-=5;
				y+=5;
				
			}
			else if (baca.equals("Rubah warna objek")) {
				Color color=JColorChooser.showDialog(CGMoveABall.this, "Pilih Warna", warnaObjek);
				if(color!=null) {
					warnaObjek=color;
				}
			}
			else if(baca.equals("Rubah warna background")) {
				Color color=JColorChooser.showDialog(CGMoveABall.this, "Pilih Warna", warnaBackground);
				if(color!=null) {
					warnaBackground=color;
				}
			}
			repaint();
		}
	}
	
	private class keyListener implements KeyListener{

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			int key = e.getKeyCode();
			if (key == KeyEvent.VK_UP) {
				y-=5;
			} else if (key == KeyEvent.VK_DOWN) {
				y+=5;
			} else if (key == KeyEvent.VK_RIGHT) {
				x+=5;
			} else if (key == KeyEvent.VK_LEFT) {
				x-=5;
			}else if(key== KeyEvent.VK_UP&&key==KeyEvent.VK_RIGHT) {
				y-=5;
				x+=5;
			}else if(key== KeyEvent.VK_UP&&key==KeyEvent.VK_LEFT) {
				y-=5;
				x-=5;
			}else if(key== KeyEvent.VK_DOWN&&key==KeyEvent.VK_RIGHT) {
				y+=5;
				x+=5;
			}else if(key== KeyEvent.VK_DOWN&&key==KeyEvent.VK_LEFT) {
				y+=5;
				x-=5;
			}
			repaint();
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				CGMoveABall apps=new CGMoveABall();
			}
		});
	}
	
}

