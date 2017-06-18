package ua.andrewblake.interfaces;

import ua.andrewblake.save.Stat;

/**
 * Created by AndrewBlake on 28.04.2017.
 */
public interface GetData {

    boolean canContinue();

    String[] getSimple(String[] simple);

    Stat getParams(Stat stat);

    void fillParams(Stat stat);


}
