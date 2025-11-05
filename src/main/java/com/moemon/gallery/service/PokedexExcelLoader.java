package com.moemon.gallery.service;

import com.moemon.gallery.model.Pokemon;
import com.moemon.gallery.repository.PokemonRepository;
import jakarta.annotation.PostConstruct;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class PokedexExcelLoader {

    private final PokemonRepository pokemonRepository;

    public PokedexExcelLoader(PokemonRepository pokemonRepository){
        this.pokemonRepository = pokemonRepository;
    }

    @PostConstruct  // runs automatically when the app starts
    public void loadData() {
        if (pokemonRepository.count() == 0) {
            try (InputStream inputStream = getClass().getResourceAsStream("/data/pokedex.xlsx");
                 Workbook workbook = WorkbookFactory.create(inputStream)) {

                Sheet sheet = workbook.getSheetAt(0);

                for (Row row : sheet) {
                    if (row.getRowNum() == 0) continue; // skip header row

                    int pokedexNo = (int) row.getCell(0).getNumericCellValue();
                    String name = row.getCell(1).getStringCellValue();

                    Pokemon pokemon = new Pokemon(pokedexNo, name);

                    pokemonRepository.save(pokemon);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
