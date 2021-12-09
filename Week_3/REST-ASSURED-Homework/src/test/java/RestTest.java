import org.testng.annotations.Test;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class RestTest {
    String root = "https://api.trello.com/";
    String tapi = "8fec1ddfc5bf4158b663c0654****";
    String token = "a08179e0d31a5af9c5d8421e1142dd81debceabd54771d665bf34e****";


    @Test
    public void boardslistingBDDTEST(){
        when()


                .get(root + "1/members/me/boards?key="+tapi+"&token="+token)
                .then()
                .statusCode(200)
                .body("name[0]", equalTo("testREST"))
                .time(lessThan(2000L));
    }
    @Test
    public void toDoListingBDDTEST() {
        when()
                .get("https://api.trello.com/1/cards/R0RkK5cX?key=8fec1ddfc5bf4158b663c0654d20e42b&token=a08179e0d31a5af9c5d8421e1142dd81debceabd54771d665bf34e573f9975ac")
                .then()
                .statusCode(200)
                .body("desc", equalTo("Morning Meet at 9am"));

    }
    @Test
    public void meetTimeCheckBDDTEST() {
        when()
                .get("https://api.trello.com/1/cards/R0RkK5cX?key=8fec1ddfc5bf4158b663c0654d20e42b&token=a08179e0d31a5af9c5d8421e1142dd81debceabd54771d665bf34e573f9975ac")
                .then()
                .statusCode(200)
                .body("due", equalTo("2021-12-09T06:00:00.000Z"));

    }
    @Test
    public void lastActivityCheckBDDTEST(){
        when()
                .get("https://api.trello.com/1/cards/R0RkK5cX?key=8fec1ddfc5bf4158b663c0654d20e42b&token=a08179e0d31a5af9c5d8421e1142dd81debceabd54771d665bf34e573f9975ac")
                .then()
                .statusCode(200)
                .body("dateLastActivity", equalTo("2021-12-08T19:14:02.639Z"));

    }
}
