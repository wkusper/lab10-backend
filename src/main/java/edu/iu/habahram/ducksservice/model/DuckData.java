package edu.iu.habahram.ducksservice.model;

public record DuckData(int id, String name, String type) {

    public String toLine() {
        return String.format("%1$s,%2$s,%3$s", id(), name(), type());
    }

    public String toLine(int id) {
        return String.format("%1$s,%2$s,%3$s", id, name(), type());
    }

    public static DuckData fromLine(String line) {
        String[] tokens = line.split(",");
        return new DuckData(Integer.parseInt(tokens[0]), tokens[1], tokens[2]);
    }

}
