package ejercicio1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Persona {
    private String nombre;
    private String poblacion;
    private String edad;

    public static void main(String[] args) {
        List<Persona> lista = new ArrayList<Persona>();
        File f = new File("src/main/java/ejercicio1/fichero.txt");
        BufferedReader in;
        String linea;
        Persona p;
        StringTokenizer st;

        //System.out.println("========================\n========================\n========================");

        try {
            in = new BufferedReader(new FileReader(f));
            while((linea = in.readLine()) != null){
                p = new Persona();
                String[] tokens = linea.split(":");
                p.setNombre(tokens[0]);
                if(!(tokens.length<3)) {
                    if (tokens[1] == "" || tokens[1] == null) {
                        p.setPoblacion("Desconocida");
                    } else {
                        p.setPoblacion(tokens[1]);
                    }
                }else{
                    p.setPoblacion("Desconocida");
                }

                if(!(tokens.length<3)) {
                    if (tokens[2] == "" || tokens[2] == null) {
                        p.setEdad(0+"");
                    } else {
                        p.setEdad(tokens[2]);
                    }
                }else{
                    p.setEdad(0+"");
                }
                lista.add(p);
               // System.out.println(lista.get(0).toString());
            }
            System.out.println(lista);
            System.out.println("========================\n========================\n========================");
            //menores de 25 años
            ArrayList resultado = (ArrayList) lista.stream()
                    .filter(persona -> Integer.parseInt(persona.getEdad()) < 25)
                    .filter(persona -> Integer.parseInt(persona.getEdad()) > 0)
                    .collect(Collectors.toList());
            //System.out.println(resultado);
            resultado.forEach(persona -> System.out.println(persona.toString()));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Nombre: "+nombre+"Poblacion: "+poblacion+"Edad: "+edad;
    }
}
