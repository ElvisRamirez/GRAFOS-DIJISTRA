package modeloDeVistaGrafo;

import java.awt.Color;




import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import mundo.Lienzo;
import mundo.Grafo;
import modelo.grafo.dijkstra.AlgoritmoCaminoMinimo;
public class GraficadorGrafoFrame extends javax.swing.JFrame {
	
	
   
   Lienzo pintar =new Lienzo();
   Grafo grafos = new Grafo();    
   public static void R_repaint(int tope, Grafo grafos){//pinta lo q esta antes en el panel 
        for (int j = 0; j < tope; j++) {
            for (int k = 0; k < tope; k++) {
                if(grafos.getmAdyacencia(j, k) == 1)
                     Lienzo.pintarLinea(jPanel1.getGraphics(),grafos.getCordeX(j),grafos.getCordeY(j), grafos.getCordeX(k), grafos.getCordeY(k),grafos.getmCoeficiente(j, k));
            }
        }
        for (int j = 0; j < tope; j++) 
            Lienzo.pintarCirculo(jPanel1.getGraphics(), grafos.getCordeX(j),grafos.getCordeY(j),String.valueOf(grafos.getNombre(j)));
                
   }
 
   public static int ingresarNodoOrigen(String nodoOrige, String noExiste, int tope) {
	    int nodoOrigen = 0;
	    try {
	        String input = JOptionPane.showInputDialog("" + nodoOrige);
	        if (input == null) {  // Si se presiona Cancelar
	            nodoOrigen = -1;   // Valor especial para indicar cancelación
	        } else {
	            nodoOrigen = Integer.parseInt(input);
	            if (nodoOrigen >= tope) {
	                JOptionPane.showMessageDialog(null, "" + noExiste + "\nSe debe ingresar un nodo existente ");
	                nodoOrigen = ingresarNodoOrigen(nodoOrige, noExiste, tope);
	            }
	        }
	    } catch (Exception ex) {
	        nodoOrigen = ingresarNodoOrigen(nodoOrige, noExiste, tope);
	    }
	    return nodoOrigen;
	}

 public  int ingresarTamano(String tama){        
        int tamano = 0;
        try{
            tamano = Integer.parseInt(JOptionPane.showInputDialog(""+tama));
            if(tamano<1){ JOptionPane.showMessageDialog(null,"El tamaño minimo es 1");
               tamano = ingresarTamano(tama);//no es nesario hacer esto
            }
        }catch(Exception ex){
            tamano = ingresarTamano(tama);
        }
        return tamano;
    }
 public boolean cicDerechoSobreNodo(int xxx,int yyy){ 
     for (int j = 0; j < tope; j++) {// consultamos si se ha sado  click sobre algun nodo 
            if((xxx+2) > grafos.getCordeX(j) && xxx < (grafos.getCordeX(j)+13) && (yyy+2) > grafos.getCordeY(j) && yyy<(grafos.getCordeY(j)+13) ) {
                                       
               if(n==0){
                   id = j;
                   R_repaint(tope,grafos);
                   Lienzo.clickSobreNodo(jPanel1.getGraphics(), grafos.getCordeX(j), grafos.getCordeY(j), null,Color.orange);       
                   n++;                   
               }
               else{ 
                   id2=j;                   
                   n++;
                   Lienzo.clickSobreNodo(jPanel1.getGraphics(), grafos.getCordeX(j), grafos.getCordeY(j), null,Color.orange);       
                   if(id==id2){// si id == id2 por q se volvio a dar click sobre el mismos nodo, se cancela el click anterio
                       n=0;
                       Lienzo.pintarCirculo(jPanel1.getGraphics(),grafos.getCordeX(id), grafos.getCordeY(id),String.valueOf(grafos.getNombre(id)));
                       id=-1;
                       id2=-1;
                   }
               } 
               nn=0;
                return true;              
            }
         }
     return false;
 }  
 public void clicIzqSobreNodo(int xxx, int yyy){
            for (int j = 0; j <tope; j++) {
              if((xxx+2) > grafos.getCordeX(j) && xxx < (grafos.getCordeX(j)+13) && (yyy+2) > grafos.getCordeY(j) && yyy<(grafos.getCordeY(j)+13) ) {
                if(nn==0){
                   permanente =j; 
                   R_repaint(tope, grafos);                   
               }
               else{ nodoFin = j;}
                nn++;
                n=0;
                id =-1;
                Lienzo.clickSobreNodo(jPanel1.getGraphics(), grafos.getCordeX(j), grafos.getCordeY(j), null,Color.GREEN);  
                   break;
               }
           
            }
            
     
 }
 public void adactarImagen(File file){
  try{   
 
        BufferedImage read = ImageIO.read(file);
        Image scaledInstance = read.getScaledInstance(jmapa.getWidth(),jmapa.getHeight(), Image.SCALE_DEFAULT);
      
 jmapa.setIcon(new ImageIcon(scaledInstance));  
 }catch(Exception ex){
               JOptionPane.showMessageDialog(null,"No se pudo cargar la imagen");
       }
 }
         

