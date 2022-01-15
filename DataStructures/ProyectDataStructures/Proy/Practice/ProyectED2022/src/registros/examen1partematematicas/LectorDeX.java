package registros.examen1partematematicas;

import estructuraslineales.ArregloDatos;

import java.io.*;

/**
 *
 * @author Daniel Alejandro Morales Castillo
 */

/**
 * Clase que lee los valores para x
 *
 */
public class LectorDeX {
    public static ArregloDatos leerX(String archivo){
        FileReader input=null;
        int registro=0;
        ArregloDatos datos=null;
        BufferedReader buffer = null;

        try {
            String cadena=null;
            input = new FileReader(archivo);
            buffer = new BufferedReader(input);
            datos=new ArregloDatos((int)buffer.lines().count());
            buffer.close();
            input.close();
            input = new FileReader(archivo);
            buffer = new BufferedReader(input);
            while((cadena = buffer.readLine())!=null) {
                datos.agregar(cadena);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                input.close();
                buffer.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        return datos;
    }

    /**
     * Método que permite guardar las líneas de un archivo de texto en un arreglo
     * Una línea por cada posición del arreglo
     * @param archivo Es el archivo con ruta para leer el archivo.
     * @param tamanioArchivo Es el número de líneas que tiene el archivo.
     * @return Regresa un TDA Arreglo con todas las líneas leidas del archivo.
     * Una línea por cada posición del arreglo.
     */

    public static ArregloDatos leerX(String archivo, int tamanioArchivo){
        FileReader input=null;

        ArregloDatos datos=new ArregloDatos(tamanioArchivo);
        try {
            String cadena=null;
            input = new FileReader(archivo);
            BufferedReader buffer = new BufferedReader(input);
            while((cadena = buffer.readLine())!=null) {
                datos.agregar(cadena);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try{
                input.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        return datos;
    }

    public static void escribir(ArregloDatos arreglo, String archivo){
        FileWriter output=null;
        try {
            output = new FileWriter(archivo);
            for(int posicion=0;posicion<arreglo.cantidadElementos() -1 ;posicion++) {
                output.write((String)arreglo.obtener(posicion)+ "\n");
            }
            output.write((String)arreglo.obtener(arreglo.cantidadElementos() - 1));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try{
                output.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
    
}
