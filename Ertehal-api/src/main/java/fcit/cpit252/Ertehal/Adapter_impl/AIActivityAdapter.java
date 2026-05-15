package fcit.cpit252.Ertehal.Adapter_impl;

import fcit.cpit252.Ertehal.Adapter.ActivityAdapter;
import fcit.cpit252.Ertehal.Adapter_response.ExternalActivityResponse;
import fcit.cpit252.Ertehal.Model.Activity;

public class AIActivityAdapter implements ActivityAdapter {

    @Override
    public Activity adapt(ExternalActivityResponse response) {
        String name = (response.getActivityName() != null && !response.getActivityName().isEmpty())
                ? response.getActivityName()
                : "Local Activity";

        String location = (response.getCityArea() != null && !response.getCityArea().isEmpty())
                ? response.getCityArea()
                : "City Center";

        double price = response.getPriceSar() >= 0
                ? response.getPriceSar()
                : 100.0;

        return new Activity(name, location, price);
    }
}