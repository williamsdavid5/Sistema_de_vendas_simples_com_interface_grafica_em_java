package controledecaixa;

import java.io.Serializable;
import java.util.LinkedHashMap;


public class Dados implements Serializable{
    private double caixa;
    private Estoque estoque; //o estoque de produtos
    private LinkedHashMap <String, Funcionario> funcionariosCadastrados;
    private LinkedHashMap <String, Registro> registroDeVendas;
    private LinkedHashMap <String, Registro> registroPorFuncionario;
    
    public Dados (){
        this.caixa = 0.0;
        this.estoque = new Estoque();
        this.funcionariosCadastrados = new LinkedHashMap<>();
        this.registroDeVendas = new LinkedHashMap<>();
        this.registroPorFuncionario = new LinkedHashMap<>();
    }
    
    public void guardarArquivos(double caixa, Estoque estoque, LinkedHashMap <String, Funcionario> funcionariosCadastrados, LinkedHashMap <String, Registro> registroDeVendas, LinkedHashMap <String, Registro> registroPorFuncionario){
        this.caixa = caixa;
        this.estoque = estoque;
        this.funcionariosCadastrados = funcionariosCadastrados;
        this.registroDeVendas = registroDeVendas;
        this.registroPorFuncionario = registroPorFuncionario;
    }

    public double getCaixa() {
        return caixa;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public LinkedHashMap <String, Funcionario> getFuncionariosCadastrados() {
        return funcionariosCadastrados;
    }

    public LinkedHashMap <String, Registro> getRegistroDeVendas() {
        return registroDeVendas;
    }

    public LinkedHashMap <String, Registro> getRegistroPorFuncionario() {
        return registroPorFuncionario;
    }
}
