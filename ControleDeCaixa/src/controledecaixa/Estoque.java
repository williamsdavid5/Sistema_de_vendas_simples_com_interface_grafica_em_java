package controledecaixa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import javax.swing.JOptionPane;

public class Estoque implements Serializable  {
    private ArrayList<Produto> estoque;
    
    public Estoque(){
        estoque = new ArrayList<>();
    }
    
    public void estocar(Produto produto){
        estoque.add(produto);
        Collections.sort(estoque) ;
    }
    
    public void subtrair (String nome, int quantidade){
        Iterator iterator = estoque.iterator();
        
        for (int i = 0; i<estoque.size(); i++){
            if(estoque.get(i).getNome() == nome){
                
                if (estoque.get(i).getEstoque() >= quantidade){
                    estoque.get(i).setEstoque(estoque.get(i).getEstoque() - quantidade);
                } else {
                    JOptionPane.showMessageDialog(null, "Você está tentando comprar mais do que tem no estoque!", "Atenção", JOptionPane.WARNING_MESSAGE);
                }   
            }
        }
    }
    
    public ArrayList<Produto> resgatarEstoque(){
        return estoque;
    }
    
    public void setEstoque(ArrayList<Produto> novoEstoque){
        estoque = novoEstoque;
    }
}
