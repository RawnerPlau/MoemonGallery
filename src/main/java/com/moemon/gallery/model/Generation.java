package com.moemon.gallery.model;

public enum Generation {
    GEN_1(1, 151),
    GEN_2(152, 251),
    GEN_3(252, 386),
    GEN_4(387, 493),
    GEN_5(494, 649),
    GEN_6(650, 721),
    GEN_7(722, 809),
    GEN_8(810, 905),
    GEN_9(906, 1025);

    private final int pokedexMin;
    private final int pokedexMax;

    private Generation(int pokedexMin, int pokedexMax) {
        this.pokedexMin = pokedexMin;
        this.pokedexMax = pokedexMax;
    }

    public int getPokedexMin() {
        return pokedexMin;
    }

    public int getPokedexMax() {
        return pokedexMax;
    }

    public boolean contains(Integer pokedexNo) {
        return pokedexNo >= pokedexMin && pokedexNo <= pokedexMax;
    }

    public static Generation fromPokedexNumber(Integer pokedexNo){
        for (Generation gen : values()){
            if(gen.contains(pokedexNo)){
                return gen;
            }
        }
        return null;
    }
}
