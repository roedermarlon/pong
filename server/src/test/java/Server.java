import com.github.roedermarlon.pong.server.GameServer;

public class Server {

    public static void main(String[] args) {
        GameServer server = GameServer.getInstance();

        server.initialize("0.0.0.0", 8080);
    }
}
