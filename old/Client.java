import networking.NetworkingClient;

public class Client {

    public static void main(String[] args) {
        NetworkingClient.startNetworkingClient("127.0.0.1", 8080);
    }
}
