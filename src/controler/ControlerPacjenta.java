package controler;

import gui.Pacjent;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by adam on 6/14/14.
 */
public class ControlerPacjenta extends IControlerPacjent {

    ControlerPacjenta(Pacjent pacjentWindow) {
        super(pacjentWindow);
    }

    @Override
    public MPair<Integer, HashMap<String, String>> checkDanePacjenta(String key, String value) {
        return null;
    }

    @Override
    public ArrayList<String> readPakiety() {
        return null;
    }

    @Override
    public void removePacjent(String pesel) {

    }

    @Override
    public void updateDanePacjenta(HashMap<String, String> danePacjenta) {

    }

    @Override
    public void updatePakietPacjenta(String pakietPacjenta, boolean add) {

    }
}
