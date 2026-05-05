package fcit.cpit252.Ertehal.Adapter_impl;

import fcit.cpit252.Ertehal.Adapter.ActivityAdapter;
import fcit.cpit252.Ertehal.Adapter_response.ExternalActivityResponse;
import fcit.cpit252.Ertehal.Model.Activity;

public class ExternalActivityAdapter implements ActivityAdapter {

    @Override
    public Activity adapt(ExternalActivityResponse response) {
        String name = response.getPlaceName() != null
                ? response.getPlaceName() : "Unknown Activity";

        String location = response.getCity() != null
                ? response.getCity() : "Unknown Location";

        double cost = 100.0;

        return new Activity(name, location, cost);
    }
}