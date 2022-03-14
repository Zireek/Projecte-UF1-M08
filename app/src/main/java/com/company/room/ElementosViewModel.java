package com.company.room;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import java.util.List;

public class ElementosViewModel extends AndroidViewModel {
    Boolean creado = false;
    ElementosRepositorio elementosRepositorio;


    MutableLiveData<Elemento> elementoSeleccionado = new MutableLiveData<>();

    MutableLiveData<String> terminoBusqueda = new MutableLiveData<>();

    LiveData<List<Elemento>> resultadoBusqueda = Transformations.switchMap(terminoBusqueda, new Function<String, LiveData<List<Elemento>>>() {
        @Override
        public LiveData<List<Elemento>> apply(String input) {
            return elementosRepositorio.buscar(input);
        }
    });

    public void crear(){
        if (!creado){
            insertar(new Elemento("Barcelona", "El Circuito de Barcelona-Cataluña (en catalán y oficialmente, Circuit de Barcelona-Catalunya), también conocido como Circuito de Montmeló o Circuito de Barcelona, es un autódromo situado en las poblaciones de Montmeló (sectores 1 y 2) y Granollers (sector 3), en la provincia de Barcelona, comunidad autónoma de Cataluña, España.",R.drawable.espana1));
            insertar(new Elemento("Algarve", "El Autódromo Internacional do Algarve es un autódromo situado en Portimão, región de Algarve, Portugal. Se acabó de construir en octubre de 2008, con un coste de 195 millones de euros y fue inaugurado el 2 de noviembre de ese año coincidiendo con la celebración de la carrera final del Campeonato Mundial de Superbikes. El circuito ha sido visitado por el A1 Grand Prix, la Superleague Formula. ",R.drawable.portimao));
            insertar(new Elemento("Bakú", "El Circuito callejero de Bakú (en azerí, Bakı Şəhər Halqası, en inglés, Baku City Circuit) es un circuito urbano de carreras construido en la ciudad de Bakú, Azerbaiyán, en el Baku Boulevard. Acogió el Gran Premio de Europa de 2016 de Fórmula 1. A partir del 2017, la FIA, luego de ver los buenos resultados obtenidos en el circuito callejero de Bakú, ha concedido el cambio de la denominación de Gran Premio de Europa para que a partir de 2017 se dispute como Gran Premio de Azerbaiyán.",R.drawable.baku));
            insertar(new Elemento("Monza", "El Autodromo Nazionale di Monza es un autódromo ubicado en el parque de la villa real de Monza en las cercanías de Monza, región de Lombardía, Italia, a unos 20 km al norte de la ciudad de Milán.\n" + "\n" + "El autódromo consiste de tres pistas: el trazado de 5.793 metros usado para los Grandes Premios, la pista Junior que se extiende a lo largo de 2.405 metros, y un circuito peraltado de velocidad de 4.250 metros hoy en desuso.",R.drawable.monza));
            creado = true;


        }
    }


    public ElementosViewModel(@NonNull Application application) {
        super(application);

        elementosRepositorio = new ElementosRepositorio(application);
    }



    LiveData<List<Elemento>> obtener(){
        return elementosRepositorio.obtener();
    }

    LiveData<List<Elemento>> masValorados(){
        return elementosRepositorio.masValorados();
    }

    LiveData<List<Elemento>> buscar(){
        return resultadoBusqueda;
    }

    void insertar(Elemento elemento){
        elementosRepositorio.insertar(elemento);
    }

    void eliminar(Elemento elemento){
        elementosRepositorio.eliminar(elemento);
    }

    void actualizar(Elemento elemento, float valoracion){
        elementosRepositorio.actualizar(elemento, valoracion);
    }


    void seleccionar(Elemento elemento){
        elementoSeleccionado.setValue(elemento);
    }

    MutableLiveData<Elemento> seleccionado(){
        return elementoSeleccionado;
    }


    void establecerTerminoBusqueda(String s){
        terminoBusqueda.setValue(s);
    }
}