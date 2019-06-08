package jogo;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;


public class Enemy {
    
    private Image imagem;   
    private int x; 
    private final int y; 
    private int altura, largura;
    
    private boolean isVisivel; 
    
    public static final int LARGURA_TELA = 540; 
    public static final double VELOCIDADE = 0.5; 
    
    public Enemy(int x , int y){
        
        this.x = x;
        this.y = y;
        
        ImageIcon referencia = new ImageIcon("imagem\\25por25.png");
        imagem = referencia.getImage();
        
        this.largura = imagem.getWidth(null);
        this.altura = imagem.getHeight(null);
        
        isVisivel = true; 
        
    }
    
    
    
    public void mexer(){
        
        if(this.x < 2){
            ImageIcon referencia = new ImageIcon("imagem\\perdeu.png");
            imagem = referencia.getImage();
        }else{
            this.x -= VELOCIDADE;
        }
    
    }
   
    public boolean isVisivel(){
        return isVisivel;
    }
    
    public void setVisivel(boolean isVisivel){
        this.isVisivel = isVisivel;
    }
    
    public Image getImage(){
        return imagem;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }    
   
    public Rectangle getBounds(){
        return new Rectangle(x, y, largura, altura);
    }
   
}