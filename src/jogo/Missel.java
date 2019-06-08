package jogo;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;


public class Missel {
    
    private final Image imagem; 
    private int x; 
    private final int y;
    private int largura, altura;
    private boolean isVisivel; 
    
    public static final int LARGURA_TELA = 960; 
    public static final int VELOCIDADE = 7; 
    
    public Missel(int x , int y){
        
        this.x = x;
        this.y = y;
        
        ImageIcon referencia = new ImageIcon("imagem\\4por3.png");
        imagem = referencia.getImage();
        
        this.largura = imagem.getWidth(null);
        this.altura = imagem.getHeight(null);
        
        isVisivel = true; 
        
    }
    
    
    
    public void mexer(){
    
    this.x += VELOCIDADE;
    if(this.x > LARGURA_TELA){
      
        isVisivel = false;        
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