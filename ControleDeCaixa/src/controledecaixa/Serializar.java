/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controledecaixa;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;
 //classe usada exclusivamente para receber objetos e serializar eles na pasta raiz do programam
public class Serializar {
    //metodo de serializar
    //recebe um objeto por parametro e tenta serializar em um arquivo chamado "dados.dat"
    public static void serializar(Object objeto){
        try{
            FileOutputStream fileOut = new FileOutputStream("dados.dat");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(objeto);
            out.close();
            
        } catch (java.io.FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "Não há nenhum dado cadastrado ainda. Os dados serão criados agora!", "Atenção!",JOptionPane.WARNING_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "ERRO DE E/S!\n" + e, "Atenção!", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    //metodo para desserializar
    //ele retorna o objeto desserialiozado
    //se ele retirnar null, significa que o objeto não existe no arquivi, e é necessário cria-lo primeiro
    //se ele não retornar null, a desserialização foi bem sucedida
    public static Object desserializarObjeto() {
        Object objetoDeserializado = null;
        try (FileInputStream fileIn = new FileInputStream("dados.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn)) {
            objetoDeserializado = in.readObject();
            in.close();
            
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "ERRO!\n" + e, "Atenção!",JOptionPane.WARNING_MESSAGE);
        }
        return objetoDeserializado;
    }
}
