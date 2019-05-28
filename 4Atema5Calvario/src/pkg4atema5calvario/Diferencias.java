/*
+

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4atema5calvario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marco
 */
public class Diferencias {
    
    public void Calcular(JTextField txtI,JTable Jt1, JTable Jt2){

        try{
            //obtenemos el valor de i
            int i = Integer.parseInt(txtI.getText());
        Double x []= new Double[i];
        Double fx []= new Double[i];
        //llenamos los arreglos x y fx
        for (int j = 0; j<i;j++){   
            x[j]=Double.parseDouble(Jt1.getValueAt(j,0).toString());               
        }
        for (int j = 0; j<i;j++){  
           fx[j]=Double.parseDouble(Jt1.getValueAt(j,1).toString());               
        }
         //Primera diferencia
         double diferencia [] = new double[i];
         for (int j = 0; j<i;j++){
            
            diferencia[0] = (fx[1] - fx[0])/ (x[1]-x[0]);
            diferencia[1] = (fx[2] - fx[1])/ (x[2]-x[1]);
            diferencia[2] = (fx[3] - fx[2])/ (x[3]-x[2]);
          }
        //pasamos el arreglo diferencia a un arreglo de tipo big decimal
        BigDecimal d1 [] = new BigDecimal[diferencia.length];
        for (int j = 0; j<i;j++){
            
            d1[0] = BigDecimal.valueOf(diferencia[0]);
            d1[1] = BigDecimal.valueOf(diferencia[1]);
            d1[2] = BigDecimal.valueOf(diferencia[2]);
          }
            d1[0]=d1[0].setScale(1, RoundingMode.HALF_UP);
            d1[1]=d1[1].setScale(1, RoundingMode.HALF_UP);
            d1[2]=d1[2].setScale(1, RoundingMode.HALF_UP);
        
        // segunda diferencia
            double diferencia2 [] = new double[i];
         for (int j = 0; j<i;j++){
            
            diferencia2[0] = (diferencia[1] - diferencia[0])/ (x[2]-x[0]);
            diferencia2[1] = (diferencia[2] - diferencia[1])/ (x[3]-x[1]);
                        
        }
          //pasamos el arreglo diferencia2 a un arrglo de tipo big decimal
          BigDecimal d2 [] = new BigDecimal[i];
         for (int j = 0; j<i;j++){
            
          d2[0]=BigDecimal.valueOf(diferencia2[0]);
          d2[1]=BigDecimal.valueOf(diferencia2[1]);            
        } 
             d2[0]=d2[0].setScale(1, RoundingMode.HALF_UP);
            d2[1]=d2[1].setScale(1, RoundingMode.HALF_UP);
         
         // tercera diferencia
         double diferencia3 [] = new double[i];
         for (int j = 0; j<i;j++){
            diferencia3[0] = (diferencia2[1] - diferencia2[0])/ (x[3]-x[0]);                
        }
         
          //pasamos el arreglo diferencia3 a un arrglo de tipo big decimal
          BigDecimal d3 [] = new BigDecimal[i];
         for (int j = 0; j<i;j++){ 
          d3[0]=BigDecimal.valueOf(diferencia3[0]);              
        } 
          d3[0]=d3[0].setScale(1, RoundingMode.HALF_UP);
            
       
            //CREACIÓN DE LA TABLA 2
          DefaultTableModel model = (DefaultTableModel)Jt2.getModel();
                    Jt2.getTableHeader().setUI(null);
                    model.setColumnCount(3);
                    model.setRowCount(i);
         //LLENADO DE LA TABLA 2
       for (int j = 0; j<d1.length; j++)
            {
               
               Jt2.setValueAt(d1[0],0, 0);
               Jt2.setValueAt(d1[1],1, 0);
               Jt2.setValueAt(d1[2],2, 0);
               Jt2.setValueAt(d2[0],0, 1);
               Jt2.setValueAt(d2[1],1, 1);
               Jt2.setValueAt(d3[0],0, 2);
               
               


            }//Primer for*/
    
               }catch(Exception e){
           JOptionPane.showMessageDialog(null, "No se permite campos vacios.\nIngrese los valores faltantes");
          
       }
         
     
    }



}
