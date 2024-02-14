import java.util.ArrayList;
import java.util.List;

public class Lista {

    List<Jugador> equipo;

    public Lista(){
        equipo=new ArrayList<Jugador>();
    }

    public void agregar(Jugador dato){
        equipo.add(dato);
    }

    public boolean actualizar (Jugador dato){

        for(Jugador j:equipo){
            if(j.getIdentificador()==dato.getIdentificador()){
                j.setNombre(dato.getNombre());
                j.setEdad(dato.getEdad());
                j.setRendimiento(dato.getRendimiento());
                j.setPosicion(dato.getPosicion());
                return true;
            }
        }
        return false;
    }

    public List<Jugador> getEquipo() {
        return equipo;
    }

    private float sumatoria(int indice, String posicion){
        if(indice<equipo.size()){
            //caso general
            if(equipo.get(indice).getPosicion().compareTo(posicion)==0)
               return equipo.get(indice).getRendimiento()+sumatoria(indice+1,posicion);
            else
                return sumatoria(indice+1,posicion);
        }else{
            //caso base
            return 0;
        }
    }
    public float sumatoria(String posicion){
       return sumatoria(0,posicion);
    }


    public void ordenarInsercion(){

        Jugador aux=new Jugador();
        int j;
        for(int i=1;i<equipo.size();i++){
            aux=equipo.get(i);
            j=i-1;
            while(j>=0 && aux.getIdentificador()<equipo.get(j).getIdentificador()){
                equipo.set(j+1,equipo.get(j));
                j--;
            }
            equipo.set(j+1,aux);
        }


    }



}
