package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        try {
            JSONObject sandwichJsonObject = new JSONObject(json);
            JSONObject nameJsonObject = sandwichJsonObject.getJSONObject("name");
            Sandwich sandwich = new Sandwich();
            sandwich.setMainName(nameJsonObject.getString("mainName"));
            sandwich.setDescription(sandwichJsonObject.getString("description"));
            sandwich.setImage(sandwichJsonObject.getString("image"));
            sandwich.setPlaceOfOrigin(sandwichJsonObject.getString("placeOfOrigin"));
            sandwich.setAlsoKnownAs(convertJsonArrayToArrayList(nameJsonObject.getJSONArray("alsoKnownAs")));
            sandwich.setIngredients(convertJsonArrayToArrayList(sandwichJsonObject.getJSONArray("ingredients")));
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
