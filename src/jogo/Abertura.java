package jogo;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

public class Abertura extends JFrame{
    
    
    
    public Abertura(){
        
        JMenuBar barraMenu = new JMenuBar();
        
        JMenu menu = new JMenu("Menu");
        
            JMenuItem instrucao = new JMenuItem("Instrução");
        instrucao.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                JOptionPane.showMessageDialog(null, "Espaço = atira \n A ou Seta para esquerda = para esquerda \n S ou Seta para baixo = para baixo \n D ou Seta para direita = para direita \n W ou Seta para cima = para cima ", "Instrução", JOptionPane.INFORMATION_MESSAGE);
            }
               
        });
       
        JMenuItem sobre = new JMenuItem("Sobre");
        sobre.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                JOptionPane.showMessageDialog(null, "Jogo desenvolvido por : \n Jéssica Parise Melim \n Gabriel Machado Coutinho \n Jhonathan Lucas Ferreira de Barros ", "Informações", JOptionPane.INFORMATION_MESSAGE);
            }
               
        });
        
    
            
        JMenuItem sair = new JMenuItem("Sair");
        sair.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
                
            }
        
        });
        menu.add(instrucao);
        menu.add(new JSeparator());
        menu.add(sobre);
        menu.add(new JSeparator());
        menu.add(sair);

        
        
        barraMenu.add(menu);
        
        setJMenuBar(barraMenu);
        
        add(new Fase());   
        setTitle("Galaxy Champions");       
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        setSize(540,720); 
        setLocationRelativeTo(null); 
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
    
        new Abertura();
    }
}