package org.example;

import org.example.core.Template;
import org.example.models.Light;
import org.example.models.Thing;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThingController {

    public String detail(Request request, Response response) {

        String idParam = request.params(":id");
        int index = Integer.parseInt(idParam) - 1;

        List<Thing> things = HomeSystem.getInstance().getThings();
        Thing thing = things.get(index);
        Light light = (Light)thing;

        String action = request.queryParamOrDefault("action", "");
        if(action.equals("toggle")){
            light.setLightOn(!light.isLightOn());
        }

        Map<String, Object> model = new HashMap<>();
        model.put("light", light);
        model.put("id", idParam);
        return Template.render("thing_light.html", model);
    }
}
