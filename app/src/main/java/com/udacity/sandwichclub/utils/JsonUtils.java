package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static final String KEY_MAIN_NAME = "mainName";
    public static final String KEY_ALSO_KNOW_AS = "alsoKnownAs";
    public static final String KEY_PLACE_OF_ORIGIN = "placeOfOrigin";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_INGREDIENTS = "ingredients";
    public static final String KEY_NAME = "name";

    public static Sandwich parseSandwichJson(String json) {
        try {
            JSONObject sandwichJsonObject = new JSONObject(json);
            JSONObject nameJsonObject = sandwichJsonObject.getJSONObject(KEY_NAME);
            Sandwich sandwich = new Sandwich();
            sandwich.setMainName(nameJsonObject.getString(KEY_MAIN_NAME));
            sandwich.setDescription(sandwichJsonObject.getString(KEY_DESCRIPTION));
            sandwich.setImage(sandwichJsonObject.getString(KEY_IMAGE));
            sandwich.setPlaceOfOrigin(sandwichJsonObject.getString(KEY_PLACE_OF_ORIGIN));
            sandwich.setAlsoKnownAs(convertJsonArrayToArrayList(nameJsonObject.getJSONArray(KEY_ALSO_KNOW_AS)));
            sandwich.setIngredients(convertJsonArrayToArrayList(sandwichJsonObject.getJSONArray(KEY_INGREDIENTS)));
            return sandwich;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static List<String> convertJsonArrayToArrayList(JSONArray jsonArray){
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++){
            try {
                stringList.add(jsonArray.getString(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return stringList;
    }
}
