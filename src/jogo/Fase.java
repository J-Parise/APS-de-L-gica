package jogo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Fase extends JPanel implements ActionListener{
    
    private final Image fundo;
    private Nave nave;
    private final Timer timer;
   
    private boolean emJogo;
    
    private List<Enemy> inimigos;
    
    private int[][] coordenadas = {
        {1200, 529}, {1600, 580}, {2000, 489}, {2400, 109},
        {2800, 139}, {3200, 239}, {3600, 259}, {4000, 250},
        {1300, 150}, {1700, 209}, {2100, 345}, {2500, 470},
        {1100, 159}, {1500, 60}, {1900, 460}, {2300, 459},
        {1000, 500}, {1400, 200}, {1800, 259}, {2200, 300},
        {2600, 500}, {2700, 220}, {2900, 200}, {3000, 180},
        {3100, 512}, {3300,100}, {3400, 150}, {3500,500},
        {3600,480}, {3700, 580}, {3800,120}, {3900, 500},
        {4000,120}, {4050,536}, {4100, 500}, {4150,46},        
        {4200, 429}, {4250, 550}, {4300, 460}, {4350, 100},
        {4400, 256}, {4450, 335}, {4500, 266}, {4550, 336},
        {4600, 177}, {4650, 221}, {4700, 366}, {4750, 470},
        {4800, 159}, {4850, 362}, {4900, 500}, {4950, 459},
        {5000, 400}, {5550, 250}, {5600, 120}, {5650, 300},
        {5700, 514}, {5750, 222}, {5800, 278}, {5850, 180},
        {5900, 452}, {5950,110}, {6000, 195}, {6050,500},
        {6100,470}, {6150, 572},
        {6220,131}, {6250,536}, {6300, 433}, {6350,46},
        
        {6400, 529}, {6430, 580}, {6460, 489}, {6490, 109},
        {6520, 139}, {6550, 239}, {6580, 259}, {6610, 250},
        {6640, 150}, {6670, 209}, {6700, 345}, {6730, 470},
        {6760, 159}, {6790, 60}, {6820, 460}, {6850, 459},
        {6880, 500}, {6910, 200}, {6940, 259}, {6970, 300},
        {7000, 500}, {7030, 220}, {7060, 200}, {7090, 180},
        {7120, 512}, {7150,100}, {7180, 150}, {7210,500},
        {7240,520}, {7270, 580},
        {7400,441}, {7425,536}, {7450, 500}, {7475,46},        
        {7500, 429}, {7525, 550}, {7550, 460}, {7575, 100},
        {7600, 256}, {7625, 335}, {7650, 266}, {7675, 336},
        {7700, 177}, {7725, 221}, {7750, 366}, {7775, 470},
        {7800, 159}, {7825, 362}, {7850, 500}, {7875, 459},
        {7900, 400}, {7925, 250}, {7950, 120}, {8000, 300},
        {8025, 514}, {8050, 222}, {8075, 278}, {8100, 180},
        {8125, 452}, {8150,110}, {8175, 195}, {8200,500},
        {8225,470}, {8250, 572},
        {8275,131}, {8300,536}, {8325, 433}, {8350,46}
    };

    
    public Fase(){
        
       
    setDoubleBuffered(true);       
    setFocusable(true);   
    addKeyListener(new TecladoAdapter());
    ImageIcon referencia = new ImageIcon("imagem\\backstar.png");
    fundo = referencia.getImage();    
    nave = new Nave();
    
    emJogo = true;
    
    inicializaInimigos();
    
    
    timer = new Timer(5,this);
    timer.start();
    
    }
    
    public void inicializaInimigos(){
        inimigos = new ArrayList<Enemy>();
        
        for(int i = 0; i<coordenadas.length; i++){
            inimigos.add(new Enemy(coordenadas[i][0], coordenadas [i][1]));
            
        }
        
    }
    
    
    @Override
    public void paint(Graphics g){
    
        Graphics2D graficos = (Graphics2D) g;    
        graficos.drawImage(fundo,0,0,null); 
        
        
        if(emJogo){        
        
        
        graficos.drawImage(nave.getImagem(), nave.getX(), nave.getY(), this);
        
        List<Missel> misseis = nave.getMisseis();
        
        for(int i = 0; i < misseis.size(); i++){
            Missel m = (Missel) misseis.get(i);
            graficos.drawImage(m.getImage(), m.getX(), m.getY(), this);
        }
        
        for(int i = 0; i < inimigos.size(); i++){
            Enemy in = inimigos.get(i);
            graficos.drawImage(in.getImage(), in.getX(), in.getY(), this);
        }
        graficos.setColor(Color.WHITE);
        graficos.drawString("INIMIGOS: " + inimigos.size(), 5, 15);
        
        }else{
            
            ImageIcon endgame = new ImageIcon("imagem\\perdeu.png");
            graficos.drawImage(endgame.getImage(), 0, 0, null);
            
        }
        if(inimigos.size() == 0){
            emJogo = false;
            ImageIcon endgame = new ImageIcon("imagem\\youwon.png");
            graficos.drawImage(endgame.getImage(), 0, 0, null);
        }
        
        g.dispose();
        
        
    }
    
    @Override        
    public void actionPerformed(ActionEvent arg0) {
        
        if(inimigos.size() == 0){
        
            emJogo = false;
        
        }
         
        List<Missel> misseis = nave.getMisseis();
            
            for(int i = 0; i < misseis.size(); i++){
                
                Missel m = (Missel) misseis.get(i);
                
                if(m.isVisivel()){
                    m.mexer();
                }else{
                    misseis.remove(i);
                }
                
            }
        
            for(int i = 0; i < inimigos.size(); i++){
                
                Enemy in = (Enemy) inimigos.get(i);
                
                if(in.isVisivel()){
                    in.mexer();
                }else{
                    inimigos.remove(i);
                }
                
            }
          nave.mexer();
          checarColisoes();
          repaint();
    }
    
   
    public void checarColisoes(){
        
        Rectangle formaNave = nave.getBounds();
        Rectangle formaEnemy;
        Rectangle formaMissel;
        
        for(int i = 0; i < inimigos.size(); i++){
            Enemy tempEnemy = inimigos.get(i);
            formaEnemy = tempEnemy.getBounds();
            
            if(formaNave.intersects(formaEnemy)){
                nave.setVisivel(false);
                tempEnemy.setVisivel(false);
                emJogo = false;
            }
        }
        
        List<Missel> misseis = nave.getMisseis();
        
        for(int i = 0; i < misseis.size(); i++){
        
            Missel tempMissel = misseis.get(i);
            formaMissel = tempMissel.getBounds();
            
            for(int j = 0; j < inimigos.size(); j++){
                
                Enemy tempEnemy = inimigos.get(j);
                formaEnemy = tempEnemy.getBounds();
                
                if(formaMissel.intersects(formaEnemy)){
                    tempEnemy.setVisivel(false);
                    tempMissel.setVisivel(false);
                                                        
                }
                
            }
            
        }
        
    }
    
    
    private class TecladoAdapter extends KeyAdapter{
    
        @Override
        public void keyPressed(KeyEvent e){
            if(e.getKeyCode() == KeyEvent.VK_ENTER){
                emJogo = true;
                nave = new Nave();
                inicializaInimigos();
            }
            
            nave.keyPressed(e);
        }
        
        @Override
        public void keyReleased(KeyEvent e){
            nave.keyReleased(e);
        }
    }
    
}
