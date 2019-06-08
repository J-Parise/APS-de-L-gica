package jogo;



import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;


public class Nave {
   
    private int x, y;
    private int dx, dy;
    private final int altura;
    private final int largura;
    
    private boolean isVisivel;

    private final Image imagem;  
    private List<Missel> misseis;
    

    public Nave(){

    ImageIcon referencia = new ImageIcon("imagem\\novanave.png");
    imagem = referencia.getImage();
    
    altura = imagem.getHeight(null);
    largura = imagem.getWidth(null);
    

    misseis = new ArrayList<Missel>();
    
    this.x = 100;
    this.y = 200;
}

    public void mexer(){

    x += dx; 
    y += dy; 
    
    if(this.x < 2){
        x = 2;
    }
    if(this.x > 480){
        x = 480;
    }
    if(this.y < 2){
        y = 2;
    }
    if(this.y > 620){
        y = 620;
    }
    }
    
    public List<Missel> getMisseis(){
        return misseis;
    }
    
   
    public int getX(){
    return x;
    }
    
    public int getY(){
    return y;
    }
    
    public Image getImagem(){
       
    return imagem;
    }
    public boolean isVisivel(){
        return isVisivel;
    }
    public void setVisivel(boolean isVisivel){
        this.isVisivel = isVisivel;
    }
    
 
    public void atira(){
   
        this.misseis.add(new Missel(x + largura, y + altura/2));
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x, y, largura, altura);
    }
    
    
    public void keyPressed(KeyEvent tecla){
    
        int codigo = tecla.getKeyCode();
          
        if(codigo == KeyEvent.VK_SPACE){
            atira();
        }
        
        if(codigo == KeyEvent.VK_UP){        
        dy = -5;
        }
        if(codigo == KeyEvent.VK_DOWN){
        dy = 5;
        }
        if(codigo == KeyEvent.VK_LEFT){
        dx = -5;
        }
        if(codigo == KeyEvent.VK_RIGHT){
        dx = 5;
        }
        
        
    }
    
    public void keyReleased(KeyEvent tecla){
    
        int codigo = tecla.getKeyCode();
        
        if(codigo == KeyEvent.VK_UP){        
        dy = 0;
        }
        if(codigo == KeyEvent.VK_DOWN){
        dy = 0;
        }
        if(codigo == KeyEvent.VK_LEFT){
        dx = 0;
        }
        if(codigo == KeyEvent.VK_RIGHT){
        dx = 0;
        }
    }
}