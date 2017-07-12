package ua.andrewblake.temporary;

import ua.andrewblake.utils.SerializeToVRS;
import ua.andrewblake.version.Version;

public class SerializeVRS {
    public static void main(String[] args) {
        Version vrs = new Version("0.5", 7, "<2017-07-06>");
        SerializeToVRS.serialize(vrs);
    }
}