    public GraficadorGrafoFrame() {
    	getContentPane().setBackground(Color.WHITE); 
        initComponents();
        jPanel2.setVisible(false);   
        jDialog1.setLocationRelativeTo(null);
        
    }    
    @SuppressWarnings("unchecked")
   
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jFileChooser2 = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jmapa = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton1.setBackground(new Color(0, 153, 153));
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        new javax.swing.JLabel();
        new javax.swing.JPanel();
        jtacumulado = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuBar1.setBackground(new Color(0, 153, 153));
        jMenu1 = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem13 = new javax.swing.JMenuItem();
        new javax.swing.JMenuItem();
        new javax.swing.JPopupMenu.Separator();
        new javax.swing.JMenuItem();
        new javax.swing.JPopupMenu.Separator();
        new javax.swing.JMenuItem();
        new javax.swing.JMenuItem();
        new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        new javax.swing.JMenuItem();

        jDialog1.setMaximumSize(new java.awt.Dimension(700, 450));
        jDialog1.setMinimumSize(new java.awt.Dimension(700, 450));
        jDialog1.setPreferredSize(new java.awt.Dimension(700, 450));
        jDialog1.setResizable(false);
        jDialog1.getContentPane().setLayout(null);

        jFileChooser2.setMaximumSize(new java.awt.Dimension(21475, 21474));
        jFileChooser2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooser2ActionPerformed(evt);
            }
        });
        jDialog1.getContentPane().add(jFileChooser2);
        jFileChooser2.setBounds(10, 20, 670, 390);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Grafo General - Proyecto de Estructura de Datos");
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(252, 252, 252));////////////////////////
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 102, 102)));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 600));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel1MouseMoved(evt);
            }
        });
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPanel1KeyReleased(evt);
            }
        });
        jPanel1.setLayout(null);
        jPanel1.add(jmapa);
        jmapa.setBounds(10, 10, 750, 500);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(210, 10, 770, 520);

     
        jButton2.setBackground(new java.awt.Color(0, 0, 0));//Color de
        jButton2.setForeground(new java.awt.Color(153, 153, 0));
        jButton2.setBorder(javax.swing.BorderFactory.createMatteBorder(40, 40, 40, 40, new java.awt.Color(102, 255, 255)));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton2MouseReleased(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(10, 10, 20, 20);

        jButton3.setBackground(new java.awt.Color(204, 0, 204));
        jButton3.setForeground(new java.awt.Color(153, 153, 0));
        jButton3.setBorder(javax.swing.BorderFactory.createMatteBorder(40, 40, 40, 40, new java.awt.Color(102, 255, 255)));
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton3MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton3MouseReleased(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(40, 10, 20, 20);

        jButton4.setBackground(new java.awt.Color(189, 182, 182));
        jButton4.setForeground(new java.awt.Color(153, 153, 0));
        jButton4.setBorder(javax.swing.BorderFactory.createMatteBorder(40, 40, 40, 40, new java.awt.Color(102, 255, 255)));
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton4MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton4MouseReleased(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);
        jButton4.setBounds(100, 10, 20, 20);

        jButton5.setBackground(new java.awt.Color(51, 0, 51));
        jButton5.setForeground(new java.awt.Color(153, 153, 0));
        jButton5.setBorder(javax.swing.BorderFactory.createMatteBorder(40, 40, 40, 40, new java.awt.Color(102, 255, 255)));
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton5MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton5MouseReleased(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5);
        jButton5.setBounds(10, 40, 20, 20);

        jButton6.setBackground(java.awt.Color.lightGray);
        jButton6.setForeground(new java.awt.Color(153, 153, 0));
        jButton6.setBorder(javax.swing.BorderFactory.createMatteBorder(40, 40, 40, 40, new java.awt.Color(102, 255, 255)));
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton6MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton6MouseReleased(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6);
        jButton6.setBounds(40, 40, 20, 20);

        jButton7.setBackground(new java.awt.Color(164, 167, 255));
        jButton7.setForeground(new java.awt.Color(153, 153, 0));
        jButton7.setBorder(javax.swing.BorderFactory.createMatteBorder(40, 40, 40, 40, new java.awt.Color(102, 255, 255)));
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton7MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton7MouseReleased(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton7);
        jButton7.setBounds(70, 70, 20, 20);

        jButton8.setBackground(new java.awt.Color(141, 141, 141));
        jButton8.setForeground(new java.awt.Color(153, 153, 0));
        jButton8.setBorder(javax.swing.BorderFactory.createMatteBorder(40, 40, 40, 40, new java.awt.Color(102, 255, 255)));
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton8MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton8MouseReleased(evt);
            }
        });
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton8);
        jButton8.setBounds(100, 40, 20, 20);

        jButton9.setBackground(new java.awt.Color(0, 0, 255));
        jButton9.setForeground(new java.awt.Color(153, 153, 0));
        jButton9.setBorder(javax.swing.BorderFactory.createMatteBorder(40, 40, 40, 40, new java.awt.Color(102, 255, 255)));
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton9MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton9MouseReleased(evt);
            }
        });
        jPanel2.add(jButton9);
        jButton9.setBounds(100, 70, 20, 20);

        jButton10.setBackground(new java.awt.Color(153, 0, 0));
        jButton10.setForeground(new java.awt.Color(153, 153, 0));
        jButton10.setBorder(javax.swing.BorderFactory.createMatteBorder(40, 40, 40, 40, new java.awt.Color(102, 255, 255)));
        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton10MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton10MouseReleased(evt);
            }
        });
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton10);
        jButton10.setBounds(70, 10, 20, 20);

        jButton11.setBackground(new java.awt.Color(0, 102, 102));
        jButton11.setForeground(new java.awt.Color(153, 153, 0));
        jButton11.setBorder(javax.swing.BorderFactory.createMatteBorder(40, 40, 40, 40, new java.awt.Color(102, 255, 255)));
        jButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton11MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton11MouseReleased(evt);
            }
        });
        jPanel2.add(jButton11);
        jButton11.setBounds(40, 70, 20, 20);

        jButton12.setBackground(java.awt.Color.white);
        jButton12.setForeground(new java.awt.Color(153, 153, 0));
        jButton12.setBorder(javax.swing.BorderFactory.createMatteBorder(40, 40, 40, 40, new java.awt.Color(102, 255, 255)));
        jButton12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton12MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton12MouseReleased(evt);
            }
        });
        jPanel2.add(jButton12);
        jButton12.setBounds(70, 40, 20, 20);

        jButton13.setBackground(new java.awt.Color(0, 51, 51));
        jButton13.setForeground(new java.awt.Color(153, 153, 0));
        jButton13.setBorder(javax.swing.BorderFactory.createMatteBorder(40, 40, 40, 40, new java.awt.Color(102, 255, 255)));
        jButton13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton13MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton13MouseReleased(evt);
            }
        });
        jPanel2.add(jButton13);
        jButton13.setBounds(10, 70, 20, 20);

        jButton14.setText("Ok");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton14);
        jButton14.setBounds(30, 100, 60, 23);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(40, 40, 130, 130);

        
        jMenu1.setText("Opciones");
        jMenu1.add(jSeparator1);

        
        jMenuItem13.setText("Camino Minimo");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        
        jMenu1.add(jMenuItem13);
        jMenuItem4.setText("Grafo de Redes: ");
        jMenuItem4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem4MousePressed(evt);
            }
        });
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);
        jMenuItem6.setText("Cargar fondo");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);
        jMenuItem1.setText("Nuevo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenu1.add(jSeparator5);
        jMenu1.setText("Opciones: ");

        jMenuItem10.setText("Eliminar nodo ruta");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem10);

        
        jMenuItem9.setText("Elimina arista ruta");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem9);

   
        jMenuItem11.setText("Eliminar todas las aristas de ruta");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem11);

        jMenuBar1.add(jMenu2);

        
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);
      
        jMenuItem8.setText("Salir");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JOptionPane.showMessageDialog(null,""+"\nGRACIAS POR SU ATENCION ");
                jMenuItem8ActionPerformed(evt);
               
            }
        });
        jMenu1.add(jMenuItem8);

        jMenuBar1.add(jMenu1);
        setSize(new Dimension(1200, 700));
        setLocationRelativeTo(null);
    }

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {
       int xxx, yyy;   
       xxx=evt.getX();
       yyy=evt.getY();
       if(evt.isMetaDown()){
           clicIzqSobreNodo(xxx, yyy );            
          if(nn==2){
              nn=0;
               AlgoritmoCaminoMinimo Dijkstra = new AlgoritmoCaminoMinimo(grafos,tope,permanente, nodoFin);
               Dijkstra.dijkstra();
               jtacumulado.setText(""+Dijkstra.getAcumulado());
               
           }
       }
       else{
       if(!cicDerechoSobreNodo(xxx,yyy)){// si  clik sobre  nodo es falso entra
          if(tope<50){
               grafos.setCordeX(tope,xxx);
               grafos.setCordeY(tope,yyy);
               grafos.setNombre(tope, tope);
             Lienzo.pintarCirculo(jPanel1.getGraphics(),grafos.getCordeX(tope), grafos.getCordeY(tope),String.valueOf(grafos.getNombre(tope)));
           tope++;          
          } 
         else JOptionPane.showMessageDialog(null,"ESTA AL LIMITE DE LOS NODOS RUTAS");
       } 
         if(n==2 ){
             n=0; 
             int  ta = ingresarTamano("Digite la velocidad");
             if(aristaMayor < ta) aristaMayor=ta;
             grafos.setmAdyacencia(id2, id, 1);
             grafos.setmAdyacencia(id, id2, 1);
             grafos.setmCoeficiente(id2, id,ta );
             grafos.setmCoeficiente(id, id2, ta);
             Lienzo.pintarLinea(jPanel1.getGraphics(),grafos.getCordeX(id), grafos.getCordeY(id), grafos.getCordeX(id2), grafos.getCordeY(id2), ta); 
             Lienzo.pintarCirculo(jPanel1.getGraphics(),grafos.getCordeX(id), grafos.getCordeY(id),String.valueOf(grafos.getNombre(id)));
             Lienzo.pintarCirculo(jPanel1.getGraphics(),grafos.getCordeX(id2), grafos.getCordeY(id2),String.valueOf(grafos.getNombre(id2)));
              id=-1;
              id2=-1;
         }
        }
    }

    private void jMenuItem4MousePressed(java.awt.event.MouseEvent evt) {

    }
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {
        
        jPanel1.paint(jPanel1.getGraphics()); 
         n=0;
         id=-1;
         id2=-1;
            int Matriz[][]={{0,1,0,1,1,0,0,1},
                            {1,0,1,0,0,0,0,0},
                            {0,1,0,1,1,0,0,0},
                            {1,0,1,0,0,0,0,0},
                            {1,0,1,0,0,1,0,0},
                            {0,0,0,0,1,0,1,1},
                            {0,0,0,0,0,1,0,0},
                            {1,0,0,0,0,1,0,0}
                           };
          int coe[][]={{0,50,0,46,216,0,0,578}, 
               {50,0,59,0,0,0,0,0}, 
               {0,59,0,89,174,0,0,0},
               {46,0,89,0,0,0,0,0},
               {216,0,174,0,0,471,0,0} ,
               {0,0,0,0,471,0,194,398},  
               {0,0,0,0,0,194,0,0}, 
               {578,0,0,0,0,398,0,0},
  
  };
   int xx1[]={202,102,8,198,248,352,481,416};
  int yy1[]={12,74,165,113,233,300,368,177};
  int nom[]={0,1,2,3,4,5,6,7};          
        aristaMayor=600;       
        for (int j = 0; j < 8; j++) {
            grafos.setCordeX(j, xx1[j]);
            grafos.setCordeY(j, yy1[j]);
            grafos.setNombre(j, nom[j]);      
         
        }
        for (int j = 0; j < 8; j++) {            
            for (int k = 0; k < 8; k++) {
                grafos.setmAdyacencia(j,k, Matriz[j][k]);
                grafos.setmCoeficiente(j, k, coe[j][k]); 
            }
        }        
       tope=8;       
        R_repaint(tope,grafos);
    }

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {
        
    }

    private void jPanel1KeyReleased(java.awt.event.KeyEvent evt) {
     
    }

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {
       System.exit(0);
    }

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {
      
         
          for (int j = 0; j < tope; j++) {
              grafos.setCordeX(j,0);
              grafos.setCordeY(j,0);              
              grafos.setNombre(j,0);            
        }
         for (int j = 0; j < tope; j++) {
             for (int k = 0; k < tope; k++) {
                 grafos.setmAdyacencia(j, k, 0);
                 grafos.setmCoeficiente(j, k, 0);                 
             }            
        }
        tope=00;   
        jPanel1.repaint(); 
       
    }

    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {
     
    }

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {
    if(tope>=2){
        this.setEnabled(false);
      new EliminarArista(pintar,grafos,tope,this).setVisible(true);
      jPanel1.paint(jPanel1.getGraphics());
      R_repaint(tope,grafos); 
    }
    else  JOptionPane.showMessageDialog(null,"No hay nodos enlazados");
    
    }

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {
      int Eliminar= ingresarNodoOrigen("Digite el nodo a eliminar ","No existe nodo",tope); 
 if(Eliminar<=tope && Eliminar>=0 && tope>0){
        for (int j = 0; j < tope; j++) {
            for (int k = 0; k < tope; k++){
                if(j==Eliminar ||k==Eliminar){
                    grafos.setmAdyacencia(j, k, -1);                    
                }
            }
        }
        for (int l = 0; l < tope-1; l++) {
                    for (int m = 0; m < tope; m++) {
                      if(grafos.getmAdyacencia(l, m)==-1){
                           grafos.setmAdyacencia(l, m,grafos.getmAdyacencia(l+1, m)); 
                           grafos.setmAdyacencia(l+1, m,-1);
                           grafos.setmCoeficiente(l, m,grafos.getmCoeficiente(l+1, m));
                      }
                  }
                }
                for (int l = 0; l < tope; l++) {
                    for (int m = 0; m < tope-1; m++) {
                
                     if(grafos.getmAdyacencia(l, m)==-1){
                           grafos.setmAdyacencia(l, m,grafos.getmAdyacencia(l, m+1)); 
                           grafos.setmAdyacencia(l, m+1,-1);
                           grafos.setmCoeficiente(l, m,grafos.getmCoeficiente(l, m+1));
                          
                     }
                    }
                }
                
                grafos.setCordeX(Eliminar,-10);
                grafos.setCordeY(Eliminar,-10);
                grafos.setNombre(Eliminar, -10);
                for (int j = 0; j < tope; j++) {
                    for (int k = 0; k < tope-1; k++) {
                        if(grafos.getCordeX(k)==-10){
                            grafos.setCordeX(k, grafos.getCordeX(k+1));
                            grafos.setCordeX(k+1, -10);
                            grafos.setCordeY(k, grafos.getCordeY(k+1));
                             grafos.setCordeY(k+1, -10);
                            grafos.setNombre(k, grafos.getNombre(k+1));
                            grafos.setNombre(k+1,-10);
                        }
                    }
               }
                for (int j = 0; j < tope; j++)                      
                grafos.setNombre(j,j);// renombramos             
                
                // eliminamos los -1 y  los -10 
                for (int j = 0; j < tope+1; j++) {
                    for (int k = 0; k < tope+1; k++) {
                       if( grafos.getmAdyacencia(j, k)!=-1)
                          grafos.setmAdyacencia(j, k, grafos.getmAdyacencia(j, k));
                       else 
                          grafos.setmAdyacencia(j, k, 0);                       
                       if(grafos.getmCoeficiente(j, k) !=-10)
                           grafos.setmCoeficiente(j, k, grafos.getmCoeficiente(j, k));
                       else
                           grafos.setmCoeficiente(j, k, 0);                        
                    }         
                }
                tope--;
                jPanel1.paint(jPanel1.getGraphics());
                R_repaint(tope,grafos);
       }    
    }

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {
       for (int j = 0; j < tope; j++) {
            for (int k = 0; k < tope; k++) {      
                    grafos.setmAdyacencia(j, k, 0);
                    grafos.setmAdyacencia(k, j, 0);
                    grafos.setmCoeficiente(j, k, 0);
                    grafos.setmCoeficiente(k, j, 0);
            }
        }
        jPanel1.paint(jPanel1.getGraphics());
        R_repaint(tope,grafos);
    }

    private void jButton3MousePressed(java.awt.event.MouseEvent evt) {
       jPanel1.setBackground(jButton3.getBackground());
       
    
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {
      
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
   
    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
     
    }

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
      
    }

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
      
    }
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {
    
    }

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {
        jPanel2.setVisible(false);  
    }

    private void jButton4MouseReleased(java.awt.event.MouseEvent evt) {
      R_repaint(tope,grafos);   
    }

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {
      
    }
    private void jButton4MousePressed(java.awt.event.MouseEvent evt) {
       jPanel1.setBackground(jButton4.getBackground());
       
    }

    private void jButton2MousePressed(java.awt.event.MouseEvent evt) {
       jPanel1.setBackground(jButton2.getBackground());
      
    }

    private void jButton2MouseReleased(java.awt.event.MouseEvent evt) {
      R_repaint(tope,grafos);  
    }

    private void jButton3MouseReleased(java.awt.event.MouseEvent evt) {
      R_repaint(tope,grafos);        
    }

    private void jButton10MousePressed(java.awt.event.MouseEvent evt) {
      jPanel1.setBackground(jButton10.getBackground());
      
    }

    private void jButton10MouseReleased(java.awt.event.MouseEvent evt) {
    R_repaint(tope,grafos);      
    }

    private void jButton5MousePressed(java.awt.event.MouseEvent evt) {
     jPanel1.setBackground(jButton5.getBackground());
             
    }

    private void jButton5MouseReleased(java.awt.event.MouseEvent evt) {
    R_repaint(tope,grafos);      
    }

    private void jButton7MousePressed(java.awt.event.MouseEvent evt) {
       jPanel1.setBackground(jButton7.getBackground());
             
    }

    private void jButton7MouseReleased(java.awt.event.MouseEvent evt) {
     R_repaint(tope,grafos);        
    }

    private void jButton8MousePressed(java.awt.event.MouseEvent evt) {
    jPanel1.setBackground(jButton8.getBackground());       
    }

    private void jButton8MouseReleased(java.awt.event.MouseEvent evt) {
     R_repaint(tope,grafos); 
    }

    private void jButton6MousePressed(java.awt.event.MouseEvent evt) {
      jPanel1.setBackground(jButton6.getBackground());  
    }

    private void jButton6MouseReleased(java.awt.event.MouseEvent evt) {
       R_repaint(tope,grafos);        
    }

    private void jButton13MousePressed(java.awt.event.MouseEvent evt) {
      jPanel1.setBackground(jButton13.getBackground());  
    }

    private void jButton11MousePressed(java.awt.event.MouseEvent evt) {
      jPanel1.setBackground(jButton11.getBackground());        
    }

    private void jButton12MouseReleased(java.awt.event.MouseEvent evt) {
       R_repaint(tope,grafos);        
    }

    private void jButton9MousePressed(java.awt.event.MouseEvent evt) {
      jPanel1.setBackground(jButton9.getBackground());     
    }

    private void jButton12MousePressed(java.awt.event.MouseEvent evt) {
       jPanel1.setBackground(jButton12.getBackground()); 
    }

    private void jButton11MouseReleased(java.awt.event.MouseEvent evt) {
       R_repaint(tope,grafos);  
    }

    private void jButton9MouseReleased(java.awt.event.MouseEvent evt) {
     R_repaint(tope,grafos);        
    }

    private void jButton13MouseReleased(java.awt.event.MouseEvent evt) {
       R_repaint(tope,grafos);        
    }

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {
     if(tope>=2){
          permanente =  ingresarNodoOrigen("Nodo Origen: ","NO EXITE EL NODO ORIGEN RUTA",tope);// hacemos el llamano de la funcion         
          nodoFin =  ingresarNodoOrigen("Nodo Destino: ","NO EXISTE EL NODO RUTA FINAL",tope);
            AlgoritmoCaminoMinimo Dijkstra = new AlgoritmoCaminoMinimo(grafos,tope,permanente,nodoFin);
            Dijkstra.dijkstra();
            jtacumulado.setText(""+Dijkstra.getAcumulado());
        }
    else JOptionPane.showMessageDialog(null,"SE DEBE CREAR MAS NODOS RUTAS ");
    }

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {
       
    }

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {
       jDialog1.setVisible(true); 
    }

    private void jFileChooser2ActionPerformed(java.awt.event.ActionEvent evt) {
 
        JFileChooser selectorArchios = (JFileChooser) evt.getSource();
        String comando = evt.getActionCommand();
        if(comando.equals(JFileChooser.APPROVE_SELECTION)){
            File archiSeleccionado = selectorArchios.getSelectedFile();
            adactarImagen(archiSeleccionado);
            jDialog1.setVisible(false);
            
        }
    }

    /**
     * @param args the command line arguments
     */
    //Iniciar la aplicacion
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GraficadorGrafoFrame frame = new GraficadorGrafoFrame();
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    private int tope=0;// lleva el # de nodos creado 
    private int nodoFin;
    private int permanente;
    int n=0,nn=0,id,id2;// permite controlar que se halla dado click sobre un nodo
    private int aristaMayor;
 
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JFileChooser jFileChooser2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JLabel jmapa;
    private javax.swing.JTextField jtacumulado;
}
