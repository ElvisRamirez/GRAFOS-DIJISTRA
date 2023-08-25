package modeloDeVistaGrafo;

import java.awt.Frame;


import javax.swing.JOptionPane;
import mundo.Grafo;
import mundo.Lienzo;

	public class EliminarArista extends javax.swing.JFrame {
		
		int i;

		   Grafo grafos = new Grafo();  
		 //CREACION DE MARCO DE ELIMINACION DE ARISTAS
		public void R_repaint(){
		        for (int j = 0; j < i; j++) {
		            for (int k = 0; k < i; k++) {
		                if(grafos.getmAdyacencia(j, k) == 1)
		                Lienzo.pintarLinea(GraficadorGrafoFrame.jPanel1.getGraphics(),grafos.getCordeX(j),grafos.getCordeY(j), grafos.getCordeX(k), grafos.getCordeY(k),grafos.getmCoeficiente(j, k));
		            }
		        }
		        for (int j = 0; j < i; j++) {
		            Lienzo.pintarCirculo(GraficadorGrafoFrame.jPanel1.getGraphics(), grafos.getCordeX(j),grafos.getCordeY(j),String.valueOf(grafos.getNombre(j)));
		           
		       }
		   }
		 Lienzo pintar ;
		      ///Grafo grafos ;
		      Frame frame;
		    public EliminarArista(Lienzo pinta , Grafo grafo ,int ii, Frame fram) {
		        initComponents();
		        i=ii;
		        this.pintar =pinta;
		       this.grafos=grafo;
		       frame = fram;
		    }

		  
		    @SuppressWarnings("unchecked")
		 
		    private void initComponents() {

		        jPanel1 = new javax.swing.JPanel();
		        n1 = new javax.swing.JTextField();
		        n2 = new javax.swing.JTextField();
		        jLabel1 = new javax.swing.JLabel();
		        jLabel2 = new javax.swing.JLabel();
		        jButton1 = new javax.swing.JButton();

		        setTitle(":Eliminr:");
		        setPreferredSize(new java.awt.Dimension(159, 343));
		        setResizable(false);
		        addWindowListener(new java.awt.event.WindowAdapter() {
		            public void windowClosing(java.awt.event.WindowEvent evt) {
		                formWindowClosing(evt);
		            }
		        });
		        getContentPane().setLayout(null);

		        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Eliminar arista de ruta"));
		        jPanel1.setLayout(null);

		        n1.addActionListener(new java.awt.event.ActionListener() {
		            public void actionPerformed(java.awt.event.ActionEvent evt) {
		                n1ActionPerformed(evt);
		            }
		        });
		        n1.addKeyListener(new java.awt.event.KeyAdapter() {
		            public void keyPressed(java.awt.event.KeyEvent evt) {
		                n1KeyPressed(evt);
		            }
		            public void keyReleased(java.awt.event.KeyEvent evt) {
		                n1KeyReleased(evt);
		            }
		        });
		        jPanel1.add(n1);
		        n1.setBounds(100, 30, 30, 20);

		        n2.addActionListener(new java.awt.event.ActionListener() {
		            public void actionPerformed(java.awt.event.ActionEvent evt) {
		                n2ActionPerformed(evt);
		            }
		        });
		        n2.addKeyListener(new java.awt.event.KeyAdapter() {
		            public void keyReleased(java.awt.event.KeyEvent evt) {
		                n2KeyReleased(evt);
		            }
		        });
		        jPanel1.add(n2);
		        n2.setBounds(100, 60, 30, 20);

		        jLabel1.setText("Nodo Origen:  ");
		        jPanel1.add(jLabel1);
		        jLabel1.setBounds(10, 30, 110, 14);

		        jLabel2.setText("Nodo Destino:::");
		        jPanel1.add(jLabel2);
		        jLabel2.setBounds(10, 60, 100, 14);

		        getContentPane().add(jPanel1);
		        jPanel1.setBounds(10, 10, 150, 90);

		        jButton1.setText("Eliminar");
		        jButton1.addActionListener(new java.awt.event.ActionListener() {
		            public void actionPerformed(java.awt.event.ActionEvent evt) {
		                jButton1ActionPerformed(evt);
		            }
		        });
		        getContentPane().add(jButton1);
		        jButton1.setBounds(30, 110, 90, 23);

		        setBounds(60, 130, 182, 179);
		    }

		    private void n1ActionPerformed(java.awt.event.ActionEvent evt) {
		        
		    }

		    private void n1KeyPressed(java.awt.event.KeyEvent evt) {
		    }

		    private void n1KeyReleased(java.awt.event.KeyEvent evt) {
		        String tem = new String(n1.getText());
		        StringBuffer tem2= new StringBuffer();
		        for (int j = 0; j < tem.length(); j++) {
		            if(Character.isDigit(tem.charAt(j))){
		                tem2.append(tem.charAt(j));
		            }
		        }
		        n1.setText(""+tem2);
		    }

		    private void n2KeyReleased(java.awt.event.KeyEvent evt) {
		        String tem = new String(n2.getText());
		        StringBuffer tem2= new StringBuffer();
		        for (int j = 0; j < tem.length(); j++) {
		            if(Character.isDigit(tem.charAt(j))){
		                tem2.append(tem.charAt(j));
		            }
		        }
		        n2.setText(""+tem2);      
		    }

		    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		        int x;int y;int ta;
		        if(n1.getText().length()<1 || n2.getText().length()<1 )
		        JOptionPane.showMessageDialog(null,"ERROR.. FALTAN DATOS : ");
		        else{
		            x=Integer.parseInt(n1.getText());
		            y=Integer.parseInt(n2.getText());
		           

		            if(x==y)
		            JOptionPane.showMessageDialog(null,"ERROR.. DEBE DIGITAR DIFERENTE NODO RUTA : "+y);
		            else if(x<0 || x>=i || y<0 || y>=i){
		                JOptionPane.showMessageDialog(null,"ERROR.. NODO RUTA NO VALIDO ");
		            }else{
		                grafos.setmAdyacencia(x, y, 0);
		                grafos.setmAdyacencia(y, x, 0);
		                grafos.setmCoeficiente(x, y, 0);
		                grafos.setmCoeficiente(y, x, 0);
		                n1.setText(null);
		                n2.setText(null);
		                GraficadorGrafoFrame.jPanel1.paint(GraficadorGrafoFrame.jPanel1.getGraphics());
		                
		               R_repaint();

		            }
		        }
		    }

		    private void n2ActionPerformed(java.awt.event.ActionEvent evt) {
		    }

		    private void formWindowClosing(java.awt.event.WindowEvent evt) {
		      frame.setEnabled(true); 
		    }


		    
		    // DECLARACION DE VARIABLES
		    private javax.swing.JButton jButton1;
		    private javax.swing.JLabel jLabel1;
		    private javax.swing.JLabel jLabel2;
		    private javax.swing.JPanel jPanel1;
		    private javax.swing.JTextField n1;
		    private javax.swing.JTextField n2;
		
		 
		}
	
