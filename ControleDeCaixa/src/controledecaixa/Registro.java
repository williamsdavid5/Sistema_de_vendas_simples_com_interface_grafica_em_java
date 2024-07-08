package controledecaixa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class Registro implements Serializable {
    private LinkedHashMap<String, ArrayList<Produto>> registrodavenda;
    
    public Registro(){
        this.registrodavenda = new LinkedHashMap<>();
    }
    
    @Override
    public String toString(){
        String s = "sei la meu patrao";
        return s;
    }
    
    public void adicionarRegistro(String hora, ArrayList<Produto> registroProdutos){
        registrodavenda.put(hora, registroProdutos);
    }

    public LinkedHashMap<String, ArrayList<Produto>> getRegistrodavenda() {
        return registrodavenda;
    }

    public double getValorArrecadado(String registroDesejado) {
        double valorArrecadado = 0.0;
        
        ArrayList<Produto> listaDeProdutos = registrodavenda.get(registroDesejado);
        Iterator iterator = listaDeProdutos.iterator();
        while (iterator.hasNext()){
            Produto p = (Produto) iterator.next();
            valorArrecadado += p.getValor();
        }
        return valorArrecadado;
    }
    
    public void setRegistroDeVendas(LinkedHashMap<String, ArrayList<Produto>> registrodavenda){
        this.registrodavenda = registrodavenda;
    }
}