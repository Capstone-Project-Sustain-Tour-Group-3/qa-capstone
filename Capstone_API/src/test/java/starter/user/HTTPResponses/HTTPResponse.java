package starter.user.HTTPResponses;
import net.serenitybdd.annotations.Step;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;


public class HTTPResponse {

    @Step
    public void ReceiveResponse200(){
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step
    public void ReceiveResponse201(){
        restAssuredThat(response -> response.statusCode(201));
    }

    @Step
    public void ReceiveResponse400(){
        restAssuredThat(response -> response.statusCode(400));
    }


    @Step
    public void ReceiveResponse409(){
        restAssuredThat(response -> response.statusCode(409));
    }


}
