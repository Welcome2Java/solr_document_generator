package com.mtg.jsonparser;

import com.mtg.jsonparser.Utils.JsonParserUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class JsonparserApplication {

    private static String pathToAllPrintings = "C:\\Users\\jonat\\Desktop\\Projects\\Data\\MTG DATA\\AllPrintings.json";
    private static String Data = "data";

    public static void main(String[] args) {
        System.out.println("Generating json files for all known Magic the Gathering Cards.");
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(pathToAllPrintings)) {

            JSONObject object = (JSONObject) jsonParser.parse(reader);
            JSONObject dataMap = (JSONObject) object.get(Data);

            JsonParserUtils jsonParserUtils = new JsonParserUtils();
            jsonParserUtils.getSetData(dataMap);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Done");
    }
}
