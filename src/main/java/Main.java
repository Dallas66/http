import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {
        String urlIzhevsk = "https://yandex.ru/maps/44/izhevsk";
        String urlYekaterinburg = "https://yandex.ru/maps/54/yekaterinburg";
        String yanResponse,
                myResponse,
                yanUid,
                yancsrfToken,
                coordinate;

        String myAddressIzhevsk = "Ижевск, Красногеройская, 65";
        String myAddresYekaterinburg = "Екатеринбург, 8 Марта, 144";

        GetRequest getRequest = new GetRequest();
        MyGetRequest myGetRequest = new MyGetRequest();
        CoordinateFinder cr = new CoordinateFinder();


        yanResponse = getRequest.yandexRequest(urlIzhevsk);

        yanUid = Finders.yandexUidFinder(yanResponse);
        yancsrfToken = Finders.csrfTokenFinder(yanResponse);

        myResponse = myGetRequest.createNewGetRequest(yanUid, yancsrfToken, myAddresYekaterinburg);

        coordinate = cr.correctCoordinate(cr.findCoordinate(myResponse));
        System.out.println(coordinate);
    }
}
