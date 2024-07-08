
package controledecaixa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Funcionario implements Serializable {
    private String nome;
    private boolean permissoes; //diz se é permitido que este funcionario veja dados importantes
    //como registro de vendas e informações de outros funcionarios, bem como editar os produtos do estoque
    private String senha;
    private LinkedHashMap <String, Registro> registroDeVendas; //cada funcionario tem o seu registro individual (vendas que ele fez)
    private double arrecadado;
    
    public Funcionario(String nome, boolean permissoes, String senha){
        this.nome = nome;
        this.permissoes = permissoes;
        this.senha = senha;
        registroDeVendas = new LinkedHashMap<>();
        arrecadado = 0.0;
    }

    public String toString(){
        String s = "\nnome: " + nome + "\nsenha: " + senha;
        return s;
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isPermissoes() {
        return permissoes;
    }

    public void setPermissoes(boolean permissoes) {
        this.permissoes = permissoes;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

public double getArrecadado() {
    arrecadado = 0.0;

    for (Registro registro : registroDeVendas.values()) {
        for (ArrayList<Produto> listaDeProdutos : registro.getRegistrodavenda().values()) {
            for (Produto p : listaDeProdutos) {
                arrecadado += p.getValor();
            }
        }
    }
    
    return arrecadado;
}


    public void setArrecadado(double arrecadado) {
        this.arrecadado += arrecadado;
    }

    public LinkedHashMap <String, Registro> getRegistroDeVendas() {
        return registroDeVendas;
    }

    public void setRegistroDeVendas(LinkedHashMap <String, Registro> registroDeVendas) {
        this.registroDeVendas = registroDeVendas;
    }
}
