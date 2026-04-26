package fcit.cpit252.Ertehal.Adapter_impl;

import fcit.cpit252.Ertehal.Adapter_response.ExternalActivityResponse;
import fcit.cpit252.Ertehal.Model.Activity;
import fcit.cpit252.Ertehal.Adapter.ActivityAdapter;

public class ExternalActivityAdapter implements ActivityAdapter {

    @Override
    public Activity adapt(ExternalActivityResponse response) {
        return new Activity(
                response.getTitle(),
                response.getDestination(),
                response.getAmount());
    }
}
