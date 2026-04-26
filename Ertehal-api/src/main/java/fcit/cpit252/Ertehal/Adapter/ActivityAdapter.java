package fcit.cpit252.Ertehal.Adapter;
import fcit.cpit252.Ertehal.Adapter_response.ExternalActivityResponse;
import fcit.cpit252.Ertehal.Model.Activity;

public interface ActivityAdapter {
    Activity adapt(ExternalActivityResponse response);
}
