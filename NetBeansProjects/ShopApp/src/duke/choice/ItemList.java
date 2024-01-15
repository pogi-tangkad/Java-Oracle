package duke.choice;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import io.helidon.common.http.Http;
import io.helidon.webserver.Handler;
import io.helidon.webserver.ServerRequest;
import io.helidon.webserver.ServerResponse;

/**
 *
 * @author opc
 */
public class ItemList implements Handler {

    private Clothing[] items;

    public ItemList(Clothing[] items) {
        this.items = items;
    }

    @Override
    public void accept(ServerRequest req, ServerResponse res) {
        res.status(Http.Status.OK_200);
        res.headers().put("Content-Type",
                "text/plain; charset=UTF-8");
        StringBuilder result = new StringBuilder();
        for (Clothing item : items) {
            result.append(item + "\n");
        }
        res.send(result);
    }
}
